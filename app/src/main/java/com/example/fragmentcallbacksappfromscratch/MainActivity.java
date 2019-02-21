package com.example.fragmentcallbacksappfromscratch;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fragmentcallbacksappfromscratch.fragments.DisplayFragment;
import com.example.fragmentcallbacksappfromscratch.fragments.InputFragment;

public class MainActivity extends AppCompatActivity implements InputFragment.OnInputFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputFragment inputFragment = InputFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_container, inputFragment).commit();
    }

    @Override
    public void onInputFragmentInteraction(String input, String input2, String input3) {
        DisplayFragment displayFragment = DisplayFragment.newInstance(input, input2, input3);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_container, displayFragment)
                .addToBackStack(DisplayFragment.KEY).commit();
    }
}
