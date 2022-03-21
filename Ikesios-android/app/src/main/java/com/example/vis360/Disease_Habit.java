package com.example.vis360;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Disease_Habit extends AppCompatActivity {
    Button final1;
    CheckBox r11,r12,r13,r14,r21,r22,r23,r24,r25,r26,r27,r31,r32,r33;
    List<Integer>  kardia;
    List<Integer> pneumoni;
    private FirebaseAuth mAuth;
    Context ta=this;

    List<Integer> alles;
    boolean kapnistis=false,piesi=false,diabitis=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease__habit);
        final1=(Button)findViewById(R.id.final_covid);

        kardia=new ArrayList<>();
        pneumoni=new ArrayList<>();
        alles=new ArrayList<>();
        r11=(CheckBox)findViewById(R.id.habit_kardiakiarithmia);
        r12=(CheckBox)findViewById(R.id.habit_apofraksi);
        r13=(CheckBox)findViewById(R.id.habit_siggenis);
        r14=(CheckBox)findViewById(R.id.habit_allikardiaki);

        r21=(CheckBox)findViewById(R.id.habit_asthma);
        r22=(CheckBox)findViewById(R.id.habit_emfisima);
        r23=(CheckBox)findViewById(R.id.habit_brogxitida);
        r24=(CheckBox)findViewById(R.id.habit_apofragmatiki);
        r25=(CheckBox)findViewById(R.id.habit_inosi);

        r26=(CheckBox)findViewById(R.id.habit_oidima);

        r27=(CheckBox)findViewById(R.id.habit_allianapneustiki);

        r31=(CheckBox)findViewById(R.id.habit_piesi);
        r32=(CheckBox)findViewById(R.id.habit_diabiti);
        r33=(CheckBox)findViewById(R.id.habit_kapnistis);




        final1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(r11.isChecked())
                    kardia.add(10);
                if(r12.isChecked())
                    kardia.add(15);
                if(r13.isChecked())
                    kardia.add(20);
                if(r14.isChecked())
                    kardia.add(25);
                if(r21.isChecked())
                    pneumoni.add(10);
                if(r22.isChecked())
                    pneumoni.add(15);
                if(r23.isChecked())
                    pneumoni.add(20);
                if(r24.isChecked())
                    pneumoni.add(25);
                if(r25.isChecked())
                    pneumoni.add(30);
                if(r26.isChecked())
                    pneumoni.add(35);
                if(r27.isChecked())
                    pneumoni.add(40);

                if(r31.isChecked())
                    piesi=true;
                if(r32.isChecked())
                    diabitis=true;
                if(r33.isChecked())
                    kapnistis=true;

                JSONObject jsonParam = new JSONObject();
                mAuth = FirebaseAuth.getInstance();
                FirebaseUser user = mAuth.getCurrentUser();
                try {
                    JSONArray kardies = new JSONArray();
                    JSONArray pneumonia = new JSONArray();


                        for (int num : kardia){

                            JSONObject test = new JSONObject();
                            test.put("HeartDiseases",num);
                            kardies.put(test);
                        }
                        for (int num : pneumoni){

                            JSONObject test = new JSONObject();
                            test.put("BreathingDiseases",num);
                            pneumonia.put(test);
                        }
                    Bundle extras = getIntent().getExtras();
                        int id=0;
                    if (extras != null) {
                         id=extras.getInt("Id");
                        jsonParam.put("OtherMemberID",id);
                    }

                        jsonParam.put("UserID", user.getUid());

                    jsonParam.put("BloodPressure", piesi);
                    jsonParam.put("Diabetes", diabitis);
                    jsonParam.put("Smoker", kapnistis);
                    jsonParam.put("HeartDiseases", kardies);
                    jsonParam.put("BreathingDiseases", pneumonia);


                    Api.post("Disease/BasicInfo", jsonParam.toString(), ta);
                    Toast.makeText(getApplicationContext(), "Η δήλωση καταχωρήθηκε επιτυχώς!! ", Toast.LENGTH_LONG).show();


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });


    }
}
