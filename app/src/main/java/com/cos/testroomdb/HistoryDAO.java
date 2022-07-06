package com.cos.testroomdb;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HistoryDAO {

    //insert, getAll, deleteAll
    //Data Access Object

    @Query("SELECT * FROM history")
    List<History> getAll();

    @Insert
    void insertAll(History... histories);

    @Delete
    void delete(History history);



}
