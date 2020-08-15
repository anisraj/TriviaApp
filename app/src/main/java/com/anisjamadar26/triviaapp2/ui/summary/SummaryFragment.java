package com.anisjamadar26.triviaapp2.ui.summary;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.anisjamadar26.triviaapp2.R;
import com.anisjamadar26.triviaapp2.entity.GameEntity;
import com.anisjamadar26.triviaapp2.ui.BestCricketerFragment;
import com.anisjamadar26.triviaapp2.ui.FlagQuesFragment;
import com.anisjamadar26.triviaapp2.ui.UserNameFragment;

import java.text.SimpleDateFormat;
import java.util.Date;

import static android.content.Context.MODE_PRIVATE;

public class SummaryFragment extends Fragment {

    private SummaryViewModel summaryViewModel;

    //getting views
    private TextView tvName;
    private TextView tvBestCricketer;
    private TextView tvFlagColors;
    private Button btnFinish;
    private Button btnSeeHistory;

    //declaring variables for shared preferences
    private SharedPreferences mPreferences;
    private String sharedPrefFile =
            "com.anisjamadar26.triviaapp.hellosharedprefs";
    private SharedPreferences.Editor preferencesEditor;

    //declaring variables for getting values from shared preferences
    private String userName;
    private String bestCricketer;
    private String flagColors;

    //Getting nav controller
    private NavController navController;

    public SummaryFragment() {
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
        View view = inflater.inflate(R.layout.fragment_summary, container, false);

        summaryViewModel = ViewModelProviders.of(getActivity()).get(SummaryViewModel.class);

        //initializing shared pref
        mPreferences = getActivity().getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        preferencesEditor = mPreferences.edit();

        //initializing views
        tvName = view.findViewById(R.id.textView4);
        tvBestCricketer = view.findViewById(R.id.textView_bestCrickAns);
        tvFlagColors = view.findViewById(R.id.textView_natFlagAns);
        btnFinish = view.findViewById(R.id.button_finish);
        btnSeeHistory = view.findViewById(R.id.button_seeHistory);

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAllScreens();
            }
        });

        btnSeeHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToHistory();
            }
        });

        //getting values from shared preferences
        userName = mPreferences.getString(UserNameFragment.USER_NAME_KEY, "");
        bestCricketer = mPreferences.getString(BestCricketerFragment.BEST_CRICK_KEY, "");
        flagColors = mPreferences.getString(FlagQuesFragment.FLAG_COLOR_KEY, "");

        //setting data to views
        tvName.setText("Hello "+userName+",");
        tvBestCricketer.setText("Answer:"+bestCricketer);
        tvFlagColors.setText("Answer:"+flagColors);

        //Getting and formatting date time
        SimpleDateFormat f = new SimpleDateFormat("MMM");
        SimpleDateFormat f1 = new SimpleDateFormat("dd");
        SimpleDateFormat f2 = new SimpleDateFormat("a");
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");

        String currentDate =""
                +f1.format(new Date())+"th "
                +f.format(new Date())+" "
                +sdf.format(new Date())+"";


        //Assigning nav controller
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        GameEntity gameEntity = new GameEntity(currentDate, userName, bestCricketer, flagColors);
        summaryViewModel.insert(gameEntity);

        return view;
    }

    private void finishAllScreens() {
        navController.navigate(R.id.action_summaryFragment_to_userNameFragment);
    }

    private void goToHistory() {
        navController.navigate(R.id.action_summaryFragment_to_historyFragment);
    }
}