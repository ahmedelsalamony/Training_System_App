package com.example.ahmed.training_system_app.supervisor;

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

public class CardViewAdapter extends BaseAdapter{
    private Context context;
    private String[] studentNames;
    private String[] studentReport;




    public CardViewAdapter(Context context, String[] studentNames , String[] studentReport) {
        this.context=context;
        this.studentNames=studentNames;
        this.studentReport=studentReport;
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
        inflater.inflate(R.layout.sup_report_item,parent,false);
        View v;

        if(convertView == null) {
            v = new View(context);
            v = inflater.inflate(R.layout.sup_report_item, null);

            TextView userName = (TextView) v.findViewById(R.id.textView_StudentNameReport);
            TextView phone = (TextView) v.findViewById(R.id.textView_StudentReoprt);

            userName.setText(studentNames[position]);
            phone.setText(studentReport[position]);




        }else {
            v = (View) convertView;
        }


        return v;
    }
}
