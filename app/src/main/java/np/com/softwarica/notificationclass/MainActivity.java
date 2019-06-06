package np.com.softwarica.notificationclass;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn1, btn2;
    private NotificationManager manager;
    private BroadcastExampleReceiver receiver = new BroadcastExampleReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotification1();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotification2();
            }
        });
    }

    private void DisplayNotification1() {
        NotificationChannel mChannel = new NotificationChannel("1", "Channel1", NotificationManager.IMPORTANCE_LOW);

        Notification notification = new Notification.Builder(MainActivity.this)
                .setSmallIcon(R.drawable.ic_directions_bike_black_24dp)
                .setContentTitle("Car Arrived.")
                .setContentText("Your car has arrived.")
                .setChannelId(mChannel.getId())
                .build();

        manager.notify(1, notification);
    }

    private void DisplayNotification2() {
        NotificationChannel mChannel = new NotificationChannel("1", "Channel2", NotificationManager.IMPORTANCE_HIGH);

        Notification notification = new Notification.Builder(MainActivity.this)
                .setSmallIcon(R.drawable.ic_directions_bike_black_24dp)
                .setContentTitle("Destination Arrived.")
                .setContentText("Your destination has arrived.")
                .setChannelId(mChannel.getId())
                .build();

        manager.notify(2, notification);
    }


    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.SUPPLICANT_CONNECTION_CHANGE_ACTION);
        registerReceiver(receiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiver);
    }
}
