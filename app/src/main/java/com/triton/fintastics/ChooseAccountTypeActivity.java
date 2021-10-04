package com.triton.fintastics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChooseAccountTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_account_type);
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