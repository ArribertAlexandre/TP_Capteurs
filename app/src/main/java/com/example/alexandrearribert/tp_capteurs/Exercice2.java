package com.example.alexandrearribert.tp_capteurs;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Exercice2 extends AppCompatActivity {
    SensorManager sensorManager ;
    TextView tv_capteurs_indisponible;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice2);
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);

        tv_capteurs_indisponible = findViewById(R.id.tv_unavailable_sensor);


        Sensor humidite = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        if(humidite == null){
            tv_capteurs_indisponible.setText(R.string.sensor_unavailable);
        }

    }
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }
}
