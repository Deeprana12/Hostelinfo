package com.example.hostelinfo.insideHostel.nisarg;

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
import com.example.hostelinfo.insideHostel.ashirwad.ashirwadCard;
import com.example.hostelinfo.insideHostel.ashirwad.aswd_ftab1;
import com.example.hostelinfo.insideHostel.ashirwad.aswd_ftab2;
import com.example.hostelinfo.insideHostel.ashirwad.aswd_ftab3;
import com.example.hostelinfo.insideHostel.ashirwad.aswd_ftab4;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class nisargCard extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    private nsrg_ftab1 Ftab1;
    private nsrg_ftab2 Ftab2;
    private nsrg_ftab3 Ftab4;
    private nsrg_ftab4 Ftab3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nisarg_card);


        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.vPager);

        Ftab1=new nsrg_ftab1();
        Ftab2=new nsrg_ftab2();
        Ftab4=new nsrg_ftab3();
        Ftab3=new nsrg_ftab4();

        tabLayout.setupWithViewPager(viewPager);

        ImageSlider imageSlider = findViewById(R.id.imageSlider);

        List<SlideModel> slideModels = new ArrayList<>();



        slideModels.add(new SlideModel("https://lh5.googleusercontent.com/p/AF1QipNcQOx5WbcYXux28qguFJY2kBzBHhfvlSDmcx5T=s841-k-no"));
        slideModels.add(new SlideModel("https://content3.jdmagicbox.com/comp/kheda/x9/9999p2694.2694.190814123949.a4x9/catalogue/nisarg-hostel-changa-kheda-kheda-hostel-for-boy-students-s50vhjcisg.jpg"));
        slideModels.add(new SlideModel("https://content3.jdmagicbox.com/comp/kheda/x9/9999p2694.2694.190814123949.a4x9/catalogue/nisarg-hostel-changa-kheda-kheda-hostel-for-boy-students-esk3ssrqcw.jpg"));
        slideModels.add(new SlideModel("https://content3.jdmagicbox.com/comp/kheda/x9/9999p2694.2694.190814123949.a4x9/catalogue/nisarg-hostel-changa-kheda-kheda-hostel-for-boy-students-fn9ezlwzvw.jpg"));
        imageSlider.setImageList(slideModels, true);

        nisargCard.viewPageAdapter viewPageAdapter=new nisargCard.viewPageAdapter(getSupportFragmentManager(),0);
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