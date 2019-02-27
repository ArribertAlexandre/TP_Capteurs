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

public class Exercice3 extends AppCompatActivity {
    SensorManager sensorManager;
    Sensor accelerometreSensor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice3);


        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometreSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float[] valeur = event.values;
                float accelerometre = (float) sqrt(valeur[0] * valeur[0] + valeur[1] * valeur[1] + valeur[2] * valeur[2]);
                if (accelerometre < 9.4) {
                    getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                } else if (accelerometre > 10) {
                    getWindow().getDecorView().setBackgroundColor(Color.RED);
                } else {
                    getWindow().getDecorView().setBackgroundColor(Color.WHITE);
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
