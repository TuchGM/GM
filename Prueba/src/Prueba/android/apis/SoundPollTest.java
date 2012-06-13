package Prueba.android.apis;

import java.io.IOException;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class SoundPollTest extends Activity implements OnTouchListener{
	SoundPool soundPoll;
	int misonido =-1;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		textView.setOnTouchListener(this);
		setContentView(textView);
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		soundPoll = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
		try {
			AssetManager assetManager = getAssets();
			AssetFileDescriptor descriptor  = assetManager.openFd("sound37.ogg");
			misonido = soundPoll.load(descriptor, 1);
			
		} catch (IOException e) {
			textView.setText("No se ha podido cargar el efecto de sonido"+e.getMessage());
		} 
	}
	public boolean onTouch(View view, MotionEvent event) {
		if (event.getAction()==MotionEvent.ACTION_UP) {
			if (misonido!=-1) {
				soundPoll.play(misonido, 1, 1, 0, 0, 1);
				
			}
		}
		return true;
	}
} 