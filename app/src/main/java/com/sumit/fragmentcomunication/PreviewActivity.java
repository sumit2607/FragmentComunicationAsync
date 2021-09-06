package com.sumit.fragmentcomunication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PreviewActivity extends AppCompatActivity {
private TextView mTvname, mtvage, mtvgrade, mtvper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        initview();
        getDataModel();
    }

    private void getDataModel() {
        ModelClass modelClass  =  (ModelClass) getIntent().getSerializableExtra("modelClass");
        mTvname.setText(modelClass.getName());
        mtvage.setText(modelClass.getAge()+ "");
        mtvgrade.setText(modelClass.getGrade());
        mtvper.setText(modelClass.getPercentage());
    }

    private void initview() {
        mTvname = findViewById(R.id.tvStudentName);
        mtvage = findViewById(R.id.etStudentPercentage);
        mtvgrade = findViewById(R.id.btnPreview);
        mtvper =findViewById(R.id.btnPreview);
    }
}