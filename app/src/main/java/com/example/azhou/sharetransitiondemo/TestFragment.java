package com.example.azhou.sharetransitiondemo;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.transition.Fade;
import android.transition.TransitionSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import junit.framework.Test;

/**
 * Created by Almin on 2015/12/24.
 */
public class TestFragment extends Fragment {


    public static TestFragment newInstance(){
        TestFragment testFragment = new TestFragment();
        Bundle bundle = new Bundle();
        testFragment.setArguments(bundle);
        return testFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment,container,false);
        final ImageView imageView  = (ImageView) view.findViewById(R.id.iv_2);
//        Bundle bundle = getArguments();
//        String actionTitle = "";
//        Bitmap imageBitmap = null;
//        String transText = "";
        String transitionName = "pic";

//        if (bundle != null) {
//            imageBitmap = bundle.getParcelable("IMAGE");
//        }

//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            imageView.setTransitionName(transitionName);
//        }

//        imageView.setImageResource(R.drawable.test);
//        imageView.setImageBitmap(imageBitmap);
        return view;
    }
}
