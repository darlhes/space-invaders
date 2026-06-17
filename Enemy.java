import greenfoot.*;

public class Enemy extends Actor
{
    private final int pontos = 10;

    public Enemy()
    {
        getImage().scale(40, 30);
    }

    public int getPontos()
    {
        return pontos;
    }
}