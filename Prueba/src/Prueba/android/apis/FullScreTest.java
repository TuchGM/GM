package Prueba.android.apis;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class FullScreTest  extends singleTouchTest   {
	@Override
	public void onCreate(Bundle savedInstanceState){
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
	}
}