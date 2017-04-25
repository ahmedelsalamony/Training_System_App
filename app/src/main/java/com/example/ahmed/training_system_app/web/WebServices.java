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
import android.view.View;
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
    public SharedPreferences sharedPreferences;
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

    //  TODO training Table
    public static String ID_Training = "id";
    public static String UID_Taining = "uid";
    public static String VACANCIES_Num = "vacancies_num";
    public static String ADVERTISE_Status = "advertise_status";
    public static String DEPARTMENT_Training = "department";
    public static String FROM_Date = "from_date";
    public static String TO_Date = "to_date";
    public static String SALARY = "salary";


    // TODO reports Table
    public static String ID_Reports = "id";
    public static String UID_Reports = "uid";
    public static String REPORTS = "reports";
    public static String TRAINING_STATUS = "training_order_status";
    public static String Reorts_SUperVisor = "supervisor_name";

    // TODO Tag that use it to know type of WebService   >> you can here put the TAG  of your method Name ------//
    public static String TAG = "tag";
    public static String ADD_USER_TAG = "add_user";
    public static String USERLOGINTAG = "login_user";
    public static String GETADMINEMAIL = "getAdminEmail";
    public static String ADD_ADVERTISE_TRAIN = "add_training";
    public static String GetAdminData="getAdminData";
    public static String UpdateAdminData="updateAdminData";
    public static String GetStudentData="getStudentData";
    public static String UpdateStudentData="updateStudentData";
    public static String GetCompanyData="getCompanyData";
    public static String GetSupervisorData="getSupervisorData";

    public static String ADD_TRAINING_ORDER = "add_training_order";
    public static String GETAIIREQUESTS = "getAllRequsts";
    public static String SEARCHCOMPANY = "search_company";
    public static String UPDATEREPORTS = "update_reports";
    public static String GET_ALL_COMPANY = "getAllCompany";
    public static String GET_ALL_Students = "getAllStudents";
    public static String UPDATEREPORTS_REPORT = "update_reports_report";
    public static String GET_ALL_Reports = "getAllReports";

    private RequestQueue queue;
    private String url = "http://it-training.000webhostapp.com/uploads/re_tags.php";

    // TODO Login Method ----------------------------------//
    public void user_login(final Activity activity, final String unique_num, final String password)
    {
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

                        int id = jsonObject.getInt("id");
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
                        editor.putString("unique_num",unique_num);
                        editor.putString("year_study",year_study);
                        editor.putString("department",department);
                        editor.putInt("id", id);
                        editor.putString("user_name", user_name);
                        editor.putString("password", password);
                        editor.putString("email", email);
                        editor.putString("phone", phone);
                        editor.putString("user_type", user_type);
                        editor.putString("sup_name", supervisor_name);
                        editor.putString("uniq_num", unique_num);
                        editor.putString("year_study", year_study);
                        editor.putString("department", department);
                        editor.putFloat("student_grade", Float.parseFloat(student_grade));
                        editor.putString("site_company", site_company);
                        editor.commit();
                        if (user_type.equals("admin")) {
                            Intent i = new Intent(activity, AdminProfileActivity.class);
                            activity.startActivity(i);
                        } else if (user_type.equals("supervisor")) {
                            Intent i = new Intent(activity, SupervisorProfileActivity.class);
                            activity.startActivity(i);
                        } else if (user_type.equals("company")) {
                            Intent i = new Intent(activity, CompanyProfileActivity.class);
                            activity.startActivity(i);
                        } else if (user_type.equals("student")) {
                            Intent i = new Intent(activity, StudentProfileActivity.class);
                            activity.startActivity(i);
                        }
                    } else if (login_response.equals("incorrect password")) {
                        Toast.makeText(activity, "من فضلك اعد ادخال كلمة المرور الصحيحة", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(activity, " هذا المستخدم غير موجود بالنظام", Toast.LENGTH_LONG).show();
                    }

                } catch (JSONException e) {

                }
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Snackbar.make(activity.findViewById(android.R.id.content), "الاتصال بالانترنت", Snackbar.LENGTH_LONG).show();

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
                Snackbar.make(activity.findViewById(android.R.id.content), "الاتصال بالانترنت", Snackbar.LENGTH_LONG).show();
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
            public void onResponse(String response) {
                requestinterface.onResponse(response);
            }

        }, new Response.ErrorListener() {
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


    //----------------------------------------------------------------------------------------//

    public void addTraining(final Activity activity, final int uid, final String vacancies_num, final String advertise_status,
                            final String department, final String from_date, final String to_date, final String salary) {


        b = new AlertDialog.Builder(activity);
        b.setMessage("تحميل...");
        b.setTitle("اضافة");


        queue = Volley.newRequestQueue(activity);
        StringRequest request = new StringRequest(com.android.volley.Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                b.setCancelable(true);
                Toast.makeText(activity, "تمت اضافة الاعلان", Toast.LENGTH_SHORT).show();
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Snackbar.make(activity.findViewById(android.R.id.content), "الاتصال بالانترنت", Snackbar.LENGTH_LONG).show();
            }
        })

        {
            @Override
            protected java.util.Map<String, String> getParams() throws AuthFailureError {
                java.util.Map<String, String> params = new HashMap<String, String>();


                params.put(UID_Taining, "" + uid);

                params.put(VACANCIES_Num, vacancies_num);
                params.put(ADVERTISE_Status, advertise_status);
                params.put(DEPARTMENT, department);
                params.put(FROM_Date, from_date);
                params.put(TO_Date, to_date);
                params.put(SALARY, salary);

                params.put(TAG, ADD_ADVERTISE_TRAIN);
                return params;
            }
        };
        queue.add(request);
    }


    //-----------------------------------------------------------------------------------------//


    public void getAllRequests(final Activity activity, final request_interface object) {
        queue = Volley.newRequestQueue(activity);
        StringRequest request = new StringRequest(com.android.volley.Request.Method.POST, url, new Response.Listener<String>() {


            @Override
            public void onResponse(String response) {
                object.onResponse(response);


            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                object.onError();

            }
        }) {
            @Override
            protected java.util.Map<String, String> getParams() throws AuthFailureError {
                java.util.Map<String, String> params = new HashMap<String, String>();

                params.put(TAG, GETAIIREQUESTS);
                return params;
            }


        };
        queue.add(request);

    }


    //-----------------------------------------------------//

    public void searchCompany(final Activity activity, final int id, final request_interface request_interface) {


        queue = Volley.newRequestQueue(activity);
        final StringRequest request = new StringRequest(com.android.volley.Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                request_interface.onResponse(response);
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                request_interface.onError();
            }
        }) {
            protected java.util.Map<String, String> getParams() throws AuthFailureError {
                java.util.Map<String, String> params = new HashMap<String, String>();
                params.put(UID_Taining, "" + id);
                params.put(TAG, SEARCHCOMPANY);
                return params;
            }

        };
        queue.add(request);

    }


    //-------------------------------------------------------------------//

    //TODO Update reports data
    public void updateReports(final Activity activity, final int id) {
        queue = Volley.newRequestQueue(activity);
        StringRequest request = new StringRequest(com.android.volley.Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(activity, "تم قبول الطالب", Toast.LENGTH_SHORT).show();
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Snackbar.make(activity.findViewById(android.R.id.content), "خطأ بالاتصال", Snackbar.LENGTH_LONG).show();
            }
        })

        {
            @Override
            protected java.util.Map<String, String> getParams() throws AuthFailureError {
                java.util.Map<String, String> params = new HashMap<String, String>();


                params.put(ID, ""+ id);

                params.put(TAG, UPDATEREPORTS);
                return params;
            }
        };
        queue.add(request);
    }



    //-----------------------------------------------------------------------//
    public void addTrainingOrder(final Activity activity, final int uid, final String report, final String training_Order_status ,final String supervisorName) {



        queue = Volley.newRequestQueue(activity);
        StringRequest request = new StringRequest(com.android.volley.Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(activity, "لقد قمت بارسال طلب تدريب للشركات", Toast.LENGTH_SHORT).show();
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Snackbar.make(activity.findViewById(android.R.id.content), "الاتصال بالانترنت", Snackbar.LENGTH_LONG).show();
            }
        })

        {
            @Override
            protected java.util.Map<String, String> getParams() throws AuthFailureError {
                java.util.Map<String, String> params = new HashMap<String, String>();


                params.put(UID_Reports, "" + uid);
                params.put(SUPERVISORNAME,  supervisorName);
                params.put(REPORTS, report);
                params.put(TRAINING_STATUS, training_Order_status);

                params.put(TAG, ADD_TRAINING_ORDER);

                return params;
            }
        };

        queue.add(request);
    }



//---------------------------------------------------------------------------//
public void getAllCompany(final Activity activity, final request_interface object) {
    queue = Volley.newRequestQueue(activity);
    StringRequest request = new StringRequest(com.android.volley.Request.Method.POST, url, new Response.Listener<String>() {


        @Override
        public void onResponse(String response) {
            object.onResponse(response);


        }

    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            object.onError();

        }
    }) {
        @Override
        protected java.util.Map<String, String> getParams() throws AuthFailureError {
            java.util.Map<String, String> params = new HashMap<String, String>();

            params.put(TAG, GET_ALL_COMPANY);
            return params;
        }


    };
    queue.add(request);

}

//---------------------------------------------------------------------------------------//

    public void updateReportsReport(final Activity activity, final int uid, final String report, final request_interface request_interface) {
        queue = Volley.newRequestQueue(activity);
        final StringRequest request = new StringRequest(com.android.volley.Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
request_interface.onResponse(response);

            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                request_interface.onError();
            }
        })

        {
            @Override
            protected java.util.Map<String, String> getParams() throws AuthFailureError {
                java.util.Map<String, String> params = new HashMap<String, String>();


                params.put(UID_Reports, ""+ uid);
                params.put(REPORTS, ""+ report);
                params.put(TAG, UPDATEREPORTS_REPORT);
                return params;
            }
        };
        queue.add(request);
    }



    //--------------------------------------------------------------------------------//
    public void getAllStudents(final Activity activity,final String superVisorName, final request_interface object) {
        queue = Volley.newRequestQueue(activity);
        StringRequest request = new StringRequest(com.android.volley.Request.Method.POST, url, new Response.Listener<String>() {


            @Override
            public void onResponse(String response) {
                object.onResponse(response);


            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                object.onError();

            }
        }) {
            @Override
            protected java.util.Map<String, String> getParams() throws AuthFailureError {
                java.util.Map<String, String> params = new HashMap<String, String>();
                params.put(SUPERVISORNAME, superVisorName);
                params.put(TAG, GET_ALL_Students);
                return params;
            }


        };
        queue.add(request);

    }

//--------------------------------------------------------------------------//


    public void getAllReports(final Activity activity, final  String SuperVisorName  ,final request_interface object) {
        queue = Volley.newRequestQueue(activity);
        StringRequest request = new StringRequest(com.android.volley.Request.Method.POST, url, new Response.Listener<String>() {


            @Override
            public void onResponse(String response) {
                object.onResponse(response);


            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                object.onError();

            }
        }) {
            @Override
            protected java.util.Map<String, String> getParams() throws AuthFailureError {
                java.util.Map<String, String> params = new HashMap<String, String>();

                params.put(Reorts_SUperVisor,SuperVisorName );


                params.put(TAG,GET_ALL_Reports );
                return params;
            }


        };
        queue.add(request);

    }

    public void getAdminData(Activity activity,final String unique_num,final request_interface requestinterface){

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
                params.put(UNIQUENUM,unique_num);
                params.put(TAG, GetAdminData);
                return params;
            }

        };
        queue.add(request);
    }
    public void updateAdminData(Activity activity,final int id,final String user_name,final String password,final String email,
                                final String phone,final String unique_num,final String department
            ){

        queue=Volley.newRequestQueue(activity);
        final StringRequest request = new StringRequest(com.android.volley.Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response)
            {

            }

        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {

            }
        }) {
            protected java.util.Map<String, String> getParams() throws AuthFailureError {
                java.util.Map<String, String> params = new HashMap<String, String>();
                params.put(ID,""+id);
                params.put(USERNAME,user_name);
                params.put(PASSWORD,password);
                params.put(EMAIL,email);
                params.put(PHONE,phone);
                params.put(UNIQUENUM,unique_num);
                params.put(DEPARTMENT,department);
                params.put(TAG, UpdateAdminData);
                return params;
            }

        };
        queue.add(request);
    }
public void getStudentData(Activity activity,final request_interface requestInterface){

    queue = Volley.newRequestQueue(activity);
    final StringRequest request = new StringRequest(com.android.volley.Request.Method.POST, url, new Response.Listener<String>() {

        @Override
        public void onResponse(String response)
        {
            requestInterface.onResponse(response);
        }

    }, new Response.ErrorListener()
    {
        @Override
        public void onErrorResponse(VolleyError error) {

            requestInterface.onError();
        }
    }) {
        protected java.util.Map<String, String> getParams() throws AuthFailureError {
            java.util.Map<String, String> params = new HashMap<String, String>();
            params.put(USERTYPE,"student");
            params.put(TAG, GetStudentData);
            return params;
        }
    };
    queue.add(request);
}
    public void updateStudentData(Activity activity,final int id,final String user_name,final String password,final String email,
                                  final String phone,final String supervisor_name,final String unique_num,
                                  final String year_study,final String department,final String student_grade,final String site_company)
    {


            queue = Volley.newRequestQueue(activity);
            final StringRequest request = new StringRequest(com.android.volley.Request.Method.POST, url, new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {

                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }) {
                protected java.util.Map<String, String> getParams() throws AuthFailureError {
                    java.util.Map<String, String> params = new HashMap<String, String>();
                    params.put(ID, "" + id);
                    params.put(USERNAME, user_name);
                    params.put(PASSWORD, password);
                    params.put(EMAIL, email);
                    params.put(PHONE, phone);
                    params.put(SUPERVISORNAME, supervisor_name);
                    params.put(UNIQUENUM, unique_num);
                    params.put(YEARSTUDY, year_study);
                    params.put(DEPARTMENT, department);
                    params.put(STUDENTGRADE, student_grade);
                    params.put(SITECOMPANY,site_company);
                    params.put(TAG, UpdateStudentData);
                    return params;
                }

            };
            queue.add(request);

        }

    public void getCompanyData(Activity activity,final request_interface requestInterface){

        queue = Volley.newRequestQueue(activity);
        final StringRequest request = new StringRequest(com.android.volley.Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response)
            {
                requestInterface.onResponse(response);
            }

        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error) {

                requestInterface.onError();
            }
        }) {
            protected java.util.Map<String, String> getParams() throws AuthFailureError {
                java.util.Map<String, String> params = new HashMap<String, String>();
                params.put(USERTYPE,"student");
                params.put(TAG, GetCompanyData);
                return params;
            }
        };
        queue.add(request);
}

    public void getSupervisorData(Activity activity,final request_interface requestInterface){

        queue = Volley.newRequestQueue(activity);
        final StringRequest request = new StringRequest(com.android.volley.Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response)
            {
                requestInterface.onResponse(response);
            }

        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error) {

                requestInterface.onError();
            }
        }) {
            protected java.util.Map<String, String> getParams() throws AuthFailureError {
                java.util.Map<String, String> params = new HashMap<String, String>();
                params.put(USERTYPE,"supervisor");
                params.put(TAG, GetSupervisorData);
                return params;
            }
        };
        queue.add(request);
}}