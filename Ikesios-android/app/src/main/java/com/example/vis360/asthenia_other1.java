package com.example.vis360;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONException;
import org.json.JSONObject;

public class asthenia_other1 extends AppCompatActivity {

    Button next;
    TextInputLayout onoma,ilikia,poli,atoma;
    RadioButton arseniko,thiliko;
    Context ta=this;
    private FirebaseAuth mAuth;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asthenia_other1);
        mAuth = FirebaseAuth.getInstance();
        final FirebaseUser user = mAuth.getCurrentUser();


        next=(Button)findViewById(R.id.asthenia_other1_finalstep);

        onoma=(TextInputLayout) findViewById(R.id.asthenia_other1_name);
        ilikia=(TextInputLayout) findViewById(R.id.asthenia_other1_ilikia);
        poli=(TextInputLayout) findViewById(R.id.asthenia_other1_poli);
        atoma=(TextInputLayout) findViewById(R.id.asthenia_other1_atoma);
        arseniko=(RadioButton)findViewById(R.id.asthenia_other1_filo_arseniko);
        thiliko=(RadioButton)findViewById(R.id.asthenia_other1_filo_thiliko);




        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=onoma.getEditText().getText().toString();
                String age=ilikia.getEditText().getText().toString();
                String town=poli.getEditText().getText().toString();
                String people=atoma.getEditText().getText().toString();
                int filo=0;
                if (arseniko.isChecked()){
                     filo=10;
                }
                else if (thiliko.isChecked()){
                   filo=15;
                }

                JSONObject jsonParam = new JSONObject();
                try {

                    jsonParam.put("UserID", user.getUid());
                    jsonParam.put("Name", name);
                    jsonParam.put("Age", Integer.parseInt(age));
                    jsonParam.put("Gender", filo);
                    jsonParam.put("City", town);
                    jsonParam.put("PeopleLivingWith",Integer.parseInt(people));

                    Api.post("Account/AddOtherMember",jsonParam.toString(),ta);

                } catch (JSONException e) {
                    e.printStackTrace();
                }


                final Handler handler = new Handler();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i=new Intent(getApplicationContext(),asthenia_list.class);
                        startActivity(i);

                    }
                }, 4000);


            }
        });
    }
}
