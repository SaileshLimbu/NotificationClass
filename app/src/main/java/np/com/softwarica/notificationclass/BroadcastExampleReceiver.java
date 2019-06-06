package np.com.softwarica.notificationclass;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.widget.Toast;

public class BroadcastExampleReceiver extends android.content.BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        if (action.equals(WifiManager.SUPPLICANT_CONNECTION_CHANGE_ACTION)) {
            if (intent.getBooleanExtra(WifiManager.EXTRA_SUPPLICANT_CONNECTED, false)) {
                Toast.makeText(context, "WiFi Connected", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "WiFi connection lost.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}