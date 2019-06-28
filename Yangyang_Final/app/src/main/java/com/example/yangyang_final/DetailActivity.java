package com.example.yangyang_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yangyang_final.model.Account;
import com.example.yangyang_final.model.Customer;

import java.util.Iterator;

import static com.example.yangyang_final.MainActivity.cellController_base_adapter;
import static com.example.yangyang_final.MainActivity.customersList;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText_name, editText_family, editText_phone, editText_sin, editText_ac, editText_openDate, editText_balance;
    Button button_add, button_find, button_remove, button_update, button_save, button_load, button_clear, button_show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initialize();
        getMyIntent();
    }

    private void getMyIntent() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String famly = intent.getStringExtra("family");
        String phone = intent.getStringExtra("phone");
        String sin = intent.getStringExtra("sin");
        String acNo = intent.getStringExtra("acNo");
        String balance = intent.getStringExtra("balance");
        String openDate = intent.getStringExtra("openDate");

        editText_name.setText("Name: " + name);
        editText_family.setText("Family: " + famly);
        editText_phone.setText("Phone: " + phone);
        editText_sin.setText("SIN: " + sin);
        editText_ac.setText("Account Number: " + acNo);
        editText_balance.setText("Balance: " + balance);
        editText_openDate.setText("Open Date: " + openDate);

    }

    private void initialize() {
        editText_name = findViewById(R.id.editText_name);
        editText_family = findViewById(R.id.editText_family);
        editText_phone = findViewById(R.id.editText_phone);
        editText_sin = findViewById(R.id.editText_sin);
        button_add = findViewById(R.id.button_add);
        button_add.setOnClickListener(this);
        button_find = findViewById(R.id.button_find);
        button_find.setOnClickListener(this);
        button_remove = findViewById(R.id.button_remove);
        button_remove.setOnClickListener(this);
        button_update = findViewById(R.id.button_update);
        button_update.setOnClickListener(this);
        editText_ac = findViewById(R.id.editText_ac);
        editText_openDate = findViewById(R.id.editText_openDate);
        editText_balance = findViewById(R.id.editText__balance);
        button_save = findViewById(R.id.button_save);
        button_save.setOnClickListener(this);
        button_load = findViewById(R.id.button_load);
        button_load.setOnClickListener(this);
        button_clear = findViewById(R.id.button_clear);
        button_clear.setOnClickListener(this);
        button_show = findViewById(R.id.button_show);
        button_show.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int btnId = view.getId();
        switch (btnId) {
            case R.id.button_add:
                addCustomer();
                break;
            case R.id.button_clear:
                clear();
                break;
            case R.id.button_show:
                showAll();
                break;
            case R.id.button_find:
                findBySIN();
                break;
            case R.id.button_remove:
                removeBySIN();
                break;
            case R.id.button_update:
                update();
                break;
        }
    }

    private void update() {
        Iterator<Customer> itr = customersList.iterator();
        while (itr.hasNext()) {
            Customer c = itr.next();
            if (c.getSin().equals(editText_sin.getText().toString())) {
                c.setName(editText_name.getText().toString());
                c.setFamily(editText_family.getText().toString());
                c.setPhone(editText_phone.getText().toString());
                c.getAccount().setAccountNumber(Long.valueOf(editText_ac.getText().toString()));
                c.getAccount().setBalance(Double.valueOf(editText_balance.getText().toString()));
                c.getAccount().setOpendate(editText_ac.getText().toString());

                Toast.makeText(this, "You have updated this person!", Toast.LENGTH_SHORT).show();
            }
        }
        System.out.println(customersList);
    }

    private void removeBySIN() {
        Iterator<Customer> itr = customersList.iterator();
        while (itr.hasNext()) {
            Customer c = itr.next();
            if (c.getSin().equals(editText_sin.getText().toString())) {
                itr.remove();
                Toast.makeText(this, "You have removed this person!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void findBySIN() {
        Iterator<Customer> itr = customersList.iterator();
        while (itr.hasNext()) {
            Customer c = itr.next();
            if (c.getSin().equals(editText_sin.getText().toString())) {
                Toast.makeText(this, "You have found this person!", Toast.LENGTH_SHORT).show();
                editText_name.setText(c.getName());
                editText_family.setText(c.getFamily());
                editText_phone.setText(c.getPhone());
                editText_ac.setText(String.valueOf(c.getAccount().getAccountNumber()));
                editText_openDate.setText(c.getAccount().getOpendate());
                editText_balance.setText(String.valueOf(c.getAccount().getBalance()));
            }
        }
    }

    private void showAll() {

     /*   Intent myIntent = new Intent(this, MainActivity.class);
        myIntent.putExtra("list", customersList);
        startActivity(myIntent);
      */
   //FIXME
        cellController_base_adapter = new CellController_Base_Adapter(this, customersList);
        MainActivity.listView.setAdapter(cellController_base_adapter);
        startActivity(new Intent(DetailActivity.this, MainActivity.class));
    }

    private void clear() {
        editText_ac.setText("");
        editText_openDate.setText("");
        editText_balance.setText("");
        editText_sin.setText("");
        editText_phone.setText("");
        editText_family.setText("");
        editText_name.setText("");
    }

    private void addCustomer() {
        // handle exception of null
        String acNo = editText_ac.getText().toString();
        if(acNo == null){
            editText_ac.setText("0");
        }
        for(int i = 0; i < customersList.size(); i++){
            if(acNo.equals(customersList.get(i).getAccount().getAccountNumber())){
                Toast.makeText(this, "Account Number is Unique!", Toast.LENGTH_SHORT).show();
            }
        }

        String balance = editText_balance.getText().toString();
        if(balance == null){
            editText_balance.setText("0");
        }



        Account account = new Account(Long.valueOf(editText_ac.getText().toString()),Double.valueOf(editText_balance.getText().toString()), editText_openDate.getText().toString());
        Customer customer = new Customer(editText_name.getText().toString(),
                editText_family.getText().toString(),
                editText_phone.getText().toString(),
                editText_sin.getText().toString(),account);
        customersList.add(customer);
        Toast.makeText(this, "You have added a new customer!", Toast.LENGTH_SHORT).show();
        System.out.println(customersList);
    }
}
