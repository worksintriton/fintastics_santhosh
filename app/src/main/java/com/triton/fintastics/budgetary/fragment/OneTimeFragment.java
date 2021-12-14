package com.triton.fintastics.budgetary.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.triton.fintastics.R;
import com.wang.avi.AVLoadingIndicatorView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class OneTimeFragment extends Fragment {

    View view;

    private static final String TAG = "OneTimeFragment";

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.avi_indicator)
    AVLoadingIndicatorView avi_indicator;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.rv_onetime_budgetary)
    RecyclerView rv_onetime_budgetary;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.ll_no_budget)
    LinearLayout ll_no_budget;

    public OneTimeFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_one_time, container, false);

        Log.w(TAG,"onCreateView-->");
        ButterKnife.bind(this,view);


        return view;
    }
}