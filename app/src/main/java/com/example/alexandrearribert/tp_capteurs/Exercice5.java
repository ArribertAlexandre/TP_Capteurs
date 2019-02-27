package com.example.alexandrearribert.tp_capteurs;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static java.lang.Math.sqrt;

public class Exercice5 extends AppCompatActivity {
    SensorManager sensorManager;
    Sensor accelerometreSensor;
    Sensor accelerometreShake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice5);



        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometreSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        accelerometreShake = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);



                if(getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)) {
                    sensorManager.registerListener(new SensorEventListener() {
                        @Override
                        public void onSensorChanged(SensorEvent event) {
                            float[] valeur = event.values;
                            float accelerometre = (float) sqrt(valeur[0] * valeur[0] + valeur[1] * valeur[1] + valeur[2] * valeur[2]);

                            if(accelerometre > 10.7) {
                                android.hardware.Camera camera = android.hardware.Camera.open();
                                android.hardware.Camera.Parameters params = camera.getParameters();
                                params.setFlashMode(android.hardware.Camera.Parameters.FLASH_MODE_TORCH);
                                Boolean flash = false;
                                if(flash) {
                                    camera.stopPreview();
                                    camera.release();
                                } else {
                                    camera.setParameters(params);
                                    camera.startPreview();
                                }
                            }
                        }

                        @Override
                        public void onAccuracyChanged(Sensor sensor, int accuracy) {

                        }
                    }, accelerometreShake, SensorManager.SENSOR_DELAY_NORMAL);

                }
            }


    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }
}
