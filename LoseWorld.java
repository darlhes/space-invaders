import greenfoot.*;

public class LoseWorld extends World
{
    public LoseWorld(int pontuacaoFinal)
    {
        super(600, 400, 1);

        GreenfootImage bg = getBackground();

        GreenfootImage titulo = new GreenfootImage("DESTRUCTOR CALLED", 28, Color.RED, new Color(0, 0, 0, 0));
        bg.drawImage(titulo, (600 - titulo.getWidth()) / 2, 100);

        GreenfootImage mensagem = new GreenfootImage(
            "O metodo destruidor foi acionado", 20, Color.WHITE, new Color(0, 0, 0, 0)
        );
        bg.drawImage(mensagem, (600 - mensagem.getWidth()) / 2, 150);

        GreenfootImage mensagem2 = new GreenfootImage(
            "e limpou a sua nave do mapa.", 20, Color.WHITE, new Color(0, 0, 0, 0)
        );
        bg.drawImage(mensagem2, (600 - mensagem2.getWidth()) / 2, 180);

        GreenfootImage pontos = new GreenfootImage(
            "Pontuacao final: " + pontuacaoFinal, 22, Color.YELLOW, new Color(0, 0, 0, 0)
        );
        bg.drawImage(pontos, (600 - pontos.getWidth()) / 2, 230);

        GreenfootImage reiniciar = new GreenfootImage(
            "Pressione ENTER para voltar ao menu", 18, Color.GREEN, new Color(0, 0, 0, 0)
        );
        bg.drawImage(reiniciar, (600 - reiniciar.getWidth()) / 2, 300);

        Greenfoot.playSound("lose.wav");
        Greenfoot.stop();
    }

    public void act()
    {
        if (Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new MenuWorld());
        }
    }
}
