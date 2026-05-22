import java.util.Random;

public class JogadorMaquina extends Jogador {

    public JogadorMaquina(char simbolo)
    {
        super(simbolo);
    }

    @Override
    public void jogar(Tabuleiro tabuleiro)
    {
        Random random = new Random();

        int linha;
        int coluna;

        do {
            linha = random.nextInt(3);
            coluna = random.nextInt(3);

        } while (!tabuleiro.jogar(simbolo, linha, coluna));
    }
}