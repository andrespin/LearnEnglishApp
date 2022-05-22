package android.famme.learnenglishapp.ui.progress;

import android.famme.learnenglishapp.App;
import android.famme.learnenglishapp.data.storage.room.ResultEntity;
import android.famme.learnenglishapp.data.storage.themes.IThemes;
import android.famme.learnenglishapp.databinding.FragmentProgressBinding;
import android.famme.learnenglishapp.ui.themes.ThemesAdapter;
import android.famme.learnenglishapp.ui.themes.exercises.ExercisesViewModel;
import android.famme.learnenglishapp.utils.navigator.INavigator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ProgressFragment extends Fragment implements ProgressAdapter.ItemClickListener {

    FragmentProgressBinding binding;

    ThemesAdapter adapter;

    ProgressViewModel model;

    @Inject
    IThemes themes;

    @Inject
    INavigator navigator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentProgressBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViewModel();
        inject();
        initAdapter();
        observeViewModel();
        model.getAllResults();
        initListeners();
    }

    private void initListeners() {
        binding.btnOpenGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigator.navigateViewPagerToGraph(view);
            }
        });
    }

    public static ProgressFragment newInstance(String text) {
        ProgressFragment f = new ProgressFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onItemClick(View view, int position) {
        System.out.println("Click");
    }

    private void initViewModel() {
        model = new ViewModelProvider(this).get(ProgressViewModel.class);
    }

    private void inject() {
        App.instance.appComponent.inject(this);
        App.instance.appComponent.inject(model);
    }

    private void initAdapter() {
        RecyclerView recyclerView = binding.rvThemes;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ThemesAdapter(getContext());
        recyclerView.setAdapter(adapter);
    }

    private void setDataToAdapter(List<String> list) {
        adapter.setData(list);
    }

    private void observeViewModel() {
        model.eventGetResults.observe(getViewLifecycleOwner(), new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                setDataToAdapter(strings);
            }
        });
    }
}