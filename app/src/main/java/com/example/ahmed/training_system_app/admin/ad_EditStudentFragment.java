package com.example.ahmed.training_system_app.admin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.ahmed.training_system_app.R;
import com.example.ahmed.training_system_app.web.WebServices;
import com.example.ahmed.training_system_app.web.request_interface;

/**
 * Created by ahmed on 4/25/2017.
 */

public class ad_EditStudentFragment extends Fragment {

    View mView;
    Button btnsave;
    EditText edtUserName,edtPassword,edtEmail,edtPhoneNumber,edtSupervisorName,edtUniqueNum,edtYearStudy,edtDepart,edtStudentGrade;
    WebServices webServices;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.ad_add_student_fragment, container, false);

        AdminProfileActivity.sAdmin=6;

        webServices = new WebServices();
        edtUserName = (EditText) mView.findViewById(R.id.AddStudent_Edit_UserName);
        edtPassword = (EditText) mView.findViewById(R.id.AddStudent_Edit_password);
        edtEmail = (EditText) mView.findViewById(R.id.AddStudent_Edit_email);
        edtPhoneNumber = (EditText) mView.findViewById(R.id.AddStudent_Edit_phone);
        edtSupervisorName = (EditText) mView.findViewById(R.id.AddStudent_Edit_supervisor);
        edtUniqueNum = (EditText) mView.findViewById(R.id.AddStudent_uniquenum);
        edtYearStudy = (EditText) mView.findViewById(R.id.AddStudent_yearstudy);
        edtDepart = (EditText) mView.findViewById(R.id.AddStudent_depart);
        edtStudentGrade = (EditText) mView.findViewById(R.id.AddStudent_studentgrade);
        btnsave = (Button) mView.findViewById(R.id.AddStudent_btnAddStudent);

        Bundle arguments = getArguments();
        final   int id=arguments.getInt("id");
        String user_name = arguments.getString("user_name");
        String password =arguments.getString("password");
        String email=arguments.getString("email");
        String phone=arguments.getString("phone");
        String supervisor_name=arguments.getString("supervisor_name");
        String unique_num=arguments.getString("unique_num");
        String year_study=arguments.getString("year_study");
        String department=arguments.getString("department");
        String student_grade=arguments.getString("student_grade");

        edtUserName.setText(user_name);
        edtPassword.setText(password);
        edtEmail.setText(email);
        edtPhoneNumber.setText(phone);
        edtSupervisorName.setText(supervisor_name);
        edtUniqueNum.setText(unique_num);
        edtYearStudy.setText(year_study);
        edtDepart.setText(department);
        edtStudentGrade.setText(student_grade);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                webServices.updateStudentData(getActivity(),id,edtUserName.getText().toString(),edtPassword.getText().toString(),
                        edtEmail.getText().toString(),edtPhoneNumber.getText().toString(),edtSupervisorName.getText().toString()
                        ,edtUniqueNum.getText().toString(),edtYearStudy.getText().toString(),
                        edtDepart.getText().toString(),edtStudentGrade.getText().toString(),"");

            }
        });

        return mView;
    }
}
