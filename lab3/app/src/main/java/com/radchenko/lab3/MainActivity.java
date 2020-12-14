package com.radchenko.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button send_msg = findViewById(R.id.send_msg);
        send_msg.setOnClickListener(new View.OnClickListener() { // Обработка нажатия кнопки отпраки сообщения
            @Override
            public void onClick(View v) {
                Intent forma = new Intent(MainActivity.this, CreateMessageActivity.class); // Создание интента для перемещения с текущей на нужную активити
                MainActivity.this.startActivity(forma);
            }
        });
    }
}