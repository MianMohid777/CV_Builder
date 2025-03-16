package com.example.cv_builder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RefActivity extends AppCompatActivity {

    EditText companyTxt,refTxt,posTxt,contactTxt;

    Button editButton;
    Button saveButton;
    ImageView backBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ref_activity);
        init();

        Intent i = getIntent();

        ArrayList<String> refs = i.getStringArrayListExtra("REFS_LIST");

        if (refs != null && refs.size() == 4)
        {
            refTxt.setText(refs.get(0));
            posTxt.setText(refs.get(1));
            companyTxt.setText(refs.get(2));
            contactTxt.setText(refs.get(3));
        }


        backBtn.setOnClickListener(v -> {
            finish();
        });

        editButton.setOnClickListener(v -> {
            companyTxt.setEnabled(true);
            posTxt.setEnabled(true);
            contactTxt.setEnabled(true);
            refTxt.setEnabled(true);
            saveButton.setEnabled(true);
        });

        saveButton.setOnClickListener(v -> {

            String myCo = companyTxt.getText().toString().strip();
            String myPos = posTxt.getText().toString().strip();
            String myName = refTxt.getText().toString().strip();
            String myContact = contactTxt.getText().toString().strip();

            Intent intent = new Intent(RefActivity.this, MainActivity.class);

            ArrayList<String> myRef = new ArrayList<>();

            if(!myCo.isEmpty() && !myPos.isEmpty() && !myName.isEmpty() && !myContact.isEmpty())
            {
                myRef.add(myName);
                myRef.add(myPos);
                myRef.add(myCo);
                myRef.add(myContact);

            }

            intent.putStringArrayListExtra("REFS_LIST", myRef);

            setResult(RESULT_OK, intent);
            finish();
        });
    }

    void init()
    {
        companyTxt = findViewById(R.id.etRefCompany);
        posTxt = findViewById(R.id.etRefPosition);
        refTxt = findViewById(R.id.etRefName);
        contactTxt = findViewById(R.id.etRefContact);

        backBtn = findViewById(R.id.backBtnRef);
        saveButton = findViewById(R.id.btnSaveRef);
        editButton = findViewById(R.id.btnEditRef);
    }
}
