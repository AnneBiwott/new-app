package com.example.newapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    Button mRegister;
    EditText mEmail, mPass, mCon;
    TextView mHaveaccount;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Register");

        Toast.makeText(Register.this, "go to login", Toast.LENGTH_LONG).show();


        mEmail = findViewById(R.id.register_email);
        mPass = findViewById(R.id.register_password);
        mCon = findViewById(R.id.confirm_password);
        mRegister = findViewById(R.id.btn_register);
        mHaveaccount = findViewById(R.id.have_account);
        mAuth = FirebaseAuth.getInstance();

        mHaveaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(Register.this, "go to login", Toast.LENGTH_LONG).show();
            }
        });

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userRegister();
            }
        });
    }

    private void userRegister() {

        String email = mEmail.getText().toString().trim();
        String pass = mPass.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent register = new Intent(Register.this, About.class);
                            startActivity(register);
                        } else {
                            Toast.makeText(Register.this, "User registration failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}
