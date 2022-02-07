package com.example.recyclerviewpractice07feb22;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.recyclerviewpractice07feb22.Fragment.FragmentAdapter;
import com.example.recyclerviewpractice07feb22.databinding.ActivityTabLayoutBinding;
import com.google.android.material.tabs.TabLayout;

public class TabLayoutActivity extends AppCompatActivity {

    ActivityTabLayoutBinding binding;
    FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTabLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        FragmentManager fragmentManager = getSupportFragmentManager();
        adapter = new FragmentAdapter(fragmentManager, getLifecycle());
        binding.viewPager.setAdapter(adapter);

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Chats"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Status"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Calls"));

        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                binding.viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {

                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position));
            }
        });
    }
}