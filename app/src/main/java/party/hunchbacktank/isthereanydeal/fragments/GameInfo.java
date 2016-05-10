package party.hunchbacktank.isthereanydeal.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import party.hunchbacktank.isthereanydeal.R;

public class GameInfo extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String PLAIN = "plain";
    private static final String GAMEID = "gameId";
    private static final String PRIMARYSTORE = "primary_store";


    // TODO: Rename and change types of parameters
    private String plain;
    private int gameId;
    private String primaryStore;

    public GameInfo() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static GameInfo newInstance(String plain, String primaryStore, String gameId) {
        GameInfo fragment = new GameInfo();
        Bundle args = new Bundle();
        args.putString(PLAIN, plain);
        args.putString(PRIMARYSTORE, primaryStore);
        args.putString(GAMEID, gameId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            plain = getArguments().getString(PLAIN);
            gameId = Integer.parseInt(getArguments().getString(GAMEID));
            primaryStore = getArguments().getString(PRIMARYSTORE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_info, container, false);
    }
}
