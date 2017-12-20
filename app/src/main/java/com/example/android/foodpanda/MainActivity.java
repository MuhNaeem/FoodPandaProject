package com.example.android.foodpanda;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;


import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

import static android.view.View.*;

public class MainActivity extends AppCompatActivity {
    private static final int RC_SIGN_IN = 1;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static final String TAG = "AddToDatabase";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mFirebaseAuth = FirebaseAuth.getInstance();

         /* Auth listener for Firebase API
        ....
        .....
        ......
         */
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    // user is signed in
                    Toast.makeText(MainActivity.this, "Welcome!",Toast.LENGTH_SHORT).show();
                }
                else {
                    // user is not signed in
                    // Create and launch sign in intent
                    // Choose authentication providers
                    List<AuthUI.IdpConfig> providers = Arrays.asList(
                            new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build());

                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    //.setIsSmartLockEnabled(false)
                                    .setAvailableProviders(providers)
                                    .build(),
                            RC_SIGN_IN);

                }
            }
        };

        //intent to go on menulist interface
        Button toMenuList = (Button) findViewById(R.id.menu_list);
        toMenuList.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goMenuList = new Intent(MainActivity.this, MenuList.class);
                startActivity(goMenuList);
            }
        });

        //intent to go on updatemenu interface
        Button toUpdate = (Button) findViewById(R.id.update_menu);
        toUpdate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goUpdate = new Intent(MainActivity.this, UpdateMenu.class);
                startActivity(goUpdate);
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                // Successfully signed in
                Toast.makeText(this, "Signed In!",Toast.LENGTH_SHORT).show();
            } else {
                // Sign in failed, check response for error code
                Toast.makeText(this, "Signed In cancelled!",Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        mFirebaseAuth.removeAuthStateListener(mAuthListener);
    }

    @Override
    protected void onResume(){
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthListener);
    }

}

