package com.example.ahmed.training_system_app.admin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ahmed.training_system_app.R;
import com.example.ahmed.training_system_app.web.WebServices;
import com.example.ahmed.training_system_app.web.request_interface;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ahmed on 4/24/2017.
 */

public class ad_Edit_Company_fragment extends Fragment {

    View mView;
    Button btnsave;
    EditText edtUserName,edtPassword,edtEmail,edtPhoneNumber,edtUniqueNum,edtDepart,edtSite;
    WebServices webServices;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView= inflater.inflate(R.layout.ad_add_company, container, false);
        webServices=new WebServices();
        edtUserName=(EditText)mView.findViewById(R.id.AddCompany_Add_UserName);
        edtPassword=(EditText)mView.findViewById(R.id.AddCompany_Add_Password);
        edtEmail=(EditText)mView.findViewById(R.id.AddCompany_Add_email);
        edtPhoneNumber=(EditText)mView.findViewById(R.id.AddCompany_Add_phone);
        edtUniqueNum=(EditText)mView.findViewById(R.id.AddCompany_Add_unique_num);
        edtDepart=(EditText)mView.findViewById(R.id.AddCompany_Add_department);
        edtSite=(EditText)mView.findViewById(R.id.AddCompany_Add_sitecompany);
        btnsave=(Button)mView.findViewById(R.id.AddStudent_btnAddCompany);

        Bundle arguments = getArguments();
        final   int id=arguments.getInt("id");
        String user_name = arguments.getString("user_name");
        String password =arguments.getString("password");
        String unique_num=arguments.getString("unique_num");
        String phone=arguments.getString("phone");
        String email=arguments.getString("email");
        String department=arguments.getString("department");
        String site_company=arguments.getString("site_company");

        edtUserName.setText(user_name);
        edtPassword.setText(password);
        edtEmail.setText(email);
        edtPhoneNumber.setText(phone);
        edtUniqueNum.setText(unique_num);
        edtDepart.setText(department);
        edtSite.setText(site_company);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                webServices.updateStudentData(getActivity(),id,edtUserName.getText().toString(),edtPassword.getText().toString(),
                        edtEmail.getText().toString(),edtPhoneNumber.getText().toString(),""
                        ,edtUniqueNum.getText().toString(),"",
                        edtDepart.getText().toString(),"",edtSite.getText().toString());

            }
        });


        return mView;
    }
}
