package com.example.ahmed.training_system_app.student;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ahmed.training_system_app.R;
import com.example.ahmed.training_system_app.web.WebServices;


public class UserInformationFragment extends Fragment {

      private TextView mUserName , mPhone ,mEmail ,mSupervisor ,mGrade , mYear ,mUnique;
      private  View mView;
      private WebServices mWebServices;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView= inflater.inflate(R.layout.stu_fragment_information, container, false);
        mWebServices=new WebServices();
        mWebServices.sharedPreferences=getActivity().getSharedPreferences("abc" , 0);

        mUserName= (TextView) mView.findViewById(R.id.textView_StudentName_Info);
        mEmail= (TextView) mView.findViewById(R.id.textView_StudentEmail_Info);
        mPhone= (TextView) mView.findViewById(R.id.textView_StudentPhone_Info);
        mGrade= (TextView) mView.findViewById(R.id.textView_StudentGrades_Info);
        mYear= (TextView) mView.findViewById(R.id.textView_StudentYear_Info);
        mUnique= (TextView) mView.findViewById(R.id.textView_StudentUniq_Info);
        mSupervisor= (TextView) mView.findViewById(R.id.textView_StudentVisor_Info);

        mUserName.setText(mWebServices.sharedPreferences.getString("user_name",""));
        mEmail.setText(mWebServices.sharedPreferences.getString("email",""));
        mUnique.setText(mWebServices.sharedPreferences.getString("uniq_num",""));
        mPhone.setText(mWebServices.sharedPreferences.getString("phone",""));
        mSupervisor.setText(mWebServices.sharedPreferences.getString("supervisor_name",""));
        mYear.setText(mWebServices.sharedPreferences.getString("year_study",""));
        mGrade.setText(""+mWebServices.sharedPreferences.getFloat("student_grade",0));







        return  mView;

    }

}
