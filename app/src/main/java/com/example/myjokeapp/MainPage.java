package com.example.myjokeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainPage extends AppCompatActivity {
    RequestQueue queue;
    String url ="https://official-joke-api.appspot.com/random_joke";
    TextView textjokes;
    TextView textid;
    TextView textType;
    TextView textSetup;
    TextView textpunch;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        queue=Volley.newRequestQueue(this);
        textjokes =findViewById(R.id.txtJokes);
        textid =findViewById(R.id.textID);
        textType =findViewById(R.id.textType);
        textSetup =findViewById(R.id.textSetup);
        textpunch =findViewById(R.id.textPunch);

        progressBar=findViewById(R.id.progressBar);
    }
    public void getJokes(View view) {
        progressBar.setVisibility(View.VISIBLE);
        JSONObjectRequest jsonObjectRequest = new JSONObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        int JokeID=0;
                        String type,setup,punch;
                        try {
                            JokeID=response.getInt("Jokeid");
                            Joketype=response.getString("Joketype");
                            setup=response.getString("setup");
                            punch=response.getString("punchline");
                            Joke joke=new Joke(JokeID,Joketype,setup,punch);
                            textid.setText(joke.getJokeID()+"");
                            textid.setVisibility(View.VISIBLE);
                            textType.setText(joke.getJokeType()+"");
                            textType.setVisibility(View.VISIBLE);
                            textSetup.setText(joke.getSetup()+"");
                            textSetup.setVisibility(View.VISIBLE);
                            textpunch.setText(joke.getPunchLine()+"");
                            textpunch.setVisibility(View.VISIBLE);
                            progressBar.setVisibility(View.INVISIBLE);
                        } catch (JSONException e) {

                            e.printStackTrace();
                        }

                        textjokes.setText("Response: " +JokeID);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String err=error.toString();
                        textjokes.setText("Cannot Get Data: " +error.toString());

                    }
                });
        queue.add(jsonObjectRequest);


    }
}