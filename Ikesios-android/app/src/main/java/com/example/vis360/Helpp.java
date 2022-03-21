package com.example.vis360;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.vis360.OfferHelp;
import com.example.vis360.R;

public class Helpp extends AppCompatActivity {

    Button ask,offer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpp);

        ask=(Button) findViewById(R.id.ask_help);
        offer=(Button) findViewById(R.id.offer_help);


        ask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askForHelp();
            }
        });

        offer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                offerHelp();
            }
        });
    }
    public void offerHelp(){
        Intent intent = new Intent(this, OfferHelp.class);
        startActivity(intent);
    }
    public void askForHelp(){
        Intent intent = new Intent(this, AskForHelp.class);
        startActivity(intent);
    }
}
