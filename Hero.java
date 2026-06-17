import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hero extends Actor
{
    SimpleTimer shotTimer = new SimpleTimer();
    int SHOT_INTERVAL = 250;
    
    public Hero()
    {
        getImage().scale(30, 25);
    }
    /**
     * Act - do whatever the Hero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("right"))
        {
            move (5);
        }
        if (Greenfoot.isKeyDown("left"))
        {
            move(-5);
        }
        
        //Aqui é onde atiramos
        if (Greenfoot.isKeyDown("space") && shotTimer.millisElapsed() > SHOT_INTERVAL)
        {
            getWorld().addObject(new Bullet(), getX(), getY());
            shotTimer.mark();
        }
    }
}
