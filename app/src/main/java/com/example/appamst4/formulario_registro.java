package com.example.appamst4;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class formulario_registro extends AppCompatActivity {

    FloatingActionsMenu btnMenu;
    FloatingActionButton btnVideo, btnMapa, btnGraficaLineal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_registro);

        btnMenu = (FloatingActionsMenu) findViewById(R.id.btnMenu);
        btnVideo = (FloatingActionButton) findViewById(R.id.btnVideo);
        btnMapa = (FloatingActionButton) findViewById(R.id.btnMapa);
        btnGraficaLineal = (FloatingActionButton) findViewById(R.id.btnGraficaLineal);
    }

    //insertarpaciente
    public void insertarpaciente(View v) {
        addNotification();

    }

    private void addNotification() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            String id ="canal";
            String description = "AMST";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(id, description, importance);

            NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(this,id)
                            .setSmallIcon(R.drawable.medicalcare)
                            .setContentTitle("Se ha registrado con exito")
                            .setContentText("Revise su correo electronico en los proximos 2 dias")
                            .setAutoCancel(true)
                            .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            Intent notificationIntent = new Intent(this, formulario_registro.class);
            notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            notificationIntent.putExtra("message", "This is a notification message");

            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                    PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(pendingIntent);
            NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            manager.createNotificationChannel(channel);
            manager.notify(0, builder.build());
        }}

    public void Video(View view) {
        Intent intent = new Intent(this, video_view.class);
        startActivity(intent);
    }

    public void GraficoLineal(View view) {
        Intent intent = new Intent(this, grafica_lineal.class);
        startActivity(intent);
    }

    public void Mapa(View view) {
        Intent intent = new Intent(this, mapa_view.class);
        startActivity(intent);
    }

    public void onClick(View v) {
        if(v.getId() == R.id.btnVideo){
            Log.d("mensaje","video");
        }else if(v.getId() == R.id.btnGraficaLineal) {
        }else if(v.getId() == R.id.btnMapa) {
        }
    }

}