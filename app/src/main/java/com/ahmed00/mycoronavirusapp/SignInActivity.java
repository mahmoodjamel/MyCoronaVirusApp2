package com.ahmed00.mycoronavirusapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class SignInActivity extends AppCompatActivity {

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        auth = FirebaseAuth.getInstance();

        Button singinBtn  = findViewById(R.id.singinBtn);
        final EditText email = findViewById(R.id.email_signIn);
        final EditText password = findViewById(R.id.password_login);

        singinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String e = Objects.requireNonNull(email.getText()).toString();
                String p = Objects.requireNonNull(password.getText()).toString();

                Task<AuthResult> task = auth.createUserWithEmailAndPassword(e, p);
                task.addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);

                        }else{
                            Log.d("ttt","Fales");
                        }
                    }
                });

            }
        });
    }
}
