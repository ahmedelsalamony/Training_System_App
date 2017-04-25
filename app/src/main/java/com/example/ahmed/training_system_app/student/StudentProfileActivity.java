package com.example.ahmed.training_system_app.student;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.ahmed.training_system_app.R;
import com.example.ahmed.training_system_app.launching.UserLoginFragment;

public class StudentProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stu_activity_student_profile);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);




        SendRequestFragment sendRequestFragment =new SendRequestFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        ft.replace(R.id.stu_activity_student_profile,sendRequestFragment);
        ft.commit();



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.stu_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_send) {

            SendReportFragment sendReportFragment =new SendReportFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft= fm.beginTransaction();
            ft.replace(R.id.stu_activity_student_profile,sendReportFragment);
            ft.commit();


            return true;
        }else if(id == R.id.nav_info){
            UserInformationFragment userInformationFragment =new UserInformationFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft= fm.beginTransaction();
            ft.replace(R.id.stu_activity_student_profile,userInformationFragment);
            ft.commit();

        }


        return super.onOptionsItemSelected(item);
    }

}
