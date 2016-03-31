package com.mli.album;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mli.Common;

/**
 * Created by limian on 2016/3/31.
 */
public abstract class LazyFragment extends Fragment {


    private String tag = "";
    public LazyFragment(String tag) {
        this.tag = tag;
    }
    public abstract void startLoad();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Common.logI(tag  + "onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Common.logI(tag + "onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        startLoad();
        Common.logI( tag + getUserVisibleHint());
    }


}
