import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RiverRaidWorld2 here.
 * 
 * @Thenayan AlThenayan and Omar AlDraye
 * @version (a version number or a date)
 */
public class RiverRaidWorld2 extends RiverRaidWorld1
{

    /**
     * Constructor for objects of class RiverRaidWorld2.
     * 
     */
    
    public RiverRaidWorld2(int num, int score)
    {
        super(num, score);
    }
    public void act() {
        super.act();
        if (Greenfoot.getRandomNumber(1000) < 5) { 
            addObject(new TouristBoat(), Greenfoot.getRandomNumber(200)+200, 0); 
        }  
    }
}
