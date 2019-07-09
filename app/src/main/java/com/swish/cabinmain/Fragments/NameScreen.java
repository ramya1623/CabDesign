package com.swish.cabinmain.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.swish.cabinmain.Activities.RegistrationScreen;
import com.swish.cabinmain.Interface.FragmentInterface;
import com.swish.cabinmain.R;

public class NameScreen extends Fragment {
    RegistrationScreen registrationScreen;
    FragmentInterface fragmentInterface;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_name,container,false);
        return view;


    }
}
