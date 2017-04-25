package com.example.ahmed.training_system_app.launching;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
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

import org.json.JSONException;
import org.json.JSONObject;

import de.cketti.mailto.EmailIntentBuilder;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserContactUsFragment extends Fragment {

   private View mView;
   private TextView mPlease;
   private EditText mProblem , mEmail;
   private Button mSend;
    String email;
    WebServices webServices;
  Typeface custom_font;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        mView= inflater.inflate(R.layout.lau_fragment_user_contact_us, container, false);
        MainActivity.sMainActivity=2;
        mPlease= (TextView) mView.findViewById(R.id.TextView_Please);
        mProblem= (EditText) mView.findViewById(R.id.EditText_Write_Problem);
        mEmail= (EditText) mView.findViewById(R.id.EditText_Email);
        mSend= (Button) mView.findViewById(R.id.Button_SendProblem);
        webServices=new WebServices();

        custom_font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/font.ttf");
        mEmail.setTypeface(custom_font);
        mPlease.setTypeface(custom_font);
        mProblem.setTypeface(custom_font);

        webServices.getAdminEmail(getActivity(), new request_interface() {
            @Override
            public void onResponse(String response) {
                try
                {
                    JSONObject jsonObject = new JSONObject(response);
                    String email_response = jsonObject.getString("email_response");

                    if (email_response.equals("done"))
                    {
                        email = jsonObject.getString("email");
                    }
                    else if (email_response.equals("notDone"))
                    {
                        Toast.makeText(getActivity(), "هذا الايميل الخاص بالادمن غير موجود", Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                }
            }
            @Override
            public void onError()
            {
                Snackbar.make(getActivity().findViewById(android.R.id.content), "الاتصال بالانترنت", Snackbar.LENGTH_LONG).show();
            }
        });





        mSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean success = EmailIntentBuilder.from(getActivity())
                        .to(email.trim())
                        .cc(email.trim())
                        .subject(" مشكلة فى نظام التدريب ")
                        .body(mProblem.getText().toString().trim())
                        .start();

            }
        });

        return  mView;
    }

}
