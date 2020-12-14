package com.radchenko.lab4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PhoneActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPhone;
    EditText editPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        btnPhone = (Button) findViewById(R.id.btnPhone);
        editPhone = (EditText) findViewById(R.id.editPhone);
        btnPhone.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("tel:"+editPhone.getText().toString()));
        startActivity(intent);
    }
}
