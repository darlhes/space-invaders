import greenfoot.*;

public class Hero extends Actor
{
    private SimpleTimer shotTimer = new SimpleTimer();

    private final int intervaloTiro = 250;
    private final int velocidade = 5;

    public Hero()
    {
        getImage().scale(30, 25);
    }

    public void act()
    {
        mover();
        atirar();
    }

    private void mover()
    {
        if (Greenfoot.isKeyDown("right"))
        {
            move(velocidade);
        }

        if (Greenfoot.isKeyDown("left"))
        {
            move(-velocidade);
        }
    }

    private void atirar()
    {
        if (Greenfoot.isKeyDown("space") && shotTimer.millisElapsed() > intervaloTiro)
        {
            getWorld().addObject(new Bullet(), getX(), getY());
            shotTimer.mark();
        }
    }
}