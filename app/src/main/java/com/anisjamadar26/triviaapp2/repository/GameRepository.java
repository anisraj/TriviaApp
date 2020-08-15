package com.anisjamadar26.triviaapp2.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.anisjamadar26.triviaapp2.dao.GameDao;
import com.anisjamadar26.triviaapp2.database.GameRoomDatabase;
import com.anisjamadar26.triviaapp2.entity.GameEntity;

import java.util.List;

/**
 * This Repository is a class that can access multiple data sources,
 * used for for code separation and good architecture.
 *
 * So here I have Room Database access, and from that I get LiveData,
 * used LiveData class for observe data
 */

public class GameRepository {
    private GameDao gameDao;
    private LiveData<List<GameEntity>> allGameData;

    public GameRepository(Application application) {
        GameRoomDatabase gameRoomDatabase = GameRoomDatabase.getInstance(application);
        gameDao = gameRoomDatabase.gameDao();
        allGameData = gameDao.getAllGameData();
    }

    public LiveData<List<GameEntity>> getAllGameData() {
        return allGameData;
    }

    public void insert(GameEntity gameEntity) {
        new InsertAsyncTask(gameDao).execute(gameEntity);
    }

    /**
     * for insert operation used AsyncTask, so our ui will not freeze
     */

    private static class InsertAsyncTask extends AsyncTask<GameEntity, Void, Void> {
        private GameDao asyncTaskDao;

        public InsertAsyncTask(GameDao gameDao) {
            this.asyncTaskDao = gameDao;
        }

        @Override
        protected Void doInBackground(GameEntity... gameEntities) {
            asyncTaskDao.insert(gameEntities[0]);
            return null;
        }
    }
}
