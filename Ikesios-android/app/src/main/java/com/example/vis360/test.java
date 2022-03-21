package com.example.vis360;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class test extends AppCompatActivity implements View.OnClickListener{

    private CardView dilosi,help,test,logout,stats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        dilosi=(CardView)findViewById(R.id.dilosi_menu);
        help=(CardView)findViewById(R.id.help_menu);
        test=(CardView)findViewById(R.id.test_menu);
        logout=(CardView)findViewById(R.id.logout_menu);

        dilosi.setOnClickListener(this);
        help.setOnClickListener(this);

        test.setOnClickListener(this);

        logout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch(v.getId()){

            case R.id.dilosi_menu:i= new Intent(this,Asthenia_Start.class);startActivity(i);break;
            case R.id.help_menu:i=new Intent(this,Helpp.class);startActivity(i);break;
            case R.id.test_menu:i=new Intent(this,DiseaseStatement_Start.class);startActivity(i);break;
            case R.id.logout_menu:i=new Intent(this,MainActivity.class);startActivity(i);break;

        }

    }
}
