import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WarBoat here.
 * 
 * @Thenayan AlThenayan and Omar AlDraye
 * @version (a version number or a date)
 */
public class WarBoat extends TouristBoat
{
    public WarBoat(){
        super();
        
    }
    public void act() 
    {
        if(Greenfoot.getRandomNumber(100) == 0){
            World here = getWorld();
            if(here instanceof RiverRaidWorld1){
                ((RiverRaidWorld1) here).shoot(false,getX(),getY());
            }
        }
        super.act();
    }
    
    
}
