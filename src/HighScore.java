import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * HighScore class .
 * 
 * @Thenayan AlThenayan and Omar AlDraye
 * @v1.0
 */
public class HighScore extends Actor
{
    UserInfo userInfo;
    boolean loggedIn;
    private int highscore;
    public HighScore() {
        getHighScore();
    }
    /**
     * Act - do whatever the HighScore wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    setImage(new GreenfootImage("High Score: "+ highscore,30,Color.RED,Color.BLACK));
}
    public void setHighScore() {
        if (UserInfo.isStorageAvailable()) {
            UserInfo info = UserInfo.getMyInfo();
                info.setInt(0,highscore);
                info.store();
        }
    }
    public void getHighScore() {
        if (UserInfo.isStorageAvailable()) {
            UserInfo info = UserInfo.getMyInfo();
            highscore = info.getInt(0);
            info.store();
        }
    }
    public boolean setScore(int score){
        if(score > highscore){
            highscore = score;
            setHighScore();
            return true;
        }
        else return false;
    }
}
