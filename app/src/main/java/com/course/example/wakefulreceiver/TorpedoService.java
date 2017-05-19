/*
 * This example uses a thread to fire 3 photon torpedos,
 * one every 5 seconds. 
 * The service is started by a receiver.
 */

package com.course.example.wakefulreceiver;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;

import java.io.IOException;

public class TorpedoService extends IntentService {

	private static MediaPlayer mp;

	public TorpedoService() {
		super("TorpedoService");
	}

	@Override
	protected void onHandleIntent(Intent intent) {

		// Do the work that requires your app to keep the CPU running.
		mp = MediaPlayer.create(this, R.raw.photon);

		for(int i=0; i<3; i++){
			Log.e("RECEIVER", "Loop");
			mp.seekTo(0);
			mp.start();
			try{
				Thread.sleep(5000);
			} catch(InterruptedException e) {Log.e("RECEIVER", "Blowup");}
		}

		//wait until player is finished
		while (mp.isPlaying()) {};

		mp.release();

		//release wakelock provided by the WakefulBroadcastReceiver
		BootReceiver.completeWakefulIntent(intent);
		Log.e("RECEIVER", "Wakelock Removed");


	}
}
