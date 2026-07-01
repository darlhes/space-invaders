import greenfoot.*;

public class Hero extends Actor
{
    private SimpleTimer shotTimer = new SimpleTimer();
    private SimpleTimer invencibilidadeTimer = new SimpleTimer();

    private final int intervaloTiro = 250;
    private final int velocidade = 5;
    private final int tempoInvencibilidade = 1500;

    private boolean invencivel = false;

    public Hero()
    {
        getImage().scale(30, 25);
    }

    public void act()
    {
        mover();
        atirar();
        atualizarInvencibilidade();
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
            Greenfoot.playSound("shoot.wav");
            shotTimer.mark();
        }
    }

    public void receberDano()
    {
        if (invencivel)
        {
            return;
        }

        World mundo = getWorld();

        if (mundo instanceof MyWorld)
        {
            ((MyWorld) mundo).jogadorAtingido();
        }

        Greenfoot.playSound("hit.wav");
        invencivel = true;
        invencibilidadeTimer.mark();
    }

    private void atualizarInvencibilidade()
    {
        if (invencivel)
        {
            if (invencibilidadeTimer.millisElapsed() > tempoInvencibilidade)
            {
                invencivel = false;
                getImage().setTransparency(255);
            }
            else
            {
                int transparencia = (invencibilidadeTimer.millisElapsed() / 100) % 2 == 0 ? 100 : 255;
                getImage().setTransparency(transparencia);
            }
        }
    }
}
