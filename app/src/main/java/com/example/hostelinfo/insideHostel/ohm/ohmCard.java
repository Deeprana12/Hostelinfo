package com.example.hostelinfo.insideHostel.ohm;

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
import com.example.hostelinfo.insideHostel.nilkanth.nilkanthCard;
import com.example.hostelinfo.insideHostel.nilkanth.nlk_ftab1;
import com.example.hostelinfo.insideHostel.nilkanth.nlk_ftab2;
import com.example.hostelinfo.insideHostel.nilkanth.nlk_ftab3;
import com.example.hostelinfo.insideHostel.nilkanth.nlk_ftab4;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ohmCard extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    private ohm_ftab1 Ftab1;
    private ohm_ftab2 Ftab2;
    private ohm_ftab3 Ftab4;
    private ohm_ftab4 Ftab3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ohm_card);


        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.vPager);

        Ftab1=new ohm_ftab1();
        Ftab2=new ohm_ftab2();
        Ftab4=new ohm_ftab3();
        Ftab3=new ohm_ftab4();

        tabLayout.setupWithViewPager(viewPager);

        ImageSlider imageSlider = findViewById(R.id.imageSlider);

        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://lh5.googleusercontent.com/p/AF1QipO8it32Q7tepymi0YvyZiJ6InjXzIW4DGoSvgS0=s311-k-no"));
        slideModels.add(new SlideModel("https://lh5.googleusercontent.com/p/AF1QipMRA7LeZ71FjfbDcJZvhN-SdKYya8Pctz-gsVnN=s316-k-no"));
        slideModels.add(new SlideModel("https://lh5.googleusercontent.com/p/AF1QipO4gda1KPd0RNILnpFS15qx38HnenRejNGBvm0x=s277-k-no"));
        slideModels.add(new SlideModel("https://lh5.googleusercontent.com/p/AF1QipPQ3mD8b6q-NeMO9xcSZ64ieUfecF6KyMTKswLs=s316-k-no"));
        slideModels.add(new SlideModel("https://lh5.googleusercontent.com/p/AF1QipOQ2eVxOiZb5-dBa84AQNakpHBDip-YNsE3LL-d=s316-k-no"));

        imageSlider.setImageList(slideModels, true);

        ohmCard.viewPageAdapter viewPageAdapter=new ohmCard.viewPageAdapter(getSupportFragmentManager(),0);
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