package com.anisjamadar26.triviaapp2.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "game_history_table")
public class GameEntity {

    @PrimaryKey
    @NonNull
    @ColumnInfo
    private String dateTime;

    @ColumnInfo
    private String userName;

    @ColumnInfo
    private String bestCricketer;

    @ColumnInfo
    private String flagColors;

    public GameEntity(@NonNull String dateTime, String userName, String bestCricketer, String flagColors) {
        this.dateTime = dateTime;
        this.userName = userName;
        this.bestCricketer = bestCricketer;
        this.flagColors = flagColors;
    }

    @NonNull
    public String getDateTime() {
        return dateTime;
    }

    public String getUserName() {
        return userName;
    }

    public String getBestCricketer() {
        return bestCricketer;
    }

    public String getFlagColors() {
        return flagColors;
    }
}
