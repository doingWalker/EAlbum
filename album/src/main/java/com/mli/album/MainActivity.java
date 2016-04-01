package com.mli.album;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    private List<Fragment> fragments = new ArrayList<>();

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragment();
    }

    private void addFragment() {

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        Fragment fragment = new LazyFragment("1") {
            @Override
            public void startLoad() {

            }
        };
        Fragment fragment1 = new LazyFragment("2") {
            @Override
            public void startLoad() {

            }
        };

        fragments.add(fragment);
        fragments.add(fragment1);

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        FragmentPagerListAdapter fragmentPagerListAdapter = new FragmentPagerListAdapter(mFragmentManager, fragments);
        mViewPager.setAdapter(fragmentPagerListAdapter);
        mViewPager.setCurrentItem(0);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
