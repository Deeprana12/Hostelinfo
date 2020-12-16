package com.example.hostelinfo.insideHostel.ashirwad;

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

public class ashirwadCard extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    private aswd_ftab1 Ftab1;
    private aswd_ftab2 Ftab2;
    private aswd_ftab3 Ftab4;
    private aswd_ftab4 Ftab3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ashirwad_card);

    tabLayout = findViewById(R.id.tab_layout);
    viewPager = findViewById(R.id.vPager);

    Ftab1=new aswd_ftab1();
    Ftab2=new aswd_ftab2();
    Ftab4=new aswd_ftab3();
    Ftab3=new aswd_ftab4();

        tabLayout.setupWithViewPager(viewPager);

    ImageSlider imageSlider = findViewById(R.id.imageSlider);

    List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://content3.jdmagicbox.com/comp/kheda/l4/9999p2694.2694.170603234247.f3l4/catalogue/ashirvad-hostel-kheda-hostels-677mhrde0z.jpg"));
        slideModels.add(new SlideModel("https://lh3.googleusercontent.com/-N2PnkvdeGlM/W63RT1bknFI/AAAAAAAAAOo/SpkfnonzDsQZNb-rPhu5RsmgrA9VKAYCwCLIBGAYYCw/w768-h768-n-o-k-v1/"));
        slideModels.add(new SlideModel("https://lh3.googleusercontent.com/-APIYMsDVr2o/XMAIjjzh6ZI/AAAAAAAAA6M/8UWiKRUe68EFw56l6SkhbvLSqAQ0RxxKgCLIBGAYYCw/w768-h768-n-o-k-v1/"));
        slideModels.add(new SlideModel("https://lh5.googleusercontent.com/p/AF1QipNnbqwKUhLQpBSnv7Uqflif7-ZOgwX7kEMQSpMK=s237-k-no"));
        imageSlider.setImageList(slideModels, true);

    ashirwadCard.viewPageAdapter viewPageAdapter=new ashirwadCard.viewPageAdapter(getSupportFragmentManager(),0);
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