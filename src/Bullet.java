import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @Thenayan AlThenayan and Omar AlDraye
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    private boolean friendly;
    public Bullet(boolean friend) {
        friendly = friend;
        
        GreenfootSound s = new GreenfootSound("metal_pipe_hit.mp3");
        if(friend){
            s = new GreenfootSound("blood_4.mp3");
        }
        s.play();
        
    }
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       int move = 20;
       if(!friendly) move = move * -1;
       boolean del = !destroyEnemies();
       if(del){setLocation(getX(), getY() - move);
       checkBoundaries();}
    }
    public void checkBoundaries()
   {
       if(getX() > getWorld().getWidth() - 1) 
            getWorld().removeObject(this);
       else if(getX() < 1) 
            getWorld().removeObject(this);
       if(getY() > 590) 
            getWorld().removeObject(this);
       else if(getY() < 1) 
            getWorld().removeObject(this);
   }
   public boolean destroyEnemies()
   {
       Actor target = getOneIntersectingObject(FishingBoat.class);
       if(target != null && friendly) {
            getWorld().removeObject(target);
            getWorld().removeObject(this);
            return true;
       }
       target = getOneIntersectingObject(FighterJet.class);
       if(target != null && !friendly) {
            World w = getWorld();
            if(w instanceof RiverRaidWorld1){
(                (RiverRaidWorld1) w ).damage();
            }
            getWorld().removeObject(this);
            return true;
       }
       return false;
   }
}
