package com.sumit.fragmentcomunication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class StudentPersonalDetailsFragment extends Fragment {

    private EditText mEtName;
private EditText mEtAge;
private  ComunicationListner listner;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_personal_details, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listner = (ComunicationListner) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        intitView(view);
    }

    private void intitView(View view) {
        Button mbtnNext = view.findViewById(R.id.btnNext);
        mEtName = view.findViewById(R.id.etStudentName);
        mEtAge = view.findViewById(R.id.etStudentAge);
        mbtnNext.setOnClickListener(view1 -> {
           String name = mEtName.getText().toString();
           int age = Integer.parseInt(mEtAge.getText().toString());
           Bundle bundle = new Bundle();
           bundle.putString("name" , name);
           bundle.putInt("age", age);
           if(listner!=null){
               listner.launchPerformanceFragment(bundle);
           }
        });
    }
}