package com.triton.fintastics.familyaccount;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.triton.fintastics.R;
import com.triton.fintastics.activities.DashoardActivity;

public class SharelinkFamilyMembersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharelink_family_members);
    }

    public void gotoDashboard(View view) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(SharelinkFamilyMembersActivity.this);
// ...Irrelevant code for customizing the buttons and title
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.show_link_share_success_popup__layout, null);
        dialogBuilder.setView(dialogView);

        dialogBuilder.setCancelable(true);

        LinearLayout ll_root = dialogView.findViewById(R.id.ll_root);

        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

        ll_root.setOnClickListener(v -> {

            Intent i=new Intent(SharelinkFamilyMembersActivity.this,
                    DashoardActivity.class);
            //Intent is used to switch from one activity to another.

            startActivity(i);


        });


    }
}