package com.example.cv_builder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    EditText sumTxt;
    Button editButton;
    Button saveButton;
    ImageView backBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summary_activity);


        init();

        Intent i = getIntent();

        String summary = i.getStringExtra("SUMMARY");

        if(summary != null)
            sumTxt.setText(summary);


        backBtn.setOnClickListener(v -> {
            finish();
        });

        editButton.setOnClickListener(v->{
            sumTxt.setEnabled(true);
            saveButton.setEnabled(true);
        });

        saveButton.setOnClickListener(v -> {

            String mySum = sumTxt.getText().toString().strip();

            Intent intent = new Intent(SummaryActivity.this, MainActivity.class);

            if(!mySum.isEmpty())
                intent.putExtra("SUMMARY",mySum);

            setResult(RESULT_OK,intent);
            finish();
        });
    }

    void init()
    {
        sumTxt = findViewById(R.id.etSummary);
        backBtn = findViewById(R.id.backBtn3);
        saveButton = findViewById(R.id.btnSave2);
        editButton = findViewById(R.id.btnEdit2);
    }
}
