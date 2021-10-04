package com.triton.fintastics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CreateProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);
    }

    public void gotoSharedLink(View view) {


        Intent i=new Intent(CreateProfileActivity.this,
                SharelinkFamilyMembersActivity.class);
        //Intent is used to switch from one activity to another.

        startActivity(i);


    }
}