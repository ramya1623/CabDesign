package com.swish.cabinmain.Activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.swish.cabinmain.R;
import com.swish.cabinmain.Utils.LoginCustomPagerAdapter;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    int images[] = {R.drawable.cabgif, R.drawable.moneygif, R.drawable.cardgif};
    LoginCustomPagerAdapter myCustomPagerAdapter;
    Button mob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        viewPager = (ViewPager)findViewById(R.id.viewpager);
        ImageView imageView=(ImageView)findViewById(R.id.image);
        mob=(Button)findViewById(R.id.mob);

        myCustomPagerAdapter = new LoginCustomPagerAdapter(MainActivity.this, images);
        viewPager.setAdapter(myCustomPagerAdapter);


    }
}
