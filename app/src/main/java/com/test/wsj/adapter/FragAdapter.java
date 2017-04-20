package com.test.wsj.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by DELL on 2017/4/15.
 */

public class FragAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;

    public FragAdapter(FragmentManager fm) {
        super(fm);
    }

    public FragAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int postion) {
        return list.get(postion);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
