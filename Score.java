import greenfoot.*;

public class Score extends Actor
{
    private int pontos;

    public Score()
    {
        pontos = 0;
        atualizarImagem();
    }

    public void adicionarPontos(int valor)
    {
        pontos += valor;
        atualizarImagem();
    }

    public int getPontos()
    {
        return pontos;
    }

    private void atualizarImagem()
    {
        setImage(new GreenfootImage("Pontos: " + pontos, 24, Color.WHITE, new Color(0, 0, 0, 0)));
    }
}