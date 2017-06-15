/*
 * This receiver is registered in the Manifest. It filters on
 * a standard broadcast, ACTION_BOOT_COMPLETED. It starts a service
 * and writes to the log.
 */

package com.course.example.wakefulreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

import static android.support.v4.content.WakefulBroadcastReceiver.startWakefulService;


public class BootReceiver extends WakefulBroadcastReceiver {
	
	@Override
	public void onReceive(Context context, Intent intent) {

        Log.e("RECEIVER", "starting WakefulService");
        Intent service = new Intent(context, TorpedoService.class);
        startWakefulService(context, service);


    }

}
