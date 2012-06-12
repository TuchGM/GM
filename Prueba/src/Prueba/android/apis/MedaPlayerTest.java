package Prueba.android.apis;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MedaPlayerTest extends Activity {
	StringBuilder builder = new StringBuilder();
	TextView textview;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		textview = new TextView(this);
		textview.setText("No lista");
		setContentView(textview);
	}
}