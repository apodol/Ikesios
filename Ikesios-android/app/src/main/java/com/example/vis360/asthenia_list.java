package com.example.vis360;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.FileReader;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


import okhttp3.OkHttpClient;

public class asthenia_list extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    Button add;
    Button next;
    SpinnerAdapter spinnerAdapter;

    TextInputLayout onoma,ilikia,poli,atoma;
    int thesi;


    final  List<String> onomata = new ArrayList<String>();
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asthenia_list);

        add=(Button)findViewById(R.id.asthenia_list_prosthiki);
        next=(Button)findViewById(R.id.asthenia_list_sinexia);

        onomata.add("..Eπιλέξτε κάποιο μέλος που έχετε καταχωρήσει..");
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent (getApplicationContext(),asthenia_Other.class);
                startActivity(i);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),asthenia_final.class);
                i.putExtra("Id",thesi);

                startActivity(i);
            }
        });



        mAuth = FirebaseAuth.getInstance();


        final Spinner spinner = (Spinner) findViewById(R.id.spinner1);



        FirebaseUser user = mAuth.getCurrentUser();

        JsonReader j=new JsonReader();
        JSONObject json = null;

        String url = ("https://vis36020200404041324.azurewebsites.net/api/Account/GetMembers?ID="+user.getUid());


        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        final List<Integer> end=new ArrayList<Integer>();
        end.add(1);
    int counter=1;

        int waiting=1;
        while( waiting<5000){
            waiting++;
        }

        while (end.size()==1) {
            if(counter==1){
                counter=counter+1;
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {

                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                    if (response.isSuccessful()) {
                        String myResponse = response.body().string();


                        System.out.println("ablabla" + myResponse);
                        Gson gson = new Gson();
                        MyJsonResponse[] responsee = gson.fromJson(myResponse, MyJsonResponse[].class);


                        System.out.println("ENADIOTR" + myResponse);

                        System.out.println("test123"+end.size());
                        String a="";
                        for (MyJsonResponse num : responsee) {

                            onomata.add(num.Name);
                            a=num.Name;
                        }
                        System.out.println("test1234567"+a);
                        end.add(2);

                    } else {

                        System.out.println("responsefailed:" + response.toString());
                    }
                }
            });

        }}

        System.out.println("test12345"+end.size());

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, onomata);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);



        // Spinner Drop down elements
        spinner.setOnItemSelectedListener(this);
        // Creating adapter for spinner
        spinner.setEnabled(false);


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (onomata.size()>0){
                    System.out.println("tesete"+onomata.size());
                    int thesi =onomata.size();
                    spinner.setEnabled(true);
                    spinner.setSelection(thesi-1);
                }
                else{
                    int thesi=0;
                    spinner.setEnabled(true);
                    spinner.setSelection(thesi);

                }

            }
        }, 4000);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();


        thesi=position;


        if (position != 0){
            Toast.makeText(parent.getContext(), "Επιλέχθηκε: " + item, Toast.LENGTH_LONG).show();}
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}



