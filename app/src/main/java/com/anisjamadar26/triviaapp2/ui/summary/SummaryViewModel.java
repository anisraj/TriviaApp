package com.anisjamadar26.triviaapp2.ui.summary;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.anisjamadar26.triviaapp2.entity.GameEntity;
import com.anisjamadar26.triviaapp2.repository.GameRepository;

import java.util.List;

/**
 * In this viewmodel class , I get access to repository class and just save the data
 */

public class SummaryViewModel extends AndroidViewModel {
    private GameRepository gameRepository;

    public SummaryViewModel(Application application) {
        super(application);
        gameRepository = new GameRepository(application);
    }

    public void insert(GameEntity gameEntity) {
        gameRepository.insert(gameEntity);
    }
}
