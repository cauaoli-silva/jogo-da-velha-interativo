import java.util.Random;
import java.util.Scanner;

class JogoDaVelha
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.print("Escolha seu símbolo (X ou O): ");
        char simboloHumano = sc.next().toUpperCase().charAt(0);
        char simboloMaquina = (simboloHumano == 'X') ? 'O' : 'X';

        Jogador jogador1 = new Jogador(simboloHumano); 
        Jogador jogador2 = new Jogador(simboloMaquina); 
        
        Tabuleiro tabuleiro = new Tabuleiro();

        int linha, coluna;
        int partida = 1;

        while(!tabuleiro.acabouOJogo())
        {
            System.out.println("Partida " + partida);

           
            do {
                System.out.print("Digite a linha (0-2): ");
                linha = sc.nextInt();

                System.out.print("Digite a coluna (0-2): ");
                coluna = sc.nextInt();

            } while (!tabuleiro.jogar(jogador1.getSimbolo(), linha, coluna));

            System.out.println("Jogador 1 (Humano) jogou:");

            if (tabuleiro.acabouOJogo()) {
                break;
            }

            
            do {
                linha = random.nextInt(3);
                coluna = random.nextInt(3);
            } while(!tabuleiro.jogar(jogador2.getSimbolo(), linha, coluna));

            System.out.println("Jogador 2 (Máquina) jogou:");

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

        System.out.println("Criado por Cauã");
        sc.close();
    }
}