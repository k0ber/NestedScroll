package com.nik.noveo.scroller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter {

    private int tabsCount;


    public MyPagerAdapter(FragmentManager fm, int tabsCount) {
        super(fm);
        this.tabsCount = tabsCount;
    }

    @Override
    public Fragment getItem(int position) {
        return TabFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return tabsCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }

}
