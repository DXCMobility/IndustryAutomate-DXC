package example.com.industrialautomation.activities;

import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;

import Pojo.Industry;
import Presenter.ConnectionTask;
import Presenter.IClearedDB;
import example.com.industrialautomation.R;
import fragments.Dashboard;
import fragments.DeviceStatus;
import fragments.Feedback;
import fragments.Intellisense;
import fragments.Settings;

public class MainActivity extends AppCompatActivity implements IClearedDB {
    Toolbar toolbar;
    DrawerLayout drawerlayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        new ConnectionTask(this,this).execute();
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerlayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerlayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawerlayout.setDrawerListener(actionBarDrawerToggle);

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_container,new Dashboard());
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("DashBoard");
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.dashboard_id:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new Dashboard());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Dashboard");
                        item.setChecked(true);
                        drawerlayout.closeDrawers();
                        break;

                    case R.id.devicestatus_id:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new DeviceStatus());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("DeviceStatusModel");
                        item.setChecked(true);
                        drawerlayout.closeDrawers();
                        break;
                    case R.id.intellisense_id:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new Intellisense());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Intellisense");
                        item.setChecked(true);
                        drawerlayout.closeDrawers();
                        break;
                    case R.id.feedback_id:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new Feedback());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Feedback");
                        item.setChecked(true);
                        drawerlayout.closeDrawers();
                        break;
                    case R.id.settings_id:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new Settings());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Settings");
                        item.setChecked(true);
                        drawerlayout.closeDrawers();
                        break;
                }
                return true;
            }

    });
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();

    }


    @Override
    public void AutomatedData(ArrayList<Industry> lstIndustry) {

        if(lstIndustry !=null && lstIndustry.size() > 0){


        }
    }


}
