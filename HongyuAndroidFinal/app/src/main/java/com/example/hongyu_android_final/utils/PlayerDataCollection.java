package com.example.hongyu_android_final.utils;

import com.example.hongyu_android_final.Model.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlayerDataCollection implements Serializable {

    private static List<Player> playerList;

    public PlayerDataCollection(){

        playerList = new ArrayList<>();
    }

    public static List<Player> getPlayerList(){

        return playerList;

    }


}
