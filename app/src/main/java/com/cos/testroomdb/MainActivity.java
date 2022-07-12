package com.cos.testroomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity222";
    private Context mContext = this;

    private HistoryDB historyDB = null;
    private List<History> historyList;
    private HistoryAdapter historyAdapter;

    private Button btnInsert, btnDelete;
    private EditText tvExpression, tvResult;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = getApplicationContext();

        btnInsert = findViewById(R.id.btn_insert);
        btnDelete = findViewById(R.id.btn_delete);

        tvExpression = findViewById(R.id.tv_expression);
        tvResult = findViewById(R.id.tv_answer);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        historyAdapter = new HistoryAdapter(historyList);
        recyclerView.setAdapter(historyAdapter);


        new Thread(){

            @Override
            public void run() {

                loadAll();

            }

        }.start();


        /*historyDB = HistoryDB.getInstance(this);
        HistoryDAO historyDAO = historyDB.historyDAO();*/

        /*class InsertRunnable implements Runnable{

            @Override
            public void run() {

                historyDB.historyDAO().insertAll(new History(expression, result));

                historyList = historyDB.historyDAO().getAll();
                historyAdapter = new HistoryAdapter(historyList);
                historyAdapter.notifyDataSetChanged();

                recyclerView.setAdapter(historyAdapter);
                LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false);
                recyclerView.setLayoutManager(mLinearLayoutManager);

            }
        }*/


        btnInsert.setOnClickListener(view -> {

            /*InsertRunnable insertRunnable = new InsertRunnable();
            Thread thread = new Thread(insertRunnable);
            thread.start();*/

            String expression = tvExpression.getText().toString();
            String result = tvResult.getText().toString();

            //insertResult(expression, result);

            new Thread(){

                @Override
                public void run() {

                    insertResult(expression, result);

                    //loadAll();

                }
            }.start();

        });

        btnDelete.setOnClickListener(view -> {



        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        HistoryDB.destroyInstance();
        historyDB = null;

    }


    //결과 집어넣기
    private void insertResult(String expression, String result){


        History history = new History();
        history.expression = expression;
        history.result = result;

        HistoryDB historyDB = HistoryDB.getInstance(mContext);

        historyDB.historyDAO().insertAll(history);

        Log.d(TAG, "insertResult: 저장됨");

        setResult(Activity.RESULT_OK);

        finish();


    }

    //전체 불러오기
    private void loadAll(){

        HistoryDB historyDB = HistoryDB.getInstance(mContext);
        historyList = historyDB.historyDAO().getAll();

        historyAdapter.setHistoryList(historyList); //리스트 저장

    }

}