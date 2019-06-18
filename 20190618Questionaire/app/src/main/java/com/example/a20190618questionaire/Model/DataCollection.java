package com.example.a20190618questionaire.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataCollection implements Serializable {
    private List<Client> clientArray = new ArrayList<Client>();

    public List<Client> getClientArray() {
        return clientArray;
    }
}
