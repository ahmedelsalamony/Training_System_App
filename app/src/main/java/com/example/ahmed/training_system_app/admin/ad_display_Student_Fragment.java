package com.example.ahmed.training_system_app.admin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ahmed.training_system_app.R;
import com.example.ahmed.training_system_app.web.WebServices;
import com.example.ahmed.training_system_app.web.request_interface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ahmed on 4/24/2017.
 */

public class ad_display_Student_Fragment extends Fragment {
    View mView;
    Button btnsave;
    EditText edtUserName, edtPassword, edtEmail, edtPhoneNumber, edtSupervisorName, edtUniqueNum, edtYearStudy, edtDepart, edtStudentGrade;
    WebServices webServices;
    ArrayList<DataModelStudentList> dataModels;
    ListView listView;
    private static CustomAdapterStudent adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.ad_edit_student_listview, container, false);
        webServices = new WebServices();
        listView = (ListView) mView.findViewById(R.id.ad_row_edit_student_listview_list);
        dataModels = new ArrayList<>();
        webServices.getStudentData(getActivity(), new request_interface() {

            @Override
            public void onResponse(String response) {


                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("search");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject sub_jsonObject = jsonArray.getJSONObject(i);
                        int id = sub_jsonObject.getInt("id");
                        String user_name = sub_jsonObject.getString("user_name");
                        String password=sub_jsonObject.getString("password");
                        String email=sub_jsonObject.getString("email");
                        String phone = sub_jsonObject.getString("phone");
                        String supervisor_name=sub_jsonObject.getString("supervisor_name");
                        String unique_name=sub_jsonObject.getString("unique_num");
                        String year_study=sub_jsonObject.getString("year_study");
                        String department=sub_jsonObject.getString("department");
                        String Student_grade=sub_jsonObject.getString("student_grade");

                        Toast.makeText(getActivity(),user_name, Toast.LENGTH_SHORT).show();
                        dataModels.add(new DataModelStudentList(id,user_name,password,email, phone,supervisor_name,unique_name,year_study,department,Student_grade));
                        //dataModels.add(new DataModelStudentList(user_name,phone));
                        adapter.notifyDataSetChanged();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onError() {
            }
        });

        adapter = new CustomAdapterStudent(dataModels, getActivity(), (AppCompatActivity) getActivity());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        return mView;
    }
}
