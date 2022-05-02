package android.famme.learnenglishapp.auth;

import android.famme.learnenglishapp.R;
import android.famme.learnenglishapp.databinding.FragmentAuthBinding;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;


public class AuthFragment extends Fragment {

    private FragmentAuthBinding binding;

    private AuthViewModel model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAuthBinding.inflate(inflater, container, false);
        return binding.getRoot();
        //  return inflater.inflate(R.layout.fragment_auth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViewModel();
        initListeners();
        initViewModelListeners();
    }

    private void initViewModel() {
        model = new ViewModelProvider(this).get(AuthViewModel.class);
    }

    private void initListeners() {

        binding.authLayout.imgBtnRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                binding.authLayout.getRoot().setVisibility(View.GONE) ;
                binding.regLayout.getRoot().setVisibility(View.VISIBLE) ;
            }
        });


        binding.regLayout.imgBtnRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                binding.authLayout.getRoot().setVisibility(View.VISIBLE) ;
                binding.regLayout.getRoot().setVisibility(View.GONE) ;
            }
        });





        binding.authLayout.imgBtnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String login = binding.authLayout.txtEnterLogin.toString();

                String pass = binding.authLayout.txtEnterPass.toString();

                try {
                    model.checkLoginAndPass(login, pass, v);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initViewModelListeners() {
        model.eventRightRegData.observe(getViewLifecycleOwner(), new Observer<View>() {
            @Override
            public void onChanged(View view) {
                Navigation.findNavController(view).popBackStack(R.id.auth, true);
                Navigation.findNavController(view).navigate(R.id.view_pager);
            }
        });
    }

}