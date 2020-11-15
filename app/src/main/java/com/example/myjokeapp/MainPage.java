package com.example.myjokeapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainPage extends AppCompatActivity {
    RequestQueue queue;
    String url ="https://official-joke-api.appspot.com/random_joke";
    TextView textjokes;
    TextView Joketextid;
    TextView JoketextType;
    TextView JoketextSetup;
    TextView Joketextpunch;
    ProgressBar JokeprogressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        queue=Volley.newRequestQueue(this);
        textjokes =findViewById(R.id.txtJokes);
        Joketextid =findViewById(R.id.textJokeID);
        JoketextType =findViewById(R.id.textJokeType);
        JoketextSetup =findViewById(R.id.textJokeSetup);
        Joketextpunch =findViewById(R.id.textJokePunch);

        JokeprogressBar=findViewById(R.id.JokeprogressBar);
    }
    public void getJokes(View view) {
        JokeprogressBar.setVisibility(View.VISIBLE);
        JSONObjectRequest jsonObjectRequest = new JSONObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {




            @Override
                    public void onResponse(JSONObject response) {
                        int JokeID=0;
                        String Joketype,Jokesetup,punch;
                        try {
                            JokeID=response.getInt("Jokeid");
                            Joketype=response.getString("Joketype");
                            Jokesetup=response.getString("Jokesetup");
                            punch=response.getString("Jokepunchline");
                            Joke joke=new Joke(JokeID,Joketype,Jokesetup,punch);
                            Joketextid.setText(joke.getJokeID()+"");
                            Joketextid.setVisibility(View.VISIBLE);
                            JoketextType.setText(joke.getJokeType()+"");
                            JoketextType.setVisibility(View.VISIBLE);
                            JoketextSetup.setText(joke.getJokeSetup()+"");
                            JoketextSetup.setVisibility(View.VISIBLE);
                            Joketextpunch.setText(joke.getJokePunchLine()+"");
                            Joketextpunch.setVisibility(View.VISIBLE);
                            JokeprogressBar.setVisibility(View.INVISIBLE);
                        } catch (JSONException e) {

                            e.printStackTrace();
                        }

                        textjokes.setText("Response: " +JokeID);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String err=error.toString();
                        textjokes.setText("Cannot Get The Data: " +error.toString());

                    }
                });
        queue.add(jsonObjectRequest);


    }


}