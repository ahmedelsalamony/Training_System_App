package com.example.ahmed.training_system_app.admin;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ahmed.training_system_app.R;

import java.util.ArrayList;

/**
 * Created by ahmed on 4/25/2017.
 */

public class CustomAdapterCompany extends ArrayAdapter<DataModelStudentList> implements View.OnClickListener{

    private ArrayList<DataModelStudentList> dataSet;
    Context mContext;
    AppCompatActivity appActivity;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView txtPhone;
        LinearLayout linearContainer;
    }
    public CustomAdapterCompany(ArrayList<DataModelStudentList> data, Context context, AppCompatActivity appActivity) {
        super(context, R.layout.ad_row_edit_student,data);
        this.dataSet=data;
        this.mContext=context;
        this.appActivity=appActivity;
    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        DataModelStudentList dataModel=(DataModelStudentList) object;

        switch (v.getId())
        {
            case R.id.ad_row_edit_student_container:

                ad_Edit_Company_fragment ad_edit_student_fragment=new ad_Edit_Company_fragment();
                FragmentManager fm=appActivity.getSupportFragmentManager();

                Bundle arguments = new Bundle();
                arguments.putInt("id",dataModel.getId());
                arguments.putString( "user_name" , dataModel.getUser_name());
                arguments.putString("password",dataModel.getPassword());
                arguments.putString("unique_num",dataModel.getUnique_num());
                arguments.putString("phone",dataModel.getPhone());
                arguments.putString("email",dataModel.getEmail());
                arguments.putString("department",dataModel.getDepartment());
                arguments.putString("site_company",dataModel.getSite_company());
                ad_edit_student_fragment.setArguments(arguments);
                FragmentTransaction ft= fm.beginTransaction();
                ft.replace(R.id.content_admin_profile,ad_edit_student_fragment);
                ft.commit();
                break;
        }
    }
    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        DataModelStudentList dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder = null; // view lookup cache stored in tag

        final View result;

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.ad_row_edit_student, parent, false);
            viewHolder.txtName  = (TextView) convertView.findViewById(R.id.ad_row_edit_student_txtname);
            viewHolder.txtPhone =  (TextView) convertView.findViewById(R.id.ad_row_edit_student_txtphone);
            viewHolder.linearContainer=(LinearLayout)convertView.findViewById(R.id.ad_row_edit_student_container);
            result=convertView;


        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.txtName.setText(dataModel.getUser_name());
        viewHolder.txtPhone.setText(dataModel.getPhone());
        viewHolder.linearContainer.setOnClickListener(this);
        viewHolder.linearContainer.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }
}
