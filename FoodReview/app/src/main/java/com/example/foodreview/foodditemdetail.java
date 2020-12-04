package com.example.foodreview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class foodditemdetail extends AppCompatActivity {

    TextView a,b,c,d;
    ImageView ig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodditemdetail);

        a=findViewById(R.id.fdname);
        b=findViewById(R.id.fddiscription);
        c=findViewById(R.id.fdrate);
        d=findViewById(R.id.fdlink);
        ig=findViewById(R.id.imageView);

        Intent i = getIntent();
        if(i!= null){
            a.setText(i.getStringExtra("fname"));
            b.setText(i.getStringExtra("fdis"));
            c.setText(i.getDoubleExtra("frate",3.5)+"");
            d.setText(i.getStringExtra("flink"));
            Picasso.get().load(i.getStringExtra("fimg")).into(ig);
            d.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String str =d.getText().toString();
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(str));
                    startActivity(intent);
                }
            });
        }
    }
}