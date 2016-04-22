/*
 * Copyright 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.effectivenavigation;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity{

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide fragments for each of the
     * three primary sections of the app. We use a {@link android.support.v4.app.FragmentPagerAdapter}
     * derivative, which will keep every loaded fragment in memory. If this becomes too memory
     * intensive, it may be best to switch to a {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    AppSectionsPagerAdapter mAppSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will display the three primary sections of the app, one at a
     * time.
     */
    ViewPager mViewPager;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the adapter that will return a fragment for each of the three primary sections
        // of the app.
        mAppSectionsPagerAdapter = new AppSectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager, attaching the adapter and setting up a listener for when the
        // user swipes between sections.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mAppSectionsPagerAdapter);

    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to one of the primary
     * sections of the app.
     */
    public static class AppSectionsPagerAdapter extends FragmentPagerAdapter {

        public AppSectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    // The first section of the app is the most interesting -- it offers
                    // a launchpad into the other demonstrations in this example application.
                    return new LaunchpadSectionFragment();

                default:
                    // The other sections of the app are dummy placeholders.
                    Fragment fragment = new DummySectionFragment();
                    Bundle args = new Bundle();
                    args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, i + 1);
                    fragment.setArguments(args);
                    return fragment;
            }
        }

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Section " + (position + 1);
        }
    }

    /**
     * A fragment that launches other parts of the demo application.
     */
    public static class LaunchpadSectionFragment extends Fragment {

        private TextView tv1;
        private ImageView iv1;
        private TextView tv2;
        private TextView tv3;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_section_launchpad, container, false);
            tv1 = (TextView) rootView.findViewById(R.id.myImageViewText);
            tv2 = (TextView) rootView.findViewById(R.id.myImageViewText2);
            tv3 = (TextView) rootView.findViewById(R.id.myImageViewText3);
            Typeface type = Typeface.createFromAsset(rootView.getContext().getAssets(),"fonts/LobsterTwo-Regular.ttf");
            Typeface type2 = Typeface.createFromAsset(rootView.getContext().getAssets(),"fonts/LobsterTwo-Bold.ttf");
            tv1.setTypeface(type);
            tv2.setTypeface(type2);
            tv3.setTypeface(type);

            iv1 = (ImageView) rootView.findViewById(R.id.image);
            iv1.setImageResource(R.drawable.space);
            return rootView;
        }
    }

    /**
     * A dummy fragment representing a section of the app, but that simply displays dummy text.
     */
    public static class DummySectionFragment extends Fragment {

        public static final String ARG_SECTION_NUMBER = "section_number";
        private TextView tv1;
        private ImageView iv1;

        @Override
        public void onDestroyView() {
            super.onDestroyView();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_section_dummy, container, false);
            Bundle args = getArguments();
            Resources res = getResources();
            int index = args.getInt(ARG_SECTION_NUMBER);

            String[] visionStrings = res.getStringArray(R.array.vision_board_items);
            Typeface type = Typeface.createFromAsset(rootView.getContext().getAssets(),"fonts/LobsterTwo-Regular.ttf");

            tv1 = (TextView) rootView.findViewById(android.R.id.text1);
            tv1.setText(visionStrings[index-2]);
            tv1.setTypeface(type);

            iv1 = (ImageView) rootView.findViewById(R.id.image2);

            switch (index-2) {
                case 0:
                    iv1.setImageResource(R.drawable.charlie_sheen);
                    tv1.setGravity((Gravity.CENTER | Gravity.BOTTOM));
                    break;
                case 1:
                    iv1.setImageResource(R.drawable.environment);
                    tv1.setGravity((Gravity.CENTER | Gravity.BOTTOM));
                    break;
                case 2:
                    iv1.setImageResource(R.drawable.froggy);
                    break;
                case 3:
                    iv1.setImageResource(R.drawable.nutrition);
                    //tv1.setGravity((Gravity.CENTER | Gravity.BOTTOM));
                    tv1.setTextColor(Color.BLACK);
                    break;
                case 4:
                    iv1.setImageResource(R.drawable.exercise);
                    tv1.setGravity((Gravity.CENTER | Gravity.BOTTOM));
                    break;
                case 5:
                    iv1.setImageResource(R.drawable.communication);
                    break;
                case 6:
                    iv1.setImageResource(R.drawable.relationships);
                    tv1.setGravity((Gravity.CENTER | Gravity.BOTTOM));

                    break;
                case 7:
                    iv1.setImageResource(R.drawable.humor);
                    break;
                case 8:
                    iv1.setImageResource(R.drawable.peaceful_warrior);
                    //tv1.setTextColor(Color.BLACK);

                    break;
            }
            return rootView;
        }
    }
}
