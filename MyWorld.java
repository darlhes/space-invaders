import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(new Hero(), 300, 350);
        
        addObject(new Enemy(), 50, 100);
        addObject(new Enemy(), 150, 100);
        addObject(new Enemy(), 250, 100);
        addObject(new Enemy(), 350, 100);
        addObject(new Enemy(), 450, 100);
    }
}
