package com.cihangul.favoriekleme;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;
public class MainActivity extends AppCompatActivity {

    public TabHost tabHost;
    public TabHost.TabSpec pencere1, pencere2, pencere3;
    public ViewPager viewPager;
    public FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TabHost Tanımlamaları
        tabHost = (TabHost) findViewById(R.id.tabhost);
        tabHost.setup();
        ///Tab 1 ;
        pencere1 = tabHost.newTabSpec("Kişiler");
        pencere1.setContent(R.id.tab1);
        pencere1.setIndicator("", getResources().getDrawable(R.drawable.ic_kisi));
        tabHost.addTab(pencere1);
        ///Tab 2 ;
        pencere2 = tabHost.newTabSpec("Favoriler");
        pencere2.setContent(R.id.tab2);
        pencere2.setIndicator("", getResources().getDrawable(R.drawable.ic_favoriler));
        tabHost.addTab(pencere2);
        ///Tab 3 ;
        pencere3 = tabHost.newTabSpec("Arkadaşlar");
        pencere3.setContent(R.id.tab3);
        pencere3.setIndicator("", getResources().getDrawable(R.drawable.ic_arkadas));
        tabHost.addTab(pencere3);


        //ViewPager Tanımlamaları
        fragmentManager = getSupportFragmentManager();
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new FragmentAdapter(fragmentManager));
        //Tab değişti zaman olacaklar
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                int i = tabHost.getCurrentTab();
                if (i == 0) {
                    //ekranda gösterilecek sayfayı tıklanan taba göre belirliyoruz
                    viewPager.setCurrentItem(i);

                } else if (i == 1) {

                    viewPager.setCurrentItem(i);

                } else if (i == 2) {
                    viewPager.setCurrentItem(i);

                }

            }
        });

        //Sayfa Kaydırıldığı zaman olacaklar
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            public void onPageSelected(int position) {
                //Seçili olacak tabı viewpager'ın pozisyonuna göre belirliyoruz
                tabHost.setCurrentTab(position);
            }

            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public class FragmentAdapter extends FragmentPagerAdapter {

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment = null;

            if (position == 0) {
                fragment = new KisilerFragment();
            } else if (position == 1) {
                fragment = new FavorilerFragment();
            } else if (position == 2) {
                fragment = new ArkadaslarFragment();
            }

            return fragment;
        }

        //Kaç tab olacaksa o değerde bir int değeri döndürüyoruz.
        @Override
        public int getCount() {
            return 3;

        }
    }
}
