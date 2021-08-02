import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * FighterJet class dictates how to control fighter jet
 * 
 * @Thenayan AlThenayan and Omar AlDraye
 * @v1.0
 */
public class FighterJet extends Actor
{
    public FighterJet() {
    }
    /**
     * Act - do whatever the FighterJet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkBoundaries();
        if (Greenfoot.isKeyDown("right")) {
            moveRight();
    } else if (Greenfoot.isKeyDown("left")) {
            moveLeft();
}
}
public void moveRight(){
        int x_current = super.getX();
        int y_current = super.getY();
        int x_new = x_current+1; // +1 to move the Plane 1 pixel on the x-axis
        setLocation(x_new, y_current);
}
public void moveLeft(){
        int x_current = super.getX();
        int y_current = super.getY();
        int x_new = x_current-1; // -1 to move the Plane 1 pixel on the x-axis
        setLocation(x_new, y_current);

}

public void checkBoundaries()
   {
       if(getX() > getWorld().getWidth() - 2) 
            setLocation(1,super.getY());
       else if(getX() < 1) 
            setLocation(getWorld().getWidth() - 2,super.getY());
       if(getY() > getWorld().getHeight() - 1) 
            getWorld().removeObject(this);
       else if(getY() < 100) {
            setLocation(super.getX(),100);
   }
}
}