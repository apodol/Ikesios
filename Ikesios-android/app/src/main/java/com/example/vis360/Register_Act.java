package com.example.vis360;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import timber.log.Timber;

public class Register_Act extends AppCompatActivity {

    TextInputLayout email;
    TextInputLayout onoma;
    TextInputLayout epitheto;
    TextInputLayout epalitheusi;
    TextView error;
    TextInputLayout kodikos;
    Button submit;
    Context ta = this;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    //    if (user != null) {
       //     Intent i = new Intent(this, Menu.class);
      //      startActivity(i);
      //  }
        setTitle("Ικέσιος ");

        email = (TextInputLayout) findViewById(R.id.Register_Email);
        kodikos = (TextInputLayout) findViewById(R.id.Register_Kodikos);
        submit = (Button) findViewById(R.id.Register_Submit);
        onoma = (TextInputLayout) findViewById(R.id.Register_Onoma);
        epitheto = (TextInputLayout) findViewById(R.id.Register_Epitheto);
        epalitheusi = (TextInputLayout) findViewById(R.id.Register_Epalitheusi);
        error = (TextView) findViewById(R.id.Register_Error);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (email.getEditText().getText().toString().isEmpty() || kodikos.getEditText().getText().toString().isEmpty() || onoma.getEditText().getText().toString().isEmpty() || epitheto.getEditText().getText().toString().isEmpty() || epalitheusi.getEditText().getText().toString().isEmpty()) {

                    error.setText("Παρακαλώ συμπληρώστε όλα τα πεδία!");

                } else if (!email.getEditText().getText().toString().contains("@") || !email.getEditText().getText().toString().contains(".com")) {
                    error.setText("                 To email δεν είναι σωστό!!");
                } else if (!kodikos.getEditText().getText().toString().equals(epalitheusi.getEditText().getText().toString())) {
                    error.setText("                 Οι κωδικοί διαφέρουν!!");
                } else if (kodikos.getEditText().length() < 7) {

                    error.setText("                 Αδύναμος Κωδικός!!");
                }

                String emai = email.getEditText().getText().toString();
                String kodiko = kodikos.getEditText().getText().toString();

                mAuth.createUserWithEmailAndPassword(emai, kodiko)
                        .addOnCompleteListener(Register_Act.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {


                                    // Sign in success, update UI with the signed-in user's information
                                    Timber.d("createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    //updateUI(user);
                                    JSONObject jsonParam = new JSONObject();
                                    try {
                                        jsonParam.put("Ud", user.getUid());
                                        jsonParam.put("Email", user.getEmail() );
                                        jsonParam.put("Provider", user.getProviderId());
                                        Api.post("Account/Register", jsonParam.toString(), ta);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    Intent i = new Intent(Register_Act.this, Demographics.class);
                                    startActivity(i);
                                } else {

                                    if (!task.isSuccessful()) {
                                        try {
                                            throw task.getException();
                                        } catch (FirebaseAuthWeakPasswordException e) {
                                            Toast.makeText(Register_Act.this, "Weak Password",
                                                    Toast.LENGTH_SHORT).show();
                                            kodikos.requestFocus();
                                        } catch (FirebaseAuthInvalidCredentialsException e) {
                                            Toast.makeText(Register_Act.this, "Invalid Email",
                                                    Toast.LENGTH_SHORT).show();
                                            kodikos.requestFocus();
                                        } catch (FirebaseAuthUserCollisionException e) {
                                            Toast.makeText(Register_Act.this, "User already exists.",
                                                    Toast.LENGTH_SHORT).show();
                                            email.requestFocus();
                                        } catch (Exception e) {
                                            //Timber.d(e.getMessage());
                                        }
                                    }
                                    // If sign in fails, display a message to the user.
                                    Timber.d("createUserWithEmail:failure " + task.getException().getClass().getSimpleName());
                                    //Toast.makeText(Register_Act.this, "Authentication failed.",
                                    //Toast.LENGTH_SHORT).show();
                                    //updateUI(null);
                                }

                                // ...
                            }
                        });

//                JSONObject jsonParam = new JSONObject();
//                try {
//                    jsonParam.put("Email", emai);
//                    jsonParam.put("Password", kodiko);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//
//
//
//                OkHttpClient client = new OkHttpClient();
//
//                String url = "https://vis36020200404041324.azurewebsites.net/api/Account/Register";
//                Api.post("Account/Register",jsonParam.toString(),ta);


            }
        });

    }
}
