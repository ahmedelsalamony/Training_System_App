package com.example.ahmed.training_system_app.company;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ahmed.training_system_app.R;
import com.example.ahmed.training_system_app.web.WebServices;
import com.example.ahmed.training_system_app.web.request_interface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompanySeeRequestsFragment extends Fragment {

     WebServices mWebServices;
     StringBuffer userNames , userPhone ,userEmail,userId;
     String names[] , phones[] ,emails[] ,ids[];
     CardViewAdapter adapter;
     ListView listView;
     View   mView;
     int position = 0;
Typeface custom_font;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
           mView= inflater.inflate(R.layout.com_fragment_company_see_requests, container, false);

        CompanyProfileActivity.sCompanyHome=3;


        custom_font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/font.ttf");

        mWebServices=new WebServices();
        mWebServices.sharedPreferences=getActivity().getSharedPreferences("abc",0);
        listView = (ListView) mView.findViewById(R.id.ListView_See_Requests);
        userNames=new StringBuffer();
        userEmail=new StringBuffer();
        userPhone=new StringBuffer();
        userId=new StringBuffer();


        mWebServices.searchCompany(getActivity(), mWebServices.sharedPreferences.getInt("id", 2017), new request_interface() {




            @Override
            public void onResponse(String response) {
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(response);

                String email_response = jsonObject.getString("search_response");

                if (email_response.equals("done"))
                {

                    mWebServices.getAllRequests(getActivity() , new request_interface() {
                        @Override
                        public void onResponse(String response) {

                            try {

                                JSONObject jsonResponse = new JSONObject(response);
                                JSONArray jsonArray = jsonResponse.getJSONArray("requests");


                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject search_object = jsonArray.getJSONObject(i);
                                    userNames.append(search_object.getString("user_name") + "#");
                                    userPhone.append(search_object.getString("phone") + "#");
                                    userEmail.append(search_object.getString("email") + "#");
                                    userId.append(search_object.getString("id") + "#");

                                }


                                names = userNames.toString().split("#");
                                phones = userPhone.toString().split("#");
                                emails = userEmail.toString().split("#");
                                ids=userId.toString().split("#");

                                adapter = new CardViewAdapter(getActivity(),names,phones,emails);

                                listView.setAdapter(adapter);



                            } catch (JSONException e) {
                                Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onError() {

                            Snackbar.make(getActivity().findViewById(android.R.id.content), "خطأ فى الاتصال ", Snackbar.LENGTH_LONG).show();

                        }

                    });



                }

                else if (email_response.equals("notDone"))
                {
                    NoRequestsFragment companyHomeFragment =new NoRequestsFragment();
                    FragmentManager fm =getActivity(). getSupportFragmentManager();
                    FragmentTransaction ft= fm.beginTransaction();
                    ft.replace(R.id.com_activity_company_profile,companyHomeFragment);
                    ft.commit();

                }
            } catch (JSONException e) {
                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onError() {


            }
        });

        userNames=new StringBuffer();
       userPhone=new StringBuffer();
       userEmail=new StringBuffer();




    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        position = i;

        AlertDialog.Builder  builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("طلب تدريب ");
        builder.setMessage("هل تريد قبول طلب التدريب ؟");
        builder.setCancelable(true);
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                // TODO >> update table reports . column training_order_status >> false
                Toast.makeText(getActivity(), ""+position, Toast.LENGTH_SHORT).show();
                    mWebServices.updateReports(getActivity() , Integer.parseInt(ids[position]));


                CompanySeeRequestsFragment companySeeRequestsFragment =new CompanySeeRequestsFragment();
                FragmentManager fm =getActivity(). getSupportFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();
                ft.replace(R.id.com_activity_company_profile,companySeeRequestsFragment);
                ft.commit();

            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                  dialogInterface.dismiss();
            }
        });

           builder.show();

     }
     });


        return  mView;
    }

}
