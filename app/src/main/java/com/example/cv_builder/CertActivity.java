package com.example.cv_builder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CertActivity extends AppCompatActivity {

    EditText certTxt,orgTxt,dateTxt;

    Button editButton;
    Button saveButton;
    ImageView backBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cert_activity);
        init();

        Intent i = getIntent();

        ArrayList<String> exp = i.getStringArrayListExtra("CERTS_LIST");

        if (exp != null && exp.size() == 3)
        {
            certTxt.setText(exp.get(0));
            orgTxt.setText(exp.get(1));
            dateTxt.setText(exp.get(2));

        }


        backBtn.setOnClickListener(v -> {
            finish();
        });

        editButton.setOnClickListener(v -> {
            certTxt.setEnabled(true);
            orgTxt.setEnabled(true);
            dateTxt.setEnabled(true);
            saveButton.setEnabled(true);
        });

        saveButton.setOnClickListener(v -> {

            String myCertName = certTxt.getText().toString().strip();
            String myOrg = orgTxt.getText().toString().strip();
            String myDate = dateTxt.getText().toString().strip();


            Intent intent = new Intent(CertActivity.this, MainActivity.class);

            ArrayList<String> myCert = new ArrayList<>();

            if(!myCertName.isEmpty() && !myOrg.isEmpty() && !myDate.isEmpty())
            {
                myCert.add(myCertName);
                myCert.add(myOrg);
                myCert.add(myDate);

            }

            intent.putStringArrayListExtra("CERTS_LIST",myCert);

            setResult(RESULT_OK, intent);
            finish();
        });
    }

    void init()
    {
        certTxt = findViewById(R.id.etCertName);
        orgTxt = findViewById(R.id.etCertOrg);
        dateTxt = findViewById(R.id.etDateEarned);

        backBtn = findViewById(R.id.backBtnCert);
        saveButton = findViewById(R.id.btnSaveCert);
        editButton = findViewById(R.id.btnEditCert);
    }
}

