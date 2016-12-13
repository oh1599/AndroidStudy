package com.example.quickcodingpedometer;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.R.attr.gravity;

public class MainActivity extends AppCompatActivity implements SensorEventListener{


    Sensor sensor_accel;
    SensorManager sm;

    TextView result;

    double acceleration,gravity;
    int dir_UP,dir_DOWN;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dir_UP=0;
        dir_DOWN=0;
        count=0;
        gravity=9.81;

        result=(TextView)findViewById(R.id.result);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        sensor_accel = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }
    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(this, sensor_accel, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();

        sm.unregisterListener(this);
    }



    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            acceleration =  Math.sqrt(x * x + y * y + z * z);
        }

        if(acceleration - gravity > 5){
            dir_UP = 1;
        }

        if(dir_UP == 1 && gravity - acceleration > 5){
            dir_DOWN = 1;
        }

        if(dir_DOWN == 1){
            count++;
            result.setText("  "+count+"  ");

            dir_UP = 0;
            dir_DOWN = 0;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
