package com.swish.cabinmain.TabLayoutActivities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.swish.cabinmain.Fragments.FragmentEarnMoreTab1;
import com.swish.cabinmain.Fragments.FragmentEarnMoreTab2;
import com.swish.cabinmain.Fragments.FragmentPassbookTab1;
import com.swish.cabinmain.Fragments.FragmentPassbookTab2;
import com.swish.cabinmain.R;
import com.swish.cabinmain.Utils.TabAdapter;

public class TabLayoutActivityEarnMore extends AppCompatActivity {
    private TabAdapter adapter,adapter1;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabLayout tabLayout1;
    private ViewPager viewPager1;
    Button earnmore;
    Fragment fragment=null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        earnmore=(Button)findViewById(R.id.earnmore);
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentEarnMoreTab1(), "INVITE FRIENDS");
        adapter.addFragment(new FragmentEarnMoreTab2(), "CREDITS EARNED");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }


}
