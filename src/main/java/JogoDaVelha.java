import java.util.Random;

class JogoDaVelha
{
    private Jogador jogador1;
    private Jogador jogador2;
    private Tabuleiro tabuleiro;

    public JogoDaVelha(Jogador jogador1, Jogador jogador2, Tabuleiro tabuleiro)
    {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.tabuleiro = tabuleiro;
    }

    public static void main(String args[])
    {
        Jogador jogador1, jogador2;

        jogador1 = new Jogador('X');
        jogador2 = new Jogador('O');

        Tabuleiro tabuleiro = new Tabuleiro();

        JogoDaVelha jogoDaVelha;

        jogoDaVelha = new JogoDaVelha(jogador1,jogador2,tabuleiro);
        jogoDaVelha.iniciar();
    }

    private void iniciar()
    {
        Random random = new Random();

        int linha,coluna;

        while(!tabuleiro.acabouOJogo())
        {
            tabuleiro.imprimir();

            linha = random.nextInt(3);
            coluna = random.nextInt(3);

            if(tabuleiro.estaLivre(linha,coluna))
            {
                tabuleiro.jogar(linha,coluna,jogador1);
            }

            linha = random.nextInt(3);
            coluna = random.nextInt(3);

            if(tabuleiro.estaLivre(linha,coluna))
            {
                tabuleiro.jogar(linha,coluna,jogador2);
            }
        }

        tabuleiro.imprimir();
    }
}