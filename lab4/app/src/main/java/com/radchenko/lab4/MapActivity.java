package com.radchenko.lab4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MapActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnMap;
    EditText editCoord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        btnMap = (Button) findViewById(R.id.btnMap);
        editCoord = (EditText) findViewById(R.id.editCoord);
        btnMap.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("geo:"+editCoord.getText().toString()));
        startActivity(intent);
    }
}
