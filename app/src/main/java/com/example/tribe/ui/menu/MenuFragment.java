package com.example.tribe.ui.menu;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.example.tribe.R;
import com.example.tribe.databinding.FragmentMenuBinding;

public class MenuFragment extends Fragment {


   private Toolbar toolbar;
    private FragmentMenuBinding binding;
    CardView memories,community;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MenuViewModel menuViewModel =
                new ViewModelProvider(this).get(MenuViewModel.class);

        binding = FragmentMenuBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        memories=root.findViewById(R.id.memories);
        community=root.findViewById(R.id.community);
        community.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_navigation_menu_to_community);

            }
        });
        memories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_navigation_menu_to_memories2);
            }
        });

        toolbar = getActivity().findViewById(R.id.main_menu_toolbar);

        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
       /* setHasOptionsMenu(true);*/
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {

      /*  inflater.inflate(R.menu.profile_menu, menu);*/

        super.onCreateOptionsMenu(menu, inflater);
    }


}