import greenfoot.*;

public class AlienRapido extends Enemy
{
    public AlienRapido()
    {
        super(1, 5);
        GreenfootImage src = new GreenfootImage("alienn2.png");
        GreenfootImage img = new GreenfootImage(src.getWidth(), src.getHeight());
        img.drawImage(src, 0, 0);
        img.scale(30, 22);
        setImage(img);
    }
}
