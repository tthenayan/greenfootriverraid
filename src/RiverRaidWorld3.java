import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RiverRaidWorld3 here.
 * 
 * @Thenayan AlThenayan and Omar AlDraye
 * @version (a version number or a date)
 */
public class RiverRaidWorld3 extends RiverRaidWorld2
{

    /**
     * Constructor for objects of class RiverRaidWorld3.
     * 
     */
    public RiverRaidWorld3(int num, int score)
    {
        super(num, score);
    }
    public void act() {
        super.act();
        Greenfoot.setSpeed(60);
        if (Greenfoot.getRandomNumber(1000) < 3) { 
            addObject(new WarBoat(), Greenfoot.getRandomNumber(200)+200, 0); 
        }  
    }
}
