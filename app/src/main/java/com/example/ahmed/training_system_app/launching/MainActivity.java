package com.example.ahmed.training_system_app.launching;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.ahmed.training_system_app.R;


public class MainActivity extends AppCompatActivity {

    static  int sMainActivity =0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lau_activity_main);
        addFragmentLogin();
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
    }


    @Override
    public void onBackPressed() {
        if(sMainActivity ==1){

            finish();
        }else  if(sMainActivity ==2){
            UserLoginFragment userLoginFragment = new UserLoginFragment();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft= fm.beginTransaction();
            ft.replace(R.id.activity_main,userLoginFragment);
            ft.commit();

        }


    }

    public  void addFragmentLogin(){
        UserLoginFragment userLoginFragment = new UserLoginFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        ft.replace(R.id.activity_main,userLoginFragment);
        ft.commit();

    }




}
