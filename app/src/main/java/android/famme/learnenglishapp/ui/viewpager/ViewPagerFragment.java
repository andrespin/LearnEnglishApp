package android.famme.learnenglishapp.ui.viewpager;

import android.famme.learnenglishapp.R;
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

public class ViewPagerFragment extends Fragment {

    public static ViewPager2 viewPager;
    private FragmentStateAdapter pagerAdapter;
    private String[] titles = new String[]{"Профиль", "Темы", "Прогресс"};

    private Integer[] icons = new Integer[]{
            R.drawable.ic_client_profile,
            R.drawable.ic_client_themes,
            R.drawable.ic_client_progress};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_pager, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {

        viewPager = getActivity().findViewById(R.id.mypager);

        pagerAdapter = new ViewPagerAdapter(getActivity());

        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = (TabLayout) getActivity().findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setIcon(icons[position])).attach();

    }

}