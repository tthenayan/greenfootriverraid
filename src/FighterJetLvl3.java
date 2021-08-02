import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FighterJetLvl3 here.
 * 
 * @Thenayan AlThenayan and Omar AlDraye
 * @version (a version number or a date)
 */
public class FighterJetLvl3 extends FighterJetLvl2
{
    private int counter;
    public FighterJetLvl3() {
        super();
        counter = 0;
    }
    /**
     * Act - do whatever the FighterJetLvl3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        counter--;
        super.act();
        if(Greenfoot.isKeyDown("space")&& counter <= 0) {
            counter = 20;
            World w = getWorld();
            if(w instanceof RiverRaidWorld1){
                ((RiverRaidWorld1) w ).shoot(true, getX(), getY()-10);
            }
    }
        checkBoundaries();
    if (Greenfoot.isKeyDown("left")) {
            super.moveLeft();
    } else if (Greenfoot.isKeyDown("right")) {
            super.moveRight();
    }
    }   
    
}
