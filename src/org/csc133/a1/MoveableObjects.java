package org.csc133.a1;

public abstract class MoveableObjects extends GameObject {
private int heading;
private int speed;


    MoveableObjects() {
    super();
    speed = 0;
    heading = 0;

    }

    public MoveableObjects(int size, int shape, int myColor, int speed, int heading, double X, double Y)
    {
        super(size, shape, myColor, X, Y);
        this.speed = speed;
        this.heading = heading;



    }
    public int getSpeed() {
        return this.speed;
    }

    public int getHeading() {
        return this.heading;
    }
    public void move() {
        double x;
        double y;
         x = getX();
         y = getY();

        x = x + (Math.cos(Math.toRadians(90 - heading)) * speed);
        y = y + (Math.sin(Math.toRadians(90 - heading)) * speed);
    }



  /* public int move(deltaX, deltaY){
        Math.toRadians();
        newLocation(X,Y) = location(X,Y) + (deltaX,
                deltaY)
        return heading;
    }*/

}



    //need to modify
 /*public int move(){ //this will change the heading of the object
        , wheredeltaX = cos(θ)*speed, deltaY = sin(θ)*speed,and where θ = 90 ˗ heading (90


     return heading;
*/
