package com.example.ahmed.training_system_app.supervisor;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ahmed.training_system_app.R;
import com.example.ahmed.training_system_app.company.CompanyHomeFragment;

public class SupervisorProfileActivity extends AppCompatActivity {

    static int sSupervisor=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sup_activity_supervisor_profile);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        SuperHomeFragment superHomeFragment =new SuperHomeFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        ft.replace(R.id.sup_activity_supervisor_profile,superHomeFragment);
        ft.commit();


    }

    @Override
    public void onBackPressed() {
        if(sSupervisor==1){
            finish();
        }else {
            SuperHomeFragment superHomeFragment =new SuperHomeFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft= fm.beginTransaction();
            ft.replace(R.id.sup_activity_supervisor_profile,superHomeFragment);
            ft.commit();

        }
    }
}
