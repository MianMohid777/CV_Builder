package com.example.cv_builder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PreviewActivity extends AppCompatActivity {

    Button shareBtn;

    ImageView img;

    ImageView backBtn;

    TextView tvName;


    TextView tvEmail;


    TextView tvPhone;


    TextView tvSummary;


    TextView tvEducation;


    TextView tvExperience;

    TextView tvCertificates;
    TextView tvReferences;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.preview_activity);

        init();

        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
        String email = intent.getStringExtra("EMAIL");
        String phone = intent.getStringExtra("PHONE");
        String summary = intent.getStringExtra("SUMMARY");
        ArrayList<String> education = intent.getStringArrayListExtra("EDUCATION");
        ArrayList<String> experience = intent.getStringArrayListExtra("EXPERIENCE");
        ArrayList<String> certificates = intent.getStringArrayListExtra("CERTIFICATES");
        ArrayList<String> references = intent.getStringArrayListExtra("REFERENCES");
        Uri imageUri = intent.getParcelableExtra("URI");


        if (imageUri != null) {
            img.setImageURI(imageUri);
        }

        if (name != null)
            tvName.setText(name);
        if (email != null)
            tvEmail.setText(email);
        if (phone != null)
            tvPhone.setText(phone);
        if (summary != null)
            tvSummary.setText(summary);

        StringBuilder edu = new StringBuilder();
        StringBuilder exp = new StringBuilder();
        StringBuilder cert = new StringBuilder();
        StringBuilder ref = new StringBuilder();


        if (education != null && education.size() == 3) {

            edu.append("").append(education.get(0)).append("\n").append(education.get(1)).append("\n").append(education.get(2));

        }

        if (experience != null && experience.size() == 4) {

            exp.append("").append(experience.get(0)).append("\n").append(experience.get(1)).append("\n").append(experience.get(2)).append("\n").append(experience.get(3)
            );
        }

        if (certificates != null && certificates.size() == 3) {

            cert.append("").append(certificates.get(0)).append("\n").append(certificates.get(1)).append("\n").append(certificates.get(2));

        }

        if (references != null && references.size() == 4) {
            ref.append("").append(references.get(0)).append("\n").append(references.get(1)).append("\n").append(references.get(2)).append("\n").append(references.get(3)
            );
        }

        shareBtn.setOnClickListener(v -> {

            StringBuilder shareText = new StringBuilder();

            // Basic Information
            shareText.append("Name: ").append(name).append("\n");
            shareText.append("Email: ").append(email).append("\n");
            shareText.append("Phone: ").append(phone).append("\n\n");

            // Professional Summary
            shareText.append("Professional Summary:\n").append(summary).append("\n\n");

            // Education

            shareText.append("Education:\n").append(edu);


            // Experience

            shareText.append("Experience:\n").append(exp);


            // Certificates

            shareText.append("Certifications:\n").append(cert);

            // References

            shareText.append("References:\n").append(ref);

            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My CV Details");
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareText.toString());
        });

        backBtn.setOnClickListener(v -> {
            finish();
        });
    }

    void init() {

        shareBtn = findViewById(R.id.btnShare);
        img = findViewById(R.id.img_prev);
        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        tvSummary = findViewById(R.id.tvSummary);
        tvEducation = findViewById(R.id.tvEducation);
        tvExperience = findViewById(R.id.tvExperience);
        tvCertificates = findViewById(R.id.tvCertificates);
        tvReferences = findViewById(R.id.tvReferences);
        backBtn = findViewById(R.id.backBtnPrev);
    }
}
