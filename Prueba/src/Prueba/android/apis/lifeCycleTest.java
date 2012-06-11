package Prueba.android.apis;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class lifeCycleTest extends Activity{
	//objeto donde se almacenara los mensajes 
	StringBuilder builder = new StringBuilder();
	//widget donde se mostrara el texto
	TextView textview;
	//metodo que llamaremos para registar los cambios de estado de una activuty
	private void log(String text){
		//usaremos log para tirara miensajes al log del sistema
		Log.d("LifeCycleTest",text);
		//agregamos el msg al objeto
		builder.append(text);
		builder.append('\n');
		//mandamos el texto al widget
		textview.setText(builder.toString());
	}
	@Override
	//pirmer metosdo cuando se llama una actuvity, este configuramos la activity
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		//creamos un widget y lo relacionamos con esta activity
		textview = new TextView(this);
		//textview.setText(builder.toString());// en el video ponden esta linea pero es inesesaria porque en la funcion log la llamana
		//mamostramos el widget
		setContentView(textview);
		//mandamos a log el mensaje
		log("Created");
		
	}
	@Override
	//este metodo se llama se inicia o re reinicia el hilo de ejecucion de la activity 
	protected void onResume(){
		super.onResume();
		log("resumed"); 
	}
	@Override
	//esto cuando se detiene el la activity
	protected void onPause(){
		super.onPause();
		log("paused");
		//con esto verificamos que la activity se finalizara
		if (isFinishing()){
			log("finishing");
		}
	}

}
