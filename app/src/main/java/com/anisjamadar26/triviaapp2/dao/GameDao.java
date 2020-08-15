package com.anisjamadar26.triviaapp2.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.anisjamadar26.triviaapp2.entity.GameEntity;

import java.util.List;

/**
 * The data access object, or Dao,
 * here I specify SQL queries and associate them with method calls.
 *
 * here I specify Insert operation and Get all Data operation
 */

@Dao
public interface GameDao {

    @Insert
    void insert(GameEntity gameEntity);

    @Query("SELECT * FROM game_history_table")
    LiveData<List<GameEntity>> getAllGameData();
}
