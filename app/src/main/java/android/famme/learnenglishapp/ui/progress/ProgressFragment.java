package android.famme.learnenglishapp.ui.progress;

import android.famme.learnenglishapp.App;
import android.famme.learnenglishapp.data.storage.themes.IThemes;
import android.famme.learnenglishapp.databinding.FragmentProgressBinding;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import javax.inject.Inject;

public class ProgressFragment extends Fragment implements ProgressAdapter.ItemClickListener {

    FragmentProgressBinding binding;

    ProgressAdapter adapter;

    @Inject
    IThemes themes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentProgressBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        App.instance.appComponent.inject(this);

        ArrayList<String> list = themes.getThemes();

        // data to populate the RecyclerView with
        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("Horse");
        animalNames.add("Cow");
        animalNames.add("Camel");
        animalNames.add("Sheep");
        animalNames.add("Goat");

        // set up the RecyclerView
        RecyclerView recyclerView = binding.rvThemes;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ProgressAdapter(getContext(), animalNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

    }

//    private String addToList(ArrayList<String> list) {
//
//        for (int i = 0; i < list.size(); i++) {
//
//
//
//        }
//
//    }


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
}