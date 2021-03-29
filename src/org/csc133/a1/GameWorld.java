package org.csc133.a1;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
//import jdk.internal.jrtfs.JrtFileAttributeView;
//import com.sun.org.apache.xerces.internal.impl.dv.util.ByteListImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameWorld extends GameObject {
    private int lives = 3;
    private int newHeading;
    private int newSpeed;
    private int newMyColor;
    private int damageReport;
    private int currentScraper;
    private int currentFuel;
    private int clock;
    private int gameSizeX = 1024;
    private int gameSizeY = 768;


    private List<GameObject> listOfGameObjects =  new ArrayList<GameObject>();
    Helicopter heli = new Helicopter(20,0,255,1,0,102.0,55.0,0,0,20,1,50,1);
    Bird bird1 = new Bird(3,0, 230, 2,90, 130.5,60.0);
    Bird bird2 = new Bird(3,0, 230, 3, 45,100.0,40.0);
    SkyScraper sky1 = new SkyScraper(20,0, 250, 145.0, 34.00);
    SkyScraper sky2 = new SkyScraper(20,0, 250, 130.0, 60.0);
    SkyScraper sky3 = new SkyScraper(20, 0, 250, 125.0, 200);
    SkyScraper sky4 = new SkyScraper(20, 0, 250, 1000.0, 345.0);
    RefuelingBlimp Blimp1 = new RefuelingBlimp(10, 0, 255, 0.00, 0.00);
    RefuelingBlimp Blimp2 = new RefuelingBlimp(10, 0, 255, 0.00, 0.00);

    public GameWorld() {

    }
//this is where I initialize the world, I need to figure out how to initialize randomly for birds
    public void init() {

    listOfGameObjects.add(Blimp1);
    listOfGameObjects.add(Blimp2);
    listOfGameObjects.add(heli);
    listOfGameObjects.add(bird1);
    listOfGameObjects.add(bird2);
    listOfGameObjects.add(Blimp1);
    listOfGameObjects.add(sky1);
    listOfGameObjects.add(sky2);
    listOfGameObjects.add(sky3);
    listOfGameObjects.add(sky4);
    }

   // Helicopter heli = new Helicopter();//these are used to guide methods below
    //Bird bird = new Bird();
    //RefuelingBlimp Blimp = new RefuelingBlimp();


    void skyScrapeCheckpoint(){ //I know I need to fix this to compare to user input not sure how to compare char and int
        currentScraper = heli.getLastSkyScraperReached();
        System.out.print("You have reached " + "" + " SkyScraper");
    }

    void accelerate() {
        newSpeed = heli.getSpeed();
        System.out.printf("you are going " + newSpeed);

        /*newSpeed = heli.getSpeed();//accelerate
        newSpeed = newSpeed + 5;
        System.out.print("You've accelerated " + newSpeed +"\n");*/
    }

    void brake() {
        if (newSpeed <= 0) {
            System.out.print("you're not moving!\n");
        }
        else {
            newSpeed = heli.getSpeed();
            newSpeed = newSpeed - 5; //brake
            System.out.print("You've hit the brakes: " + newSpeed);
        }
    }
     void turnLeft () {
        newHeading = heli.getHeading() + 5;//left
        //Form hi2 = new Form("You are turning left 5 degrees " + newHeading, BoxLayout.y());
         System.out.print("You are turning left 5 degrees " + newHeading);

    }
    void turnRight () {
        newHeading = heli.getHeading() - 5; //right
        //Form hi3 = new Form("You're turing right 5 degrees: " + newHeading, BoxLayout.y());
        //hi3.show();
        System.out.print("You are turning right 5 degrees " + newHeading);
    }
    void heliCollision () {
        newMyColor = heli.getMyColor(); //gets current color
        newMyColor = ColorUtil.rgb(230, 0, 0); //this is just for testing
        damageReport = heli.getDamageLevel() + 2; //adjusts the damage level
        newSpeed = heli.getSpeed() - 2; //slows down helicopter
        System.out.print("It looks like you hit another helicopter" + newMyColor + newSpeed + damageReport);
    }

     void birdCollision () {
        newMyColor = heli.getMyColor();
        newMyColor = ColorUtil.rgb(200, 0, 0);
        damageReport = heli.getDamageLevel() + 1;
        newSpeed = heli.getSpeed() - 1;
        System.out.print("You're gummed up from a bird!" + newMyColor + damageReport + newSpeed);
    }
      void showDisplay () {

        System.out.print("You have " + lives + " lives left.");
        System.out.print("The clock has elapsed " + clock + " ticks.");
        currentScraper = heli.getLastSkyScraperReached();
        System.out.print("You currently passed # " + currentScraper);
        currentFuel = heli.getFuelLevel();
        System.out.print("You have " + currentFuel + " units of fuel left.");
        damageReport = heli.getDamageLevel();
        System.out.print("You have " + damageReport + " units of damage.\n");
        int heliSpeed = heli.getSpeed();
        System.out.print("You are currently going " + heliSpeed);


                    }

     void showMap () {

         Iterator iterator = listOfGameObjects.iterator(); //I don't know how to make this output the map yet
         for (int i=0; i<listOfGameObjects.size(); i++) {
             if (listOfGameObjects.get(i) instanceof Helicopter) { Helicopter heliPlayer =
                     (Helicopter) listOfGameObjects.get(i); heliPlayer.move();
             }
         }
         for (int i=0; i<listOfGameObjects.size(); i++) {
             if (listOfGameObjects.get(i) instanceof Bird) {
                 Bird birdPlayer =
                         (Bird) listOfGameObjects.get(i);
                 birdPlayer.move();
             }
         }
     }
     void clockTick () {
        heli.move(); //calls move to adjust the x location and y location
       // bird.move();
        clock++;
        System.out.printf("the clocked has ticked! " + " here is the current time", clock);
    }
    void fuelBlimp () {
        System.out.printf("You have made it to refuel. ", BoxLayout.y());
        int fuel;
        int showHeli;
        int showBlimp; //these are testers to see my output
        fuel = Blimp1.getSize();
        showHeli = heli.setFuelLevel(fuel);
        showBlimp = Blimp1.setSize(0);


        System.out.printf("this is the helicopter fuel capacity " + showHeli + "\n");
        System.out.printf("this is the blimp fuel capacity " + showBlimp + "\n");



    }

}

