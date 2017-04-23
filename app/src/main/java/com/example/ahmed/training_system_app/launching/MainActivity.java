package com.example.ahmed.training_system_app.launching;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.ahmed.training_system_app.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lau_activity_main);

        addFragmentLogin();


    }






    public  void addFragmentLogin(){
        UserLoginFragment userLoginFragment = new UserLoginFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        ft.replace(R.id.activity_main,userLoginFragment);
        ft.commit();

    }




}
