package com.cos.testroomdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    private HistoryDB historyDB = null;
    private Context mContext;
    private EditText tvExpression, tvResult;
    private Button btnInsert, btnDelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        btnInsert = findViewById(R.id.btn_insert);
        tvExpression = findViewById(R.id.tv_expression);
        tvResult = findViewById(R.id.tv_answer);

        historyDB = HistoryDB.getInstance(this);
        mContext = getApplicationContext();

        class InsertRunnable implements Runnable{

            @Override
            public void run() {
                History history = new History();
                history.expression = tvExpression.getText().toString();
                history.result = tvResult.getText().toString();

                HistoryDB.getInstance(mContext).historyDAO().insertAll(history);
            }
        }

    }
}