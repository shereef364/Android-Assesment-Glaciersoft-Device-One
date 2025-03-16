package com.example.androidassesmentwebsocket;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import java.net.InetSocketAddress;

public class MainActivity extends AppCompatActivity {

    private ChatServer server;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Start WebSocket Server
        server = new ChatServer(new InetSocketAddress(8080));
        server.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (server != null) {
            try {
                server.stop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}