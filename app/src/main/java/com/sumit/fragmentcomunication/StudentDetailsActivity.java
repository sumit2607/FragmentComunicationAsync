package com.sumit.fragmentcomunication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class StudentDetailsActivity extends AppCompatActivity implements ComunicationListner {
   public FragmentManager fragmentManager ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        launchStudentPersonalFragment();
    }

    private void launchStudentPersonalFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        StudentPersonalDetailsFragment fragment = new StudentPersonalDetailsFragment();
        fragmentTransaction.add(R.id.container,  fragment, "StudentPersonalDetailsFragment").commit();
    }

    @Override
    public void launchPerformanceFragment(Bundle bundle) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        StudentPerformanceDetailsFragment personalDetailsFragment = new StudentPerformanceDetailsFragment();
        personalDetailsFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.container,  personalDetailsFragment, "StudentPersonalDetailsFragment").addToBackStack("").commit();

    }


}