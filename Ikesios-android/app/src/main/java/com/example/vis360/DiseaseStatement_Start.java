package com.example.vis360;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DiseaseStatement_Start extends AppCompatActivity {
Button me;
Button other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_statement__start);

        me=(Button)findViewById(R.id.start_me);
        other=(Button)findViewById(R.id.start_other);

        me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Disease_Habit.class);
                startActivity(i);
            }
        });

        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),DiseaseStatement_list.class);
                startActivity(i);
            }
        });
    }
}
