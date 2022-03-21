package com.example.vis360;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Asthenia_Start extends AppCompatActivity {
Button me;
Button other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asthenia__start);

        me=(Button)findViewById(R.id.asthenia_me);
        other=(Button)findViewById(R.id.asthenia_other);

        me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),asthenia_final.class);
                startActivity(i);
            }
        });

        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),asthenia_list.class);
                startActivity(i);
            }
        });


    }
}
