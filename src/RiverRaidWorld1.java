import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * RiverRaidWorld class sets background and adds fighter jet to it
 * 
 * @Thenayan AlThenayan and Omar AlDraye
 * @v1.0
 */
public class RiverRaidWorld1 extends World
{
    private Counter count; 
    private FuelCount fuel;
    private int counter; 
    private int lives;
    private Lives lifeOut;
    private GreenfootSound bgm;
    private FighterJet jet;
    private int worldNum;
    private boolean ended;
    private boolean won;
    private HighScore high;
    private int temp;
    /**
     * Constructor for objects of class RiverRaidWorld.
     * 
     */
    public RiverRaidWorld1()
    {    
        // Create a new world with 600x600 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        ended = false;
        won = false;
        setPaintOrder (FighterJet.class);
        jet = new FighterJet();
        setSong("001.mp3");
        count = new Counter();
        fuel = new FuelCount();
        lifeOut = new Lives();
        lifeOut.setLives(3);
        high = new HighScore();
        worldNum = 1;
        setup(worldNum);
        addObject(jet,305,550);
        addObject(count,100,20);
        addObject(high,100,580);
        addObject(lifeOut,480,20);
        addObject(fuel,100,100);
        addObject(new LevelNum(worldNum),480,580);
        lives = 3;
        bgm.play();
    }
    
    public RiverRaidWorld1(int world, int score)
    {    
        // Create a new world with 600x600 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        worldNum = world;
        ended = false;
        won = false;
        jet = new FighterJet();
        lifeOut = new Lives();
        lifeOut.setLives(3);
        setSong("001.mp3");
        setPaintOrder (FighterJet.class);
        jet = new FighterJet();
        fuel = new FuelCount();
        count = new Counter();
        high = new HighScore();
        count.setCounter(score);
        addObject(jet,305,550);
        addObject(count,100,20);
        addObject(high,100,580);
        addObject(lifeOut,480,20);
        addObject(fuel,100,100);
        addObject(new LevelNum(worldNum),480,580);
        
        lives = 3;
        setup(worldNum);
        bgm.play();
    }
    public void act() {  
        if(ended){
            counter = 0;
            count.setCounter(temp);
            if(Greenfoot.isKeyDown("space")){
                bgm.stop();
                Greenfoot.setWorld(toLevel(1,0));}

        }
        
        if(won){
            count.setCounter(temp);
            lives = 100;
            if(Greenfoot.isKeyDown("enter")){
                bgm.stop();
                Greenfoot.setWorld(toLevel(4,temp));
            }
        }
        
        //Jet transformations
        if(!ended && ! (jet instanceof FighterJetLvl2) && count.getCounter() > 500){
            int newX = jet.getX();
            int newY = jet.getY();
            removeObject(jet);
            jet = new FighterJetLvl2();
            addObject(jet,newX,newY);
        }
        if(!ended && ! (jet instanceof FighterJetLvl3) && count.getCounter() > 1000){
            int newX = jet.getX();
            int newY = jet.getY();
            removeObject(jet);
            jet = new FighterJetLvl3();
            addObject(jet,newX,newY);
        }
        //Speed,timer
        counter++;
        Greenfoot.setSpeed(40+ (15*worldNum));
            
        if (counter == 5000) {
            bgm.stop();
            
            if(worldNum!=3){
                Greenfoot.setWorld(toLevel(worldNum+1,count.getCounter()));
        
            }
            else{
                bgm = new GreenfootSound("03 - Gamma Knife.mp3");
                won = true;
                temp = count.getCounter();
                bgm.play();
                addObject(new GameWon(), 300, 200);
            }
        }
        if (counter%120==0) {
            addObject(new Fuel(), Greenfoot.getRandomNumber(400)+100, 0);
            
        }
        if (counter%120==0) {
            addObject(new Coin(), Greenfoot.getRandomNumber(400)+100, 0);
            
        }
        if (counter%120==0) {
            addObject(new Tree(), 50, 0);
            addObject(new Tree(), 50, 0);
        }
       
        if (Greenfoot.getRandomNumber(1000) < 10) { 
            addObject(new FishingBoat(), Greenfoot.getRandomNumber(400)+100, 0); 
        }
        
        if(fuel.getFuel() <= 0){
            damage();
        }
    }
    
    public void damage(){
        if(!ended){
        lives--;
        count.crash();
        lifeOut.setLives(lives);
        if(lives == 0){
            temp = count.getCounter();
            high.setScore(count.getCounter());
            bgm.stop();
            bgm = new GreenfootSound("08.mp3");
            bgm.play();
            GreenfootSound sound = new GreenfootSound("track_crash.mp3");
            sound.play();
            GameOver g = new GameOver();
            addObject(g, 300,200);
            g.act();
            removeObject(jet);
            ended = true;
            //We need to use the ended variable to hold onto the fact that
            //The game is over, but render the game over screen
        }   
    }}
    
    public World toLevel(int num, int score){
        int a = num % 3;
        switch(a){
           case 1: return new RiverRaidWorld1(num,score);
           case 2: return new RiverRaidWorld2(num,score);
            default: return new RiverRaidWorld3(num,score);
        }
        
    }
    public void setup(int num){
        int a = num%3;
        switch(a){
            case 2: setSong("001.mp3");
                    break;
            case 0: setSong("001.mp3");
            default: return;
        }
    }
    public void fuelGet(){
        fuel.addFuel(10);
    }
    
    public void coinGet(){
        count.addPoint();
    }
    public void setSong(String song){
        bgm = new GreenfootSound(song);
    }
    public GreenfootSound getSong(){
        return bgm;
    }
    
    public void setCounter(Counter c){
        count = c;
    }
    public Counter getCounter(){
        return count;
    }
    
    public FuelCount getFuelCount(){
        return fuel;
    }
    public void setFuelCount(FuelCount f){
        fuel = f;
    }
    
    public void setTimer(int t){
        counter = t;
    }
    public int getTime(){
        return counter;}
     
    public int getLives(){
        return lives;}
    public void setLives(int l){ lives = l;}
    
    public Lives getLife(){ return lifeOut;}
    public void setLife(Lives l){ lifeOut = l;}
    
    public FighterJet getJet(){ return jet;}
    public void setJet(int i){ 
        switch(i){
            default: jet = new FighterJet(); break;
            case 2: jet = new FighterJetLvl2();  break;
            case 3: new FighterJetLvl3();  break;
        }
    }
    
    public int getLevel(){ return worldNum;}
    public void setLevel(int n){ worldNum = n;}
    
    public void shoot(boolean friendly, int x, int y){
        Bullet b = new Bullet(friendly);
        addObject(b,x,y);
    }
}
