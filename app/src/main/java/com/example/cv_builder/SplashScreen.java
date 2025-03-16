package com.example.cv_builder;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashScreen extends AppCompatActivity {

    CardView logo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.splash_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.splash), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        logo = findViewById(R.id.logo);

        Animation fadeOut = AnimationUtils.loadAnimation(this,R.anim.fade_in);
        Animation rotate = AnimationUtils.loadAnimation(this,R.anim.rotate);
        Animation translate = AnimationUtils.loadAnimation(this,R.anim.translate);


        AnimationSet animationSet = new AnimationSet(true);

        animationSet.addAnimation(fadeOut);
        animationSet.addAnimation(rotate);
        animationSet.addAnimation(translate);

        logo.startAnimation(animationSet);

        new Handler().postDelayed(()->{
          startActivity(new Intent(SplashScreen.this, MainActivity.class));
           finish();
        },5000);

    }
}
