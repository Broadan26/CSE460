package com.unit5.unit5project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class MenuFragment extends Fragment
{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.menu_fragment, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.bmi_calc_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                NavHostFragment.findNavController(MenuFragment.this).navigate(R.id.bmi_calc_fragment);
            }
        });

        view.findViewById(R.id.bmi_api_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                NavHostFragment.findNavController(MenuFragment.this).navigate(R.id.bmi_api_fragment);
            }
        });
    }
}