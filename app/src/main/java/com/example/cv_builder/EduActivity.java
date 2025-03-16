package com.example.cv_builder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class EduActivity extends AppCompatActivity {

    EditText institutionTxt,degTxt,dateTxt;

    Button editButton;
    Button saveButton;
    ImageView backBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.edu_activity);

        init();

        Intent i = getIntent();

        ArrayList<String> education = i.getStringArrayListExtra("EDUCATION_LIST");

        if (education != null && education.size() == 3)
        {
            institutionTxt.setText(education.get(0));
            degTxt.setText(education.get(1));
            dateTxt.setText(education.get(2));
        }


        backBtn.setOnClickListener(v -> {
            finish();
        });

        editButton.setOnClickListener(v -> {
            institutionTxt.setEnabled(true);
            degTxt.setEnabled(true);
            dateTxt.setEnabled(true);
            saveButton.setEnabled(true);
        });

        saveButton.setOnClickListener(v -> {

            String myIn = institutionTxt.getText().toString().strip();
            String myDeg = degTxt.getText().toString().strip();
            String myDate = dateTxt.getText().toString().strip();

            Intent intent = new Intent(EduActivity.this, MainActivity.class);

            ArrayList<String> myEdu = new ArrayList<>();

            if(!myIn.isEmpty() && !myDeg.isEmpty() && !myDate.isEmpty())
            {
                myEdu.add(myIn);
                myEdu.add(myDeg);
                myEdu.add(myDate);
            }

            intent.putStringArrayListExtra("EDUCATION_LIST",myEdu);

            setResult(RESULT_OK, intent);
            finish();
        });
    }

        void init()
        {
            institutionTxt = findViewById(R.id.etInstitution);
            degTxt = findViewById(R.id.etDegree);
            dateTxt = findViewById(R.id.etEduDates);
            backBtn = findViewById(R.id.backBtnEdu);
            saveButton = findViewById(R.id.btnSaveEdu);
            editButton = findViewById(R.id.btnEditEdu);
        }
}
