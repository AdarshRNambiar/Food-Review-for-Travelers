package com.example.foodreview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UserAdding_item extends AppCompatActivity {

    EditText name,discription,image,link,rating;
    Spinner district;
    ArrayAdapter<String> dis;
    String arr[];
    Button add;
    FoodHelperDb fdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_adding_item);

        fdb =new FoodHelperDb(UserAdding_item.this);

        name=(EditText)findViewById(R.id.nam);
        discription=(EditText)findViewById(R.id.disc);
        image=(EditText)findViewById(R.id.imgli);
        link=(EditText)findViewById(R.id.url);
        rating=(EditText)findViewById(R.id.rate);
        district=(Spinner)findViewById(R.id.spinner);
        add=(Button)findViewById(R.id.addingbtn);


        arr=new String[]{"Kasaragod","Kannur","Kozhikode","Wayanad","Malappuram","Palakkad","Thrissur","Ernakulam","Idukki","Kottayam","Alappuzha","Pathanamthitta","Kollam","Thiruvananthapuram","Common items"};

        dis=new ArrayAdapter<String>(UserAdding_item.this,android.R.layout.simple_list_item_1,arr);
        district.setAdapter(dis);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!name.getText().toString().equals("")&&!discription.getText().toString().equals("")&&!image.getText().toString().equals("")&&!link.getText().toString().equals("")&&!rating.getText().toString().equals("")){
                    fdb.addingitem(district.getSelectedItem().toString(),name.getText().toString(),image.getText().toString(),Double.parseDouble(rating.getText().toString()),discription.getText().toString(),link.getText().toString());
                    Toast.makeText(getApplicationContext(),"Successfully added",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"notadded",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}