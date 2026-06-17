import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    //Variavel que controla o movimento do inimigo 
    int X_MOVE = 3;
    
    public Enemy()
    {
        getImage().scale(40, 30);
    }
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation(getX() + X_MOVE, getY());
        if ( (getX() > 590) || (getX() < 10) )
        {
            X_MOVE = X_MOVE * -1;
        }
    }
}
