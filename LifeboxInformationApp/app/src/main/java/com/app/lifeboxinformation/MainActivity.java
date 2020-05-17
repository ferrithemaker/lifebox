package com.app.lifeboxinformation;

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

public class MainActivity extends AppCompatActivity {

    MainScreenFragment myMainScreen = new MainScreenFragment(); // fragments creation
    YellowFragment myYellowScreen = new YellowFragment();
    BlueFragment myBlueScreen = new BlueFragment();
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
                Snackbar.make(view, "Go to Lifebox website", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
            case R.id.yellow_species_info:

                myFragmentTransaction.replace(R.id.placeholder, myYellowScreen);
                myFragmentTransaction.commit();
                break;

            case R.id.blue_species_info:
                myFragmentTransaction.replace(R.id.placeholder, myBlueScreen);
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
