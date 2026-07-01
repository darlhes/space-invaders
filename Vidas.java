import greenfoot.*;

public class Vidas extends Actor
{
    private int vidas;

    public Vidas(int vidasIniciais)
    {
        vidas = vidasIniciais;
        atualizarImagem();
    }

    public void perderVida()
    {
        vidas--;
        atualizarImagem();
    }

    public int getVidas()
    {
        return vidas;
    }

    private void atualizarImagem()
    {
        setImage(new GreenfootImage("Vidas: " + vidas, 24, Color.WHITE, new Color(0, 0, 0, 0)));
    }
}
