package com.example.myjokeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText mTextEmail;
    EditText mTextPassword;
    Button mButtonLogin;
    Button mButtonRegister;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mTextEmail = (EditText)findViewById(R.id.editText_email);
        mTextPassword = (EditText)findViewById(R.id.editText_password);
        mButtonLogin = (Button) findViewById(R.id.button_Login);
        mButtonRegister = (Button) findViewById(R.id.button_register);
        DB = new DBHelper(this) {
            @Override
            public boolean checkemail(String email) {
                return false;
            }
        };
        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(Login.this,Register.class);
                startActivity(registerIntent);
            }
        });
        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextEmail.getText().toString();
                String pass = mTextPassword.getText().toString();
                if(user.equals("")||pass.equals(""))
                    Toast.makeText(Login.this,"Enter The All",Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkEmailpassword(user,pass);
                    if(checkuserpass==true){
                        Toast.makeText(Login.this,"Login in successfull",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this,MainPage.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(Login.this,"ERROR:Invalid Credentials",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}