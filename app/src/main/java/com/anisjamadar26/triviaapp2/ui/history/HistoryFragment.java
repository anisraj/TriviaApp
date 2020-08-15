package com.anisjamadar26.triviaapp2.ui.history;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anisjamadar26.triviaapp2.R;
import com.anisjamadar26.triviaapp2.entity.GameEntity;

import java.util.List;

/**
 * This is fragment I used to show history of previous games,
 * in layout used recyclerview,
 * and for attaching data to recyclerview used adapter,
 * for getting data from database used ViewModel
 */


public class HistoryFragment extends Fragment {
    private RecyclerView recyclerView;
    private HistoryViewModel historyViewModel;

    public HistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        historyViewModel = ViewModelProviders.of(getActivity()).get(HistoryViewModel.class);
        recyclerView = view.findViewById(R.id.recyclerView_history);
        final HistoryDataAdapter adapter = new HistoryDataAdapter(getActivity());

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        historyViewModel.getAllGameData().observe(getActivity(), new Observer<List<GameEntity>>() {
            @Override
            public void onChanged(List<GameEntity> gameEntities) {
                adapter.setGameEntities(gameEntities);
            }
        });

        recyclerView.setAdapter(adapter);
        return view;
    }
}