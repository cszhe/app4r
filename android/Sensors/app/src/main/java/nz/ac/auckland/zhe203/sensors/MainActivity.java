package nz.ac.auckland.zhe203.sensors;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.os.Bundle;
import android.view.View;
import android.view.Display;
import android.widget.Button;
import android.widget.TextView;
import android.hardware.*;

public class MainActivity extends Activity implements SensorEventListener{


    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tv = (TextView)this.findViewById(R.id.tvDisp);

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (accelerometer != null) {
            // success! we have an accelerometer
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            tv.setText("No Accelerometer Detected");
        }

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];

        String disp = String.format("x=%f, y=%f, z=%f", x, y, z);

        this.tv.setText(disp);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
