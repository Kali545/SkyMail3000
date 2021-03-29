package org.csc133.a1;
import com.codename1.charts.util.ColorUtil;
abstract class GameObject {
    private int size;
    private int shape;
    private int myColor;
    private double X;
    private double Y;


    public GameObject() {
        size = 0;
        shape = 0;
        X = 0.00; //adjust these for other objects
        Y = 0.00;
        myColor = ColorUtil.rgb(0 ,0,0); //need to modify these still
    }
    public GameObject(int size, int shape, int myColor, double X, double Y){
        this.myColor = myColor;
        this.size = size;
        this.shape = shape;
        this.X = X;
        this.Y = Y;

    }

    public int getSize(){
        return size;
    }
    public int setSize(int newSize){
        size = newSize;
        return size;

    }

    public double getX(){
        return this.X;
    }
    public double getY(){
        return this.Y;
    }
}
