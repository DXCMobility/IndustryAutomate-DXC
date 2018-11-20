package fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import adapters.MyPageAdapter;
import example.com.industrialautomation.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Intellisense extends Fragment {

    View view ;
    ViewPager viewPager;
    private MyPageAdapter mPagerAdapter;

    public Intellisense() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_intellisense, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mPagerAdapter = new MyPageAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(mPagerAdapter);
        return view;
    }

}
