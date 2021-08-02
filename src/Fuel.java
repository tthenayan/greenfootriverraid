import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Fuel class .
 * 
 * @Thenayan AlThenayan and Omar AlDraye
 * @v1.0
 */
public class Fuel extends Actor
{
    public Fuel() {
    }
    /**
     * Act - do whatever the Fuel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    
    if(!checkCollision()){
        moveDown(); }
}
    public void moveDown() {
        int x_current = super.getX();
        int y_current = super.getY();
        int y_new = y_current + 2;
        setLocation(x_current,y_new);
        if (y_current>595){
            getWorld().removeObject(this);}
    }
   public void refuel()
   {
       Actor target = getOneIntersectingObject(FighterJet.class);
       if(target != null) {
            getWorld().removeObject(target);
            getWorld().removeObject(this);
       }
   }
   public boolean checkCollision() {
        Actor collided = getOneIntersectingObject(FighterJet.class);
        GreenfootSound sound = new GreenfootSound("Mario-coin-sound.mp3");
        if (collided != null) {
            World w = getWorld();
            if(w instanceof RiverRaidWorld1){
(                (RiverRaidWorld1) w ).fuelGet();
            }
            sound.play();
            getWorld().removeObject(this);
            return true;
}
return false;
}
}
