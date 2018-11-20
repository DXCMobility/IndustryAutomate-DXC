package adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import Presenter.IClearedDB;
import fragments.ScreenSlidePageFragment;

/**
 * Created by ashukuma on 2/7/2017.
 */

public class MyPageAdapter extends FragmentStatePagerAdapter {

    final int MAX_FACTORY = 2;

    public MyPageAdapter(FragmentManager fm) {
        super(fm);


    }

    @Override
    public Fragment getItem(int position) {

            return ScreenSlidePageFragment.init(position);


    }

    @Override
    public int getCount() {

        return MAX_FACTORY;
    }

}