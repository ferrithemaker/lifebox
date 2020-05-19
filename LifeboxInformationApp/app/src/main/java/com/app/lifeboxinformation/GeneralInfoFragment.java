package com.app.lifeboxinformation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.Fragment;

public class GeneralInfoFragment extends Fragment {

    String htmlText = "<p>LifeBox is project about a virtual ecosystem. The project started in 2015 and is still in constant evolution.</p> " +
            "<p>Inside the LifeBox you can find two different kind of species, the ‘species’ and the ‘mana’. Each of the ‘species’ have a set of parameters that defines how they evolve inside the virtual ecosystem, and you can change all the parameter of species in real-time.</p> " +
            "<p>The ‘species’ need to gather energy from the ‘mana’ to grow, replicate itself and survive. The ‘mana’ has also a set of parameters that defines its behavior inside the LifeBox ecosystem.</p> " +
            "<p>The goal of the project is to offer the possibility to learn the basic concepts of biology through the experimentation, viewing the consequences of your actions and trying to find the way to balance the ecosystem through changing the LifeBox ‘species’ and ‘mana’ parameters.</p>";


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View fragmentview =  inflater.inflate(R.layout.fragment_general, container, false);
        TextView mainScreenFragmentText = fragmentview.findViewById(R.id.general_text_view);
        mainScreenFragmentText.setText(HtmlCompat.fromHtml(htmlText,0));
        return fragmentview;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
