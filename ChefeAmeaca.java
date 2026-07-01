import greenfoot.*;

public class ChefeAmeaca extends Enemy
{
    public ChefeAmeaca()
    {
        super(5, 50);
        GreenfootImage src = new GreenfootImage("alienn2.png");
        GreenfootImage img = new GreenfootImage(src.getWidth(), src.getHeight());
        img.drawImage(src, 0, 0);
        img.scale(60, 45);
        setImage(img);
    }
}
