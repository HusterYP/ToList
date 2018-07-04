package com.example.yuanping.todolist.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.example.yuanping.todolist.R;
import com.example.yuanping.todolist.adapter.MainPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;
    private ViewPager mainPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        bottomNav = findViewById(R.id.main_navigation);
        mainPager = findViewById(R.id.main_pager);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView
                .OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.main_main: {
                        mainPager.setCurrentItem(0);
                        return true;
                    }
                    case R.id.main_mine: {
                        mainPager.setCurrentItem(1);
                        return true;
                    }
                    default:
                        return false;
                }
            }
        });
        MainFragment mainFragment = new MainFragment();
        MineFragment mineFragment = new MineFragment();
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(mainFragment);
        fragments.add(mineFragment);
        FragmentManager fm = getSupportFragmentManager();
        MainPagerAdapter adapter = new MainPagerAdapter(fragments, fm);
        mainPager.setAdapter(adapter);
        mainPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int
                    positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNav.setSelectedItemId(R.id.main_main);
                        break;
                    case 1:
                        bottomNav.setSelectedItemId(R.id.main_mine);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}