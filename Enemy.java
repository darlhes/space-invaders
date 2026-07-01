import greenfoot.*;

public abstract class Enemy extends Actor
{
    protected int vida;
    protected int pontos;
    private int flashTimer = 0;

    public Enemy(int vida, int pontos)
    {
        this.vida = vida;
        this.pontos = pontos;
    }

    public void act()
    {
        if (flashTimer > 0)
        {
            flashTimer--;
            getImage().setTransparency(flashTimer % 2 == 0 ? 100 : 255);

            if (flashTimer == 0)
            {
                getImage().setTransparency(255);
            }
        }
    }

    public int getPontos()
    {
        return pontos;
    }

    public int getVida()
    {
        return vida;
    }

    public boolean receberDano()
    {
        vida--;

        if (vida <= 0)
        {
            return true;
        }

        flashTimer = 10;
        return false;
    }
}
