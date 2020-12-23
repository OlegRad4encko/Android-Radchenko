package com.radchenko.lab8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager pager = findViewById(R.id.viewpager);
        pager.setOnTouchListener(null);
        pager.setAdapter(new MainPager(getSupportFragmentManager(), 1));
        TabLayout mainTabs = findViewById(R.id.main_tabs);
        mainTabs.setupWithViewPager(pager);
    }

    public final class MainPager extends FragmentPagerAdapter
    {
        private final int INFORMATION_PAGE = 0;
        private final int TIMER_PAGE = 1;
        private final int PAGE_COUNT = 2;

        public MainPager(FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        public Fragment getItem(int position) {

            if (position == this.INFORMATION_PAGE) {
                return InformationFragment.Companion.newInstance();
            }
            if (position == this.TIMER_PAGE) {
                return StopwatchFragment.Companion.newInstance();
            }
            return InformationFragment.Companion.newInstance();
        }

        public int getCount() {
            return this.PAGE_COUNT;
        }

        public CharSequence getPageTitle(int position) {
            if (position == this.INFORMATION_PAGE) {
                return "Информация";
            }
            if (position == this.TIMER_PAGE) {
                return "Секундомер";
            }
            return "Неизвестно";
        }
    }
}