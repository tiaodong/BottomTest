package com.ren.jiemei.bottomtest.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ren.jiemei.bottomtest.R;

/**
 * Created by Administrator on 2016/12/30 0030.
 */

public class InventFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_invent, null, false);
        return view;
    }
}
