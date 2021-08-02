import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FighterJetLvl2 here.
 * 
 * @Thenayan AlThenayan and Omar AlDraye
 * @version (a version number or a date)
 */
public class FighterJetLvl2 extends FighterJet
{
    public FighterJetLvl2() {
        GreenfootImage image = getImage();
        setImage(image);
    }
    /**
     * Act - do whatever the FighterJetLvl2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        if (Greenfoot.isKeyDown("up")) {
            moveDown();
    } else if (Greenfoot.isKeyDown("down")) {
            moveUp();
    }
    
}
    public void moveUp(){
        int x_current = super.getX();
        int y_current = super.getY();
        int y_new = y_current+1; // +1 to move the Plane 1 pixel on the y-axis
        setLocation(x_current, y_new);

    }
public void moveDown(){
        int x_current = super.getX();
        int y_current = super.getY();
        int y_new = y_current-1; // -1 to move the Plane 1 pixel on the y-axis
        setLocation(x_current, y_new);

    }
}
