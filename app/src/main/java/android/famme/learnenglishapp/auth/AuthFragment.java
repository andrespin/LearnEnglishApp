package android.famme.learnenglishapp.auth;

import android.famme.learnenglishapp.R;
import android.famme.learnenglishapp.databinding.FragmentAuthBinding;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class AuthFragment extends Fragment {

    private FragmentAuthBinding binding;

    private AuthViewModel model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        binding = FragmentAuthBinding.inflate(inflater, container, false);
//        return binding.getRoot();
        return inflater.inflate(R.layout.fragment_auth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        initViewModel();
//        initListeners();
    }

//    private void initViewModel() {
//        model = new ViewModelProvider(this).get(AuthViewModel.class);
//    }
//
//    private void initListeners() {
//        binding.authLayout.imgBtnLogIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            //    Navigation.findNavController(v).navigate(R.id.action_auth_to_view_pager);
//            }
//        });
//
//    }

}