package Prueba.android.apis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;

public class ExternalStorajeTest extends Activity {
	private void writeTextFile(File file,String texto) throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write(texto);
		writer.close();
	}
	private String readTextFile(File file) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(file));
		StringBuilder texto = new StringBuilder();
		String line;
		while ((line=reader.readLine())!=null) {
			texto.append(line);
			texto.append("\n");
		}
		reader.close();
		return texto.toString();
	}
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		setContentView(textView);
		String estado = Environment.getExternalStorageState();
		if (!estado.equals(Environment.MEDIA_MOUNTED)) {
			textView.setText("No hay almacenamiento externo nontado");
		} else {
			File externalDir = Environment.getExternalStorageDirectory();
			File textFile = new File(externalDir.getAbsolutePath()+File.separator+"texto.txt");
			try {
				writeTextFile(textFile,"esto es un prueva del funcionamiento del alacenamiento externo");
				String texto = readTextFile(textFile);
				textView.setText(texto);
				if (!textFile.delete()) {
					textView.setText("no se puede eliminar eñ archivo temporal");
				}
				
			} catch (IOException e) {
				textView.setText("se ha producido un error "+e.getMessage());
			}
		}
	}
} 