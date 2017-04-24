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

public class ad_AddCompanyFragment extends Fragment {
    View mView;
    EditText edtUserName,edtPassword,edtUniqueNum,edtEmail,edtPhone,edtWebSite,edtDepartment;
    WebServices webServices;
    Button btnsave;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.ad_add_company, container, false);
        edtUserName=(EditText)mView.findViewById(R.id.AddCompany_Add_UserName);
        edtPassword=(EditText)mView.findViewById(R.id.AddCompany_Add_Password);
        edtPhone=(EditText)mView.findViewById(R.id.AddCompany_Add_phone);
        edtEmail=(EditText)mView.findViewById(R.id.AddCompany_Add_email);
        edtUniqueNum=(EditText)mView.findViewById(R.id.AddCompany_Add_unique_num);
        edtWebSite=(EditText)mView.findViewById(R.id.AddCompany_Add_sitecompany);
        edtDepartment=(EditText)mView.findViewById(R.id.AddCompany_Add_department);
        btnsave=(Button) mView.findViewById(R.id.AddStudent_btnAddCompany);
        webServices=new WebServices();
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                webServices.addUser(getActivity(),edtUserName.getText().toString(),edtPassword.getText().toString(),edtEmail.getText().toString()
                        ,edtPhone.getText().toString(),"company","",edtUniqueNum.getText().toString(),
                        "",edtDepartment.getText().toString(), Double.parseDouble("0.0")
                        ,edtWebSite.getText().toString());
            }
        });
        return mView;
    }
}
