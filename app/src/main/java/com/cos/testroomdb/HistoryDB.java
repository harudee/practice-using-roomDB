package com.cos.testroomdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {History.class}, version = 1)
public abstract class HistoryDB extends RoomDatabase {
//entities 사용할 엔티티, version 엔티티 구조 변경 시 구분하려고

    private static HistoryDB INSTANCE = null;

    public abstract HistoryDAO historyDAO();

    //MainActivity에서 호출해서
    public static HistoryDB getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), HistoryDB.class, "history.db").build();
        }
        return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE = null;
    }

}
