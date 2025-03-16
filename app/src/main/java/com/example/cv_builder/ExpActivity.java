package com.example.cv_builder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ExpActivity extends AppCompatActivity {

    EditText companyTxt,posTxt,dateTxt,descTxt;

    Button editButton;
    Button saveButton;
    ImageView backBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exp_activity);
        init();

        Intent i = getIntent();

        ArrayList<String> exp = i.getStringArrayListExtra("EXP_LIST");

        if (exp != null && exp.size() == 4)
        {
            companyTxt.setText(exp.get(0));
            posTxt.setText(exp.get(1));
            dateTxt.setText(exp.get(2));
            descTxt.setText(exp.get(3));
        }


        backBtn.setOnClickListener(v -> {
            finish();
        });

        editButton.setOnClickListener(v -> {
            companyTxt.setEnabled(true);
            posTxt.setEnabled(true);
            dateTxt.setEnabled(true);
            descTxt.setEnabled(true);
            saveButton.setEnabled(true);
        });

        saveButton.setOnClickListener(v -> {

            String myCo = companyTxt.getText().toString().strip();
            String myPos = posTxt.getText().toString().strip();
            String myDate = dateTxt.getText().toString().strip();
            String myDesc = descTxt.getText().toString().strip();

            Intent intent = new Intent(ExpActivity.this, MainActivity.class);

            ArrayList<String> myExp = new ArrayList<>();

            if(!myCo.isEmpty() && !myPos.isEmpty() && !myDate.isEmpty() && !myDesc.isEmpty())
            {
                myExp.add(myCo);
                myExp.add(myPos);
                myExp.add(myDate);
                myExp.add(myDesc);

            }

            intent.putStringArrayListExtra("EXP_LIST",myExp);

            setResult(RESULT_OK, intent);
            finish();
        });
    }

    void init()
    {
        companyTxt = findViewById(R.id.etCompany);
        posTxt = findViewById(R.id.etPosition);
        dateTxt = findViewById(R.id.etDuration);
        descTxt = findViewById(R.id.etDescription);

        backBtn = findViewById(R.id.backBtnExp);
        saveButton = findViewById(R.id.btnSaveExp);
        editButton = findViewById(R.id.btnEditExp);
    }
}

