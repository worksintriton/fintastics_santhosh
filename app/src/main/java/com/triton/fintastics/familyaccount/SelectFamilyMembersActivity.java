package com.triton.fintastics.familyaccount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.triton.fintastics.R;

public class SelectFamilyMembersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_family_members);
    }

    public void gotoSetProfile(View view){

        Intent i=new Intent(SelectFamilyMembersActivity.this,
                SetPrrofileActivity.class);
        //Intent is used to switch from one activity to another.

        startActivity(i);
        //invoke the SecondActivity.
    }
}