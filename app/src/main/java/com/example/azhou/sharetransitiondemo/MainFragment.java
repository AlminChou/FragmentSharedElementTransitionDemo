package com.example.azhou.sharetransitiondemo;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Almin on 2015/12/24.
 */
public class MainFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,container,false);
        final ImageView imageView  = (ImageView) view.findViewById(R.id.iv_1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestFragment testFragment = new TestFragment();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    testFragment.setSharedElementEnterTransition(new DetailTransition());
                    setExitTransition(new Fade());
                    testFragment.setEnterTransition(new Fade());
                    testFragment.setSharedElementReturnTransition(new DetailTransition());
                }

//                Bundle bundle = new Bundle();
//                bundle.putParcelable("IMAGE", ((BitmapDrawable) imageView.getDrawable()).getBitmap());
//                testFragment.setArguments(bundle);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fl_container, testFragment)
                        .addToBackStack(null)
                        .addSharedElement(imageView, "pic")
                        .commit();
            }

        });


        final FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fb);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new DialogFragment();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    dialogFragment.setSharedElementEnterTransition(new DetailTransition());
                    setExitTransition(new Fade());
                    dialogFragment.setEnterTransition(new Fade());
                    dialogFragment.setSharedElementReturnTransition(new DetailTransition());
                }
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fl_container, dialogFragment)
                        .addToBackStack(null)
                        .addSharedElement(floatingActionButton, "fab")
                        .commit();
            }
        });
        return view;

    }
}
