import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Boat adds a boat to riverraidworld and moves it down every 2 pixels
 * 
* @Thenayan AlThenayan and Omar AlDraye
 * @v1.0
 */
public class FishingBoat extends Actor
{
    public FishingBoat() {
        setImage();
    }
    public void setImage() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 200, image.getHeight() - 200);
        setImage(image);
    }
    /**
     * Act - do whatever the Boat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveDown();
        if (!checkCollision() && super.getY()>595){
            getWorld().removeObject(this);}
    }
    public void moveDown() {
        int x_current = super.getX();
        int y_current = super.getY();
        int y_new = y_current + 3;
        setLocation(x_current,y_new);
        
    }
    public boolean checkCollision() {
        Actor collided = getOneIntersectingObject(FighterJet.class);
        GreenfootSound sound = new GreenfootSound("Bonk.mp3");
        if (collided != null) {
            World w = getWorld();
            if(w instanceof RiverRaidWorld1){
(                (RiverRaidWorld1) w ).damage();
            }
            sound.play();
            getWorld().removeObject(this);
            return true;
}
return false;
}
}
