package com.example.vis360;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Menu extends AppCompatActivity implements View.OnClickListener{


    private FirebaseAuth mAuth;
    private CardView dilosi,help,test,logout,stats;
    Context ta=this;
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
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        switch(v.getId()){

            case R.id.dilosi_menu:i= new Intent(this,Asthenia_Start.class);startActivity(i);break;
            case R.id.help_menu:i=new Intent(this,Helpp.class);startActivity(i);break;
            case R.id.test_menu:i=new Intent(this,DiseaseStatement_Start.class);startActivity(i);break;
            case R.id.logout_menu:
                Api.signOut(ta);
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i=new Intent(getApplicationContext(),MainActivity.class);

                        startActivity(i);



                    }
                }, 2000);


        }

    }
}
