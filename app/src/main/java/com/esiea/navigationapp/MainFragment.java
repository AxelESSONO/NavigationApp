package com.esiea.navigationapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.esiea.navigationapp.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {
    private NavController navController;
    private int count = 0;
    private String message = "";

    private FragmentMainBinding binding;

    public MainFragment() {
        // Required empty public constructor
    }


    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(
                        inflater,
                        R.layout.fragment_main,
                        container,
                        false);

        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        binding.navigationMainButton.setOnClickListener(view1 -> {
            /*navController
                    .navigate(R.id.action_mainFragment_to_secondFragment);*/

            message = binding.messageEditText.getText().toString();

            MainFragmentDirections.ActionMainFragmentToSecondFragment action
                    = MainFragmentDirections.actionMainFragmentToSecondFragment();
            action.setMessage(message);

            navController.navigate(action);

        });

        binding.addButton.setOnClickListener(view1 ->{
            count++;
            binding.setMyCount(String.valueOf(count));
            Log.d("COUNT", String.valueOf(count));
        });
    }
}