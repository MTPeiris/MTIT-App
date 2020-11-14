package com.example.myjokeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {
    DBHelper db;
    EditText mTextEmail;
    EditText mTextPassword;
    EditText mTextConfPassword;
    Button mButtonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new DBHelper(this);
        mTextEmail = (EditText)findViewById(R.id.editText_email);
        mTextPassword = (EditText)findViewById(R.id.editText_password);
        mTextConfPassword = (EditText) findViewById(R.id.editText_cofpassword);
        mButtonRegister = (Button) findViewById(R.id.button_register);
        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(Register.this,Login.class);
                startActivity(registerIntent);
                String s1 = mTextEmail.getText().toString();
                String s2 = mTextPassword.getText().toString();
                String s3 = mTextConfPassword.getText().toString();
            }
        });
    }
}