import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Lives class .
 * 
 * @Thenayan AlThenayan and Omar AlDraye
 * @v1.0
 */
public class Lives extends Actor
{
    private int lives;
    public Lives() {
    }
    /**
     * Act - do whatever the Lives wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(new GreenfootImage("Lives: "+ lives,48,Color.RED,Color.BLACK));
}
    public void setLives(int num) {
        lives = num;
    }
}
