import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * FuelCount class .
 * 
 * @Thenayan AlThenayan and Omar AlDraye
 * @v1.0
 */
public class FuelCount extends Actor
{
    private int fuel = 100;
    private int millisec = 0;
    public FuelCount() {
    }
    /**
     * Act - do whatever the FuelCount wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        millisec++;
        setImage(new GreenfootImage("Fuel: "+ fuel,48,Color.RED,Color.BLACK));
        if (millisec%50==0) {
            fuel -= 2;
    }  
}
    public int getFuel(){
        return fuel;
}
    public void addFuel(int fuel){
        this.fuel += fuel;
    }
}
