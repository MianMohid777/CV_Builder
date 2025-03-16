package com.example.cv_builder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProfilePicActivity extends AppCompatActivity {

    ImageButton imgBtn;
    Button saveButton;

    ImageView img;

    Uri uri;

    ImageView backBtn;

    ActivityResultLauncher<Intent> getImageLauncher;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profilepic_activity);

        init();

        Intent getIntent = getIntent();

        Uri currUri = getIntent.getParcelableExtra("URI");

        if (currUri != null) {
            uri = currUri;
            img.setImageURI(uri);
        }

        backBtn.setOnClickListener(v -> {
            finish();
        });

        imgBtn.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_PICK);
            i.setType("image/*");
            i.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
            getImageLauncher.launch(i);
        });

        saveButton.setOnClickListener(v -> {

            Intent intent = new Intent(ProfilePicActivity.this, MainActivity.class);
            intent.putExtra("URI", uri);
            setResult(RESULT_OK, intent);
            finish();
        });

    }


    void init() {
        imgBtn = findViewById(R.id.uploadBtn);
        saveButton = findViewById(R.id.saveBtn);
        img = findViewById(R.id.img);
        backBtn = findViewById(R.id.backBtn);


        getImageLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                (result) -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Intent imgData = result.getData();
                        Uri imgUri = imgData.getData();

                        if (imgUri != null) {
                            img.setImageURI(imgUri);
                            uri = imgUri;
                        } else {
                            Toast.makeText(this, "Error in getting the Image", Toast.LENGTH_LONG).show();
                        }
                    } else if (result.getResultCode() == RESULT_CANCELED) {
                        Toast.makeText(this, "No Image Selected", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(this, "Error !", Toast.LENGTH_LONG).show();
                    }
                });
    }
}
