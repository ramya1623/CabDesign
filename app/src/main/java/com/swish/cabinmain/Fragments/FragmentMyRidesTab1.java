package com.swish.cabinmain.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.swish.cabinmain.Activities.NavigationDrawerActivity;
import com.swish.cabinmain.Interface.FragmentInterface;
import com.swish.cabinmain.R;
import com.swish.cabinmain.TabLayoutActivities.TabLayoutActivityMyRide;

public class FragmentMyRidesTab1 extends Fragment {
    Button bookaride;
    TabLayoutActivityMyRide activity;
    FragmentInterface fragmentInterface;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_my_rides_tab1,container,false);
        bookaride=(Button)view.findViewById(R.id.btn1);
        activity=(TabLayoutActivityMyRide) getActivity();
        fragmentInterface =  activity;
        bookaride.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentInterface.book();
            }
        });


        return view;

    }
}
