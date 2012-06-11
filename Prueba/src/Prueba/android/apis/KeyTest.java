package Prueba.android.apis;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.TextView;

public class KeyTest extends Activity implements OnKeyListener{
	StringBuilder builer = new StringBuilder();
	TextView textView;
	@Override //nuca olvidar sobre escrivir la clase 
	public void onCreate(Bundle savedInstanceState){
		//nunca olvidar llamr al costructor
		super.onCreate(savedInstanceState);
		textView=new TextView(this);
		textView.setText("Pulsa y observa el ressultado en la pantalla");
		textView.setOnKeyListener(this);
		textView.setFocusableInTouchMode(true);
		textView.requestFocus();
		setContentView(textView);
	}
	
	public boolean onKey(View view, int keyCode, KeyEvent event) {
		builer.setLength(0);
		switch (event.getAction()) {
		case KeyEvent.ACTION_DOWN:
			builer.append("down, ");
			break;
		case KeyEvent.ACTION_UP:
			builer.append("up, ");
			break;

		default:
			break;
		}
		builer.append(event.getKeyCode());
		builer.append(", ");
		builer.append((char)event.getUnicodeChar());
		builer.append("\n");
		String text = builer.toString();
		Log.d("Key test", text);
		textView.setText(text);
		if (event.getKeyCode()==KeyEvent.KEYCODE_BACK) {
			return false;
		}else {
			return true;
		}
		
	}
	

}
