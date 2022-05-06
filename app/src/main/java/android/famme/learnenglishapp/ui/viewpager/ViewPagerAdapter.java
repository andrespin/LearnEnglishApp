package android.famme.learnenglishapp.ui.viewpager;

import android.famme.learnenglishapp.ui.profile.ProfileFragment;
import android.famme.learnenglishapp.ui.progress.ProgressFragment;
import android.famme.learnenglishapp.ui.themes.ThemesFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    private static final int NUM_PAGES = 3;

    public ViewPagerAdapter(FragmentActivity fa) {
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