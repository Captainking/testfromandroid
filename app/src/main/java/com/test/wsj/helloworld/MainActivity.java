package com.test.wsj.helloworld;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuView;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.test.wsj.adapter.FragAdapter;
import com.test.wsj.fragment.FragmentHome;
import com.test.wsj.fragment.FragmentLog;
import com.test.wsj.fragment.FragmentSet;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private TextView mTextMessage;

    private ViewPager viewpager;
    private FragAdapter adapter;
    private List<Fragment> list;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        viewpager = (ViewPager) findViewById(R.id.pageview);
        list = new ArrayList<Fragment>();
        list.add(new FragmentHome());
        list.add(new FragmentLog());
        list.add(new FragmentSet());


        adapter = new FragAdapter(getSupportFragmentManager(), list);
        viewpager.setAdapter(adapter);
        viewpager.setCurrentItem(0);

        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position == 0) {
                    Toast.makeText(MainActivity.this, "当前页卡的标题：" + list.get(position).getClass(), Toast.LENGTH_SHORT).show();
                    MenuView.ItemView item= (MenuView.ItemView) findViewById(R.id.navigation_home);
                    item.setChecked(true);
                } else if (position == 1) {
                    Toast.makeText(MainActivity.this, "当前页卡的标题：" + list.get(position).getClass(), Toast.LENGTH_SHORT).show();
                    MenuView.ItemView item= (MenuView.ItemView) findViewById(R.id.navigation_dashboard);
                    item.setChecked(true);
                } else if (position == 2) {
                    Toast.makeText(MainActivity.this, "当前页卡的标题：" + list.get(position).getClass(), Toast.LENGTH_SHORT).show();
                    MenuView.ItemView item= (MenuView.ItemView) findViewById(R.id.navigation_notifications);
                    item.setChecked(true);
                } else {

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

}
