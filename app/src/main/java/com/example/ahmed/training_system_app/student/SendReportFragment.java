package com.example.ahmed.training_system_app.student;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ahmed.training_system_app.R;
import com.example.ahmed.training_system_app.web.WebServices;
import com.example.ahmed.training_system_app.web.request_interface;

/**
 * A simple {@link Fragment} subclass.
 */
public class SendReportFragment extends Fragment {


    private  View mView;
    private EditText mWriteReportEdit;
    private Button mWriteReportBtn;
    private WebServices mWebServices;
    Typeface custom_font;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView =inflater.inflate(R.layout.stu_fragment_send_report, container, false);

        StudentProfileActivity.sStudent=2;

        mWriteReportBtn= (Button) mView.findViewById(R.id.Button_WriteReport);
        mWriteReportEdit= (EditText) mView.findViewById(R.id.Edit_WriteReport);
        mWebServices=new WebServices();
        mWebServices.sharedPreferences=getActivity().getSharedPreferences("abc",0);

        custom_font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/font.ttf");
        mWriteReportBtn.setTypeface(custom_font);

        mWriteReportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mWebServices.updateReportsReport(getActivity(), mWebServices.sharedPreferences.getInt("id", 2017), mWriteReportEdit.getText().toString(), new request_interface() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getActivity(), "لقد تم ارسال تقريرك الى المشرف", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError() {

                        Toast.makeText(getActivity(), "فشل فى ارسال التقرير", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        return mView;
    }



}
