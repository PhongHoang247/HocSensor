package com.phong.hocsensor;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvSensor;
    ArrayAdapter<String> adapter;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        readAllSensors();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
    private void readAllSensors() {
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        //Lấy tất cả Sensor trong thiết bị:
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for (Sensor sensor : sensors){
            adapter.add(sensor.getName() + "\n" + sensor.getVendor() + "\n" + sensor.getStringType());
        }
    }

    private void addControls() {
        lvSensor = findViewById(R.id.lvSensor);
        adapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1);
        lvSensor.setAdapter(adapter);
    }
}
