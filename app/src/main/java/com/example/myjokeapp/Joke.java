package com.example.myjokeapp;

public class Joke {
    private int JokeID;
    private String JokeType;
    private String JokeSetup;
    private String JokePunchLine;

    public Joke(int Jokeid, String Joketype, String Jokesetup, String JokepunchLine) {
        this.JokeID = Jokeid;
        JokeType = Joketype;
        JokeSetup = Jokesetup;
        JokePunchLine = JokepunchLine;
    }

    public int getJokeID() {
        return JokeID;
    }

    public void setJokeID(int JokeID) {
        this.JokeID = JokeID;
    }

    public String getJokeType() {
        return JokeType;
    }

    public void setJokeType(String Joketype) {
        JokeType = Joketype;
    }

    public String getJokeSetup() {
        return JokeSetup;
    }

    public void setJokeSetup(String Jokesetup) {
        JokeSetup = Jokesetup;
    }

    public String getJokePunchLine() {
        return JokePunchLine;
    }

    public void setJokePunchLine(String JokepunchLine) {
        JokePunchLine = JokepunchLine;
    }
}
