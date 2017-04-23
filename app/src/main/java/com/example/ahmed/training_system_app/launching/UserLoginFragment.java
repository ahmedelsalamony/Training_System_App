package com.example.ahmed.training_system_app.launching;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ahmed.training_system_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserLoginFragment extends Fragment {

   private EditText mUniqueNum,mPassword;
   private TextView mContactUs;
   private Button mLogin;
   private View mView;
   Typeface custom_font;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        mView =  inflater.inflate(R.layout.lau_fragment_user_login, container, false);
        custom_font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/font.ttf");
        mUniqueNum = (EditText) mView.findViewById(R.id.Edit_UserName);
        mPassword = (EditText) mView.findViewById(R.id.Edit_Password);
        mContactUs = (TextView) mView.findViewById(R.id.TextView_ContactUs);
        mLogin = (Button) mView.findViewById(R.id.Button_Login);
        mLogin.setTypeface(custom_font);
        mUniqueNum.setTypeface(custom_font);
        mPassword.setTypeface(custom_font);
        mContactUs.setTypeface(custom_font);

        return  mView;
    }

    public void userLogin(View view){

    }

}
