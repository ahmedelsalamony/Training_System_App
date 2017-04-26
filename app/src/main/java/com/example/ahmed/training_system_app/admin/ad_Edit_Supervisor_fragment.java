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

/**
 * Created by ahmed on 4/24/2017.
 */

public class ad_Edit_Supervisor_fragment extends Fragment {

    View mView;
    Button btnsave;
    EditText edtUserName,edtPassword,edtUniqueNum,edtEmail,edtPhone,edtDepartment;
    WebServices webServices;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView= inflater.inflate(R.layout.ad_add_supervisor_fragment, container, false);

        AdminProfileActivity.sAdmin=8;

        webServices=new WebServices();
        edtUserName=(EditText)mView.findViewById(R.id.AddSuper_Add_UserName);
        edtPassword=(EditText)mView.findViewById(R.id.AddSuper_Add_Password);
        edtEmail=(EditText)mView.findViewById(R.id.AddSuper_Add_email);
        edtDepartment=(EditText)mView.findViewById(R.id.AddSuper_Add_department);
        edtPhone=(EditText)mView.findViewById(R.id.AddSuper_Add_phone);
        edtUniqueNum=(EditText)mView.findViewById(R.id.AddSuper_Add_unique_num);
        btnsave=(Button)mView.findViewById(R.id.AddSuper_btnAddSuper);

        Bundle arguments = getArguments();
        final   int id=arguments.getInt("id");
        String user_name = arguments.getString("user_name");
        String password =arguments.getString("password");
        String unique_num=arguments.getString("unique_num");
        String phone=arguments.getString("phone");
        String email=arguments.getString("email");
        String department=arguments.getString("department");

        edtUserName.setText(user_name);
        edtPassword.setText(password);
        edtEmail.setText(email);
        edtPhone.setText(phone);
        edtUniqueNum.setText(unique_num);
        edtDepartment.setText(department);


        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                webServices.updateStudentData(getActivity(),id,edtUserName.getText().toString(),edtPassword.getText().toString(),
                        edtEmail.getText().toString(),edtPhone.getText().toString(),""
                        ,edtUniqueNum.getText().toString(),"",
                        edtDepartment.getText().toString(),"","");

            }
        });


        return mView;
    }
}
