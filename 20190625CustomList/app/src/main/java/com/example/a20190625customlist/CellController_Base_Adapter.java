package com.example.a20190625customlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CellController_Base_Adapter extends BaseAdapter {
    Context context;
    ArrayList<Flower> flowerArrayList;

    public CellController_Base_Adapter(Context context, ArrayList<Flower> flowerArrayList) {
        this.context = context;
        this.flowerArrayList = flowerArrayList;
    }

    @Override
    public int getCount() {
        return flowerArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return flowerArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View cellReusableViewObject, ViewGroup parent) {
        Flower flower = flowerArrayList.get(position);
        //
        if(cellReusableViewObject == null){
            //
            cellReusableViewObject = LayoutInflater.from(context).inflate(R.layout.cell_custom, parent, false);
        }
        TextView textView_title = cellReusableViewObject.findViewById(R.id.textView_title);
        TextView textView_price = cellReusableViewObject.findViewById(R.id.textView_price);
        TextView textView_description = cellReusableViewObject.findViewById(R.id.textView_description);
        ImageView cell_imageView= cellReusableViewObject.findViewById(R.id.imageView);

        textView_title.setText(flower.getName());
        textView_price.setText(String.valueOf(flower.getPrice() + "$"));
        textView_description.setText(flower.getInstructions());

        //load image
        String photoName = flower.getPhoto();
        if(photoName.contains(".")){
            //remove file extension from file name
            photoName = photoName.substring(0, photoName.lastIndexOf("."));
        }
        int imageResId = context.getResources().getIdentifier(photoName, "drawable",context.getApplicationContext().getPackageName());
        cell_imageView.setImageResource(imageResId);
        return cellReusableViewObject;
    }
}
