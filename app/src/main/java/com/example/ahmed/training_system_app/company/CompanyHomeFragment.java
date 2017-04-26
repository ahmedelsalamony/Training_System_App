package com.example.ahmed.training_system_app.company;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ahmed.training_system_app.R;
import com.example.ahmed.training_system_app.web.WebServices;


public class CompanyHomeFragment extends Fragment {

        private View mView;
        private  TextView  mCompanyName, mCompanyPhone, mCompanyEmail;
        private Typeface mCustomFont;
        private WebServices mWebServices;

        private Button mShowRequests;
        private FloatingActionButton mFloatButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.com_fragment_company_home, container, false);

        CompanyProfileActivity.sCompanyHome=1;

        mWebServices=new WebServices();
        mWebServices.sharedPreferences=getActivity().getSharedPreferences("abc",0);
        mCustomFont=Typeface.createFromAsset(getActivity().getAssets(), "fonts/font.ttf");

        mCompanyName= (TextView) mView.findViewById(R.id.TextView_Company_Name);
        mCompanyPhone= (TextView) mView.findViewById(R.id.TextView_Company_Phone);
        mCompanyEmail= (TextView) mView.findViewById(R.id.TextView_Company_Email);
        mShowRequests= (Button) mView.findViewById(R.id.Button_Show_Requests);
          mShowRequests.setTypeface(mCustomFont);
        mFloatButton= (FloatingActionButton) mView.findViewById(R.id.floatingActionButton);

        mCompanyName.setTypeface(mCustomFont);
        mCompanyEmail.setTypeface(mCustomFont);
        mCompanyPhone.setTypeface(mCustomFont);


        mCompanyName.setText(mWebServices.sharedPreferences.getString("user_name",""));
        mCompanyPhone.setText(mWebServices.sharedPreferences.getString("phone",""));
        mCompanyEmail.setText(mWebServices.sharedPreferences.getString("email",""));



        mFloatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AddRequestsFragment addRequestsFragment =new AddRequestsFragment();
                FragmentManager fm =getActivity().getSupportFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();
                 ft.replace(R.id.com_activity_company_profile,addRequestsFragment);
                ft.commit();

            }
        });




        mShowRequests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              CompanySeeRequestsFragment companySeeRequestsFragment =new CompanySeeRequestsFragment();
                FragmentManager fm =getActivity().getSupportFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();
                ft.replace(R.id.com_activity_company_profile,companySeeRequestsFragment);
                ft.commit();

                
            }
        });

        return  mView;
    }

}
