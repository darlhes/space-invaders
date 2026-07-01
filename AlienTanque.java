import greenfoot.*;

public class AlienTanque extends Enemy
{
    public AlienTanque()
    {
        super(3, 20);
        GreenfootImage src = new GreenfootImage("alienn2.png");
        GreenfootImage img = new GreenfootImage(src.getWidth(), src.getHeight());
        img.drawImage(src, 0, 0);
        img.scale(50, 38);
        setImage(img);
    }
}
