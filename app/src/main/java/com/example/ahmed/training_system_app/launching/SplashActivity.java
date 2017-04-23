package com.example.ahmed.training_system_app.launching;

/**
 * Created by ahmed on 4/23/2017.
 */
import android.content.Intent;

import com.daimajia.androidanimations.library.Techniques;
import com.example.ahmed.training_system_app.R;
import com.tsengvn.typekit.Typekit;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;


public class SplashActivity extends AwesomeSplash {

    @Override
    public void initSplash(ConfigSplash configSplash) {
            /* you don't have to override every property */

        //Customize Circular Reveal
        configSplash.setBackgroundColor(R.color.colorAccent); //any color you want form colors.xml
        configSplash.setAnimCircularRevealDuration(900); //int ms
        configSplash.setAnimCircularRevealDuration(900); //int ms
        configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);  //or Flags.REVEAL_LEFT
        configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM); //or Flags.REVEAL_TOP

        //Choose LOGO OR PATH; if you don't provide String value for path it's logo by default


        //Customize Logo
        configSplash.setLogoSplash(R.drawable.logo); //or any other drawable
        configSplash.setAnimLogoSplashDuration(800); //int ms
        configSplash.setAnimLogoSplashDuration(800); //int ms
        configSplash.setAnimLogoSplashTechnique(Techniques.FlipInX);
        configSplash.setPathSplashFillColor(R.color.colorAccent);
        //choose one form Techniques (ref: https://github.com/daimajia/AndroidViewAnimations)

       //Customize Title
        configSplash.setTitleSplash("نظام التدريب");
        configSplash.setTitleTextColor(R.color.colorPrimaryDark);
        configSplash.setTitleTextSize(50f); //float value
        configSplash.setAnimTitleDuration(1000);
        configSplash.setAnimTitleDuration(1800);
        configSplash.setAnimTitleTechnique(Techniques.FlipInX);
        configSplash.setTitleFont("fonts/font.ttf"); //provide string to your font located in assets/fonts/

    }

    //--------------------this refer to the next screen after splash screen finished----------------------//
    @Override
    public void animationsFinished() {
        Intent i =new Intent(SplashActivity.this,MainActivity.class);
        startActivity(i);
        finish();
    }
}