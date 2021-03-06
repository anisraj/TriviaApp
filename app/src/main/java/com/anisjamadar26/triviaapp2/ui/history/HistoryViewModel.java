package com.anisjamadar26.triviaapp2.ui.history;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.anisjamadar26.triviaapp2.entity.GameEntity;
import com.anisjamadar26.triviaapp2.repository.GameRepository;

import java.util.List;

/**
 * This class provide data to UI,
 * It is communication center between Repository and UI,
 * This provides all previously played game data
 */
public class HistoryViewModel extends AndroidViewModel {

    private GameRepository gameRepository;
    private LiveData<List<GameEntity>> allGameData;

    public HistoryViewModel(Application application) {
        super(application);
        gameRepository = new GameRepository(application);
        allGameData = gameRepository.getAllGameData();
    }

    public LiveData<List<GameEntity>> getAllGameData() {
        return allGameData;
    }
}
