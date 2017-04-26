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

public class AdminInfoFragment extends Fragment {

    View mView;

    EditText edtUserName,edtPassword,edtEmail,edtPhoneNumber,edtSupervisorName,edtUniqueNum,edtYearStudy,edtDepart,edtStudentGrade;
    String user_name_response,password_response,email_response,phone_response,unique_num,department;
    WebServices webServices;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView= inflater.inflate(R.layout.ad_admin_info, container, false);

        AdminProfileActivity.sAdmin=14;

        edtUserName=(EditText)mView.findViewById(R.id.EditAdmin_Edit_UserName);
        edtPassword=(EditText)mView.findViewById(R.id.EditAdmin_Edit_password);
        edtEmail=(EditText)mView.findViewById(R.id.EditAdmin_Edit_email);
        edtPhoneNumber=(EditText)mView.findViewById(R.id.EditAdmin_Edit_phone);
        edtUniqueNum=(EditText)mView.findViewById(R.id.EditAdmin_uniquenum);
        edtDepart=(EditText)mView.findViewById(R.id.EditAdmin_depart);


        webServices=new WebServices();
        webServices.sharedPreferences=getActivity().getSharedPreferences("abc",0);
        webServices.getAdminData(getActivity(),webServices.sharedPreferences.getString("unique_num",""), new request_interface() {
            @Override
            public void onResponse(String response) {

                try
                {
                    JSONObject jsonObject = new JSONObject(response);

                    if (jsonObject.getString("response").equals("done"))
                    {
                         user_name_response=jsonObject.getString("user_name");
                         password_response=jsonObject.getString("password");
                         email_response = jsonObject.getString("email");
                         phone_response=jsonObject.getString("phone");
                         unique_num=jsonObject.getString("unique_num");
                         department=jsonObject.getString("department");
                         edtUserName.setText(user_name_response);
                         edtPassword.setText(password_response);
                         edtEmail.setText(email_response);
                         edtPhoneNumber.setText(phone_response);
                         edtUniqueNum.setText(unique_num);

                    }
                    else if (response.equals("notDone"))
                    {
                        Toast.makeText(getActivity(), "Email Admin not found", Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                }
            }

            @Override
            public void onError() {

            }
        });

        return mView;
    }
}
