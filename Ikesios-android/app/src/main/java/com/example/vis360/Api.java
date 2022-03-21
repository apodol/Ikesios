package com.example.vis360;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Api {
    private static final String TAG = "APIRE";
    public static String apiResponse=null;
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
   private static String base = "https://vis36020200404041324.azurewebsites.net/api/";

   private static String incoming;
   private static Context te;


    public static void post(String url, String json, Context t){
        OkHttpClient client = new OkHttpClient();
        incoming=url;
        te=t;


        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(base+url)
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
               apiResponse = response.body().string();

                if (apiResponse.contains("successfully") && incoming.contains("Login") ) {


                    System.out.println("maaa");

                    Intent i=new Intent(te,Menu.class);
                    te.startActivity(i);


                    Log.d(TAG, apiResponse);

                }
                else if (apiResponse.contains("successfully") && incoming.contains("Demographics") ) {




                    Intent i=new Intent(te,Menu.class);
                    te.startActivity(i);


                    Log.d(TAG, apiResponse);

                }
                else if (apiResponse.contains("successfully") && incoming.contains("Register") ) {


                    System.out.println("maaa");


                    Intent i=new Intent(te,Demographics.class);
                    te.startActivity(i);


                    Log.d(TAG, apiResponse);

                }
                else if (apiResponse.contains("successfully") && incoming.contains("Disease/BasicInfo") ) {

                    Intent i=new Intent(te,Symptom_Check.class);
                    te.startActivity(i);

                    Log.d(TAG, "asd");

                }
                else if (apiResponse.contains("successfully") && incoming.contains("Disease/") ) {

                    Intent i=new Intent(te,Menu.class);
                    te.startActivity(i);

                Log.d(TAG, "asd");

                }
                else {

                    Log.d(TAG, apiResponse);
                }
                }

        });


    }
    // [END auth_fui_result]
    public static void signOut(Context context) {
        // [START auth_fui_signout]
        final Context current = context;
        AuthUI.getInstance()
                .signOut(current)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    public void onComplete(@NonNull Task<Void> task) {
                        Intent i = new Intent(current, MainActivity.class);
                        //startActivity(i);
                    }
                });
        // [END auth_fui_signout]
    }

}
