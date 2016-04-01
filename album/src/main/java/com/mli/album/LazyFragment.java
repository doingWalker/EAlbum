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
    private boolean isVisible;
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
        View view = super.onCreateView(inflater, container, savedInstanceState);

        startLoad();
        Common.logI(tag + "onCreateView");
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(getUserVisibleHint()) {
            isVisible = true;
        }else {
            isVisible = false;
        }
    }


}
