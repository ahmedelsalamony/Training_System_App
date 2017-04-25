package com.example.ahmed.training_system_app.supervisor;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ahmed.training_system_app.R;
import com.example.ahmed.training_system_app.web.WebServices;

/**
 * A simple {@link Fragment} subclass.
 */
public class SuperHomeFragment extends Fragment {



    private  View mView;
    private Button mListStudents , mShowReports;
    private TextView mSupName , mSupPhone , mSupEmail;

    private WebServices mWebServices;
    Typeface custom_font;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView =inflater.inflate(R.layout.sup_fragment_super_home, container, false);

        mWebServices=new WebServices();
        mWebServices.sharedPreferences=getActivity().getSharedPreferences("abc",0);
        SupervisorProfileActivity.sSupervisor=1;

        custom_font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/font.ttf");
        mListStudents = (Button) mView.findViewById(R.id.button_ListStudent);
        mShowReports= (Button) mView.findViewById(R.id.button_ٍShowReportsStudent);

        mSupName= (TextView) mView.findViewById(R.id.textView_SupName);
        mSupEmail= (TextView) mView.findViewById(R.id.textView_SupEmail);
        mSupPhone= (TextView) mView.findViewById(R.id.textView_SupPhone);

        mSupPhone.setText(mWebServices.sharedPreferences.getString("phone",""));
        mSupEmail.setText(mWebServices.sharedPreferences.getString("email",""));
        mSupName.setText(mWebServices.sharedPreferences.getString("user_name",""));

        mListStudents.setTypeface(custom_font);
        mShowReports.setTypeface(custom_font);
        mSupName.setTypeface(custom_font);
        mSupEmail.setTypeface(custom_font);
        mSupPhone.setTypeface(custom_font);



        mListStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ListStudentsFragment listStudentsFragment =new ListStudentsFragment();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();
                ft.replace(R.id.sup_activity_supervisor_profile,listStudentsFragment);
                ft.commit();

            }
        });





        mShowReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ShowReportsFragment showReportsFragment =new ShowReportsFragment();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();
                ft.replace(R.id.sup_activity_supervisor_profile,showReportsFragment);
                ft.commit();
            }
        });



        return  mView;
    }

}
