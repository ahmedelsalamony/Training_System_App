package com.example.ahmed.training_system_app.admin;

import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ahmed.training_system_app.R;
import com.example.ahmed.training_system_app.launching.UserContactUsFragment;
import com.example.ahmed.training_system_app.web.WebServices;

public class AdminProfileActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    static int sAdmin=0;
    TextView userName,email;
    WebServices webServices;
    Typeface custom_font;
    FragmentManager fm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        webServices=new WebServices();
        webServices.sharedPreferences=getSharedPreferences("abc",0);
        custom_font = Typeface.createFromAsset(getAssets(), "fonts/font.ttf");
        setContentView(R.layout.ad_activity_admin_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //the default fragment
        AdminInfoFragment admininfo = new AdminInfoFragment();
        fm=getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        ft.replace(R.id.content_admin_profile,admininfo);
        ft.commit();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        userName = (TextView) headerView.findViewById(R.id.TextView_Name_Header);
        userName.setText(webServices.sharedPreferences.getString("user_name",""));
        userName.setTypeface(custom_font);

        email = (TextView) headerView.findViewById(R.id.TextView_Email_Header);
        email.setText(webServices.sharedPreferences.getString("email",""));
        email.setTypeface(custom_font);

        navigationView.setNavigationItemSelectedListener(this);
        //this line for set the view form right to left;
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
    }

    @Override
    public void onBackPressed() {

        int count = getFragmentManager().getBackStackEntryCount();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else if(sAdmin == 14 )
        {
            finish();
        }
        else if (sAdmin == 1)
        {
            AdminInfoFragment adduser = new AdminInfoFragment();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft= fm.beginTransaction();
            ft.replace(R.id.content_admin_profile,adduser);
            ft.commit();
        }
        else if (sAdmin == 2 )
        {
            AdminInfoFragment adduser = new AdminInfoFragment();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft= fm.beginTransaction();
            ft.replace(R.id.content_admin_profile,adduser);
            ft.commit();
        }
        else if (sAdmin == 3 )
        {
            AdminInfoFragment adduser = new AdminInfoFragment();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft= fm.beginTransaction();
            ft.replace(R.id.content_admin_profile,adduser);
            ft.commit();
        }
        else if (sAdmin == 4 )
        {
            AdminInfoFragment adduser = new AdminInfoFragment();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft= fm.beginTransaction();
            ft.replace(R.id.content_admin_profile,adduser);
            ft.commit();
        }
        else if (sAdmin == 5 )
        {
            AdminInfoFragment adduser = new AdminInfoFragment();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft= fm.beginTransaction();
            ft.replace(R.id.content_admin_profile,adduser);
            ft.commit();
        }
        else if (sAdmin == 6 )
        {
            AdminInfoFragment adduser = new AdminInfoFragment();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft= fm.beginTransaction();
            ft.replace(R.id.content_admin_profile,adduser);
            ft.commit();
        }
        else if (sAdmin == 7 )
        {
            AdminInfoFragment adduser = new AdminInfoFragment();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft= fm.beginTransaction();
            ft.replace(R.id.content_admin_profile,adduser);
            ft.commit();
        }
        else if (sAdmin == 8 )
        {
            AdminInfoFragment adduser = new AdminInfoFragment();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft= fm.beginTransaction();
            ft.replace(R.id.content_admin_profile,adduser);
            ft.commit();
        }
        else if (sAdmin == 9 )
        {
            AdminInfoFragment adduser = new AdminInfoFragment();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft= fm.beginTransaction();
            ft.replace(R.id.content_admin_profile,adduser);
            ft.commit();
        }
        else if (sAdmin == 10 )
        {
            AdminInfoFragment adduser = new AdminInfoFragment();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft= fm.beginTransaction();
            ft.replace(R.id.content_admin_profile,adduser);
            ft.commit();
        }
        else if (sAdmin == 11 )
        {
            AdminInfoFragment adduser = new AdminInfoFragment();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft= fm.beginTransaction();
            ft.replace(R.id.content_admin_profile,adduser);
            ft.commit();
        }
        else if (sAdmin == 12 )
        {
            AdminInfoFragment adduser = new AdminInfoFragment();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft= fm.beginTransaction();
            ft.replace(R.id.content_admin_profile,adduser);
            ft.commit();
        }
        else if (sAdmin == 13 )
        {
            AdminInfoFragment adduser = new AdminInfoFragment();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft= fm.beginTransaction();
            ft.replace(R.id.content_admin_profile,adduser);
            ft.commit();
        }else if (sAdmin == 15 ){
            AdminInfoFragment adduser = new AdminInfoFragment();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft= fm.beginTransaction();
            ft.replace(R.id.content_admin_profile,adduser);
            ft.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.admin_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action

            AddUserFragment adduser = new AddUserFragment();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft= fm.beginTransaction();
            ft.replace(R.id.content_admin_profile,adduser);
            ft.commit();

        }
        else if (id == R.id.nav_gallery)
        {
            EditUserFragment edituser = new EditUserFragment();
            fm=getSupportFragmentManager();
            FragmentTransaction ft= fm.beginTransaction();
            ft.replace(R.id.content_admin_profile,edituser);
            ft.commit();
        }
        else if (id == R.id.nav_slideshow)
        {
            EditAdminProfileFragment editadmin = new EditAdminProfileFragment();
            fm=getSupportFragmentManager();
            FragmentTransaction ft= fm.beginTransaction();
            ft.replace(R.id.content_admin_profile,editadmin);
            ft.commit();
        }
        else if (id == R.id.nav_manage)
        {
            AdminInfoFragment admininfo = new AdminInfoFragment();
            fm=getSupportFragmentManager();
            FragmentTransaction ft= fm.beginTransaction();
            ft.replace(R.id.content_admin_profile,admininfo);
            ft.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
