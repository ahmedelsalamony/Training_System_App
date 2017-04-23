package com.example.ahmed.training_system_app.web;

/**
 * Created by ahmed on 4/23/2017.
 */

import android.app.Activity;
import android.app.Dialog;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ahmed.training_system_app.admin.AdminProfileActivity;
import com.example.ahmed.training_system_app.company.CompanyProfileActivity;
import com.example.ahmed.training_system_app.student.StudentProfileActivity;
import com.example.ahmed.training_system_app.supervisor.SupervisorProfileActivity;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;


public class WebServices {

    AlertDialog.Builder b;
    public  SharedPreferences  sharedPreferences;
    public SharedPreferences.Editor editor;

    // TODO Parameters Of Tables and WebService Function
    public static String ID = "id";
    public static String USERNAME = "user_name";
    public static String PASSWORD = "password";
    public static String EMAIL = "email";
    public static String PHONE = "phone";
    public static String USERTYPE = "user_type";
    public static String SUPERVISORNAME = "supervisor_name";
    public static String UNIQUENUM = "unique_num";
    public static String YEARSTUDY = "year_study";
    public static String DEPARTMENT = "department";
    public static String STUDENTGRADE = "student_grade";
    public static String SITECOMPANY = "site_company";


    // TODO Tag that use it to know type of WebService   >> you can here put the TAG  of your method Name ------//
    public static String TAG = "tag";
    public static String ADD_USER_TAG = "add_user";
    public static String USERLOGINTAG = "login_user";
    public static String GETADMINEMAIL = "getAdminEmail";

    private RequestQueue queue;
    private String url = "http://it-training.000webhostapp.com/uploads/re_tags.php";

    // TODO Login Method ----------------------------------//
    public void user_login(final Activity activity, final String unique_num, final String password) {

        sharedPreferences=activity.getSharedPreferences("abc",0);
        editor = sharedPreferences.edit();

        queue = Volley.newRequestQueue(activity);
        final StringRequest request = new StringRequest(com.android.volley.Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {

                    JSONObject jsonObject = new JSONObject(response);
                    String login_response = jsonObject.getString("login_response");

                    if (login_response.equals("done")) {

                        int  id = jsonObject.getInt("id");
                        String user_name = jsonObject.getString("user_name");
                        String password = jsonObject.getString("password");
                        String email = jsonObject.getString("email");
                        String phone = jsonObject.getString("phone");
                        String user_type = jsonObject.getString("user_type");
                        String supervisor_name = jsonObject.getString("supervisor_name");
                        String unique_num = jsonObject.getString("unique_num");
                        String year_study = jsonObject.getString("year_study");
                        String department = jsonObject.getString("department");
                        String student_grade = jsonObject.getString("student_grade");
                        String site_company = jsonObject.getString("site_company");
                        editor.putInt("id",  id);
                        editor.putString("user_name",user_name);
                        editor.putString("password",password);
                        editor.putString("email",email);
                        editor.putString("phone",phone);
                        editor.putString("user_type",user_type);
                        editor.putString("sup_name",supervisor_name);
                        editor.putString("uniq_num",unique_num);
                        editor.putString("year_study",year_study);
                        editor.putString("department",department);
                        editor.putFloat("student_grade", Float.parseFloat(student_grade));
                        editor.putString("site_company",site_company);
                        editor.commit();
                        if (user_type.equals("admin"))
                        {
                            Intent i = new Intent(activity, AdminProfileActivity.class);
                            activity.startActivity(i);
                        }
                        else if (user_type.equals("supervisor"))
                        {
                            Intent i = new Intent(activity, SupervisorProfileActivity.class);
                            activity.startActivity(i);
                        }
                        else if (user_type.equals("company"))
                        {
                            Intent i = new Intent(activity, CompanyProfileActivity.class);
                            activity.startActivity(i);
                        }
                        else if (user_type.equals("student"))
                        {
                            Intent i = new Intent(activity, StudentProfileActivity.class);
                            activity.startActivity(i);
                        }
                    } else if (login_response.equals("incorrect password"))
                    {
                        Toast.makeText(activity, "incorrect password please try again", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(activity, "User Invalid. ", Toast.LENGTH_LONG).show();
                    }

                } catch (JSONException e) {

                }
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Snackbar.make(activity.findViewById(android.R.id.content), "Internet Connection", Snackbar.LENGTH_LONG).show();

            }
        }) {
            protected java.util.Map<String, String> getParams() throws AuthFailureError {
                java.util.Map<String, String> params = new HashMap<String, String>();
                params.put(UNIQUENUM, unique_num);
                params.put(PASSWORD, password);
                params.put(TAG, USERLOGINTAG);
                return params;
            }

        };
        queue.add(request);

    }


    // TODO Register Method --------------------//

    public void addUser(final Activity activity, final String user_name, final String password, final String email,
                        final String phone, final String user_type, final String supervisor_name,
                        final String unique_num, final String year_study,
                        final String department, final double student_grade, final String site_company) {


        b = new AlertDialog.Builder(activity);
        b.setMessage("تحميل...");
        b.setTitle("اضافة");


        queue = Volley.newRequestQueue(activity);
        StringRequest request = new StringRequest(com.android.volley.Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                b.setCancelable(true);
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Snackbar.make(activity.findViewById(android.R.id.content), "Internet Connection", Snackbar.LENGTH_LONG).show();
            }
        })

        {
            @Override
            protected java.util.Map<String, String> getParams() throws AuthFailureError {
                java.util.Map<String, String> params = new HashMap<String, String>();


                params.put(USERNAME, user_name);
                params.put(PASSWORD, password);
                params.put(EMAIL, email);
                params.put(PHONE, phone);
                params.put(USERTYPE, user_type);
                params.put(SUPERVISORNAME, supervisor_name);
                params.put(UNIQUENUM, unique_num);
                params.put(YEARSTUDY, year_study);
                params.put(DEPARTMENT, department);
                params.put(STUDENTGRADE, String.valueOf(student_grade));
                params.put(SITECOMPANY, site_company);


                params.put(TAG, ADD_USER_TAG);
                return params;
            }
        };
        queue.add(request);
    }

    //-------------------------------------------------------------------------------------------------//

    public void getAdminEmail(final Activity activity, final request_interface requestinterface) {
        Toast.makeText(activity, "" + url, Toast.LENGTH_SHORT).show();
        queue = Volley.newRequestQueue(activity);
        final StringRequest request = new StringRequest(com.android.volley.Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response)
            {
             requestinterface.onResponse(response);
            }

        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error) {

                requestinterface.onError();
            }
        }) {
            protected java.util.Map<String, String> getParams() throws AuthFailureError {
                java.util.Map<String, String> params = new HashMap<String, String>();

                params.put(TAG, GETADMINEMAIL);
                return params;
            }

        };
        queue.add(request);

    }


}