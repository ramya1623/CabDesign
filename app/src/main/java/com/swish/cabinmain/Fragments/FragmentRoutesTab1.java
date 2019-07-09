package com.swish.cabinmain.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.swish.cabinmain.Interface.FragmentInterface;
import com.swish.cabinmain.R;
import com.swish.cabinmain.TabLayoutActivities.TabLayoutActivityMyRide;
import com.swish.cabinmain.TabLayoutActivities.TabLayoutActivityRoute;

public class FragmentRoutesTab1 extends Fragment {
    Button suggestnewroute;
    TabLayoutActivityRoute activity;
    FragmentInterface fragmentInterface;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_routes_tab1,container,false);
        suggestnewroute=(Button)view.findViewById(R.id.suggestroute);
        activity=(TabLayoutActivityRoute) getActivity();
        fragmentInterface =  activity;
        suggestnewroute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentInterface.suggest();
            }
        });

        return view;

    }
}
