package com.example.nh.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button show;
    NotificationManager notificationManager;
    NotificationChannel notificationChannel;
    final String CHANNELID="1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show=findViewById(R.id.show);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){

                    String name="MyChannel";
                    String descripe="app channel";
                    int importance =NotificationManager.IMPORTANCE_DEFAULT;
                    NotificationChannel channel=new NotificationChannel(CHANNELID,name,importance);
                    channel.setDescription(descripe);
                    NotificationManager notificationManager=getSystemService(NotificationManager.class);
                    notificationManager.createNotificationChannel(channel);
                }

                NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this,CHANNELID);
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setContentTitle("Title");
                builder.setContentText("This is notification");
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_foreground));

                NotificationManager manager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(0,builder.build());
            }
        });
    }
}
