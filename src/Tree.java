import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tree here.
 * 
 * @Thenayan AlThenayan and Omar AlDraye 
 * @version (a version number or a date)
 */
public class Tree extends Actor
{
    public Tree() {
        setImage();
    }
    /**
     * Act - do whatever the Tree wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveDown();
    }
        public void moveDown() {
        int x_current = super.getX();
        int y_current = super.getY();
        int y_new = y_current + 2;
        setLocation(x_current,y_new);
        if (y_current>590){
            getWorld().removeObject(this);}
        }
        public void setImage() {
        GreenfootImage image = getImage();
        image.scale(50, 50);
        setImage(image);
    }
}
