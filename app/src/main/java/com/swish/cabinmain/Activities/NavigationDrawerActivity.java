package com.swish.cabinmain.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

import com.swish.cabinmain.Fragments.FragmentAddMoneyScreen;
import com.swish.cabinmain.Fragments.FragmentBookARide;
import com.swish.cabinmain.Fragments.FragmentFeedbackScreen;
import com.swish.cabinmain.Fragments.FragmentMoreScreen;
import com.swish.cabinmain.Fragments.FragmentNotificationScreen;
import com.swish.cabinmain.Fragments.FragmentPassesScreens;
import com.swish.cabinmain.Fragments.FragmentPaymentScreen;
import com.swish.cabinmain.Fragments.FragmentSuggestNewRoutes;
import com.swish.cabinmain.Interface.FragmentInterface;
import com.swish.cabinmain.R;
import com.swish.cabinmain.TabLayoutActivities.TabLayoutActivityEarnMore;
import com.swish.cabinmain.TabLayoutActivities.TabLayoutActivityMyRide;
import com.swish.cabinmain.TabLayoutActivities.TabLayoutActivityPassbook;
import com.swish.cabinmain.TabLayoutActivities.TabLayoutActivityRoute;
import com.swish.cabinmain.TabLayoutActivities.TabLayoutActivityShareAndEarn;

public class NavigationDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FragmentInterface {
    private NavigationView navigationView;
    private DrawerLayout drawer;
    private View navHeader;
    private TextView txtName, txtWebsite;
    private Toolbar toolbar;
    private FloatingActionButton fab;
    private Button acceptmoney;
    private Button earnmore;
    private Button viewpassbook;

    // index to identify current nav menu item
    public static int navItemIndex = 0;

    // tags used to attach the fragments
    private static final String TAG_BOOKARIDE="bookaride";
    private static final String TAG_MYRIDES = "myrides";
    private static final String TAG_ROUTES= "routes";
    private static final String TAG_SUGGEST = "suggest";
    private static final String TAG_PAYMENT = "payment";
    private static final String TAG_PASSES = "passes";
    private static final String TAG_SHARE = "share";
    private static final String TAG_NOTIFICATION = "notification";
    private static final String TAG_FEEDBACK = "feedback";
    private static final String TAG_MORE = "more";
    public static String CURRENT_TAG = TAG_BOOKARIDE;

    // toolbar titles respected to selected nav menu item
    private String[] activityTitles;

    // flag to load home fragment when user presses back key
    private boolean shouldLoadHomeFragOnBackPress = true;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mHandler = new Handler();

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        acceptmoney=(Button)findViewById(R.id.acceptmoney);
        earnmore=(Button)findViewById(R.id.earnmore);
        viewpassbook=(Button)findViewById(R.id.viewpassbook);


        // load toolbar titles from string resources
        activityTitles = getResources().getStringArray(R.array.nav_item_activity_titles);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        // initializing navigation menu
        setUpNavigationView();

        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_BOOKARIDE;
            loadHomeFragment();
        }
    }

    private void loadHomeFragment() {
        // selecting appropriate nav menu item
        selectNavMenu();

        // set toolbar title
        setToolbarTitle();

        // if user select the current navigation menu again, don't do anything
        // just close the navigation drawer
        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            drawer.closeDrawers();

            // show or hide the fab button
            toggleFab();
            return;
        }

        // Sometimes, when fragment has huge data, screen seems hanging
        // when switching between navigation menus
        // So using runnable, the fragment is loaded with cross fade effect
        // This effect can be seen in GMail app
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        // If mPendingRunnable is not null, then add to the message queue
        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }

        // show or hide the fab button
        toggleFab();

        //Closing drawer on item click
        drawer.closeDrawers();

        // refresh toolbar menu
        invalidateOptionsMenu();
    }

    private Fragment getHomeFragment() {
        switch (navItemIndex) {
            case 0:
                //bookaride
                FragmentBookARide bookARide=new FragmentBookARide();
                return bookARide;
            case 3:
                // suggest new routes
                FragmentSuggestNewRoutes suggestNewRoutes = new FragmentSuggestNewRoutes();
                return suggestNewRoutes;
            case 4:
                // payments
                FragmentPaymentScreen paymentScreen = new FragmentPaymentScreen();
                return paymentScreen;

            case 5:
                // passes
                FragmentPassesScreens passesScreens = new FragmentPassesScreens();
                return passesScreens;

            case 6:
                // notifications
                FragmentNotificationScreen notificationScreen = new FragmentNotificationScreen();
                return notificationScreen;

            case 7:
                // feedback
                FragmentFeedbackScreen feedbackScreen = new FragmentFeedbackScreen();
                return feedbackScreen;

            case 8:
                // more
                FragmentMoreScreen moreScreen = new FragmentMoreScreen();
                return moreScreen;
            default:
                return new FragmentBookARide();
        }
    }

    private void setToolbarTitle() {
        getSupportActionBar().setTitle(activityTitles[navItemIndex]);
    }

    private void selectNavMenu() {
        navigationView.getMenu().getItem(navItemIndex).setChecked(true);
    }

    private void setUpNavigationView() {
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {
                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.book_a_ride:
                        navItemIndex=0;
                        CURRENT_TAG=TAG_BOOKARIDE;
                        break;
                    case R.id.my_rides:
                        //navItemIndex = 1;
                        startActivity(new Intent(NavigationDrawerActivity.this, TabLayoutActivityMyRide.class));
                        drawer.closeDrawers();
                        break;
                    case R.id.route:
                        //navItemIndex = 2;
                        startActivity(new Intent(NavigationDrawerActivity.this, TabLayoutActivityRoute.class));
                        drawer.closeDrawers();
                        break;
                    case R.id.suggestroute:
                        navItemIndex = 3;
                        CURRENT_TAG = TAG_SUGGEST;
                        break;
                    case R.id.payment:
                        navItemIndex = 4;
                        CURRENT_TAG = TAG_PAYMENT;
                        break;
                    case R.id.passes:
                        navItemIndex = 5;
                        CURRENT_TAG = TAG_PASSES;
                        break;
                    case R.id.share:
                        //navItemIndex=6;
                        startActivity(new Intent(NavigationDrawerActivity.this, TabLayoutActivityShareAndEarn.class));
                        drawer.closeDrawers();
                        break;
                    case R.id.notification:
                        navItemIndex=6;
                        CURRENT_TAG= TAG_NOTIFICATION;
                        break;
                    case R.id.feedback:
                        navItemIndex=7;
                        CURRENT_TAG= TAG_FEEDBACK;
                        break;
                    case R.id.more:
                        navItemIndex=8;
                        CURRENT_TAG=TAG_MORE;
                        break;
                    default:
                        navItemIndex = 0;
                }

                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);

                loadHomeFragment();

                return true;
            }
        });


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawer.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
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



    private void toggleFab() {
        if (navItemIndex == 0)
            fab.hide();
        else
            fab.hide();
    }


    @Override
    public void acceptMoney() {
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        FragmentAddMoneyScreen addMoneyScreen=new FragmentAddMoneyScreen();
        transaction.replace(R.id.frame,addMoneyScreen);
        transaction.commit();
    }

    @Override
    public void earnmore(View view) {
        Intent intent=new Intent(NavigationDrawerActivity.this, TabLayoutActivityEarnMore.class);
        startActivity(intent);
    }

    @Override
    public void viewpassbook(View view) {
        Intent intent=new Intent(NavigationDrawerActivity.this, TabLayoutActivityPassbook.class);
        startActivity(intent);
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
        //
    }

    @Override
    public void suggest1() {
//
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }
}
