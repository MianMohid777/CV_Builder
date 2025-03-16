package com.example.cv_builder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    CardView profile_pic;
    CardView detail;
    CardView summary;
    CardView education;
    CardView experience;
    CardView cert;
    CardView ref;

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

                        List<String> education = dataIntent.getStringArrayListExtra("EDUCATION_LIST");
                        List<String> experience= dataIntent.getStringArrayListExtra("EXP_LIST");
                        List<String> certs = dataIntent.getStringArrayListExtra("CERTS_LIST");

                        List<String> refs = dataIntent.getStringArrayListExtra("REFS_LIST");

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
                            myCv.setExperience(experience);

                        if(refs != null)
                            myCv.setRefer(refs);

                    }
                });

    }
}