import greenfoot.*;
import java.util.List;

public class MyWorld extends World
{
    private Score score;

    private int direcaoHorda = 1;

    private final int velocidadeHorda = 2;
    private final int descidaHorda = 2;
    private final int margemBorda = 25;

    public MyWorld()
    {
        super(600, 400, 1);

        addObject(new Hero(), 300, 350);

        score = new Score();
        addObject(score, 80, 25);

        criarMatrizDeInimigos();
    }

    public void act()
    {
        moverHorda();
        verificarDerrota();
        verificarVitoria();
    }

    private void criarMatrizDeInimigos()
    {
        int linhas = 3;
        int colunas = 6;

        int inicioX = 80;
        int inicioY = 70;

        int espacoX = 80;
        int espacoY = 45;

        for (int linha = 0; linha < linhas; linha++)
        {
            for (int coluna = 0; coluna < colunas; coluna++)
            {
                int x = inicioX + coluna * espacoX;
                int y = inicioY + linha * espacoY;

                addObject(new Enemy(), x, y);
            }
        }
    }

    private void moverHorda()
    {
        List<Enemy> inimigos = getObjects(Enemy.class);

        if (inimigos.isEmpty())
        {
            return;
        }

        boolean tocouBorda = false;

        for (Enemy inimigo : inimigos)
        {
            inimigo.setLocation(inimigo.getX() + velocidadeHorda * direcaoHorda, inimigo.getY());

            if (inimigo.getX() >= getWidth() - margemBorda || inimigo.getX() <= margemBorda)
            {
                tocouBorda = true;
            }
        }

        if (tocouBorda)
        {
            direcaoHorda *= -1;

            for (Enemy inimigo : inimigos)
            {
                inimigo.setLocation(inimigo.getX(), inimigo.getY() + descidaHorda);
            }
        }
    }

    public void inimigoDestruido(Enemy inimigo)
    {
        score.adicionarPontos(inimigo.getPontos());
        removeObject(inimigo);
    }

    private void verificarDerrota()
    {
        List<Enemy> inimigos = getObjects(Enemy.class);

        for (Enemy inimigo : inimigos)
        {
            if (inimigo.getY() >= 330)
            {
                Greenfoot.setWorld(new LoseWorld());
                return;
            }
        }
    }

    private void verificarVitoria()
    {
        if (getObjects(Enemy.class).isEmpty())
        {
            Greenfoot.setWorld(new WindWorld());
        }
    }
}