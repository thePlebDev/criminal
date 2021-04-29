package com.example.criminalintent;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

public abstract class SingleFragmentActivity extends FragmentActivity {

    protected abstract Fragment createFragment();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // this gets run before the onCreateView
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment); //set the view to activity_fragment.xml

        // FRAGMENT TIME
        FragmentManager fm = getSupportFragmentManager(); //get the fragment container
        Fragment fragment = fm.findFragmentById(R.id.fragment_container); // get the empty fragment
        if (fragment == null) {
            fragment = createFragment(); // this will eventually be what inflates the view
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}



