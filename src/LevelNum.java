import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelNum here.
 * 
 * @Thenayan AlThenayan and Omar AlDraye
 * @version (a version number or a date)
 */
public class LevelNum extends Actor
{
    private int level;
    /**
     * Act - do whatever the LevelNum wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public LevelNum(int l){
        setLevel(l);
        setImage(new GreenfootImage("Level: "+level,48,Color.RED,Color.BLACK));
    }
    public void act() 
    {
    }    
    private void setLevel(int l){
        level = l;
    }
    private int getLevel(){
        return level;
    }
}
