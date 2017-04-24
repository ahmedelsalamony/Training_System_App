package com.example.ahmed.training_system_app.admin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;

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

        rdAddStudent=(RadioButton)mView.findViewById(R.id.radio_editstudent);
        rdAddCompany=(RadioButton)mView.findViewById(R.id.radio_editcompany);
        rdAddSupervisor=(RadioButton)mView.findViewById(R.id.radio_editsupervisor);

        rdAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "edit student", Toast.LENGTH_SHORT).show();

            }
        });
        rdAddCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        rdAddSupervisor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return mView;
    }


}
