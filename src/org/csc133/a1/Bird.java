package org.csc133.a1;


import java.util.Vector;

public class Bird extends MoveableObjects {
    //Vector<Double> location; //this updates randomly with each clock tick
    public Bird(){
        super();

    }

    public Bird(int size, int shape, int myColor, int speed, int heading, double X, double Y){
        super(size, shape, myColor, speed, heading, X, Y);


    }
}
