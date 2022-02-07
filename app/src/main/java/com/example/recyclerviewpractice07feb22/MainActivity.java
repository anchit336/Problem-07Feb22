package com.example.recyclerviewpractice07feb22;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.recyclerviewpractice07feb22.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayList<ModelClass> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrayList.add(new ModelClass(R.drawable.akash, "Akash", "Hi I am akash"));
        arrayList.add(new ModelClass(R.drawable.bikram, "Bikram", "Hi I am Bikram"));
        arrayList.add(new ModelClass(R.drawable.hirak, "Hirak", "Hi I am Hirak"));
        arrayList.add(new ModelClass(R.drawable.nitai, "Nitai", "Hi I am Nitai"));
        arrayList.add(new ModelClass(R.drawable.nitish, "Nitish", "Hi I am Nitish"));
        arrayList.add(new ModelClass(R.drawable.rahul, "Rahul", "Hi I am Rahul"));
        arrayList.add(new ModelClass(R.drawable.sourav, "Sourav", "Hi I am Sourav"));
        arrayList.add(new ModelClass(R.drawable.tanmoy, "Tanmoy", "Hi I am Tanmoy"));

        RecyclerAdapter adapter = new RecyclerAdapter(this, arrayList);
        binding.recyclerView.setAdapter(adapter);

        binding.toolBar.setNavigationOnClickListener(view -> {

            binding.drawerLayout.openDrawer(GravityCompat.START);

        });

        binding.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                binding.drawerLayout.closeDrawer(GravityCompat.START);

                switch (item.getItemId())
                {

                    case R.id.send:
                        Toast.makeText(MainActivity.this, "Send Message", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.snooze:
                        Toast.makeText(MainActivity.this, "Snooze", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.star:
                        Toast.makeText(MainActivity.this, "Star Message", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.settings:
                        Toast.makeText(MainActivity.this, "Open Settings", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        return true;
                }

                return false;
            }
        });
    }
}