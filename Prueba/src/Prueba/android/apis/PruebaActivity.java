package Prueba.android.apis;
//esta es la actividad principal es como el main de cualquien aplicacion java
//esta tendra una lista de los ejemplos de las apis
//android cuenta con una clase list activiti 
//https://developer.android.com/reference/android/app/ListActivity.html
//se usara para lanzar las actividades  
//primero haremos un import de la clase que necesitamos
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PruebaActivity extends ListActivity {
//	arreglo de los nombres de las activitys
	String pruebas[]={"lifeCycleTest","singleTouchTest","MutitouchTest",
			"KeyTest","AcelerometerTest","AssestTest",
			"ExternalStorajeTest","SoundPollTest","AudioPlayer","MediaPlayerTest",
			"FullScreTest","RenderViewTest","FontTest","SufaceViewTest"};
//	este seria el constuctor de la aplicacion 
	@Override  
	public void onCreate(Bundle savedInstanceState){
//		es oblitorio llamar on create super es usada porque oncreate es un metodo de la clase activity 
		super.onCreate(savedInstanceState);
		setListAdapter(//este setListAdapter establese la conecion entre ListView (una lista de elementos de scrollin vertical) y los datos
					  new ArrayAdapter<String>//ArrayAdapter este es usado para mostar el array creado, indicando el tipo de array
					  (this,//activiaty que hacemos refrerencia
					   android.R.layout.simple_list_item_1,//hace referencia a la interface de usario https://developer.android.com/guide/topics/ui/index.html
					   //juegen con simple_list_item_ da varias opcioens intereantes
					   pruebas));//array de items que tiene que mostrar
		//para que haga algo usaremos onListItemClick
		//https://developer.android.com/reference/android/app/ListActivity.html#onListItemClick%28android.widget.ListView,%20android.view.View,%20int,%20long%29
	}
	//fanta commetar el codigo
	@Override
	protected void onListItemClick (ListView list, View view, int position, long id) {
		super.onListItemClick(list, view, position, id);
	//este metodo es llamado cuando se seleciona un elemento de la lista
		String nombrePrueva = pruebas[position];
	//obtenesmos el sting de elemento selecionado
		try{
	//usamos el tray para poder intentar llamar una activity atraves de un intent este se compone del nombre del paquete 
			Class<?> clazz = Class.forName("Prueba.android.apis."+nombrePrueva);
			Intent intent = new Intent(this,clazz);
			startActivity(intent);
	//se llama a la activity atraves de un inten
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}