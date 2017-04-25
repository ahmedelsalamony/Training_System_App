package com.example.ahmed.training_system_app.company;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ahmed.training_system_app.R;

/**
 * Created by Mahmoud on 24/04/2017.
 */

public class CardViewAdapter  extends BaseAdapter{
    private Context context;
    private String[] studentNames;
    private String[] studentPhone;
    private String[] studentEmail;
    public String keyWord;



    public CardViewAdapter(Context context, String[] studentNames ,String[] studentPhone ,String[] studentEmail) {
        this.context=context;
        this.studentNames=studentNames;
        this.studentPhone=studentPhone;
        this.studentEmail=studentEmail;
    }
    @Override
    public int getCount() {
        /*return number of elements inside this array*/
        return studentNames.length;
    }
    @Override
    public Object getItem(int position) {
        /*return the item at posion -position-*/
        return null;
    }

    @Override
    public long getItemId(int position) {
        /*return the id of the row which in this case the index of the array*/
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.com_request_item,parent,false);
        View v;

        if(convertView == null) {
            v = new View(context);
            v = inflater.inflate(R.layout.com_request_item, null);

            TextView userName = (TextView) v.findViewById(R.id.textView_StudentName);
            TextView phone = (TextView) v.findViewById(R.id.textView_StudentPhone);
            TextView email = (TextView) v.findViewById(R.id.textView_StudentEmail);

            userName.setText(studentNames[position]);
            phone.setText(studentPhone[position]);
            email.setText(studentEmail[position]);



        }else {
            v = (View) convertView;
        }


        return v;
    }
}
