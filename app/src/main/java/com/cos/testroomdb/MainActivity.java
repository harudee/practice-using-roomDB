package com.cos.testroomdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity222";
    private MainActivity mContext = this;

    private HistoryDB historyDB = null;
    private Button btnInsert, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        historyDB = HistoryDB.getInstance(this);
        HistoryDAO historyDAO = historyDB.historyDAO();

        btnInsert = findViewById(R.id.btn_insert);
        btnDelete = findViewById(R.id.btn_delete);


        btnInsert.setOnClickListener(view -> {

        });

        class InsertRunnable implements Runnable{

            @Override
            public void run() {


            }
        }

        InsertRunnable insertRunnable = new InsertRunnable();
        Thread thread = new Thread(insertRunnable);
        thread.start();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        HistoryDB.destroyInstance();
        historyDB = null;

    }
}