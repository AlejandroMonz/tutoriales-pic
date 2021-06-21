package com.example.tutoriales_pic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    FirstFragment firstFrament = new FirstFragment();
    SecondFragmente secondFragmente= new SecondFragmente();
    TercerFragment tercerFragment = new TercerFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnnavigationItemSelectedListener);
        loadFragment(firstFrament);
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnnavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull @org.jetbrains.annotations.NotNull MenuItem item) {
            switch (item.getItemId()){

                case R.id.menu_device:
                    loadFragment(firstFrament);
                    return true;

                case R.id.menu_res:
                    loadFragment(secondFragmente);
                    return true;

                case R.id.menu_tuto:
                    loadFragment(tercerFragment);
                    return true;

            }
            return false;
        }
    };

    public void loadFragment(Fragment fragment){

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }
}