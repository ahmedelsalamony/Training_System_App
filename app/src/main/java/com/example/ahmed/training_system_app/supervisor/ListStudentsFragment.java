package com.example.ahmed.training_system_app.supervisor;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ahmed.training_system_app.R;
import com.example.ahmed.training_system_app.web.WebServices;
import com.example.ahmed.training_system_app.web.request_interface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListStudentsFragment extends Fragment {


      private View mView;
      private TextView mCounterStudent;
      private ListView mListStudent;
      private WebServices mWebServices;
      private StringBuffer mStudentsNames ,idsBuffer;
      private String mStudentsName[] ,idsArray[];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView= inflater.inflate(R.layout.sup_fragment_list_students, container, false);
        mWebServices =new WebServices();
        mStudentsNames=new StringBuffer();
        idsBuffer=new StringBuffer();

        mWebServices.sharedPreferences=getActivity().getSharedPreferences("abc",0);


        mCounterStudent= (TextView) mView.findViewById(R.id.textView_StudentNum);
        mListStudent= (ListView) mView.findViewById(R.id.ListView_See_Students);









        mWebServices.getAllStudents(getActivity(),mWebServices.sharedPreferences.getString("user_name",""),new request_interface() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONObject jsonResponse = new JSONObject(response);
                    JSONArray jsonArray = jsonResponse.getJSONArray("students");

                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject search_object = jsonArray.getJSONObject(i);
                        mStudentsNames.append(search_object.getString("user_name") + "#");
                        idsBuffer.append(search_object.getString("id") + "#");
                    }

                    mStudentsName=mStudentsNames.toString().split("#");
                    idsArray=idsBuffer.toString().split("#");

                    ArrayAdapter adapter=new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,mStudentsName);

                    if(mStudentsName.equals(null)) {


                    }
                    else {
                        mCounterStudent.setText(""+mStudentsName.length);
                        mListStudent.setAdapter(adapter);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onError() {
                Toast.makeText(getActivity(), "خطأ بالاتصال بقاعدة البيانات .", Toast.LENGTH_SHORT).show();
            }
            });






        return  mView;

    }

}
