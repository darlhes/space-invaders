import greenfoot.*;

public class TiroInimigo extends Actor
{
    private final int velocidade = 4;

    public TiroInimigo()
    {
        GreenfootImage img = new GreenfootImage(4, 12);
        img.setColor(Color.RED);
        img.fill();
        setImage(img);
    }

    public void act()
    {
        mover();
        verificarColisao();

        if (getWorld() != null)
        {
            removerSeSaiuDaTela();
        }
    }

    private void mover()
    {
        setLocation(getX(), getY() + velocidade);
    }

    private void verificarColisao()
    {
        Hero heroi = (Hero) getOneIntersectingObject(Hero.class);

        if (heroi != null)
        {
            heroi.receberDano();
            getWorld().removeObject(this);
        }
    }

    private void removerSeSaiuDaTela()
    {
        if (getY() > getWorld().getHeight() - 5)
        {
            getWorld().removeObject(this);
        }
    }
}
