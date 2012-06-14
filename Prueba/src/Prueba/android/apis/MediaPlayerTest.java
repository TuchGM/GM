package Prueba.android.apis;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;

public class MediaPlayerTest  extends Activity implements OnCompletionListener{
	MediaPlayer mediaPlayer;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}
	public void onCompletion(MediaPlayer mp) {
		mediaPlayer.start();
	}
	public void onStart() {
		super.onStart();
		mediaPlayer= MediaPlayer.create(this, R.raw.musica);
		mediaPlayer.setOnCompletionListener(this);
		mediaPlayer.start();
	}
	public void onStop() {
		super.onStop();
		mediaPlayer.stop();
		mediaPlayer.release();
	}
}