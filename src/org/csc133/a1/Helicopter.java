package org.csc133.a1;

import com.codename1.charts.util.ColorUtil;

class Helicopter extends MoveableObjects implements ISteerable {

    private int stickAngle; //can change at most 40 no more than 5 each tick
    private int maximumSpeed;  //the fastest the heli can go
    private int fuelLevel;  //fuel left
    private int fuelConsumptionRate; //how much heli uses each clock tick
    private int damageLevel;   //how much damage heli has
    private int maxDamageAllowed; //This is the maximum damage allowed before loses game
    private int lastSkyScraperReached;  //updates after heli passes each sky scraper
    private int placeholder; //holds value so i can can subtract percentage of damage lost

    public Helicopter(){
        super();
        damageLevel = 0;
        stickAngle = 0;
        fuelLevel = 20;
        fuelConsumptionRate = 1;
        maxDamageAllowed = 50;
        lastSkyScraperReached = 1;

    }
    public Helicopter(int size, int shape, int myColor, int speed, int heading, double X, double Y, int damageLevel, int stickAngle, int fuelLevel, int fuelConsumptionRate, int maxDamageAllowed, int lastSkyScraperReached){
        super(size, shape, myColor, speed, heading, X, Y);
        this.damageLevel = damageLevel;
        this.stickAngle = stickAngle;
        this.fuelLevel = fuelLevel;
        this.fuelConsumptionRate = fuelConsumptionRate;
        this.maxDamageAllowed = maxDamageAllowed;
        this.lastSkyScraperReached = lastSkyScraperReached;
    }

    int myColor = ColorUtil.rgb(0, 255, 0); //helicopters are red


    private void damageSpeed(int damageLevel, int maxDamageAllowed, int speed){ //this method adjusts speed based on damage level
        if(damageLevel == maxDamageAllowed){
           // lives--; //subtract lives
        }
        else
            placeholder = speed * (damageLevel/maxDamageAllowed);
            speed = speed - placeholder;//this finds the percentage of damage and applies to speed
    }

    public int getStickAngle() {
        return this.stickAngle;
    }

    public int getMaximumSpeed() {
        return this.maximumSpeed;
    }

    public int getFuelLevel() {
        return this.fuelLevel;
    }

    public int setFuelLevel(int fuel){ //this will set the fuel level to the blimp's fuel level
        fuelLevel = fuel + fuelLevel;
        return fuelLevel;
    }

    public int getFuelConsumptionRate() {
        return this.fuelConsumptionRate;
    }

    public int getDamageLevel() {
        return this.damageLevel;
    }
    public int getLastSkyScraperReached(){
        return this.lastSkyScraperReached;
    }

    public int getMyColor(){
        return this.myColor;
    }

    @Override
    public void steer(int heading, int degree) {

    }
}



