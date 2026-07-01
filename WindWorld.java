import greenfoot.*;

public class WindWorld extends World
{
    public WindWorld(int pontuacaoFinal)
    {
        super(600, 400, 1);

        GreenfootImage bg = getBackground();

        GreenfootImage titulo = new GreenfootImage("VITORIA!", 32, Color.GREEN, new Color(0, 0, 0, 0));
        bg.drawImage(titulo, (600 - titulo.getWidth()) / 2, 80);

        GreenfootImage subtitulo = new GreenfootImage(
            "All Instances Destroyed", 26, Color.CYAN, new Color(0, 0, 0, 0)
        );
        bg.drawImage(subtitulo, (600 - subtitulo.getWidth()) / 2, 130);

        GreenfootImage mensagem = new GreenfootImage(
            "Todos os inimigos foram eliminados!", 20, Color.WHITE, new Color(0, 0, 0, 0)
        );
        bg.drawImage(mensagem, (600 - mensagem.getWidth()) / 2, 180);

        GreenfootImage pontos = new GreenfootImage(
            "Pontuacao final: " + pontuacaoFinal, 22, Color.YELLOW, new Color(0, 0, 0, 0)
        );
        bg.drawImage(pontos, (600 - pontos.getWidth()) / 2, 230);

        GreenfootImage reiniciar = new GreenfootImage(
            "Pressione ENTER para voltar ao menu", 18, Color.GREEN, new Color(0, 0, 0, 0)
        );
        bg.drawImage(reiniciar, (600 - reiniciar.getWidth()) / 2, 300);

        Greenfoot.playSound("win.wav");
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
