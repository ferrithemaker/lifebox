package com.app.lifeboxinformation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.Fragment;

public class ManaFragment extends Fragment {

    String htmlText = "<p>Every species need to gather energy from the green mana to grow, reproduce and survive. This mana also has a set of parameters that defines its behavior inside the LifeBox ecosystem.</p>" +
            "<p><b>The green ‘mana’ parameters</b></p> " +
            "<p><b>LIFE:</b> Life expectancy of species individuals.<i>High values are better.</i></p> " +
            "<p><b>REPRODUCTION:</b> Reproduction capability of species individuals. <i>High values are better.</i></p> " +
            "<p><b>GENERATION:</b> Energy generation of green species individuals.<i> High values are better.</i></p>";

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View fragmentview =  inflater.inflate(R.layout.fragment_mana, container, false);
        TextView mainScreenFragmentText = fragmentview.findViewById(R.id.mana_text_view);
        mainScreenFragmentText.setText(HtmlCompat.fromHtml(htmlText,0));
        return fragmentview;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
