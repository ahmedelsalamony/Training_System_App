package com.example.ahmed.training_system_app.admin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.ahmed.training_system_app.R;

/**
 * Created by ahmed on 4/24/2017.
 */

public class EditUserFragment extends Fragment
{
    View mView;
    RadioButton rdAddStudent,rdAddCompany,rdAddSupervisor;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView= inflater.inflate(R.layout.ad_edit_user_fragment, container, false);

        AdminProfileActivity.sAdmin=5;

        rdAddStudent=(RadioButton)mView.findViewById(R.id.radio_editstudent);
        rdAddCompany=(RadioButton)mView.findViewById(R.id.radio_editcompany);
        rdAddSupervisor=(RadioButton)mView.findViewById(R.id.radio_editsupervisor);

        rdAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ad_display_Student_Fragment ad_edit_student_fragment=new ad_display_Student_Fragment();
                FragmentManager fm=getActivity().getSupportFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();
                ft.replace(R.id.content_admin_profile,ad_edit_student_fragment);
                ft.commit();
            }
        });
        rdAddCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad_display_Company_Fragment ad_edit_student_fragment=new ad_display_Company_Fragment();
                FragmentManager fm=getActivity().getSupportFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();
                ft.replace(R.id.content_admin_profile,ad_edit_student_fragment);
                ft.commit();
            }
        });
        rdAddSupervisor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad_display_Supervisor_Fragment ad_edit_student_fragment=new ad_display_Supervisor_Fragment();
                FragmentManager fm=getActivity().getSupportFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();
                ft.replace(R.id.content_admin_profile,ad_edit_student_fragment);
                ft.commit();
            }
        });
        return mView;
    }


}
