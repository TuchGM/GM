package Prueba.android.apis;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class AcelerometerTest extends Activity implements SensorEventListener {
	TextView textView;
	StringBuilder builer = new StringBuilder();
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		textView = new TextView(this);
		setContentView(textView);
		SensorManager manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		if (manager.getSensorList(Sensor.TYPE_ACCELEROMETER).size()==0) {
			textView.setText("No hay hacelerometro instalado");
		}else {
			Sensor accelerometer = manager.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
			if (!manager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME)) {
				textView.setText("No se ha podido registrar el sensor listener");
			}
		}
	}
	
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	public void onSensorChanged(SensorEvent event) {
		builer.setLength(0);
		builer.append("x: ");
		builer.append(event.values[0]);
		builer.append(", y: ");
		builer.append(event.values[1]);
		builer.append(", z: ");
		builer.append(event.values[2]);
		textView.setText(builer.toString());
	}
	

}
