package com.radchenko.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ReceiveMessageActivity extends AppCompatActivity {
    private String message;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message); // использование верного xml файла
        TextView textView = findViewById(R.id.textView);
        if (savedInstanceState==null) { // Если сохраненных данных нет
            Intent intent = getIntent();
            message = intent.getStringExtra(Intent.EXTRA_TEXT);
            Log.d("LOG", intent.getType());
        }
        else { // если они есть, считывает данные с бандла
            message = savedInstanceState.getString("msg");
        }
        textView.setText(message);
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("msg", message);
    }

}