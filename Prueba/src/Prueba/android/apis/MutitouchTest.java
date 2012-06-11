package Prueba.android.apis;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class MutitouchTest extends Activity implements OnTouchListener{
	StringBuilder builder = new StringBuilder();
	TextView textview;
	float[] x = new float[10];
	float[] y = new float[10];
	boolean[] tocando = new boolean[10];
	private void updateTextView(){
		builder.setLength(0);
		for (int i = 0; i < 10; i++) {
			builder.append(tocando[i]);
			builder.append(", ");
			builder.append(x[i]);
			builder.append(", ");
			builder.append(y[i]);
			builder.append("\n");
		}
		textview.setText(builder.toString());
	}
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		textview = new TextView(this);
		textview.setText("Toca y arrastra ¡(un dedo solamente)!");
		textview.setOnTouchListener(this);
		setContentView(textview);
	}
	public boolean onTouch(View v, MotionEvent event) {
		int action = event.getAction() & MotionEvent.ACTION_MASK;
		//importante!! parese ser que estas constantes ya han sido obsoletas checar documentacion  
		//int pointerIndex = (event.getAction() & MotionEvent.ACTION_POINTER_ID_MASK) >> MotionEvent.ACTION_POINTER_ID_SHIFT;
		//segun la documentacion estas constantes han sido renobradas a esta forma
		int pointerIndex = (event.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
		int pointerId = event.getPointerId(pointerIndex);
		switch (action) {
		case MotionEvent.ACTION_DOWN:
		case MotionEvent.ACTION_POINTER_DOWN:
			tocando[pointerId]=true;
			x[pointerId]=(int)event.getX(pointerIndex);
			x[pointerId]=(int)event.getY(pointerIndex);
			break;
		case MotionEvent.ACTION_UP:
		case MotionEvent.ACTION_POINTER_UP:
		case MotionEvent.ACTION_CANCEL:			
			tocando[pointerId]=true;
			x[pointerId]=(int)event.getX(pointerIndex);
			x[pointerId]=(int)event.getY(pointerIndex);
			break;
		case MotionEvent.ACTION_MOVE:
			int pointerCount=event.getPointerCount();
			for (int i = 0; i < pointerCount; i++) {
				pointerIndex=i;
				pointerId=event.getPointerId(pointerIndex);
			}
			break;
		default:
			break;
		}
		updateTextView();
		return true;
	}

}
