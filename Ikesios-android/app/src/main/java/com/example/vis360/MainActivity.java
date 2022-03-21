package com.example.vis360;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AdditionalUserInfo;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.UserInfo;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    FirebaseUser user;
    Button login;
    Button register;
    private Button socialSignIn;

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private OkHttpClient client = new OkHttpClient();
    Context ta = this;
    TextInputLayout email;
    TextInputLayout password;
    Button about;

    private FirebaseAuth mAuth;

    private static final int RC_SIGN_IN = 123;
    private GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        about =(Button)findViewById(R.id.about);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i=new Intent(getApplicationContext(),Demographics.class);
            startActivity(i);


            }
        });

        // This will initialise Timber
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("170266459073-2pb4ur1iaoklbg4sp3evi6ua8rgg9spk.apps.googleusercontent.com")
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
       // Api.signOut(this);
        if (user != null) {
            Intent i = new Intent(this, Menu.class);
            startActivity(i);
        }

        setTitle("Ικέσιος ");
        login = (Button) findViewById(R.id.Login_Submit);
        register = (Button) findViewById(R.id.register);
        email = (TextInputLayout) findViewById(R.id.Login_Email);
        password = (TextInputLayout) findViewById(R.id.Login_Password);


        // Set the dimensions of the sign-in button.
        SignInButton socialSignIn = findViewById(R.id.socialSignIn);
        socialSignIn.setSize(SignInButton.SIZE_STANDARD);


        socialSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             signIn();



            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(view.getContext(), Menu.class);
                startActivity(i);
                

//


            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), Register_Act.class);
                startActivity(i);
            }
        });


    }

    public void createSignInIntent() {
        // [START auth_fui_create_intent]
        // Choose authentication providers
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.GoogleBuilder().build()
               );

        // Create and launch sign-in intent
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .setIsSmartLockEnabled(false)
                        .build(),
                RC_SIGN_IN);
        // [END auth_fui_create_intent]
    }
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Timber.d( "Google sign in failed", e);
                // ...
            }
        }
    }
    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Timber.d("firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            // Sign in success, update UI with the signed-in user's information
                            Timber.d( "signInWithCredential:success");

                            FirebaseUser user = mAuth.getCurrentUser();
                            Snackbar.make(findViewById(R.id.main_layout), "Hello " + user.getDisplayName(), Snackbar.LENGTH_SHORT).show();

                            if(task.getResult().getAdditionalUserInfo().isNewUser()) {
                                // TODO: einai new user, stelnoume API Request gia register

                            }
                            Intent i = new Intent(MainActivity.this, Menu.class);
                            startActivity(i);
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Timber.d("signInWithCredential:failure", task.getException());
                            Snackbar.make(findViewById(R.id.main_layout), "Authentication Failed.", Snackbar.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });
    }
    // [START auth_fui_result]
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == RC_SIGN_IN) {
//            IdpResponse response = IdpResponse.fromResultIntent(data);
//
//            if (resultCode == RESULT_OK) {
//
//                user = FirebaseAuth.getInstance().getCurrentUser();
//
//                for (UserInfo profile : user.getProviderData()) {
//                    Timber.d(profile + "");
//                }
//                Toast.makeText(this, user.getDisplayName(), Toast.LENGTH_SHORT);
//
//                //    ArrayList<String> emails_db = new ArrayList<>();
//
//                //     int found =0;
//                //     for (String email : emails_db){
//                //       if (user.getEmail().equals(email)){
//                //           found=1;
//                //        break;
//                //     }
//                // }
//                //  if (found == 0){
//                Intent i = new Intent(getApplicationContext(), Menu.class);
//                startActivity(i);
//                // }
//                //  else {
//
//                //    Intent i=new Intent(getApplicationContext(),POPUP.class);
//                //    startActivity(i);
//                // }
//
//
//            } else {
//                // Sign in failed. If response is null the user canceled the
//                // sign-in flow using the back button. Otherwise check
//                // response.getError().getErrorCode() and handle the error.
//                // ...
//            }
//        }
//    }



}
