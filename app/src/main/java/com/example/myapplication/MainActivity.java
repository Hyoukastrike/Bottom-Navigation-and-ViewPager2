package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.myapplication.Adapter.ViewPagerAdapter;
import com.example.myapplication.Effect.DepthPageTransformer;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mNavigationView;
    private ViewPager2 mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.view_pager);
        mNavigationView = findViewById(R.id.bottom_nav);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        mViewPager.setAdapter(adapter);
        mViewPager.setPageTransformer(new DepthPageTransformer());

        mViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0:
                        mNavigationView.getMenu().findItem(R.id.action_home).setChecked(true);
                        break;
                    case 1:
                        mNavigationView.getMenu().findItem(R.id.action_favorite).setChecked(true);
                        break;
                    case 2:
                        mNavigationView.getMenu().findItem(R.id.action_location).setChecked(true);
                        break;
                    case 3:
                        mNavigationView.getMenu().findItem(R.id.action_menu).setChecked(true);
                        break;
                }
            }
        });

        mNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.action_favorite:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.action_location:
                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.action_menu:
                        mViewPager.setCurrentItem(3);
                        break;
                }

                return true;
            }
        });
    }
}