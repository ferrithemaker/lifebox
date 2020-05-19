package com.app.lifeboxinformation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MainScreenFragment myMainScreen = new MainScreenFragment(); // fragments creation
    SpeciesFragment mySpeciesScreen = new SpeciesFragment();
    GeneralInfoFragment myGeneralInfoScreen = new GeneralInfoFragment();
    ManaFragment myManaScreen = new ManaFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentManager myFragmentManager = getSupportFragmentManager();
        FragmentTransaction myFragmentTransaction = myFragmentManager.beginTransaction();
        myFragmentTransaction.add(R.id.placeholder,myMainScreen);
        myFragmentTransaction.commit();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Lifebox controller website", Snackbar.LENGTH_LONG)
                        .setAction("VISIT", new View.OnClickListener() {
                            @Override
                                public void onClick(View view) {
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://lifebox.ferranfabregas.me"));
                                startActivity(browserIntent);
                                }
                            }).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        FragmentManager myFragmentManager = getSupportFragmentManager();
        FragmentTransaction myFragmentTransaction = myFragmentManager.beginTransaction();

        switch (item.getItemId()) {
            case R.id.species_info:
                myFragmentTransaction.replace(R.id.placeholder, mySpeciesScreen);
                myFragmentTransaction.commit();
                break;
            case R.id.mana_info:
                myFragmentTransaction.replace(R.id.placeholder, myManaScreen);
                myFragmentTransaction.commit();
                break;
            case R.id.general_info:
                myFragmentTransaction.replace(R.id.placeholder, myGeneralInfoScreen);
                myFragmentTransaction.commit();
                break;
        }

        return super.onOptionsItemSelected(item);
    }


}
