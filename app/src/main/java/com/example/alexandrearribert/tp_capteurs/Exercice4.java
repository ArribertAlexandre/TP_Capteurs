package com.example.alexandrearribert.tp_capteurs;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static java.lang.Math.sqrt;

public class Exercice4 extends AppCompatActivity {
    TextView direction;
    SensorManager sensorManager;
    Sensor accelerometreSensor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice4);

        direction = findViewById(R.id.tv_direction);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometreSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensorManager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float[] valeur = event.values;
                float accelerometre = (float) sqrt(valeur[0] * valeur[0] + valeur[1] * valeur[1] + valeur[2] * valeur[2]);

                if(valeur[0] > 0.3) {
                    direction.setText(R.string.gauche);
                } else if(valeur[0] < - 0.3) {
                    direction.setText(R.string.droite);
                } else if(valeur[1] > 0.3) {
                    direction.setText(R.string.haut);
                } else if (valeur[1] < - 0.3) {
                    direction.setText(R.string.bas);
                }

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        }, accelerometreSensor, SensorManager.SENSOR_DELAY_NORMAL) ;


     }
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

}
