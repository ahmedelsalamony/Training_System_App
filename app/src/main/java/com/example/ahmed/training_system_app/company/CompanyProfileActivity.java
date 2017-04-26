package com.example.ahmed.training_system_app.company;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ahmed.training_system_app.R;

public class CompanyProfileActivity extends AppCompatActivity {

     static int  sCompanyHome  = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.com_activity_company_profile);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        addCompanyHome();



    }



    @Override
    public void onBackPressed() {

        if(sCompanyHome == 1){

         finish();

        }
        else if(sCompanyHome == 2){

            CompanyHomeFragment companyHomeFragment =new CompanyHomeFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft= fm.beginTransaction();
            ft.replace(R.id.com_activity_company_profile,companyHomeFragment);
            ft.commit();

        }

        else if(sCompanyHome == 2){

            CompanyHomeFragment companyHomeFragment =new CompanyHomeFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft= fm.beginTransaction();
            ft.replace(R.id.com_activity_company_profile,companyHomeFragment);
            ft.commit();

        }

        else if(sCompanyHome == 3){

            CompanyHomeFragment companyHomeFragment =new CompanyHomeFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft= fm.beginTransaction();
            ft.replace(R.id.com_activity_company_profile,companyHomeFragment);
            ft.commit();

        }

        else if(sCompanyHome == 4){

            CompanyHomeFragment companyHomeFragment =new CompanyHomeFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft= fm.beginTransaction();
            ft.replace(R.id.com_activity_company_profile,companyHomeFragment);
            ft.commit();

        }



    }



    public  void addCompanyHome(){
        CompanyHomeFragment companyHomeFragment =new CompanyHomeFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        ft.replace(R.id.com_activity_company_profile,companyHomeFragment);
        ft.commit();


    }

}
