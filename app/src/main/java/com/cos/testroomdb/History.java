package com.cos.testroomdb;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "history")
public class History {
    //get/set field values
    //클래스에 뭐뭐 넣을지 정함

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String expression;

    @ColumnInfo(name = "answer")
    public String result;


}
