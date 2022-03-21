package com.example.vis360;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class asthenia_final extends AppCompatActivity implements  DatePickerDialog.OnDateSetListener{

    private FirebaseAuth mAuth;
Button submit;
RadioButton radio1,radio2,radio3;
String date_pistopiisi;
String date_nosokomio;
Date date_pistopiisi_date;
Date date_nosokomio_date;

    TextInputLayout nosokomio;
    TextInputLayout pistopiisi;
    TextInputLayout onoma_nosokomiou;
    TextInputLayout helper;
    Button ipoboli;
    Context ta=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asthenia_final);

        submit=(Button)findViewById(R.id.asthenia_final_submit);
        radio1=(RadioButton) findViewById(R.id.asthenia_final_radiobutton1);
        radio2=(RadioButton) findViewById(R.id.asthenia_final_radiobutton2);
        radio3=(RadioButton) findViewById(R.id.asthenia_final_radiobutton3);
        pistopiisi=(TextInputLayout) findViewById(R.id.asthenia_final_date1);
        nosokomio=(TextInputLayout) findViewById(R.id.asthenia_final_date2);
        onoma_nosokomiou=(TextInputLayout)findViewById(R.id.asthenia_final_nosokomio);
        int xronos = Calendar.getInstance().get(Calendar.YEAR);
        int minas = Calendar.getInstance().get(Calendar.MONTH);
        int mera = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        date_pistopiisi = (xronos + "-" + minas + "-" + mera);
        date_nosokomio = (xronos + "-" + minas + "-" + mera);
        pistopiisi.getEditText().setText(date_pistopiisi);
        nosokomio.getEditText().setText(date_nosokomio);

    ipoboli=(Button)findViewById(R.id.asthenia_final_submit);
    ipoboli.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if( (radio1.isChecked() || radio2.isChecked() || radio3.isChecked()) && (!onoma_nosokomiou.getEditText().getText().toString().equals("")))
            {
                int xronos = Calendar.getInstance().get(Calendar.YEAR);
                int minas = Calendar.getInstance().get(Calendar.MONTH);
                int mera = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);



                Bundle bundle = getIntent().getExtras();
                int id;
                if (bundle != null) {
                    id = bundle.getInt("Id");
                } else {
                    id = 0;
                }
                mAuth = FirebaseAuth.getInstance();
                FirebaseUser user = mAuth.getCurrentUser();

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    date_pistopiisi_date = dateFormat.parse(date_pistopiisi);
                    date_nosokomio_date = dateFormat.parse(date_nosokomio);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                int diagnosi = 0;
                if (radio1.isChecked()) {
                    diagnosi = 10;
                } else if (radio2.isChecked()) {
                    diagnosi = 15;
                } else if (radio3.isChecked()) {
                    diagnosi = 20;
                }


                JSONObject jsonParam = new JSONObject();
                try {
                    jsonParam.put("UserID", user.getUid());
                    if (id != 0) {
                        jsonParam.put("OtherMemberID", id);
                    }
                    jsonParam.put("Coronavirus", true);
                    jsonParam.put("Diagnose", diagnosi);
                    jsonParam.put("DiagnoseDate", date_pistopiisi);
                    jsonParam.put("HospitalAdmission", date_nosokomio);
                    jsonParam.put("HospitalName", onoma_nosokomiou.getEditText().getText().toString());


                    Api.post("Disease/Statement", jsonParam.toString(), ta);
                    Toast.makeText(getApplicationContext(), "Η δήλωση καταχωρήθηκε επιτυχώς!! ", Toast.LENGTH_LONG).show();


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            else {
                Toast.makeText(getApplicationContext(),"Παρακαλώ συμπληρώστε όλα τα πεδία!",Toast.LENGTH_LONG).show();
            }
        }
    });

    }


    public void onClick(View v) {
        helper=pistopiisi;
            showDatePickerDialog(1);
    }
    public void onClick1(View v) {
        helper=nosokomio;
        showDatePickerDialog(2);
    }


    public void showDatePickerDialog(int i){

            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    this,
                    this,
                    Calendar.getInstance().get(Calendar.YEAR),
                    Calendar.getInstance().get(Calendar.MONTH),
                    Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
            datePickerDialog.show();
        }

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            String date = (year+"-"+month+"-"+dayOfMonth);
            helper.getEditText().setText(date);

        }
    public void onClick21(View v) {
        helper=nosokomio;
        showDatePickerDialog(2);
    }


}
