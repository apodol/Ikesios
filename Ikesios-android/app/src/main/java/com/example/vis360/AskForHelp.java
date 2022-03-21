package com.example.vis360;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AskForHelp extends AppCompatActivity {

    RadioGroup radioGroup,radioGroup2,radioGroup3;
    RadioButton gia_emena,other,psonia,spiti,texnologiko,miliso,iatriki,allo;
    Button submit;
    SwitchMaterial switch1,switch2;
    Context ta=this;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_for_help);



        gia_emena=(RadioButton)findViewById(R.id.askforhelp_me);
        spiti=(RadioButton)findViewById(R.id.askforhelp_spiti);
        psonia=(RadioButton)findViewById(R.id.askforhelp_psonia);
        texnologiko=(RadioButton)findViewById(R.id.askforhelp_texnologia);
        miliso=(RadioButton)findViewById(R.id.askforhelp_miliso);
        iatriki=(RadioButton)findViewById(R.id.askforhelp_iatriki);
        allo=(RadioButton)findViewById(R.id.askforhelp_alli);
        switch1=(SwitchMaterial) findViewById(R.id.askforhelp_switch1);
        switch2=(SwitchMaterial) findViewById(R.id.askforhelp_switch2);
        submit=(Button)findViewById(R.id.askforhelp_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int help_type=0;
                if(psonia.isChecked())
                    help_type=10;
                else if(spiti.isChecked())
                    help_type=15;
                else if (texnologiko.isChecked())
                    help_type=20;
                else if(miliso.isChecked())
                    help_type=25;
                else if(iatriki.isChecked())
                    help_type=30;
                else if(allo.isChecked())
                    help_type=35;

                boolean town_push=false;
                boolean volunteer_push=false;
                if(switch1.isChecked())
                    volunteer_push=true;
                if(switch2.isChecked())
                    town_push=true;


                mAuth = FirebaseAuth.getInstance();
                FirebaseUser user = mAuth.getCurrentUser();
                JSONObject jsonParam = new JSONObject();

                try {
                    jsonParam.put("UserID", user.getUid());
                    jsonParam.put("HelpType", help_type);
                    jsonParam.put("VolunteerPush", volunteer_push);
                    jsonParam.put("TownPush", town_push);


                    Api.post("Help/Need", jsonParam.toString(), ta);
                    Toast.makeText(getApplicationContext(), "Το αίτημα για βοήθεια καταχωρήθηκε επιτυχώς!! ", Toast.LENGTH_LONG).show();

                    Intent i=new Intent(getApplicationContext(),Menu.class);
                    startActivity(i);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });


}}