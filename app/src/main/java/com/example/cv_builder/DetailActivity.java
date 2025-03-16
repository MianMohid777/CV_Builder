package com.example.cv_builder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    EditText nameTxt,emailTxt,phoneTxt;
    Button editButton;
    Button saveButton;
    ImageView backBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detail_activity);

        init();

        Intent i = getIntent();

        String name = i.getStringExtra("NAME");
        String email = i.getStringExtra("EMAIL");
        String phone = i.getStringExtra("PHONE");


        if(name != null)
            nameTxt.setText(name);
        if(email!= null)
            emailTxt.setText(email);
        if(phone != null)
            phoneTxt.setText(phone);


        backBtn.setOnClickListener(v -> {
            finish();
        });

        editButton.setOnClickListener(v->{
            nameTxt.setEnabled(true);
            emailTxt.setEnabled(true);
            phoneTxt.setEnabled(true);

            saveButton.setEnabled(true);
        });

        saveButton.setOnClickListener(v -> {

          String myName = nameTxt.getText().toString().strip();

          String myEmail = emailTxt.getText().toString().strip();

          String myPhone = phoneTxt.getText().toString().strip();

          Intent intent = new Intent(DetailActivity.this, MainActivity.class);

            if(!myName.isEmpty())
                intent.putExtra("NAME",myName);

            if(myEmail.contains("@"))
                intent.putExtra("EMAIL",myEmail);

            if(myPhone.length() == 12)
                intent.putExtra("PHONE",myPhone);

            setResult(RESULT_OK,intent);
            finish();
        });
    }


    void init()
    {
        nameTxt = findViewById(R.id.etName);
        emailTxt = findViewById(R.id.etEmail);
        phoneTxt = findViewById(R.id.etPhone);

        backBtn = findViewById(R.id.backBtn2);
        saveButton = findViewById(R.id.btnSave);
        editButton = findViewById(R.id.btnEdit);

    }
}
