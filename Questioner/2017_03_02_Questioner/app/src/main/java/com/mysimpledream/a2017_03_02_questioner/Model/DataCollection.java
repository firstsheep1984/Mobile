package com.mysimpledream.a2017_03_02_questioner.Model;

import com.mysimpledream.a2017_03_02_questioner.Model.Client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by masoud on 2017-03-02.
 */

public class DataCollection implements Serializable{

    private List<Client> clientArray = new ArrayList<Client>();

    public List<Client> getClientArray() {
        return clientArray;
    }
}