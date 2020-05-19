package com.app.lifeboxinformation;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.Fragment;


public class SpeciesFragment extends Fragment {

    String htmlText = "<p>Inside the LifeBox you can find two species, the blue and the yellow one, and both species have a set of parameters that defines how they can evolve inside the virtual ecosystem. " +
            "You can change each parameter of each species individually.</p>" +
            "<p><b>The species parameters</b></p> " +
            "<p><b>LIFE:</b> Life expectancy of species individuals. <i>High values are better.</i></p> " +
            "<p><b>REPRODUCTION:</b> Reproduction capability of species individuals. <i>High values are better.</i></p> " +
            "<p><b>EFFICIENCY:</b> Energy consumption of species individuals. <i>Low values are better.</i></p> " +
            "<p><b>GATHERING:</b> Energy gathering of species individuals from green species individuals. <i>High values are better.</i></p>";

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View fragmentview =  inflater.inflate(R.layout.fragment_species, container, false);
        TextView mainScreenFragmentText = fragmentview.findViewById(R.id.species_text_view);
        mainScreenFragmentText.setText(HtmlCompat.fromHtml(htmlText,0));
        return fragmentview;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
