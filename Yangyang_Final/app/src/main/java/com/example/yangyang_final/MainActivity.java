package com.example.yangyang_final;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.yangyang_final.model.Account;
import com.example.yangyang_final.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{
    ImageButton imageButton;
    static ListView listView;
    static ArrayList<Customer> customersList;
    static CellController_Base_Adapter cellController_base_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        initializeCustomList();
    }


    private void initializeCustomList() {
        listView = findViewById(R.id.listView);

        customersList = new ArrayList<>();
        Account account1 = new Account(11223,22.33, "2019-05-06");
        Account account2 = new Account(11225,29.33, "2016-07-08");
        Account account3 = new Account(11227,33.33, "2018-05-06");

        customersList.add(new Customer("Alan","Liu","5156667777","123456789",account1));
        customersList.add(new Customer("Lan","Lee","5156555777","543456789",account2));
        customersList.add(new Customer("Laa","Mi","4386555777","666656789",account3));
     //   ArrayAdapter<Customer> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, customersList);
     //   listView.setAdapter(listAdapter);
        cellController_base_adapter = new CellController_Base_Adapter(this, customersList);
        listView.setAdapter(cellController_base_adapter);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
    }

    private void initialize() {
        imageButton = findViewById(R.id.imageButton);
    }

    public void addNew(View view) {
        startActivity(new Intent(MainActivity.this, DetailActivity.class));
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String balance = String.valueOf(customersList.get(i).getAccount().getBalance());
        Intent myIntent = new Intent(this, WithdrawActivity.class);
        myIntent.putExtra("balance", balance);
        startActivity(myIntent);

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        String name = customersList.get(i).getName();
        String family = customersList.get(i).getFamily();
        String phone = customersList.get(i).getPhone();
        String sin = customersList.get(i).getSin();
        String acNo = String.valueOf(customersList.get(i).getAccount().getAccountNumber());
        String balance = String.valueOf(customersList.get(i).getAccount().getBalance());
        String openDate = customersList.get(i).getAccount().getOpendate();
        Intent myIntent = new Intent(this, DetailActivity.class);
        myIntent.putExtra("name", name);
        myIntent.putExtra("family", family);
        myIntent.putExtra("phone", phone);
        myIntent.putExtra("sin", sin);
        myIntent.putExtra("acNo", acNo);
        myIntent.putExtra("balance", balance);
        myIntent.putExtra("openDate", openDate);

        startActivity(myIntent);

        return true;
    }


}
