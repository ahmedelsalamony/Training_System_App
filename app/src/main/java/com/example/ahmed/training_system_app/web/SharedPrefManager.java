package com.example.ahmed.training_system_app.web;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ahmed on 4/23/2017.
 */

public class SharedPrefManager
{
      public String SHARED_PREF_NAME = "SharedPref";
      public   SharedPreferences   mSharedPreferences ;

    private static int ID = 0;
    private static String user_name ="";
    private static String password ="";
    private static String email  ="";
    private static String phone="";
    private static String user_type ="";
    private static String supervisor_name="";
    private static String unique_num ="";
    private static String year_study ="";
    private static String department ="";
    private static String student_grade ="";
    private static String site_company ="";
    SharedPreferences.Editor editor;




     public SharedPrefManager() {

    }


}
