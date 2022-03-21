package com.example.vis360;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Symptom_Check extends AppCompatActivity {
    RadioButton r11,r12,r13,r14,r15,r16,r21,r22,r23,r24,r31,r32,r33,r34,r41,r42,r43,r44,r51,r52,r53,r54,r61,r62,r63,r64,r71,r72,r73,r74;
    RadioButton r81,r82,r83,r84,r91,r92,r93,r94,r101,r102,r103,r104,r111,r112,r113,r114,r121,r122,r123,r124;
float flu=0,covid=0,cold=0;
boolean missing=false;
Context ta=this;
Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom__check);

        submit=(Button)findViewById(R.id.symptom_submit);
        r11 = (RadioButton) findViewById(R.id.symptom_1_1);
        r12 = (RadioButton) findViewById(R.id.symptom_1_2);
        r13 = (RadioButton) findViewById(R.id.symptom_1_3);
        r14 = (RadioButton) findViewById(R.id.symptom_1_4);
        r15 = (RadioButton) findViewById(R.id.symptom_1_5);
        r16 = (RadioButton) findViewById(R.id.symptom_1_6);

        r21 = (RadioButton) findViewById(R.id.symptom_2_1);
        r22 = (RadioButton) findViewById(R.id.symptom_2_2);
        r23 = (RadioButton) findViewById(R.id.symptom_2_3);
        r24 = (RadioButton) findViewById(R.id.symptom_2_4);

        r31 = (RadioButton) findViewById(R.id.symptom_3_1);
        r32 = (RadioButton) findViewById(R.id.symptom_3_2);
        r33 = (RadioButton) findViewById(R.id.symptom_3_3);
        r34 = (RadioButton) findViewById(R.id.symptom_3_4);

        r41 = (RadioButton) findViewById(R.id.symptom_4_1);
        r42 = (RadioButton) findViewById(R.id.symptom_4_2);
        r43 = (RadioButton) findViewById(R.id.symptom_4_3);
        r44 = (RadioButton) findViewById(R.id.symptom_4_4);

        r51 = (RadioButton) findViewById(R.id.symptom_5_1);
        r52 = (RadioButton) findViewById(R.id.symptom_5_2);
        r53 = (RadioButton) findViewById(R.id.symptom_5_3);
        r54 = (RadioButton) findViewById(R.id.symptom_5_4);

        r61 = (RadioButton) findViewById(R.id.symptom_6_1);
        r62 = (RadioButton) findViewById(R.id.symptom_6_2);
        r63 = (RadioButton) findViewById(R.id.symptom_6_3);
        r64 = (RadioButton) findViewById(R.id.symptom_6_4);

        r71 = (RadioButton) findViewById(R.id.symptom_7_1);
        r72 = (RadioButton) findViewById(R.id.symptom_7_2);
        r73 = (RadioButton) findViewById(R.id.symptom_7_3);
        r74 = (RadioButton) findViewById(R.id.symptom_7_4);

        r81 = (RadioButton) findViewById(R.id.symptom_8_1);
        r82 = (RadioButton) findViewById(R.id.symptom_8_2);
        r83 = (RadioButton) findViewById(R.id.symptom_8_3);
        r84 = (RadioButton) findViewById(R.id.symptom_8_4);

        r91 = (RadioButton) findViewById(R.id.symptom_9_1);
        r92 = (RadioButton) findViewById(R.id.symptom_9_2);
        r93 = (RadioButton) findViewById(R.id.symptom_9_3);
        r94 = (RadioButton) findViewById(R.id.symptom_9_4);

        r101 = (RadioButton) findViewById(R.id.symptom_10_1);
        r102 = (RadioButton) findViewById(R.id.symptom_10_2);
        r103 = (RadioButton) findViewById(R.id.symptom_10_3);
        r104 = (RadioButton) findViewById(R.id.symptom_10_4);

        r111 = (RadioButton) findViewById(R.id.symptom_11_1);
        r112 = (RadioButton) findViewById(R.id.symptom_11_2);
        r113 = (RadioButton) findViewById(R.id.symptom_11_3);
        r114 = (RadioButton) findViewById(R.id.symptom_11_4);

        r121 = (RadioButton) findViewById(R.id.symptom_12_1);
        r122 = (RadioButton) findViewById(R.id.symptom_12_2);
        r123 = (RadioButton) findViewById(R.id.symptom_12_3);
        r124 = (RadioButton) findViewById(R.id.symptom_12_4);

    submit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


        if (r11.isChecked()) {

            covid = covid - 1;
            flu = flu - 1;
            cold = cold - 1;
        } else if (r12.isChecked()) {

            covid = covid - 1;
            flu = flu - 1;
            cold = cold - 1;
        } else if (r13.isChecked()) {
            covid = covid + 1;
            flu = flu + 1;
            cold = cold + 0;
        } else if (r14.isChecked()) {
            covid = covid + 2;
            flu = flu + 2;
            cold = cold + 1;
        } else if (r15.isChecked()) {
            covid = covid + 3;
            flu = flu + 3;
            cold = cold + 1;
        } else if (r16.isChecked()) {
            covid = covid + 0;
            flu = flu + 0;
            cold = cold + 0;
        }

        if (r21.isChecked()) {
            System.out.println("edw eimai"+covid);
            covid = covid + 2;
            flu = flu + 2;
            cold = cold + 1;
        } else if (r22.isChecked()) {
            covid = covid + 3;
            flu = flu + 3;
            cold = cold + 1;
        } else if (r23.isChecked()) {
            covid = covid + 1;
            flu = flu + 1;
            cold = cold + 0;
        } else if (r24.isChecked()) {
            covid = covid + 0;
            flu = flu + 0;
            cold = cold + 0;
        }

        if (r31.isChecked()) {
            covid = covid + 3;
            flu = flu + 3;
            cold = cold - 1;
        } else if (r32.isChecked()) {
            covid = covid - 1;
            flu = flu - 1;
            cold = cold + 1;
        } else if (r33.isChecked()) {
            covid = covid - 1;
            flu = flu - 1;
            cold = cold - 1;
            System.out.println("edw eimai"+covid);

        } else if (r34.isChecked()) {
            covid = covid + 0;
            flu = flu + 0;
            cold = cold + 0;
        } else
            missing = false;

        if (r41.isChecked()) {
            covid = covid + 2;
            flu = flu + 2;
            cold = cold + 1;
        } else if (r42.isChecked()) {
            covid = covid + 3;
            flu = flu + 3;
            cold = cold + 1;
        } else if (r43.isChecked()) {
            covid = covid + 1;
            flu = flu + 1;
            cold = cold + 0;
        } else if (r44.isChecked()) {
            System.out.println("edw eimai"+covid);

            covid = covid + 0;
            flu = flu + 0;
            cold = cold + 0;
        }

        if (r51.isChecked()) {
            covid = covid - 1;
            flu = flu + 2;
            cold = cold + 3;
        } else if (r52.isChecked()) {
            covid = covid - 1;
            flu = flu + 1;
            cold = cold + 2;
        } else if (r53.isChecked()) {
            covid = covid - 1;
            flu = flu - 1;
            cold = cold - 1;
        } else if (r54.isChecked()) {
            covid = covid + 0;
            flu = flu + 0;
            cold = cold + 0;
        } else
            missing = true;

        if (r61.isChecked()) {
            covid = covid + 2;
            flu = flu + 2;
            cold = cold + 3;
        } else if (r62.isChecked()) {
            covid = covid + 1;
            flu = flu + 1;
            cold = cold + 2;
        } else if (r63.isChecked()) {
            covid = covid - 1;
            flu = flu - 1;
            cold = cold - 1;
        } else if (r64.isChecked()) {
            covid = covid + 0;
            flu = flu + 0;

            System.out.println("edw eimai"+covid);
            cold = cold + 0;
        } else
            missing = true;

        if (r71.isChecked()) {
            covid = covid + 2;
            flu = flu - 2;
            cold = cold - 2;
        } else if (r72.isChecked()) {
            covid = covid + 1;
            flu = flu - 1;
            cold = cold - 1;
        } else if (r73.isChecked()) {
            covid = covid - 1;
            flu = flu + 0;
            cold = cold + 0;
        } else if (r74.isChecked()) {
            covid = covid + 0;
            flu = flu + 0;
            cold = cold + 0;
        } else
            missing = true;

        if (r81.isChecked()) {
            covid = covid + 2;
            flu = flu + 3;
            cold = cold - 1;
        } else if (r82.isChecked()) {
            covid = covid + 1;
            flu = flu + 2;
            cold = cold - 1;
        } else if (r83.isChecked()) {
            covid = covid - 1;
            flu = flu - 1;
            cold = cold - 1;
        } else if (r84.isChecked()) {
            covid = covid + 0;
            flu = flu + 0;
            cold = cold + 0;
        }
        else
            missing=true;

        if(r91.isChecked()){
            covid = covid + 2;
            flu=flu+3;
            cold=cold+3;
        }
        else if(r92.isChecked()){
            covid = covid + 1;
            flu=flu+1;
            cold=cold+2;
        }
        else if(r93.isChecked()){
            covid = covid - 1;
            flu=flu-1;
            cold=cold-1;
        }
        else if(r94.isChecked()){
            covid = covid + 0;
            flu=flu+0;
            cold=cold+0;
        }
        else
            missing=true;

        if(r101.isChecked()){
            covid = covid -2;
            flu=flu-2;
            cold=cold+3;
        }
        else if(r102.isChecked()){
            covid = covid - 1;
            flu=flu-1;
            cold=cold+2;
        }
        else if(r103.isChecked()){
            covid = covid - 1;
            flu=flu-1;
            cold=cold-1;
        }
        else if(r104.isChecked()){
            covid = covid + 0;
            flu=flu+0;
            cold=cold+0;
        }
        else
            missing=true;

        if (r111.isChecked()){
            covid = covid + 2;
            flu=flu+3;
            cold=cold+2;
        }
        else if(r112.isChecked()){
            covid = covid + 1;
            flu=flu+2;
            cold=cold+1;
        }
        else if(r113.isChecked()){
            covid = covid - 1;
            flu=flu-1;
            cold=cold-1;
        }
        else if(r114.isChecked()){
            covid = covid + 0;
            flu=flu+0;
            cold=cold+0;
            System.out.println("edw eimai"+covid);

        }
        else
            missing=true;

        if (r121.isChecked()){
            covid = covid - 1;
            flu=flu+2;
            cold=cold-2;
        }
        else if(r122.isChecked()){
            covid = covid - 1;
            flu=flu+1;
            cold=cold-1;
        }
        else if(r123.isChecked()){
            covid = covid - 1;
            flu=flu-1;
            cold=cold-1;
        }
        else if(r124.isChecked()){
            covid = covid + 0;
            flu=flu+0;
            cold=cold+0;
        }
        else
            missing=true;

            System.out.println("edw eimaiii"+covid);

            covid=(covid/21)*100;
        flu=(flu/25)*100;
        cold=(cold/15)*100;

        System.out.println("edw eimai"+covid+flu+cold);
            AlertDialog.Builder builder = new AlertDialog.Builder(ta);

         builder.setMessage("\nΣυμβατότητα Covid: "+covid+"%\n\nΣυμβατότητα Cold: "+cold+"%\n\nΣυμβατότητα Flue: "+flu+"%")
                 .setTitle("        Αποτελέσματα")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // FIRE ZE MISSILES!
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User cancelled the dialog
                        }
                    });
            // Create the AlertDialog object and return it
           builder.create();
           builder.show();
           flu=0;
           cold=0;
           covid=0;
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                   Intent i=new Intent(getApplicationContext(),Menu.class);
                   startActivity(i);

                }
            }, 4000);





    }
    });
    }

        }


