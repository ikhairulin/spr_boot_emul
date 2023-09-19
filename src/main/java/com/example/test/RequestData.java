package com.example.test;

public class RequestData {
    public String name;
    public int first_num;
    public int second_num;
    public int sumNumbers;

    public String getName() {
        return name;
    }
    public int calcSumNumbers() {
        sumNumbers = first_num + second_num;

        return sumNumbers;
    }

    public void setName(String name) {
        this.name = name;}
}


