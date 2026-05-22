import java.util.Random;
import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);

        System.out.print("Escolha seu símbolo (X ou O): ");

        char simboloHumano = sc.next().toUpperCase().charAt(0);

        char simboloMaquina = (simboloHumano == 'X') ? 'O' : 'X';

        Jogador jogador1 = new Jogador(simboloHumano);
        Jogador jogador2 = new Jogador(simboloMaquina);

        Tabuleiro tabuleiro = new Tabuleiro();

        JogoDaVelha jogoDaVelha;

        jogoDaVelha = new JogoDaVelha(jogador1,jogador2,tabuleiro);

        jogoDaVelha.iniciar();

        sc.close();
    }

    private void iniciar()
    {
        Random random = new Random();

        int linha, coluna;

        int partida = 1;

        while(!tabuleiro.acabouOJogo())
        {
            System.out.println("Partida " + partida);

            do {
                linha = random.nextInt(3);
                coluna = random.nextInt(3);
            } while (!tabuleiro.jogar(jogador1.getSimbolo(), linha, coluna));

            System.out.println("Jogador 1 jogou:");

            if (tabuleiro.acabouOJogo()) {
                break;
            }

            do {
                linha = random.nextInt(3);
                coluna = random.nextInt(3);
            } while(!tabuleiro.jogar(jogador2.getSimbolo(), linha, coluna));

            System.out.println("Jogador 2 jogou:");

            partida++;
        }

        if (tabuleiro.haUmVencedor()) {
            if (partida % 2 == 1) {
                System.out.println("O jogador 1 ganhou");
            } else {
                System.out.println("O jogador 2 ganhou");
            }
        } else {
            System.out.println("O jogo terminou empatado.");
        }
    }
}