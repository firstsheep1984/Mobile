package com.example.a20190625customlist.XML_JSON;

import android.content.Context;
import android.content.res.AssetManager;
import android.widget.Toast;

import com.example.a20190625customlist.Flower;
import com.example.a20190625customlist.MainActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class JSON_Paser {
    ArrayList<Flower> flowerArrayList = new ArrayList<>();
    private InputStreamReader inputStreamReader;

    public void processJSONData(String data) {
        try {
            // JSONObject jsonobject = new JSONObject(data);
            // JSONArray jsonarray = jsonobject.getJSONArray("");

            JSONArray jsonArray = new JSONArray(data);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject currentJSONFlowerObject = jsonArray.getJSONObject(i);
                int productId = currentJSONFlowerObject.getInt("productId");
                String category = currentJSONFlowerObject.getString("category");
                String name = currentJSONFlowerObject.getString("name");
                String instructions = currentJSONFlowerObject.getString("instructions");
                double price = currentJSONFlowerObject.getDouble("price");
                String photo = currentJSONFlowerObject.getString("photo");

                Flower currentFlower = new Flower(productId, category, name, instructions, price, photo);
                flowerArrayList.add(currentFlower);
            }
       //     Toast.makeText(context, "The total should be <= 18", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Flower> processJSONFile(Context context, String fileName) {
        AssetManager assetManager = context.getResources().getAssets();
        try {
            // pass filename to assetManager.open(fileName). In next step pass it to InputStreamReader
            inputStreamReader = new InputStreamReader(assetManager.open(fileName));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String oneline = null;
            StringBuilder stringBuilder = new StringBuilder();

            while ((oneline = bufferedReader.readLine()) != null) {
                stringBuilder.append(oneline);
            }
            bufferedReader.close();
            inputStreamReader.close();
            //TEST:
            // Toast.makeText(context,"lalal",Toast.LENGTH_LONG).show();
            processJSONData(stringBuilder.toString());
          //  Toast.makeText(context, flowerArrayList.toString(), Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flowerArrayList;
    }
}
