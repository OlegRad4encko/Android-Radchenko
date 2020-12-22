package com.radchenko.lab7;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class OneA extends AppCompatActivity implements AlertDialog.OnClickListener {
    final int DIALOG_EXIT = 1;
    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_EXIT);
            }
        });
    }

    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_EXIT) {
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            // заголовок
            adb.setTitle(R.string.exit);
            // сообщение
            adb.setMessage(R.string.save_data);
            // иконка
            adb.setIcon(android.R.drawable.ic_dialog_info);
            // кнопка положительного ответа
            adb.setPositiveButton(R.string.yes, this);
            // кнопка отрицательного ответа
            adb.setNegativeButton(R.string.no, this);
            // кнопка нейтрального ответа
            adb.setNeutralButton(R.string.cancel, this);
            // создаем диалог
            return adb.create();
        }
        return super.onCreateDialog(id);
    }
    public void onClick(DialogInterface dialog, int which) {
        switch (which) {

            case Dialog.BUTTON_POSITIVE:
                saveData();
                finish();
                break;
            case Dialog.BUTTON_NEGATIVE:
                finish();
                break;
            case Dialog.BUTTON_NEUTRAL:
                break;
        }
    }
    void saveData() {
        Toast.makeText(this, R.string.saved, Toast.LENGTH_SHORT).show();
    }
}
