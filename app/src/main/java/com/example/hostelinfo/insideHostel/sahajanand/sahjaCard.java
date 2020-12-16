package com.example.hostelinfo.insideHostel.sahajanand;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.hostelinfo.R;
import com.example.hostelinfo.insideHostel.rylcr.rylcrCard;
import com.example.hostelinfo.insideHostel.rylcr.rylcr_ftab1;
import com.example.hostelinfo.insideHostel.rylcr.rylcr_ftab2;
import com.example.hostelinfo.insideHostel.rylcr.rylcr_ftab3;
import com.example.hostelinfo.insideHostel.rylcr.rylcr_ftab4;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class sahjaCard extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    private sahja_ftab1 Ftab1;
    private sahja_ftab2 Ftab2;
    private sahja_ftab3 Ftab4;
    private sahja_ftab4 Ftab3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sahja_card);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.vPager);

        Ftab1=new sahja_ftab1();
        Ftab2=new sahja_ftab2();
        Ftab4=new sahja_ftab3();
        Ftab3=new sahja_ftab4();

        tabLayout.setupWithViewPager(viewPager);

        ImageSlider imageSlider = findViewById(R.id.imageSlider);

        List<SlideModel> slideModels = new ArrayList<>();



       slideModels.add(new SlideModel("http://www.sahajanandhostel.com/images/hostel/9.jpg"));
       slideModels.add(new SlideModel("http://www.sahajanandhostel.com/images/hostel/17.jpg"));
       slideModels.add(new SlideModel("http://www.sahajanandhostel.com/images/hostel/22.jpg"));
       slideModels.add(new SlideModel("http://www.sahajanandhostel.com/images/hostel/25.jpg"));
       slideModels.add(new SlideModel("http://www.sahajanandhostel.com/images/hostel/28.jpg"));
       slideModels.add(new SlideModel("http://www.sahajanandhostel.com/images/hostel/34.jpg"));
        imageSlider.setImageList(slideModels, true);

        sahjaCard.viewPageAdapter viewPageAdapter=new sahjaCard.viewPageAdapter(getSupportFragmentManager(),0);
        viewPageAdapter.addFragment(Ftab1,"Overview");
        viewPageAdapter.addFragment(Ftab2,"Facility");
        viewPageAdapter.addFragment(Ftab4,"Fees");
        viewPageAdapter.addFragment(Ftab3,"in Map");
        viewPager.setAdapter(viewPageAdapter);


        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_info_24);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_baseline_house_24);
        tabLayout.getTabAt(2).setIcon(R.drawable.money);
        tabLayout.getTabAt(3).setIcon(R.drawable.map);
    }
    private class viewPageAdapter extends FragmentPagerAdapter {

        private final ArrayList<Fragment> fragmentsList = new ArrayList<>();
        private final ArrayList<String> fragmentTitle = new ArrayList<>();

        public viewPageAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentsList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentsList.size();
        }

        public void addFragment(Fragment fragment, String Title) {

            fragmentsList.add(fragment);
            fragmentTitle.add(Title);

        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitle.get(position);
        }

    }
}