package com.example.cv_builder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    CardView profile_pic;
    CardView detail;
    CardView summary;
    CardView education;
    CardView experience;
    CardView cert;
    CardView ref;

    TextView prev;

    static CV myCv;

    ActivityResultLauncher<Intent> getDataLauncher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        profile_pic.setOnClickListener(v -> {

            Intent i = new Intent(MainActivity.this,ProfilePicActivity.class);
            i.putExtra("URI",myCv.getUri());
            getDataLauncher.launch(i);
        });



        detail.setOnClickListener(v -> {

            Intent i = new Intent(MainActivity.this,DetailActivity.class);
            i.putExtra("NAME",myCv.getName());
            i.putExtra("EMAIL",myCv.getEmail());
            i.putExtra("PHONE",myCv.getPhone());

            getDataLauncher.launch(i);
        });

        summary.setOnClickListener(v -> {

            Intent i = new Intent(MainActivity.this,SummaryActivity.class);
            i.putExtra("SUMMARY",myCv.getSummary());
            getDataLauncher.launch(i);
        });

        education.setOnClickListener(v -> {

            Intent i = new Intent(MainActivity.this,EduActivity.class);
            i.putStringArrayListExtra("EDUCATION_LIST",myCv.getEducation());
            getDataLauncher.launch(i);
        });

        experience.setOnClickListener(v -> {

            Intent i = new Intent(MainActivity.this,ExpActivity.class);
            i.putStringArrayListExtra("EXP_LIST",myCv.getExperience());
            getDataLauncher.launch(i);
        });

        cert.setOnClickListener(v -> {

            Intent i = new Intent(MainActivity.this,CertActivity.class);
            i.putStringArrayListExtra("CERTS_LIST",myCv.getCerts());
            getDataLauncher.launch(i);
        });

        ref.setOnClickListener(v -> {

            Intent i = new Intent(MainActivity.this,RefActivity.class);
            i.putStringArrayListExtra("REFS_LIST",myCv.getRefer());
            getDataLauncher.launch(i);
        });

        prev.setOnClickListener(v -> {
            Intent previewIntent = new Intent(this, PreviewActivity.class);
            previewIntent.putExtra("NAME", myCv.getName());
            previewIntent.putExtra("EMAIL", myCv.getEmail());
            previewIntent.putExtra("PHONE", myCv.getPhone());
            previewIntent.putExtra("SUMMARY", myCv.getSummary());
            previewIntent.putStringArrayListExtra("EDUCATION", myCv.getEducation());
            previewIntent.putStringArrayListExtra("EXPERIENCE", myCv.getExperience());
            previewIntent.putStringArrayListExtra("CERTIFICATES", myCv.getCerts());
            previewIntent.putStringArrayListExtra("REFERENCES", myCv.getRefer());
            previewIntent.putExtra("URI", myCv.getUri());
            startActivity(previewIntent);
        });
    }


    void init()
    {
        profile_pic = findViewById(R.id.pic_card);
        detail = findViewById(R.id.detail_card);
        summary = findViewById(R.id.summary_card);
        education = findViewById(R.id.edu_card);
        experience = findViewById(R.id.exp_card);
        cert = findViewById(R.id.cert_card);
        ref = findViewById(R.id.ref_card);
        prev = findViewById(R.id.prev);

        myCv = new CV();


        getDataLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                (result)-> {

                    if(result.getResultCode() == RESULT_OK && result.getData() != null)
                    {
                        Intent dataIntent = result.getData();

                        Uri uri = dataIntent.getParcelableExtra("URI");
                        String name = dataIntent.getStringExtra("NAME");
                        String email = dataIntent.getStringExtra("EMAIL");
                        String phone = dataIntent.getStringExtra("PHONE");

                        String summary = dataIntent.getStringExtra("SUMMARY");

                        ArrayList<String> education = dataIntent.getStringArrayListExtra("EDUCATION_LIST");
                        ArrayList<String> experience= dataIntent.getStringArrayListExtra("EXP_LIST");
                        ArrayList<String> certs = dataIntent.getStringArrayListExtra("CERTS_LIST");

                        ArrayList<String> refs = dataIntent.getStringArrayListExtra("REFS_LIST");

                        if(uri != null)
                            myCv.setUri(uri);

                        if(name != null)
                            myCv.setName(name);

                        if(email != null)
                            myCv.setEmail(email);

                        if(phone != null)
                            myCv.setPhone(phone);

                        if(summary!=null)
                            myCv.setSummary(summary);

                        if(education!= null)
                            myCv.setEducation(education);

                        if(experience!= null)
                            myCv.setExperience(experience);

                        if(certs!= null)
                            myCv.setCerts(certs);

                        if(refs != null)
                            myCv.setRefer(refs);

                    }
                });

    }
}