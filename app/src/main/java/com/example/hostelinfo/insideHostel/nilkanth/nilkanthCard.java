package com.example.hostelinfo.insideHostel.nilkanth;

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

public class nilkanthCard extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    private nlk_ftab1 Ftab1;
    private nlk_ftab2 Ftab2;
    private nlk_ftab3 Ftab4;
    private nlk_ftab4 Ftab3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nilkanth);


        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.vPager);

        Ftab1=new nlk_ftab1();
        Ftab2=new nlk_ftab2();
        Ftab4=new nlk_ftab3();
        Ftab3=new nlk_ftab4();

        tabLayout.setupWithViewPager(viewPager);

        ImageSlider imageSlider = findViewById(R.id.imageSlider);

        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://lh5.googleusercontent.com/p/AF1QipMos7l9sz4d7p-sErQHbA7GkuFQBe-NLDmdZzkv=w270-h125-k-no"));
        slideModels.add(new SlideModel("https://lh5.googleusercontent.com/p/AF1QipNJD4zYG0woZNqFzB9bfivemuECCswQ8_P50QBe=w254-h338-k-no"));
//        slideModels.add(new SlideModel("https://photos.wikimapia.org/p/00/02/54/75/85_big.jpg"));
        imageSlider.setImageList(slideModels, true);

        nilkanthCard.viewPageAdapter viewPageAdapter=new nilkanthCard.viewPageAdapter(getSupportFragmentManager(),0);
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