package com.triton.fintastics.familyaccount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.triton.fintastics.R;

public class SetPrrofileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_prrofile);
    }

    public void gotoCreateProfile(View view) {

        Intent i=new Intent(SetPrrofileActivity.this,
            CreateProfileActivity.class);
        //Intent is used to switch from one activity to another.

        startActivity(i);
        //invoke the SecondActivity.
    }
}