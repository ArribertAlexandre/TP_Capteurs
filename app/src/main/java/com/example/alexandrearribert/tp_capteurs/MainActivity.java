package com.example.alexandrearribert.tp_capteurs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button exercice1;
    Button exercice2;
    Button exercice3;
    Button exercice4;
    Button exercice5;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exercice1 = findViewById(R.id.btn_exo1);
        exercice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Exercice1.class));
                finish();
            }
        });

        exercice2 = findViewById(R.id.btn_exo2);
        exercice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Exercice2.class));
                finish();

            }
        });

        exercice3 = findViewById(R.id.btn_exo3);
        exercice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Exercice3.class));
                finish();
            }
        });

        exercice4 = findViewById(R.id.btn_exo4);
        exercice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Exercice4.class));
                finish();
            }
        });

        exercice5 = findViewById(R.id.btn_exo5);
        exercice5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Exercice5.class));
                finish();
            }
        });

    }
}
