package com.radchenko.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bUpdate, bDelete, bAdd, bRead, bClear, bOrderBy;
    EditText id, fName, sName, email, address;
    Spinner spinner;

    MySqlHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bUpdate = findViewById(R.id.bUpdate);
        bDelete = findViewById(R.id.bDelete);
        bAdd = findViewById(R.id.bAdd);
        bRead = findViewById(R.id.bRead);
        bClear = findViewById(R.id.bClear);
        bOrderBy = findViewById(R.id.bOrderBy);

        spinner = findViewById(R.id.spinner);

        id = findViewById(R.id.id);
        fName = findViewById(R.id.fName);
        sName = findViewById(R.id.sName);
        email = findViewById(R.id.email);
        address = findViewById(R.id.address);

        dbHelper = new MySqlHelper(this);

        bUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues contentValues = new ContentValues();
                SQLiteDatabase database = dbHelper.getWritableDatabase();
                contentValues.put(MySqlHelper.KEY_NAME, fName.getText().toString());
                contentValues.put(MySqlHelper.KEY_SURNAME, sName.getText().toString());
                contentValues.put(MySqlHelper.KEY_EMAIL, email.getText().toString());
                contentValues.put(MySqlHelper.KEY_ADDRESS, address.getText().toString());
                database.update(MySqlHelper.TABLE_CONTACTS, contentValues, MySqlHelper.KEY_ID + "=?", new String[] {id.getText().toString()});
                Toast.makeText(MainActivity.this, "Изменено!",Toast.LENGTH_SHORT).show();
            }
        });

        bDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(id.getText().toString().length() == 0 && fName.getText().toString().length() == 0 && sName.getText().toString().length() == 0 &&
                        email.getText().toString().length() == 0 && address.getText().toString().length() == 0){

                    SQLiteDatabase database = dbHelper.getWritableDatabase();
                    int row = database.delete(MySqlHelper.TABLE_CONTACTS, null, null);
                    if(row == -1){
                        Toast.makeText(MainActivity.this, "Где-то кроется твой косяк(нет). Не удалено!",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Toast.makeText(MainActivity.this, "Удалены все записи с таблицы. Нумерация продолжается!",Toast.LENGTH_SHORT).show();

                }
                else {
                    if(id.getText().toString().length() != 0) {
                        String usrid = id.getText().toString();
                        SQLiteDatabase database = dbHelper.getWritableDatabase();
                        int row = database.delete(MySqlHelper.TABLE_CONTACTS, MySqlHelper.KEY_ID + " =? " , new String[] {usrid});
                        if(row == -1){
                            Toast.makeText(MainActivity.this, "Не удалено, Возможно, что такого ID нет. ",Toast.LENGTH_SHORT).show();
                            return;
                        }

                        id.setText("");
                        fName.setText("");
                        sName.setText("");
                        email.setText("");
                        address.setText("");
                        Toast.makeText(MainActivity.this, "Удалена запись под айди: "+usrid,Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Айди не указан!",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues contentValues = new ContentValues();
                SQLiteDatabase database = dbHelper.getWritableDatabase();
                contentValues.put(MySqlHelper.KEY_NAME, fName.getText().toString());
                contentValues.put(MySqlHelper.KEY_SURNAME, sName.getText().toString());
                contentValues.put(MySqlHelper.KEY_EMAIL, email.getText().toString());
                contentValues.put(MySqlHelper.KEY_ADDRESS, address.getText().toString());
                long row = database.insert(MySqlHelper.TABLE_CONTACTS, null, contentValues);
                if(row != -1){
                    id.setText(String.valueOf(row));
                    Toast.makeText(MainActivity.this, "Добавлено! id = " + row,Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Где-то кроется твой косяк(нет)",Toast.LENGTH_SHORT).show();
                }
            }
        });

        bRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase database = dbHelper.getWritableDatabase();
                if(id.getText().toString().length() == 0){
                    Toast.makeText(MainActivity.this, "Введите ID", Toast.LENGTH_SHORT).show();
                    return;
                }

                Cursor cursor = database.rawQuery("select * from "+ MySqlHelper.TABLE_CONTACTS +" where "+ MySqlHelper.KEY_ID +" = '"+id.getText().toString()+"' limit 1",null);
                if(!cursor.moveToFirst()){
                    Toast.makeText(MainActivity.this, "Такого ID нет!", Toast.LENGTH_SHORT).show();
                    return;
                }
                fName.setText(cursor.getString(cursor.getColumnIndex(MySqlHelper.KEY_NAME)));
                sName.setText(cursor.getString(cursor.getColumnIndex(MySqlHelper.KEY_SURNAME)));
                email.setText(cursor.getString(cursor.getColumnIndex(MySqlHelper.KEY_EMAIL)));
                address.setText(cursor.getString(cursor.getColumnIndex(MySqlHelper.KEY_ADDRESS)));
            }
        });

        bClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id.setText("");
                fName.setText("");
                sName.setText("");
                email.setText("");
                address.setText("");
                Toast.makeText(MainActivity.this, "Не беспокойся, юный друг. Твоя бд не постарадала!", Toast.LENGTH_SHORT).show();
            }
        });

        bOrderBy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long spinnerID = spinner.getSelectedItemId();
                String rez = "";
                String orderBy = "";
                switch ((int) spinnerID){
                    case 0: //name
                        orderBy = MySqlHelper.KEY_NAME;
                        rez+= "Сортировка по имени\n";
                        break;
                    case 1: //surname
                        orderBy = MySqlHelper.KEY_SURNAME;
                        rez+= "Сортировка по фамилии\n";
                        break;
                    case 2: //Email
                        orderBy = MySqlHelper.KEY_EMAIL;
                        rez+= "Сортировка по почте\n";
                        break;
                }
                SQLiteDatabase database = dbHelper.getWritableDatabase();
                Cursor cursor = database.query(MySqlHelper.TABLE_CONTACTS, null,null,null,null,null, orderBy);


                if (cursor != null) {
                    if (cursor.moveToFirst()) {
                        do {
                            for (String cn : cursor.getColumnNames()) {
                                rez += cn + " = " + cursor.getString(cursor.getColumnIndex(cn))+ " ";
                            }
                            rez += "\n";
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                }
                Toast.makeText(MainActivity.this, rez, Toast.LENGTH_LONG).show();
            }
        });
    }
}