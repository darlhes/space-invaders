import greenfoot.*;
import java.util.List;

public class MyWorld extends World
{
    private Score score;
    private Vidas vidas;
    private int corNave = 0;

    private int direcaoHorda = 1;
    private int contadorTiroInimigo = 0;

    private final int velocidadeHorda = 2;
    private final int descidaHorda = 2;
    private final int margemBorda = 25;
    private final int intervaloTiroInimigo = 60;

    public MyWorld()
    {
        super(600, 400, 1);

        addObject(new Hero(), 300, 350);

        score = new Score();
        addObject(score, 80, 25);

        vidas = new Vidas(5);
        addObject(vidas, 540, 25);

        criarMatrizDeInimigos();
    }

    public void setCorNave(int cor)
    {
        corNave = cor;

        if (cor > 0)
        {
            List<Hero> herois = getObjects(Hero.class);

            for (Hero h : herois)
            {
                GreenfootImage img = h.getImage();
                MenuWorld.aplicarCorNave(img, cor);
            }
        }
    }

    public void act()
    {
        moverHorda();
        disparoInimigoAleatorio();
        verificarDerrota();
        verificarVitoria();
    }

    private void criarMatrizDeInimigos()
    {
        int colunas = 6;

        int inicioX = 80;
        int inicioY = 60;

        int espacoX = 80;
        int espacoY = 45;

        for (int coluna = 0; coluna < colunas; coluna++)
        {
            int x = inicioX + coluna * espacoX;
            addObject(new ChefeAmeaca(), x, inicioY);
        }

        for (int coluna = 0; coluna < colunas; coluna++)
        {
            int x = inicioX + coluna * espacoX;
            addObject(new AlienTanque(), x, inicioY + espacoY);
        }

        for (int coluna = 0; coluna < colunas; coluna++)
        {
            int x = inicioX + coluna * espacoX;
            addObject(new AlienRapido(), x, inicioY + espacoY * 2);
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

    private void disparoInimigoAleatorio()
    {
        contadorTiroInimigo++;

        if (contadorTiroInimigo >= intervaloTiroInimigo)
        {
            contadorTiroInimigo = 0;

            List<Enemy> inimigos = getObjects(Enemy.class);

            if (!inimigos.isEmpty())
            {
                int indice = Greenfoot.getRandomNumber(inimigos.size());
                Enemy atirador = inimigos.get(indice);
                addObject(new TiroInimigo(), atirador.getX(), atirador.getY() + 20);
            }
        }
    }

    public void inimigoDestruido(Enemy inimigo)
    {
        score.adicionarPontos(inimigo.getPontos());
        removeObject(inimigo);
        Greenfoot.playSound("explosion.wav");
    }

    public void jogadorAtingido()
    {
        vidas.perderVida();

        if (vidas.getVidas() <= 0)
        {
            MenuWorld.registrarPontuacao(score.getPontos());
            Greenfoot.setWorld(new LoseWorld(score.getPontos()));
        }
    }

    private void verificarDerrota()
    {
        List<Enemy> inimigos = getObjects(Enemy.class);

        for (Enemy inimigo : inimigos)
        {
            if (inimigo.getY() >= 330)
            {
                MenuWorld.registrarPontuacao(score.getPontos());
                Greenfoot.setWorld(new LoseWorld(score.getPontos()));
                return;
            }
        }
    }

    private void verificarVitoria()
    {
        if (getObjects(Enemy.class).isEmpty())
        {
            MenuWorld.registrarPontuacao(score.getPontos());
            Greenfoot.setWorld(new WindWorld(score.getPontos()));
        }
    }
}
