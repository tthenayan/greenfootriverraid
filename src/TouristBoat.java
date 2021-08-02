import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FighterBoat here.
 * 
 * @Thenayan AlThenayan and Omar AlDraye
 * @version (a version number or a date)
 */
public class TouristBoat extends FishingBoat
{
    private int timer;
    public TouristBoat(){
        
    }
    /**
     * Act - do whatever the FighterBoat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkBoundaries();
        int strategy = Greenfoot.getRandomNumber(10);
        if(strategy > 0 && strategy % 2 == 0) moveLeft();
        else if(strategy % 2 == 1) moveRight();
        super.act();
        //3 strategies, move left, move right, and more rarely, niether.
       
    } 
    public void moveLeft() {
        int x_current = super.getX();
        int y_current = super.getY();
        int x_new = 0;
        if(x_current < 5){
            x_new = 599;
        }
        else{
            x_new = x_current - 3;
        }
        setLocation(x_new,y_current);
    }
    public void moveRight() {
        int x_current = super.getX();
        int y_current = super.getY();
        int x_new = 0;
        if(x_current > 597){
            x_new = 1;
        }
        else{
            x_new = x_current + 3;
        }
        setLocation(x_new,y_current);
    }
    public void checkBoundaries()
   {
       if(getX() > getWorld().getWidth() - 120) 
            setLocation(120,super.getY());
       else if(getX() < 120) 
            setLocation(480,super.getY());
   }
}
