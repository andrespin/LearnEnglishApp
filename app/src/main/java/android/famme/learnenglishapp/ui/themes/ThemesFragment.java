package android.famme.learnenglishapp.ui.themes;

import android.famme.learnenglishapp.App;
import android.famme.learnenglishapp.databinding.FragmentThemesBinding;
import android.famme.learnenglishapp.ui.auth.AuthViewModel;
import android.famme.learnenglishapp.ui.progress.ProgressAdapter;
import android.famme.learnenglishapp.utils.navigator.INavigator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import javax.inject.Inject;


public class ThemesFragment extends Fragment
        implements ThemesAdapter.ItemClickListener {

    FragmentThemesBinding binding;

    ThemesViewModel model;

    ThemesAdapter adapter;

    ArrayList<String> themes;

    View view;

    @Inject
    INavigator navigator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentThemesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        App.instance.appComponent.inject(this);
        initAdapter();
        initViewModel();
        setDataToAdapter();
        initData();
    }

    public static ThemesFragment newInstance(String text) {
        ThemesFragment f = new ThemesFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);
        f.setArguments(b);
        return f;
    }

    private void initData() {
        themes = model.getThemes();
    }

    private void setDataToAdapter() {
        adapter.setData(model.getThemes());
    }

    private void initViewModel() {
        model = new ViewModelProvider(this).get(ThemesViewModel.class);
        App.instance.appComponent.inject(model);
    }

    private void initAdapter() {
        RecyclerView recyclerView = binding.rvThemes;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ThemesAdapter(getContext());
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    protected void initView(View view) {
        this.view = view;
    }

    @Override
    public void onItemClick(View view, int position) {
        navigator.navigateViewPagerToTheme(view, themes.get(position));
    }
}