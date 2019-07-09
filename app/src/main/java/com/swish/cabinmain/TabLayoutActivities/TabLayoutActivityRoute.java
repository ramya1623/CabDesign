package com.swish.cabinmain.TabLayoutActivities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.swish.cabinmain.Fragments.FragmentBookARide;
import com.swish.cabinmain.Fragments.FragmentRoutesTab1;
import com.swish.cabinmain.Fragments.FragmentRoutesTab2;
import com.swish.cabinmain.Fragments.FragmentShareAndEarnTab1;
import com.swish.cabinmain.Fragments.FragmentShareAndEarnTab2;
import com.swish.cabinmain.Fragments.FragmentSuggestNewRoutes;
import com.swish.cabinmain.Interface.FragmentInterface;
import com.swish.cabinmain.R;
import com.swish.cabinmain.Utils.TabAdapter;

public class TabLayoutActivityRoute extends AppCompatActivity implements FragmentInterface {
    private TabAdapter adapter,adapter1;
    private TabLayout tabLayout;
    private ViewPager viewPager;
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
        adapter.addFragment(new FragmentRoutesTab1(), " ACTIVE");
        adapter.addFragment(new FragmentRoutesTab2(), "VOTE OF UNLOCK");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void acceptMoney() {
        //
    }

    @Override
    public void earnmore(View view) {
        //
    }

    @Override
    public void viewpassbook(View view) {
     //
    }

    @Override
    public void book() {
      //
    }

    @Override
    public void book2() {
      //
    }

    @Override
    public void suggest() {
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        FragmentSuggestNewRoutes suggestNewRoutes=new FragmentSuggestNewRoutes();
        transaction.replace(R.id.frame,suggestNewRoutes);
        transaction.commit();
    }

    @Override
    public void suggest1() {
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        FragmentSuggestNewRoutes suggestNewRoutes=new FragmentSuggestNewRoutes();
        transaction.replace(R.id.frame,suggestNewRoutes);
        transaction.commit();
    }
}
