package Prueba.android.apis;
//esta es la actividad principal es como el main de cualquien aplicacion java
//esta tendra una lista de los ejemplos de las apis
//android cuenta con una clase list activiti 
//https://developer.android.com/reference/android/app/ListActivity.html
//se usara para lanzar las actividades  
//primero haremos un import de la clase que necesitamos
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class PruebaActivity extends ListActivity {
//	arreglo de los nombres de las activitys
	String pruebas[]={"LifeCycleTest","SingleTouchTest","MutitouchTest",
			"KeyTest","AcelerometerTest","AssestTest",
			"ExternalStorajeTest","SoundPollTest","MedaPlayerTest",
			"FullScreTest","RenderViewTest","FontTest","SufaceViewTest"};
//	este seria el constuctor de la aplicacion 
	 public void onCreate(Bundle savedInstanceState){
//		es oblitorio llamar on create super es usada porque oncreate es un metodo de la clase activity 
		super.onCreate(savedInstanceState);
		setListAdapter(//este setListAdapter establese la conecion entre ListView (una lista de elementos de scrollin vertical) y los datos
					  new ArrayAdapter<String>//ArrayAdapter este es usado para mostar el array creado, indicando el tipo de array
					  (this,//activiaty que hacemos refrerencia
					   android.R.layout.simple_list_item_1,//hace referencia a la interface de usario https://developer.android.com/guide/topics/ui/index.html
					   pruebas));//array de items que tiene que mostrar
		
		 
	 }
}