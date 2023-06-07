package com.example.mma_fightera.Model;

public class Flyweight_male {

    // making the necessary attributs for this class.
    private int id;
    private String first_name;
    private String last_name;
    private int lose;
    private int win;
    private double weight;


    // making the constructor for this class. This will not work without the constructor.

    public Flyweight_male(int id, String first_name, String last_name, int lose, int win, double weight) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.lose = lose;
        this.win = win;
        this.weight = weight;
    }
    // make the empty constructor without the empty or default it will not work.

    public Flyweight_male() {

    }
    // The getter for this class.

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public int getLose() {
        return lose;
    }

    public int getWin() {
        return win;
    }

    public double getWeight() {
        return weight;
    }
    // setter for this class.

    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
