package com.triton.fintastics.transactionreport;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.triton.fintastics.R;
import com.triton.fintastics.activities.DashoardActivity;
import com.triton.fintastics.adapter.IncomeReportListAdapter;
import com.triton.fintastics.adapter.TransactionReportListAdapter;
import com.triton.fintastics.api.APIClient;
import com.triton.fintastics.api.RestApiInterface;
import com.triton.fintastics.requestpojo.ReportDataRequest;
import com.triton.fintastics.responsepojo.IncomeReportResponse;
import com.triton.fintastics.utils.RestUtils;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TranscationReportShowDataActivity extends AppCompatActivity {

    private String TAG = "TranscationReportShowDataActivity";

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.include_header)
    View include_header;


    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.avi_indicator)
    AVLoadingIndicatorView avi_indicator;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.rv_transactioneport)
    RecyclerView rv_transactioneport;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.txt_no_records)
    TextView txt_no_records;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.txt_available_balance)
    TextView txt_available_balance;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.txt_debit)
    TextView txt_debit;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.txt_credit)
    TextView txt_credit;

    private String user_id;
    private String end_date = "";
    private String start_date = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transcation_report_show_data);
        ButterKnife.bind(this);
        Log.w(TAG, "onCreate");

        avi_indicator.setVisibility(View.GONE);
        txt_no_records.setVisibility(View.GONE);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            user_id = extras.getString("user_id");
            start_date = extras.getString("start_date");
            end_date = extras.getString("end_date");

            Log.w(TAG,"user_id : "+user_id+" start_date : "+start_date+" end_date : "+end_date);
        }

        ImageView img_back = include_header.findViewById(R.id.img_back);
        TextView txt_title = include_header.findViewById(R.id.txt_title);
        txt_title.setText(getResources().getString(R.string.transaction_report));

        img_back.setOnClickListener(view -> onBackPressed());

        transactionReportResponseCall();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @SuppressLint("LogNotTimber")
    private void transactionReportResponseCall() {
        avi_indicator.setVisibility(View.VISIBLE);
        avi_indicator.smoothToShow();
        RestApiInterface apiInterface = APIClient.getClient().create(RestApiInterface.class);
        Call<IncomeReportResponse> call = apiInterface.transactionReportResponseCall(RestUtils.getContentType(), reportDataRequest());
        Log.w(TAG,"transactionReportResponseCall url  :%s"+" "+ call.request().url().toString());

        call.enqueue(new Callback<IncomeReportResponse>() {
            @SuppressLint({"LogNotTimber", "SetTextI18n"})
            @Override
            public void onResponse(@NonNull Call<IncomeReportResponse> call, @NonNull Response<IncomeReportResponse> response) {
                avi_indicator.smoothToHide();
                Log.w(TAG,"transactionReportResponseCall" + new Gson().toJson(response.body()));
                if (response.body() != null) {

                    if (200 == response.body().getCode()) {
                        if(response.body().getData() != null && response.body().getData().size()>0){
                            txt_no_records.setVisibility(View.GONE);
                            rv_transactioneport.setVisibility(View.VISIBLE);
                            setTransactionReportListView(response.body().getData());

                        }else{
                            rv_transactioneport.setVisibility(View.GONE);
                            txt_no_records.setVisibility(View.VISIBLE);
                        }

                        if(response.body().getTotal_count() != null){
                            txt_available_balance.setText("\u20B9 " +response.body().getTotal_count().getAvailable_balance());
                            txt_credit.setText("\u20B9 " +response.body().getTotal_count().getTotal_credit_value());
                            txt_debit.setText("\u20B9 " +response.body().getTotal_count().getTotal_debit_value());
                        }

                    }
                }


            }

            @Override
            public void onFailure(@NonNull Call<IncomeReportResponse> call,@NonNull Throwable t) {
                avi_indicator.smoothToHide();
                Log.e("DashboardDataRe flr", "--->" + t.getMessage());
            }
        });

    }
    private ReportDataRequest reportDataRequest() {
        /*
         * user_id : 617a7c37eeb3a520395e2f15
         * start_date : 23-10-2021
         * end_date : 23-10-2021
         */


        ReportDataRequest reportDataRequest = new ReportDataRequest();
        reportDataRequest.setUser_id(user_id);
        reportDataRequest.setStart_date(start_date);
        reportDataRequest.setEnd_date(end_date);

        Log.w(TAG,"reportDataRequest "+ new Gson().toJson(reportDataRequest));
        return reportDataRequest;
    }
    private void setTransactionReportListView(List<IncomeReportResponse.DataBean> data) {
        rv_transactioneport.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv_transactioneport.setItemAnimator(new DefaultItemAnimator());
        TransactionReportListAdapter transactionReportListAdapter = new TransactionReportListAdapter(getApplicationContext(), data);
        rv_transactioneport.setAdapter(transactionReportListAdapter);

    }

}