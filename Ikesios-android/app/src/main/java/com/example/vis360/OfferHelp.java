package com.example.vis360;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONException;
import org.json.JSONObject;

public class OfferHelp extends AppCompatActivity {

    Button submit;
    private FirebaseAuth mAuth;
    RadioButton psonia,spiti,texnologiko,miliso,iatriki,alli;
    Context ta=this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_help);

        psonia=(RadioButton) findViewById(R.id.offerhelp_psonia);
        spiti=(RadioButton)findViewById(R.id.offerhelp_spiti);
        texnologiko=(RadioButton)findViewById(R.id.offerhelp_texnologiko);
        miliso=(RadioButton)findViewById(R.id.offerhelp_miliso);
        iatriki=(RadioButton)findViewById(R.id.offerhelp_iatriki);
        alli=(RadioButton)findViewById(R.id.offerhelp_alli);

        submit=(Button)findViewById(R.id.offerhelp_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int help_type=0;
                if(psonia.isChecked())
                    help_type=10;
                else if (spiti.isChecked())
                    help_type=15;
                else if (texnologiko.isChecked())
                    help_type=20;
                else if (miliso.isChecked())
                    help_type=25;
                else if (iatriki.isChecked())
                    help_type=30;
                else if(alli.isChecked())
                    help_type=35;

                mAuth = FirebaseAuth.getInstance();
                FirebaseUser user = mAuth.getCurrentUser();
                JSONObject jsonParam = new JSONObject();

                try {
                    jsonParam.put("UserID", user.getUid());
                    jsonParam.put("HelpType", help_type);


                    Api.post("Help/Offer", jsonParam.toString(), ta);
                    Toast.makeText(getApplicationContext(), "Το αίτημα για παροχή βοήθειας καταχωρήθηκε επιτυχώς!! ", Toast.LENGTH_LONG).show();
                    Intent i=new Intent(getApplicationContext(),Menu.class);
                    startActivity(i);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
