package com.triton.fintastics.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.triton.fintastics.R;
import com.triton.fintastics.familyaccount.SelectFamilyMembersActivity;

public class ChooseAccountTypeActivity extends AppCompatActivity {

    private static final String TAG = "ChooseAccountTypeActivity";

    Context context = ChooseAccountTypeActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_account_type);

        Log.w("Oncreate", TAG);

    }

    public void personal(View view){

        Intent i=new Intent(ChooseAccountTypeActivity.this,
                LoginActivity.class);
        //Intent is used to switch from one activity to another.

        startActivity(i);
        //invoke the SecondActivity.
    }

    public void family(View view){

        Intent i=new Intent(ChooseAccountTypeActivity.this,
                SelectFamilyMembersActivity.class);
        //Intent is used to switch from one activity to another.

        startActivity(i);
        //invoke the SecondActivity.
    }
}