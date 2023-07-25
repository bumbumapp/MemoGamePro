package org.bumbumapps.privacyfriendlymemory.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.ads.AdView;
import com.google.firebase.crashlytics.FirebaseCrashlytics;

import org.bumbumapps.privacyfriendlymemory.BannersLoader;
import org.bumbumapps.privacyfriendlymemory.Constants;
import org.bumbumapps.privacyfriendlymemory.common.MemoGameStatistics;
import org.bumbumapps.privacyfriendlymemory.common.Preference;
import org.bumbumapps.privacyfriendlymemory.common.ResIdAdapter;
import org.bumbumapps.privacyfriendlymemory.model.CardDesign;
import org.bumbumapps.privacyfriendlymemory.model.MemoGameDefaultImages;
import org.bumbumapps.privacyfriendlymemory.model.MemoGameDifficulty;
import org.bumbumapps.privacyfriendlymemory.model.MemoGameMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class MainActivity extends AppCompatDrawerActivity {

    private SharedPreferences preferences   = null;
    private ViewPager viewPager             = null;
    private Preference preference;
    private Drawable drawable2;
    Drawable drawable;
    AdView bannerView;
    TextView level1,level2,level3,level4,level5,level6,level7,level8,level9,level10,level11,level12,level13,level14,level15,level16,level17,level18,level19,level20,level21,level22,level23,level24;
    private ArrayList<TextView> textViews=new ArrayList<TextView>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupPreferences();
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true);

        if (isFirstAppStart()) {
            setAppStarted();
            initStatistics();
        }

        setContentView(R.layout.activity_main);
        setupViewPager();
        setupLevels();
        bannerView=findViewById(R.id.hw_banner_view);
        setupDifficultyBar();
        BannersLoader.showGoogleBannerAd(this,bannerView);
        final NestedScrollView nestedScrollView = findViewById(R.id.neested);

        nestedScrollView.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        nestedScrollView.scrollTo(0, nestedScrollView.getChildAt(0).getHeight());
                        nestedScrollView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
        super.setupNavigationView();
    }

    private void setupLevels() {
        level1=findViewById(R.id.level1);
        level2=findViewById(R.id.level2);
        level3=findViewById(R.id.level3);
        level4=findViewById(R.id.level4);
        level5=findViewById(R.id.level5);
        level6=findViewById(R.id.level6);
        level7=findViewById(R.id.level7);
        level8=findViewById(R.id.level8);
        level9=findViewById(R.id.level9);
        level10=findViewById(R.id.level10);
        level11=findViewById(R.id.level11);
        level12=findViewById(R.id.level12);
        level13=findViewById(R.id.level13);
        level14=findViewById(R.id.level14);
        level15=findViewById(R.id.level15);
        level16=findViewById(R.id.level16);
        level17=findViewById(R.id.level17);
        level18=findViewById(R.id.level18);
        level19=findViewById(R.id.level19);
        level20=findViewById(R.id.level20);
        level21=findViewById(R.id.level21);
        level22=findViewById(R.id.level22);
        level23=findViewById(R.id.level23);
        level24=findViewById(R.id.level24);
        preference=new Preference(this);
        drawable = ContextCompat.getDrawable(this, R.drawable.levelbg1);
        drawable2 = ContextCompat.getDrawable(this, R.drawable.levelbg3);

        setDrawableBackground(preference.getInteger("end_level"));
        setEndDrawableBAcground();



        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (preference.getInteger("level")>=1){
                    level1.setBackground(drawable2);
                    preference.putInteger("end_level",1);
                    setDrawableBackground(1);
                }

            }
        });
        level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (preference.getInteger("level")>=2){
                    level2.setBackground(drawable2);
                    preference.putInteger("end_level",2);
                    setDrawableBackground(2);
                }

            }
        });
        level3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (preference.getInteger("level")>=3){
                    level3.setBackground(drawable2);
                    preference.putInteger("end_level",3);
                    setDrawableBackground(3);
                }

            }
        });
        level4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (preference.getInteger("level")>=4){
                    level4.setBackground(drawable2);
                    preference.putInteger("end_level",4);
                    setDrawableBackground(4);
                }

            }
        });
        level5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (preference.getInteger("level")>=5){
                    level5.setBackground(drawable2);
                    preference.putInteger("end_level",5);
                    setDrawableBackground(5);
                }

            }
        });
        level6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (preference.getInteger("level")>=6){
                    level6.setBackground(drawable2);
                    preference.putInteger("end_level",6);
                    setDrawableBackground(6);
                }

            }
        });
        level7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (preference.getInteger("level")>=7){
                    level7.setBackground(drawable2);
                    preference.putInteger("end_level",7);
                    setDrawableBackground(7);
                }

            }
        });
        level8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (preference.getInteger("level")>=8){
                    level8.setBackground(drawable2);
                    preference.putInteger("end_level",8);
                    setDrawableBackground(8);
                }

            }
        });
        level9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (preference.getInteger("level")>=9){
                    level9.setBackground(drawable2);
                    preference.putInteger("end_level",9);
                    setDrawableBackground(9);
                }

            }
        });
        level10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (preference.getInteger("level")>=10){
                    level10.setBackground(drawable2);
                    preference.putInteger("end_level",10);
                    setDrawableBackground(10);
                }

            }
        });
        level11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (preference.getInteger("level")>=11){
                    level11.setBackground(drawable2);
                    preference.putInteger("end_level",11);
                    setDrawableBackground(11);
                }

            }
        });
        level12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (preference.getInteger("level")>=12){
                    level12.setBackground(drawable2);
                    preference.putInteger("end_level",12);
                    setDrawableBackground(12);
                }

            }
        });
        level13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (preference.getInteger("level")>=13){
                    level13.setBackground(drawable2);
                    preference.putInteger("end_level",13);
                    setDrawableBackground(13);
                }

            }
        });
        level14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (preference.getInteger("level")>=14){
                    level14.setBackground(drawable2);
                    preference.putInteger("end_level",14);
                    setDrawableBackground(14);
                }

            }
        });
        level15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (preference.getInteger("level")>=15){
                    level15.setBackground(drawable2);
                    preference.putInteger("end_level",15);
                    setDrawableBackground(15);
                }

            }
        });
        level16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (preference.getInteger("level")>=16){
                    level16.setBackground(drawable2);
                    preference.putInteger("end_level",16);
                    setDrawableBackground(16);
                }

            }
        });
        level17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (preference.getInteger("level")>=17){
                    level17.setBackground(drawable2);
                    preference.putInteger("end_level",17);
                    setDrawableBackground(17);
                }

            }
        });
        level18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (preference.getInteger("level")>=18){
                    level18.setBackground(drawable2);
                    preference.putInteger("end_level",18);
                    setDrawableBackground(18);
                }

            }
        });
        level19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (preference.getInteger("level")>=19){
                    level19.setBackground(drawable2);
                    preference.putInteger("end_level",19);
                    setDrawableBackground(19);
                }

            }
        });
        level20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (preference.getInteger("level")>=20){
                    level20.setBackground(drawable2);
                    preference.putInteger("end_level",20);
                    setDrawableBackground(20);
                }

            }
        });
        level21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (preference.getInteger("level")>=21){
                    level21.setBackground(drawable2);
                    preference.putInteger("end_level",21);
                    setDrawableBackground(21);
                }

            }
        });
        level22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (preference.getInteger("level")>=22){
                    level22.setBackground(drawable2);
                    preference.putInteger("end_level",22);
                    setDrawableBackground(22);
                }

            }
        });
        level23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (preference.getInteger("level")>=23){
                    level23.setBackground(drawable2);
                    preference.putInteger("end_level",23);
                    setDrawableBackground(23);
                }

            }
        });
        level24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (preference.getInteger("level")>=24){
                    level24.setBackground(drawable2);
                    preference.putInteger("end_level",24);
                    setDrawableBackground(24);
                }

            }
        });





    }

    private void setEndDrawableBAcground() {
        int endLevel=preference.getInteger("end_level");

        if (endLevel==1){
            level1.setBackground(drawable2);
        }
        if (endLevel==2){
            level2.setBackground(drawable2);
        }
        if (endLevel==3){
            level3.setBackground(drawable2);
        }
        if (endLevel==4){
            level4.setBackground(drawable2);
        }
        if (endLevel==5){
            level5.setBackground(drawable2);
        }
        if (endLevel==6){
            level6.setBackground(drawable2);
        }
        if (endLevel==7){
            level7.setBackground(drawable2);
        }
        if (endLevel==8){
            level8.setBackground(drawable2);
        }
        if (endLevel==9){
            level9.setBackground(drawable2);
        }
        if (endLevel==10){
            level10.setBackground(drawable2);
        }
        if (endLevel==11){
            level11.setBackground(drawable2);
        }
        if (endLevel==12){
            level12.setBackground(drawable2);
        }
        if (endLevel==13){
            level13.setBackground(drawable2);
        }
        if (endLevel==14){
            level14.setBackground(drawable2);
        }
        if (endLevel==15){
            level15.setBackground(drawable2);
        }
        if (endLevel==16){
            level16.setBackground(drawable2);
        }
        if (endLevel==17){
            level17.setBackground(drawable2);
        }
        if (endLevel==18){
            level18.setBackground(drawable2);
        }
        if (endLevel==19){
            level19.setBackground(drawable2);
        }
        if (endLevel==20){
            level20.setBackground(drawable2);
        }
        if (endLevel==21){
            level21.setBackground(drawable2);
        }
        if (endLevel==22){
            level22.setBackground(drawable2);
        }
        if (endLevel==23){
            level23.setBackground(drawable2);
        }
        if (endLevel==24){
            level24.setBackground(drawable2);
        }

    }

    private void setDrawableBackground(int i) {
        int endLevel=preference.getInteger("end_level");
        if (preference.getInteger("level")>=1 && endLevel!=1){
            level1.setBackground(drawable);       }
        if (preference.getInteger("level")>=2 && endLevel!=2){
            Log.d("Edf", String.valueOf(endLevel));
            Log.d("Edf", String.valueOf(preference.getInteger("level")));
            level2.setBackground(drawable);        }
        if (preference.getInteger("level")>=3 && endLevel!=3){
            level3.setBackground(drawable);        }
        if (preference.getInteger("level" )>=4 && endLevel!=4){
            level4.setBackground(drawable);        }
        if (preference.getInteger("level")>=5 && endLevel!=5){
            level5.setBackground(drawable);        }
        if (preference.getInteger("level")>=6 && endLevel!=6){
            level6.setBackground(drawable);        }
        if (preference.getInteger("level")>=7 && endLevel!=7){
            level7.setBackground(drawable);        }
        if (preference.getInteger("level")>=8 && endLevel!=8){
            level8.setBackground(drawable);        }
        if (preference.getInteger("level")>=9 && endLevel!=9){
            level9.setBackground(drawable);        }
        if (preference.getInteger("level")>=10 && endLevel!=10){
            level10.setBackground(drawable);        }
        if (preference.getInteger("level")>=11 && endLevel!=11){
            level11.setBackground(drawable);        }
        if (preference.getInteger("level")>=12 && endLevel!=12){
            level12.setBackground(drawable);        }
        if (preference.getInteger("level")>=13 && endLevel!=13){
            level13.setBackground(drawable);        }
        if (preference.getInteger("level")>=14 && endLevel!=14){
            level14.setBackground(drawable);        }
        if (preference.getInteger("level")>=15 && endLevel!=15){
            level15.setBackground(drawable);        }
        if (preference.getInteger("level")>=16 && endLevel!=16){
            level16.setBackground(drawable);        }
        if (preference.getInteger("level")>=17 && endLevel!=17){
            level17.setBackground(drawable);        }
        if (preference.getInteger("level")>=18 && endLevel!=18){
            level18.setBackground(drawable);        }
        if (preference.getInteger("level")>=19 && endLevel!=19){
            level19.setBackground(drawable);        }
        if (preference.getInteger("level")>=20 && endLevel!=20){
            level20.setBackground(drawable);        }
        if (preference.getInteger("level")>=21 && endLevel!=21){
            level21.setBackground(drawable);        }
        if (preference.getInteger("level")>=22 && endLevel!=22){
            level22.setBackground(drawable);        }
        if (preference.getInteger("level")>=23 && endLevel!=23){
            level23.setBackground(drawable);        }
        if (preference.getInteger("level")>=24 && endLevel!=24){
            level24.setBackground(drawable);        }
    }


    public void setupViewPager() {
        final ImageView arrowLeft = (ImageView) findViewById(R.id.arrow_left);
        final ImageView arrowRight = (ImageView) findViewById(R.id.arrow_right);
        arrowLeft.setVisibility(View.INVISIBLE);
        arrowRight.setVisibility(View.VISIBLE);

        final SectionsPagerAdapter  sectionPagerAdapter = new SectionsPagerAdapter (getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.scroller);
        viewPager.setAdapter(sectionPagerAdapter);
        viewPager.setCurrentItem(0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        }
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // not used
            }

            @Override
            public void onPageSelected(int position) {
                arrowLeft.setVisibility(position == 0 ? View.INVISIBLE : View.VISIBLE);
                arrowRight.setVisibility(position == 1 ? View.INVISIBLE : View.VISIBLE);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // not used
            }
        });
    }

    public void setupDifficultyBar() {
        final TextView difficultyText = (TextView) findViewById(R.id.difficultyText);
        final RatingBar difficultyBar = (RatingBar) findViewById(R.id.difficultyBar);
        difficultyBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(rating < 1){
                    ratingBar.setRating(1);
                }
                difficultyText.setText(getString(MemoGameDifficulty.getValidDifficulties().get((int) ratingBar.getRating() - 1).getStringResID()));
            }
        });
    }

    public void onClick(View view) {
        MemoGameDifficulty memoryDifficulty;
        MemoGameMode memoryMode;
        Intent intent = new Intent(this, MemoActivity.class);
        int selectedCardDesign;
        CardDesign cardDesign;

        switch (view.getId()) {
            case R.id.playButton:
                // get select game type and difficulty
                memoryMode = MemoGameMode.getValidTypes().get(0);

                memoryDifficulty = MemoGameDifficulty.getValidDifficulties().get(preference.getInteger("end_level")-1);

                // send game information to game activity
                intent.putExtra(Constants.GAME_MODE, memoryMode);
                intent.putExtra(Constants.GAME_DIFFICULTY, memoryDifficulty);
                selectedCardDesign = preferences.getInt(Constants.SELECTED_CARD_DESIGN, 1);
                cardDesign =  CardDesign.get(selectedCardDesign);
                intent.putExtra(Constants.CARD_DESIGN, cardDesign);
                startActivity(intent);
                break;
            case R.id.playFirend:
                memoryMode = MemoGameMode.getValidTypes().get(1);

                memoryDifficulty = MemoGameDifficulty.getValidDifficulties().get(preference.getInteger("end_level")-1);

                // send game information to game activity
                intent.putExtra(Constants.GAME_MODE, memoryMode);
                intent.putExtra(Constants.GAME_DIFFICULTY, memoryDifficulty);
                selectedCardDesign = preferences.getInt(Constants.SELECTED_CARD_DESIGN, 1);
                cardDesign =  CardDesign.get(selectedCardDesign);
                intent.putExtra(Constants.CARD_DESIGN, cardDesign);
                startActivity(intent);
            default:
                break;
        }
    }

    private void initStatistics(){
        List<Integer> resIdsDeckOne = MemoGameDefaultImages.getResIDs(CardDesign.FIRST, MemoGameDifficulty.Level24, false);
        List<Integer> resIdsDeckTwo = MemoGameDefaultImages.getResIDs(CardDesign.SECOND, MemoGameDifficulty.Level24, false);
        List<String> resourceNamesDeckOne = ResIdAdapter.getResourceName(resIdsDeckOne, this);

        List<String> resourceNamesDeckTwo = ResIdAdapter.getResourceName(resIdsDeckTwo, this);
        Set<String> statisticsDeckOne = MemoGameStatistics.createInitStatistics(resourceNamesDeckOne);
        Set<String> staticticsDeckTwo =  MemoGameStatistics.createInitStatistics(resourceNamesDeckTwo);
        preferences.edit().putStringSet(Constants.STATISTICS_DECK_ONE, statisticsDeckOne).commit();
        preferences.edit().putStringSet(Constants.STATISTICS_DECK_TWO, staticticsDeckTwo).commit();
    }

    private void setAppStarted() {
        preferences.edit().putBoolean(Constants.FIRST_APP_START, false).commit();
    }



    private void setupPreferences() {
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
    }

    private boolean isFirstAppStart() {
        return preferences.getBoolean(Constants.FIRST_APP_START, true);
    }




    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a GameTypeFragment (defined as a static inner class below).
            return GameTypeFragment.newInstance(position);
        }



        @Override
        public int getCount() {
            // Show 2 total pages.
            return MemoGameMode.getValidTypes().size();
        }

    }
    /**
     * A placeholder fragment containing a simple view.
     */
    public static class GameTypeFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */


        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static GameTypeFragment newInstance(int sectionNumber) {
            GameTypeFragment fragment = new GameTypeFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public GameTypeFragment() {

        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_type_main_content, container, false);

            MemoGameMode memoryMode = MemoGameMode.getValidTypes().get(getArguments().getInt(ARG_SECTION_NUMBER));

            ImageView imageView = (ImageView) rootView.findViewById(R.id.gameTypeImage);

            imageView.setImageResource(memoryMode.getImageResID());

            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(memoryMode.getStringResID()));
            return rootView;
        }
    }


}
