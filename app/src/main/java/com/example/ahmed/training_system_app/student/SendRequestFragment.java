package com.example.ahmed.training_system_app.student;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ahmed.training_system_app.R;
import com.example.ahmed.training_system_app.company.CardViewAdapter;
import com.example.ahmed.training_system_app.company.CompanyHomeFragment;
import com.example.ahmed.training_system_app.web.WebServices;
import com.example.ahmed.training_system_app.web.request_interface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class SendRequestFragment extends Fragment {


    private  View mView;
    private ListView mListView;
    private Button mSend;
    private WebServices mWebService;
    private StringBuffer mCompanyNames;
    private String  mCompaniesNames[];
    private TextView mDefaultText;
    Typeface custom_font;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       mView=inflater.inflate(R.layout.stu_fragment_send_request, container, false);
        StudentProfileActivity.sStudent=1;
        custom_font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/font.ttf");

        mDefaultText= (TextView) mView.findViewById(R.id.TextView_Default);
        mListView= (ListView) mView.findViewById(R.id.ListView_See_Companies);
        mSend= (Button) mView.findViewById(R.id.Button_sendRequest);
        mWebService=new WebServices();
        mWebService.sharedPreferences=getActivity().getSharedPreferences("abc",0);
        mCompanyNames=new StringBuffer();


        mDefaultText.setTypeface(custom_font);
 mSend.setTypeface(custom_font);
        mWebService.getAllCompany(getActivity(), new request_interface() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONObject jsonResponse = new JSONObject(response);
                    JSONArray jsonArray = jsonResponse.getJSONArray("company");

                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject search_object = jsonArray.getJSONObject(i);
                        mCompanyNames.append(search_object.getString("user_name") + "#");
                    }

                    mCompaniesNames=mCompanyNames.toString().split("#");
                    ArrayAdapter adapter=new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,mCompaniesNames);

                   if(mCompaniesNames.equals(null)) {
                        mDefaultText.setVisibility(View.VISIBLE);
                       mSend.setVisibility(View.INVISIBLE);

                       mSend.setOnClickListener(null);
                       mSend.setClickable(false);
                       mSend.setEnabled(false);

                   }
                   else {
                       mDefaultText.setVisibility(View.INVISIBLE);
                       mSend.setVisibility(View.VISIBLE);

                        mListView.setAdapter(adapter);
                   }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onError() {
                Toast.makeText(getActivity(), "خطأ بالاتصال بقاعدة البيانات .", Toast.LENGTH_SHORT).show();
            }
        });





          mSend.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {

                  mWebService.addTrainingOrder(getActivity(),mWebService.sharedPreferences.getInt("id",2017),"no report yet!","true",mWebService.sharedPreferences.getString("sup_name",""));

              }
          });












        return  mView;

    }

}
