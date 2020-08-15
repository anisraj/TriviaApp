package com.anisjamadar26.triviaapp2.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.anisjamadar26.triviaapp2.dao.GameDao;
import com.anisjamadar26.triviaapp2.entity.GameEntity;

/**
 * Room uses the DAO to issue queries to its database
 * Usually, we only need one instance of the Room database for the whole app,
 * so I code for getting only single instance of room database
 */

@Database(entities = {GameEntity.class}, version = 1, exportSchema = false)
public abstract class GameRoomDatabase extends RoomDatabase {

    public abstract GameDao gameDao();

    private static GameRoomDatabase INSTANCE;

    public static GameRoomDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (GameRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),GameRoomDatabase.class,"dbname")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
