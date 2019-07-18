package com.example.a20190625customlist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a20190625customlist.XML_JSON.JSON_Paser;
import com.example.a20190625customlist.XML_JSON.XML_Parser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{
    Button button_json, button_xml;
    ListView listView;
    ArrayList<Flower> flowerArrayList;
    CellController_Base_Adapter cellController_base_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
       // initialistView();
        /*
        // display all the items when open this project
        listView = findViewById(R.id.listView);
        JSON_Paser json_paser = new JSON_Paser();
        flowerArrayList = new ArrayList<>();
        flowerArrayList = json_paser.processJSONFile(this,"flowers_json.json");
        cellController_base_adapter = new CellController_Base_Adapter(this, flowerArrayList);
        listView.setAdapter(cellController_base_adapter);
*/
        initializeCustomList();
    }

    private void initializeCustomList() {
        listView = findViewById(R.id.listView);

        flowerArrayList = new ArrayList<>();
        flowerArrayList.add(new Flower(122,"flower","Beautiful","asdf",22.22,"lithops.jpg"));
        flowerArrayList.add(new Flower(122,"flower","Beautiful","asdf",22.22,"pelargonium.jpg"));
        cellController_base_adapter = new CellController_Base_Adapter(this, flowerArrayList);
        listView.setAdapter(cellController_base_adapter);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
    }

    private void initialistView() {
        listView = findViewById(R.id.listView);
      //  listView.setOnItemClickListener(this);
        ArrayList<String> stringArrayList = new ArrayList<>();

        stringArrayList.add("a");
        stringArrayList.add("a");
        stringArrayList.add("a");
        flowerArrayList = new ArrayList<>();
        flowerArrayList.add(new Flower(122,"flower","Beautiful","asdf",22.22,"lithops.jpg"));
        ArrayAdapter<Flower> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, flowerArrayList);
        listView.setAdapter(listAdapter);
    }

    private void initialize() {
        button_json = findViewById(R.id.button_json);
        button_json.setOnClickListener(this);

        button_xml = findViewById(R.id.button_xml);
        button_xml.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.button_json:
                JSON_Paser json_paser = new JSON_Paser();
                flowerArrayList = json_paser.processJSONFile(this,"flowers_json.json");
                listView = findViewById(R.id.listView);
                cellController_base_adapter = new CellController_Base_Adapter(this, flowerArrayList);
                listView.setAdapter(cellController_base_adapter);
                break;

            case R.id.button_xml:
                XML_Parser xml_parser = new XML_Parser(this);
                flowerArrayList = xml_parser.parseXML();
              //  System.out.println(flowerArrayList);
                listView = findViewById(R.id.listView);
                cellController_base_adapter = new CellController_Base_Adapter(this, flowerArrayList);
                listView.setAdapter(cellController_base_adapter);
                break;
        }
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        startActivity(new Intent(this,FlowerDetailActivity.class));
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        showAlertDialog(view);
        return true;
    }

    private void showAlertDialog(View view) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("AlertDialog\njust a question for demo")
                .setMessage("Do you want to delete this file?")
                .setCancelable(false)
                .setIcon(android.R.drawable.ic_dialog_info)
                //
              .setPositiveButton("Yes",(dialogInterface,i) -> {
                    Toast.makeText(MainActivity.this, "It was just a test!", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("No", null)
                .setNeutralButton("Cancel", null);
        builder.show();
    }
}