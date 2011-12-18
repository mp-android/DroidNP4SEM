package net.madroom.dnp4sem;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;

public class SemReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        if(bundle==null) {
            return;
        }

        Intent i = new Intent("net.madroom.dnp.plugin.MUSIC_STATUS");
        i.putExtra("artist", bundle.getString("ARTIST_NAME"));
        i.putExtra("album", bundle.getString("ALBUM_NAME"));
        i.putExtra("track", bundle.getString("TRACK_NAME"));
        new ContextWrapper(context).sendBroadcast(i);
        System.exit(0);
    }
}
