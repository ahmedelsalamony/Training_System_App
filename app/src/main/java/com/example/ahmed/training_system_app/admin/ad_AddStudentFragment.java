package com.example.ahmed.training_system_app.admin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.ahmed.training_system_app.R;
import com.example.ahmed.training_system_app.web.WebServices;

/**
 * Created by ahmed on 4/24/2017.
 */

public class ad_AddStudentFragment extends Fragment {

    View mView;
    Button btnsave;
    EditText edtUserName,edtPassword,edtEmail,edtPhoneNumber,edtSupervisorName,edtUniqueNum,edtYearStudy,edtDepart,edtStudentGrade;
    WebServices webServices;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.ad_add_student_fragment, container, false);

        AdminProfileActivity.sAdmin=2;

        webServices=new WebServices();
        edtUserName=(EditText) mView.findViewById(R.id.AddStudent_Edit_UserName);
        edtPassword=(EditText)mView.findViewById(R.id.AddStudent_Edit_password);
        edtEmail=(EditText)mView.findViewById(R.id.AddStudent_Edit_email);
        edtPhoneNumber=(EditText)mView.findViewById(R.id.AddStudent_Edit_phone);
        edtSupervisorName=(EditText)mView.findViewById(R.id.AddStudent_Edit_supervisor);
        edtUniqueNum=(EditText)mView.findViewById(R.id.AddStudent_uniquenum);
        edtYearStudy=(EditText)mView.findViewById(R.id.AddStudent_yearstudy);
        edtDepart=(EditText)mView.findViewById(R.id.AddStudent_depart);
        edtStudentGrade=(EditText)mView.findViewById(R.id.AddStudent_studentgrade);
        btnsave=(Button)mView.findViewById(R.id.AddStudent_btnAddStudent);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                webServices.addUser(getActivity(),edtUserName.getText().toString(),edtPassword.getText().toString(),edtEmail.getText().toString()
                        ,edtPhoneNumber.getText().toString(),"student",edtSupervisorName.getText().toString(),edtUniqueNum.getText().toString(),
                        edtYearStudy.getText().toString(),edtDepart.getText().toString(), Double.parseDouble(edtStudentGrade.getText().toString())
                        ,"");
            }
        });
        return mView;
    }

    }
