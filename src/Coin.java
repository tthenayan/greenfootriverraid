import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Coin class adds coins to riverraidworld and moves it down every 2 pixels
 * 
* @Thenayan AlThenayan and Omar AlDraye
 * @v1.0
 */
public class Coin extends Actor
{
    public Coin() {
    }
    /**
     * Act - do whatever the Coin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!checkCollision()) moveDown();
    }
    public void moveDown() {
        int x_current = super.getX();
        int y_current = super.getY();
        int y_new = y_current + 2;
        setLocation(x_current,y_new);
        if (y_current>590){
            getWorld().removeObject(this);}
}
    public boolean checkCollision() {
        Actor collided = getOneIntersectingObject(FighterJet.class);
        GreenfootSound sound = new GreenfootSound("Mario-coin-sound.mp3");
        if (collided != null) {
            World w = getWorld();
            if(w instanceof RiverRaidWorld1){
                ((RiverRaidWorld1) w ).coinGet();
            }
            sound.play();
            getWorld().removeObject(this);
            return true;
}
return false;
}
}

