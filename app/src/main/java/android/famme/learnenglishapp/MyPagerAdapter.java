package android.famme.learnenglishapp;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyPagerAdapter extends FragmentStateAdapter {

    private static final int NUM_PAGES = 3;

    public MyPagerAdapter(FragmentActivity fa) {
        super(fa);
    }

    @Override
    public Fragment createFragment(int pos) {
        switch (pos) {
            case 0: {
                return ProfileFragment.newInstance("fragment 1");
            }
            case 1: {

                return ProgressFragment.newInstance("fragment 2");
            }
            case 2: {
                return ThemesFragment.newInstance("fragment 3");
            }
            default:
                return ProgressFragment.newInstance("fragment 1, Default");
        }
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }
}