import greenfoot.*;

public class MenuWorld extends World
{
    private int corSelecionada = 0;
    private final String[] nomeCores = {"Padrao", "Azul", "Vermelho"};
    private final Color[] cores = {Color.WHITE, new Color(100, 150, 255), new Color(255, 100, 100)};

    private static int[] topScores = {0, 0, 0};

    private int opcaoAtual = 0;
    private boolean teclaAnteriorPressionada = false;

    public MenuWorld()
    {
        super(600, 400, 1);
        desenharMenu();
    }

    public static void registrarPontuacao(int pontos)
    {
        for (int i = 0; i < topScores.length; i++)
        {
            if (pontos > topScores[i])
            {
                for (int j = topScores.length - 1; j > i; j--)
                {
                    topScores[j] = topScores[j - 1];
                }

                topScores[i] = pontos;
                break;
            }
        }
    }

    private void desenharMenu()
    {
        GreenfootImage bg = getBackground();
        bg.setColor(Color.BLACK);
        bg.fill();

        GreenfootImage titulo = new GreenfootImage("SPACE INVADERS", 36, Color.GREEN, new Color(0, 0, 0, 0));
        bg.drawImage(titulo, (600 - titulo.getWidth()) / 2, 30);

        String[] opcoes = {"INICIAR JOGO", "COR DA NAVE: " + nomeCores[corSelecionada]};

        for (int i = 0; i < opcoes.length; i++)
        {
            Color cor = (i == opcaoAtual) ? Color.YELLOW : Color.WHITE;
            String prefixo = (i == opcaoAtual) ? "> " : "  ";
            GreenfootImage opcao = new GreenfootImage(prefixo + opcoes[i], 24, cor, new Color(0, 0, 0, 0));
            bg.drawImage(opcao, (600 - opcao.getWidth()) / 2, 130 + i * 50);
        }

        GreenfootImage previewLabel = new GreenfootImage("Preview:", 18, Color.GRAY, new Color(0, 0, 0, 0));
        bg.drawImage(previewLabel, (600 - previewLabel.getWidth()) / 2, 240);

        GreenfootImage navePreview = new GreenfootImage("nave.png");
        navePreview.scale(40, 33);
        aplicarCorNave(navePreview, corSelecionada);
        bg.drawImage(navePreview, (600 - navePreview.getWidth()) / 2, 265);

        GreenfootImage ranking = new GreenfootImage("--- TOP 3 ---", 20, Color.CYAN, new Color(0, 0, 0, 0));
        bg.drawImage(ranking, (600 - ranking.getWidth()) / 2, 310);

        for (int i = 0; i < topScores.length; i++)
        {
            String texto = (i + 1) + "o: " + topScores[i] + " pts";
            GreenfootImage scoreImg = new GreenfootImage(texto, 18, Color.WHITE, new Color(0, 0, 0, 0));
            bg.drawImage(scoreImg, (600 - scoreImg.getWidth()) / 2, 335 + i * 22);
        }
    }

    public void act()
    {
        boolean teclaPressionada = Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("enter") || Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("right");

        if (teclaPressionada && !teclaAnteriorPressionada)
        {
            if (Greenfoot.isKeyDown("up"))
            {
                opcaoAtual = (opcaoAtual - 1 + 2) % 2;
                desenharMenu();
            }

            if (Greenfoot.isKeyDown("down"))
            {
                opcaoAtual = (opcaoAtual + 1) % 2;
                desenharMenu();
            }

            if (opcaoAtual == 1 && (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("enter")))
            {
                corSelecionada = (corSelecionada + 1) % nomeCores.length;
                desenharMenu();
            }
            else if (opcaoAtual == 0 && Greenfoot.isKeyDown("enter"))
            {
                iniciarJogo();
            }
        }

        teclaAnteriorPressionada = teclaPressionada;
    }

    private void iniciarJogo()
    {
        MyWorld jogo = new MyWorld();
        jogo.setCorNave(corSelecionada);
        Greenfoot.setWorld(jogo);
    }

    public static void aplicarCorNave(GreenfootImage img, int indiceCor)
    {
        if (indiceCor == 1)
        {
            for (int x = 0; x < img.getWidth(); x++)
            {
                for (int y = 0; y < img.getHeight(); y++)
                {
                    Color c = img.getColorAt(x, y);

                    if (c.getAlpha() > 50)
                    {
                        int r = Math.min(255, (int)(c.getRed() * 0.3));
                        int g = Math.min(255, (int)(c.getGreen() * 0.5));
                        int b = Math.min(255, (int)(c.getBlue() * 1.0 + 80));
                        img.setColorAt(x, y, new Color(r, g, Math.min(255, b), c.getAlpha()));
                    }
                }
            }
        }
        else if (indiceCor == 2)
        {
            for (int x = 0; x < img.getWidth(); x++)
            {
                for (int y = 0; y < img.getHeight(); y++)
                {
                    Color c = img.getColorAt(x, y);

                    if (c.getAlpha() > 50)
                    {
                        int r = Math.min(255, (int)(c.getRed() * 1.0 + 80));
                        int g = Math.min(255, (int)(c.getGreen() * 0.3));
                        int b = Math.min(255, (int)(c.getBlue() * 0.3));
                        img.setColorAt(x, y, new Color(Math.min(255, r), g, b, c.getAlpha()));
                    }
                }
            }
        }
    }
}
