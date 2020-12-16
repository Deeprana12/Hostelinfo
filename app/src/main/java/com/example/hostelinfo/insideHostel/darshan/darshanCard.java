package com.example.hostelinfo.insideHostel.darshan;

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
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class darshanCard extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    private ftab1 Ftab1;
    private ftab2 Ftab2;
    private ftab4 Ftab4;
    private ftab3 Ftab3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_darshan_card);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.vPager);

        Ftab1=new ftab1();
        Ftab2=new ftab2();
        Ftab3=new ftab3();
        Ftab4=new ftab4();

        tabLayout.setupWithViewPager(viewPager);

        ImageSlider imageSlider = findViewById(R.id.imageSlider);

        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://darshanhostel.com/wp-content/uploads/photo-gallery/imported_from_media_libray//thumb/IMG_20200627_170349.jpg"));
        slideModels.add(new SlideModel("https://darshanhostel.com/wp-content/uploads/photo-gallery/imported_from_media_libray//thumb/IMG_20200627_170328.jpg"));
        slideModels.add(new SlideModel("https://darshanhostel.com/wp-content/uploads/photo-gallery/thumb/Darshan-Hostel-Room-2.JPG"));
        slideModels.add(new SlideModel("https://darshanhostel.com/wp-content/uploads/photo-gallery/imported_from_media_libray//thumb/IMG_20200627_170102.jpg"));
        slideModels.add(new SlideModel("https://darshanhostel.com/wp-content/uploads/photo-gallery/imported_from_media_libray//thumb/IMG_20200627_170456.jpg"));

        imageSlider.setImageList(slideModels, true);

        viewPageAdapter viewPageAdapter=new viewPageAdapter(getSupportFragmentManager(),0);
        viewPageAdapter.addFragment(Ftab1,"Overview");
        viewPageAdapter.addFragment(Ftab2,"Facility");
        viewPageAdapter.addFragment(Ftab3,"Fees");
        viewPageAdapter.addFragment(Ftab4,"in Map");
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
