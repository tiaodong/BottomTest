package com.ren.jiemei.bottomtest;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ren.jiemei.bottomtest.fragment.FindFragment;
import com.ren.jiemei.bottomtest.fragment.HomeFragment;
import com.ren.jiemei.bottomtest.fragment.InventFragment;
import com.ren.jiemei.bottomtest.fragment.MeFragment;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radiogroup;
    private RadioButton homebutton,inventbutton,findbutton,mebutton;
    private FrameLayout framelay;

    private Fragment[] fragments = new Fragment[]{new HomeFragment(),new InventFragment(),new FindFragment(),new MeFragment()};
    private android.app.FragmentManager fm;
    private FragmentTransaction transaction;
    private Fragment defaultfragment ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initview();
        homebutton.setChecked(true);

        initListence();

        fm = getFragmentManager();
        transaction = fm.beginTransaction();
        for (int i = 0; i < fragments.length; i++) {

            transaction.add(R.id.frame,fragments[i],i+"");
            transaction.hide(fragments[i]);

        }
        transaction.commit();
        transaction.show(fragments[0]);
        defaultfragment = fragments[0];

    }

    private void initListence() {
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (null == fm  ){
                    fm = getFragmentManager();
                }
                FragmentTransaction ft = fm.beginTransaction();

                switch (checkedId){
                    case R.id.group_home:
                        ft.hide(defaultfragment);
                        ft.show(fragments[0]);
                        defaultfragment = fragments[0];
                        Log.e("tag", "onCheckedChanged: "+0 );
                        break;
                    case R.id.group_invent:
                        ft.hide(defaultfragment);
                        ft.show(fragments[1]);
                        defaultfragment = fragments[1];

//                        ft.replace(R.id.frame,new MeFragment());
                        Log.e("tag", "onCheckedChanged: "+1 );

                        break;
                    case R.id.group_find:
                        ft.hide(defaultfragment);
                        ft.show(fragments[2]);
                        defaultfragment = fragments[2];
                        Log.e("tag", "onCheckedChanged: "+2 );

                        break;
                    case R.id.group_me:
                        ft.hide(defaultfragment);
                        ft.show(fragments[3]);
                        defaultfragment = fragments[3];
                        Log.e("tag", "onCheckedChanged: "+3 );
                        break;



                }
                ft.commit();

            }
        });
    }

    private void initview() {
        radiogroup = (RadioGroup) findViewById(R.id.radio_group);
        homebutton = (RadioButton) findViewById(R.id.group_home);
        inventbutton = (RadioButton) findViewById(R.id.group_invent);
        findbutton = (RadioButton) findViewById(R.id.group_find);
        mebutton = (RadioButton) findViewById(R.id.group_me);
        framelay = (FrameLayout) findViewById(R.id.frame);

    }
}
