package com.swish.cabinmain.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.swish.cabinmain.Fragments.CitiesListScreen;
import com.swish.cabinmain.Fragments.EmailIDPage;
import com.swish.cabinmain.Fragments.FragmentPhoneNo;
import com.swish.cabinmain.Fragments.GenderScreen;
import com.swish.cabinmain.Fragments.HomeLocaScreen;
import com.swish.cabinmain.Fragments.InviteCodeScreen;
import com.swish.cabinmain.Fragments.NameScreen;
import com.swish.cabinmain.Fragments.OfficeLocaScreen;
import com.swish.cabinmain.Fragments.OtpPage;
import com.swish.cabinmain.Interface.FragmentInterface;
import com.swish.cabinmain.R;

import static android.widget.Toast.*;

public class RegistrationScreen extends AppCompatActivity {
    FragmentPhoneNo fragmentPhoneNo;
    OtpPage otpPage;
    NameScreen nameScreen;
    EmailIDPage emailIDPage;
    GenderScreen genderScreen;
    InviteCodeScreen inviteCodeScreen;
    HomeLocaScreen homeLocaScreen;
    OfficeLocaScreen officeLocaScreen;
    CitiesListScreen citiesListScreen;
    boolean f1,f2,f3,f4,f5,f6,f7,f8,f9;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_screen);
        FloatingActionButton floatingActionButton=findViewById(R.id.fab);
        fragmentPhoneNo=new FragmentPhoneNo();


        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(R.id.framelayout,fragmentPhoneNo);
        transaction.commit();
        f1=true;
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(f1==true && f2==false) {
                    f1=false;
                    f2=true;
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    otpPage = new OtpPage();
                    transaction.replace(R.id.framelayout, otpPage);
                    transaction.commit();
                }
                else if(f2==true && f3==false){
                    f2=false;
                    f3=true;
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    nameScreen=new NameScreen();
                    transaction.replace(R.id.framelayout,nameScreen);
                    transaction.commit();
                }
                else if(f3==true && f4==false){
                    f3=false;
                    f4=true;
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    emailIDPage=new EmailIDPage();
                    transaction.replace(R.id.framelayout,emailIDPage);
                    transaction.commit();
                }
                else if(f4==true && f5==false){
                    f4=false;
                    f5=true;
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    genderScreen=new GenderScreen();
                    transaction.replace(R.id.framelayout,genderScreen);
                    transaction.commit();
                }
                else if(f5==true && f6==false){
                    f5=false;
                    f6=true;
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    inviteCodeScreen=new InviteCodeScreen();
                    transaction.replace(R.id.framelayout,inviteCodeScreen);
                    transaction.commit();
                }
                else if(f6==true && f7==false){
                    f6=false;
                    f7=true;
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    homeLocaScreen=new HomeLocaScreen();
                    transaction.replace(R.id.framelayout,homeLocaScreen);
                    transaction.commit();
                }
                else if(f7==true && f8==false){
                    f7=false;
                    f8=true;
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    officeLocaScreen=new OfficeLocaScreen();
                    transaction.replace(R.id.framelayout,officeLocaScreen);
                    transaction.commit();
                }
                else if(f8==true && f9==false){
                    f8=false;
                    f9=true;
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    citiesListScreen=new CitiesListScreen();
                    transaction.replace(R.id.framelayout,citiesListScreen);
                    transaction.commit();
                }
                else {
                        Intent intent = new Intent(RegistrationScreen.this, NavigationDrawerActivity.class);
                        startActivity(intent);
                }

            }
        });

        }



}

