package org.csc133.a1;

public class RefuelingBlimp extends GameObject {
    int capacity = 0; //this is proportional to it's size
    public RefuelingBlimp(){
        super();
        capacity = 0;
    }

    public RefuelingBlimp(int size, int shape, int myColor, double X, double Y){
        super(size,shape,myColor,X, Y);
        this.capacity = capacity;

    }
    public void emptyBlimp(){//this is going to be my method to handle the fuel capacity of blimp
    }

    }



