package com.app.lifeboxinformation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


public class SpeciesFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View fragmentview =  inflater.inflate(R.layout.fragment_species, container, false);
        TextView mainScreenFragmentText = fragmentview.findViewById(R.id.species_text_view);
        mainScreenFragmentText.setText(R.string.species_info);
        return fragmentview;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}