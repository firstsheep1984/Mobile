package com.example.yangyang_final;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yangyang_final.model.Customer;

import java.util.ArrayList;

public class CellController_Base_Adapter extends BaseAdapter {
    Context context;
    ArrayList<Customer> customersList;

    public CellController_Base_Adapter(Context context, ArrayList<Customer> customersList) {
        this.context = context;
        this.customersList = customersList;
    }

    @Override
    public int getCount() {
        return customersList.size();
    }

    @Override
    public Object getItem(int position) {
        return customersList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View cellReusableViewObject, ViewGroup parent) {
        Customer customer = customersList.get(position);
        //
        if(cellReusableViewObject == null){
            //
            cellReusableViewObject = LayoutInflater.from(context).inflate(R.layout.cell_custom, parent, false);
        }
        TextView textView_name = cellReusableViewObject.findViewById(R.id.textView_name);
        TextView textView_family = cellReusableViewObject.findViewById(R.id.textView_family);
        TextView textView_acNo = cellReusableViewObject.findViewById(R.id.textView_acNo);

        textView_name.setText("Name: " + customer.getName());
        textView_family.setText("Family: "+ customer.getFamily());
        textView_acNo.setText("Account Number: " + String.valueOf(customer.getAccount().getAccountNumber()));

        return cellReusableViewObject;
    }
}
