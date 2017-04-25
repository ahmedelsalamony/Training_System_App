package com.example.ahmed.training_system_app.supervisor;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ahmed.training_system_app.R;
import com.example.ahmed.training_system_app.supervisor.*;
import com.example.ahmed.training_system_app.web.WebServices;
import com.example.ahmed.training_system_app.web.request_interface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowReportsFragment extends Fragment {

    private  View mView;
    private ListView mListView;
    private  CardViewAdapter adapter;
    private WebServices mWebServices;
    private  StringBuffer mStudentsName , mStudentsReports;
    private String mNamesArray[] , mReportsArray[];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      mView = inflater.inflate(R.layout.sup_fragment_show_reports, container, false);
        mListView= (ListView) mView.findViewById(R.id.ListView_See_Reports);
        mWebServices=new WebServices();
      mWebServices.sharedPreferences=getActivity().getSharedPreferences("abc",0);
        mStudentsName=new StringBuffer();
        mStudentsReports=new StringBuffer();
        final String superName=mWebServices.sharedPreferences.getString("user_name", "");

       mWebServices.getAllReports(getActivity(),superName,  new request_interface() {

           @Override
           public void onResponse(String response) {
               try {

                   Toast.makeText(getActivity(), ""+superName, Toast.LENGTH_SHORT).show();
                   JSONObject jsonResponse = new JSONObject(response);
                   JSONArray jsonArray = jsonResponse.getJSONArray("reports");

                   Toast.makeText(getActivity(), ""+jsonResponse.toString(), Toast.LENGTH_SHORT).show();
                   for (int i = 0; i < jsonArray.length(); i++) {

                       JSONObject search_object = jsonArray.getJSONObject(i);
                       mStudentsName.append(search_object.getString("user_name") + "#");
                       mStudentsReports.append(search_object.getString("reports") + "#");
                   }

                   mNamesArray=mStudentsName.toString().split("#");
                   mReportsArray=mStudentsReports.toString().split("#");
               adapter = new CardViewAdapter(getActivity() , mNamesArray , mReportsArray);
            mListView .setAdapter(adapter);



               } catch (JSONException e) {
                   e.printStackTrace();
               }
           }
           @Override
           public void onError() {
               Toast.makeText(getActivity(), "خطأ بالاتصال بقاعدة البيانات .", Toast.LENGTH_SHORT).show();
           }
       });




       return  mView;
    }

}
