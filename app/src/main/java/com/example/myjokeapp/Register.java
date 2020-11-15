package com.example.myjokeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        db = new DBHelper(this) {
            @Override
            public boolean checkemail(String email) {
                return false;
            }
        };
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
                if (s1.equals("")||s2.equals("")||s3.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else{
                    if (s2.equals(s3)){
                        Boolean checkemsil =db.checkemail(s1);
                        if (checkemsil == true){
                            Boolean insert = db.insert(s1,s2);
                            if (insert==true){
                                Toast.makeText(getApplicationContext(),"Registered Successfull",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Email Already exists",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
}