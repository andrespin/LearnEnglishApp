package android.famme.learnenglishapp.ui.viewpager;

import android.famme.learnenglishapp.R;
import android.famme.learnenglishapp.utils.navigator.INavigator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import javax.inject.Inject;


/**
 * Класс ViewPagerFragment отображает в TabLayout
 * икноки: фрагмента профиля, фрагмента со списком тем и фрагмента со
 * списком тем с прогрессом. Во ViewPager отображаются фрагменты,
 * навигация между которыми обеспечивается с помощью свайпа влево-вправо.
 */

public class ViewPagerFragment extends Fragment {

    public static ViewPager2 viewPager;
    private FragmentStateAdapter pagerAdapter;

    private Integer[] icons = new Integer[]{
            R.drawable.ic_client_profile,
            R.drawable.ic_client_themes,
            R.drawable.ic_client_progress};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_view_pager, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        viewPager.setCurrentItem(1, false);
    }

    private void init() {
        viewPager = getActivity().findViewById(R.id.mypager);
        pagerAdapter = new ViewPagerAdapter(getActivity());
        viewPager.setAdapter(pagerAdapter);
        TabLayout tabLayout = (TabLayout) getActivity().findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setIcon(icons[position])).attach();
    }

}