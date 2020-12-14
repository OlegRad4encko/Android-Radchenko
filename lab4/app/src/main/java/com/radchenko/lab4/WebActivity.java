package com.radchenko.lab4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class WebActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnWeb;
    EditText editWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        btnWeb = (Button) findViewById(R.id.btnWeb);
        editWeb = (EditText) findViewById(R.id.editWeb);
        btnWeb.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse(editWeb.getText().toString()));
        startActivity(intent);
    }
}
