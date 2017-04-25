package com.example.ahmed.training_system_app.company;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ahmed.training_system_app.R;
import com.example.ahmed.training_system_app.web.WebServices;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddRequestsFragment extends Fragment {

  private  View mView;
  public EditText mCompanyName,mDepartName,mFrom,mTo,mSalary, mTrainerNumber;
   private Button mAddAdvertise;
   private WebServices mWebServices;

    int yr, month, day;
    int yrTo,monthTo,dayTo;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.com_fragment_add_requests, container, false);
        CompanyProfileActivity.sCompanyHome=2;

        mWebServices=new WebServices();
        mWebServices.sharedPreferences=getActivity().getSharedPreferences("abc",0);


        mCompanyName= (EditText) mView.findViewById(R.id.Edit_AddCompanyName);
        mTrainerNumber= (EditText) mView.findViewById(R.id.Edit_TrainersNumbers);
        mDepartName= (EditText) mView.findViewById(R.id.Edit_DepartmentName);
        mFrom= (EditText) mView.findViewById(R.id.Edit_From);
        mTo= (EditText) mView.findViewById(R.id.Edit_To);
        mSalary= (EditText) mView.findViewById(R.id.Edit_AddSalary);
        mAddAdvertise= (Button) mView.findViewById(R.id.Button_addAdvertise);

        Calendar today = Calendar.getInstance();
        yr = today.get(Calendar.YEAR);
        month = today.get(Calendar.MONTH);
        day = today.get(Calendar.DAY_OF_MONTH);

        yrTo = today.get(Calendar.YEAR);
        monthTo = today.get(Calendar.MONTH);
        dayTo = today.get(Calendar.DAY_OF_MONTH);
        mCompanyName.setText(mWebServices.sharedPreferences.getString("user_name",""));




        mFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(getActivity(), mDateSetListener, yr, month, day).show();

            }
        });


        mTo.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               new DatePickerDialog(getActivity(), mDateSetListenerTo, yrTo, monthTo, dayTo).show();

           }
       });


          mAddAdvertise.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {


                  String trainersNum=mTrainerNumber.getText().toString().trim();
                  String deptName=mDepartName.getText().toString().trim();
                  String from=mFrom.getText().toString().trim();
                  String to=mTo.getText().toString().trim();
                  String salary=mSalary.getText().toString().trim();
                  int  uid=mWebServices.sharedPreferences.getInt("id",2017);

                  mWebServices.addTraining(getActivity(),uid,trainersNum,"posted",deptName,from,to,salary);
              }
          });





        return  mView;
    }







    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener()
    {
        public void onDateSet(
                DatePicker view, int year, int monthOfYear, int dayOfMonth)
        {
            yr = year;
            month = monthOfYear;
            day = dayOfMonth;


            mFrom.setText(""+(month + 1) + "/" + day + "/" + yr);
        }
    };


    private DatePickerDialog.OnDateSetListener mDateSetListenerTo = new DatePickerDialog.OnDateSetListener()
    {
        public void onDateSet(
                DatePicker view, int year, int monthOfYear, int dayOfMonth)
        {
            yrTo = year;
            monthTo = monthOfYear;
            dayTo = dayOfMonth;


            mTo.setText(""+(monthTo + 1) + "/" + dayTo + "/" + yrTo);
        }
    };

}
