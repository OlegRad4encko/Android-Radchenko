package com.radchenko.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CreateMessageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message); // использование верного xml файла
        final EditText message = findViewById(R.id.input_text); // типо константа, которая доступна только на нижних уровнях класа
        Button send_message = findViewById(R.id.send_message);
        send_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userMessage = message.getText().toString();
                //Log.e("Radchenko", userMessage);
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, userMessage);
                startActivity(intent);
            }
        });
    }
    final String TAG = "Радченко";
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "CreateMessageActivity: onRestart()");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "CreateMessageActivity: onStart()");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "CreateMessageActivity: onResume()");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "CreateMessageActivity: onPause()");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "CreateMessageActivity: onStop()");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "CreateMessageActivity: onDestroy()");
    }
}
