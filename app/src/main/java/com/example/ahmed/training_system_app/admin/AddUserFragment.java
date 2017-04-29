package com.example.ahmed.training_system_app.admin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.ahmed.training_system_app.R;

/**
 * Created by ahmed on 4/24/2017.
 */

public class AddUserFragment extends Fragment
{
    View mView;
    Button rdAddStudent,rdAddCompany,rdAddSupervisor;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView= inflater.inflate(R.layout.ad_add_user_fragment, container, false);

        AdminProfileActivity.sAdmin=1;

            rdAddStudent=(Button)mView.findViewById(R.id.radio_addstudent);
            rdAddCompany=(Button)mView.findViewById(R.id.radio_addcompany);
            rdAddSupervisor=(Button)mView.findViewById(R.id.radio_addsupervisor);


        rdAddCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad_AddCompanyFragment addCompanyFragment = new ad_AddCompanyFragment();
                FragmentManager fm=getActivity().getSupportFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();
                ft.replace(R.id.content_admin_profile,addCompanyFragment);
                ft.commit();
            }
        });
             rdAddStudent.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     ad_AddStudentFragment addStudentFragment = new ad_AddStudentFragment();
                     FragmentManager fm=getActivity().getSupportFragmentManager();
                     FragmentTransaction ft= fm.beginTransaction();
                     ft.replace(R.id.content_admin_profile,addStudentFragment);
                     ft.commit();
                 }
             });

        rdAddSupervisor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad_AddSupervisorFragment addSuperFragment = new ad_AddSupervisorFragment();
                FragmentManager fm=getActivity().getSupportFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();
                ft.replace(R.id.content_admin_profile,addSuperFragment);
                ft.commit();
            }
        });

        return mView;
    }
}
