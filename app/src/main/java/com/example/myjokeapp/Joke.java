package com.example.myjokeapp;

public class Joke {
    private int JokeID;
    private String JokeType;
    private String Setup;
    private String PunchLine;

    public Joke(int Jokeid, String Joketype, String setup, String punchLine) {
        this.JokeID = Jokeid;
        JokeType = Joketype;
        Setup = setup;
        PunchLine = punchLine;
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

    public String getSetup() {
        return Setup;
    }

    public void setSetup(String setup) {
        Setup = setup;
    }

    public String getPunchLine() {
        return PunchLine;
    }

    public void setPunchLine(String punchLine) {
        PunchLine = punchLine;
    }
}
