package com.radchenko.lab6;

import androidx.appcompat.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    MyTasks myTasks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("qwe", "create MainActivity: " + this.hashCode());
        textView = findViewById(R.id.myTextHello);
        String message;
        if (savedInstanceState != null) {
            message = savedInstanceState.getString("msg");
            textView.setText(message);
        }
        myTasks = (MyTasks) getLastCustomNonConfigurationInstance();
        if( myTasks == null ) {
            myTasks = new MyTasks();
            myTasks.execute();
        }
        Log.d("qwe", "create MyTask: " + myTasks.hashCode());
        myTasks.link(this);
    }

    public Object onRetainCustomNonConfigurationInstance() {
        myTasks.unLink();
        return myTasks;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("msg", textView.getText().toString());
    }

    class MyTasks extends AsyncTask < Void, Integer, Void > {
        MainActivity activity;
        void link(MainActivity act) {
            activity = act;
        }
        void unLink() {
            activity = null;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 1; i <= 100000000; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i);
                Log.d("qwe", "i = " + i
                        + ", MyTask: " + this.hashCode()
                        + ", MainActivity: " + MainActivity.this.hashCode());
            }
            return null;
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            TextView textView = activity.findViewById(R.id.myTextHello);
            textView.setText("i = " + values[0]);
        }

    }

}