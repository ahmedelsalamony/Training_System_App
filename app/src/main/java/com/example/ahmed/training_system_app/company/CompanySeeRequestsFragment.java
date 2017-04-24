package com.example.ahmed.training_system_app.company;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ahmed.training_system_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompanySeeRequestsFragment extends Fragment {


    public CompanySeeRequestsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.com_fragment_company_see_requests, container, false);
    }

}
