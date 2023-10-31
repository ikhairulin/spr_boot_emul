package com.test;

public class RequestData {
    public String name;
    public int first_num;
    public int second_num;
    public int sumNumbers;
    public String answer;

    public String getName() {
        return name;
    }

    public String calcSumNumbers() {
        try {
            sumNumbers = first_num + second_num;
        } catch (NumberFormatException e) {
           answer = "Ошибка во входных данных, пожалуйста, сверьтесь с образцом";
        }
        finally {
        answer = "Сумма ваших чисел " + String.valueOf(sumNumbers);
        }
        return answer;
    }

    public void setName(String name) {
        this.name = name;}
}


