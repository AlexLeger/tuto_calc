package com.sdz.model;

import java.util.Observable;


public class Calculator extends Observable {

    private double result;

    public Calculator() {
        super();
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public void notifyObservers(Double result) {
        super.notifyObservers(Double result);
    }


}
