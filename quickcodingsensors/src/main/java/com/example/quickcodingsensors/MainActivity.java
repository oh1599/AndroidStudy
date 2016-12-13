package com.example.quickcodingsensors;


import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements SensorEventListener{

    SensorManager sm;

    Sensor sensor_gravity;
    Sensor sensor_accelerameter;
    Sensor sensor_Linear_acceleration;
    Sensor sensor_gyroscope;

    TextView gravityX,gravityY,gravityZ;
    TextView acceleroX,acceleroY,acceleroZ;
    TextView linearX,linearY,linearZ;
    TextView gyroX,gyroY,gyroZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sm=(SensorManager)getSystemService(SENSOR_SERVICE);

        sensor_gravity = sm.getDefaultSensor(Sensor.TYPE_GRAVITY);
        sensor_accelerameter = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensor_Linear_acceleration = sm.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        sensor_gyroscope = sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        gravityX=(TextView)findViewById(R.id.gravityX);
        gravityY=(TextView)findViewById(R.id.gravityY);
        gravityZ=(TextView)findViewById(R.id.gravityZ);

        acceleroX=(TextView)findViewById(R.id.acceleroX);
        acceleroY=(TextView)findViewById(R.id.acceleroY);
        acceleroZ=(TextView)findViewById(R.id.acceleroZ);

        linearX=(TextView)findViewById(R.id.linearX);
        linearY=(TextView)findViewById(R.id.linearY);
        linearZ=(TextView)findViewById(R.id.linearZ);

        gyroX=(TextView)findViewById(R.id.gyroX);
        gyroY=(TextView)findViewById(R.id.gyroY);
        gyroZ=(TextView)findViewById(R.id.gyroZ);
    }
    @Override
    protected void onResume() {
        super.onResume();

        sm.registerListener(this, sensor_gravity, SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(this, sensor_accelerameter, SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(this, sensor_Linear_acceleration, SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(this, sensor_gyroscope, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();

        sm.unregisterListener( this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        switch(event.sensor.getType()){
            case Sensor.TYPE_GRAVITY:
                gravityX.setText("X : " + event.values[0]);
                gravityY.setText("Y : " + event.values[1]);
                gravityZ.setText("Z : " + event.values[2]);
                break;
            case Sensor.TYPE_ACCELEROMETER:
                acceleroX.setText("X : " + event.values[0]);
                acceleroY.setText("Y : " + event.values[1]);
                acceleroZ.setText("Z : " + event.values[2]);
                break;
            case Sensor.TYPE_LINEAR_ACCELERATION:
                linearX.setText("X : " + event.values[0]);
                linearY.setText("Y : " + event.values[1]);
                linearZ.setText("Z : " + event.values[2]);
                break;
            case Sensor.TYPE_GYROSCOPE:
                gyroX.setText("X : " + event.values[0]);
                gyroY.setText("Y : " + event.values[1]);
                gyroZ.setText("Z : " + event.values[2]);
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
