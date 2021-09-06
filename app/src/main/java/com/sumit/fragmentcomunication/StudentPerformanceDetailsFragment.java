package com.sumit.fragmentcomunication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class StudentPerformanceDetailsFragment extends Fragment {

private EditText metGrade;
private  EditText metPer;
private Button mBtnPreview;
private  String name;
private  int age;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_performance_details_activity, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
           name = getArguments().getString("name");
           age = getArguments().getInt("age");
        }

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initview(view);
    }

    private void initview(View view) {

        metGrade = view.findViewById(R.id.etStudentGrade);
        metPer = view.findViewById(R.id.etStudentPercentage);
        mBtnPreview = view.findViewById(R.id.btnPreview);
        mBtnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String  grade  =metGrade.getText().toString();
               String  percentage  =metPer.getText().toString();
               ModelClass modelClass = new ModelClass(name , grade, age, percentage);
                Intent intent = new Intent(getActivity(), PreviewActivity.class);
                intent.putExtra("modelClass", modelClass);
                 startActivity(intent);
            }
        });
    }
}