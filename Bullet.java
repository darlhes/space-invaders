import greenfoot.*;

public class Bullet extends Actor
{
    private final int velocidade = 8;

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
        setLocation(getX(), getY() - velocidade);
    }

    private void verificarColisao()
    {
        Enemy inimigo = (Enemy) getOneIntersectingObject(Enemy.class);

        if (inimigo != null)
        {
            World mundo = getWorld();

            if (mundo instanceof MyWorld)
            {
                MyWorld fase = (MyWorld) mundo;
                fase.inimigoDestruido(inimigo);
            }
            else
            {
                mundo.removeObject(inimigo);
            }

            mundo.removeObject(this);
        }
    }

    private void removerSeSaiuDaTela()
    {
        if (getY() < 5)
        {
            getWorld().removeObject(this);
        }
    }
}