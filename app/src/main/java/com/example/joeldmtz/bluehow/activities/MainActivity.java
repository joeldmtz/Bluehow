package com.example.joeldmtz.bluehow.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.joeldmtz.bluehow.R;
import com.example.joeldmtz.bluehow.fragments.account.AccountFragment;
import com.example.joeldmtz.bluehow.fragments.history.HistoryFragment;
import com.example.joeldmtz.bluehow.fragments.navigation.NavigationFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.my_toolbar)
    Toolbar toolbar;

    @BindView(R.id.navigation)
    BottomNavigationView navigationView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    renderFragment("navigation");
                    return true;
                case R.id.navigation_dashboard:
                    renderFragment("history");
                    return true;
                case R.id.navigation_notifications:
                    renderFragment("account");
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new NavigationFragment())
                .addToBackStack(null)
                .commit();
    }

    protected void renderFragment(String key) {
        Fragment fragment = null;
        switch (key) {
            case "navigation":
                fragment = new NavigationFragment();
                break;
            case "history":
                fragment = new HistoryFragment();
                break;
            case "account":
                fragment = new AccountFragment();
                break;
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }
}
