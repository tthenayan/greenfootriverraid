import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Counter class .
 * 
 * @Thenayan AlThenayan and Omar AlDraye
 * @v1.0
 */
public class Counter extends Actor
{
    private int counter = 0;
    private int millisec = 0;
    public Counter() {
    }
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        millisec++;
        setImage(new GreenfootImage("Score: "+ counter,48,Color.RED,Color.BLACK));
        if (millisec%100==0) {
            counter += 10;
    }    
}

    public void counterPoint(){
        counter-=5;
    }
    public int getCounter() {
        return counter;
    }
    public void setCounter(int score){
        counter = score;
    }
    public void addPoint(){
        counter +=100;
    }
    public void crash(){
        counter -=100;
    }
    
}
