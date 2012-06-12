package Prueba.android.apis;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.TextView;

public class AssestTest extends Activity {
	public String cargarArchivoTexto(InputStream inputStream) throws IOException {
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		byte[] bytes = new byte[4096];
		int len = 0;
		while ((len = inputStream.read(bytes))>0) {
			byteStream.write(bytes, 0, len); 
		}
		return new String(byteStream.toByteArray(),"UTF8" );
	}
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		setContentView(textView);
		AssetManager assetManager = getAssets();
		InputStream inputStream = null;
		try {
			inputStream = assetManager.open("canciones/foo.txt");
			String text = cargarArchivoTexto(inputStream);
			textView.setText(text);
			textView.setText(text);
		} catch (IOException e) {
			textView.setText("No se puede cargar el texto");
		}finally{
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {  
					textView.setText("No se puede cargar el texto");
				}
			}
		}
		
		
	}

}
