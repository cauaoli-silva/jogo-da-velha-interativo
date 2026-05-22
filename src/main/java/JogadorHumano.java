import java.util.Scanner;

public class JogadorHumano extends Jogador {

    public JogadorHumano(char simbolo)
    {
        super(simbolo);
    }

    @Override
    public void jogar(Tabuleiro tabuleiro)
    {
        Scanner sc = new Scanner(System.in);

        int linha;
        int coluna;

        do {
            System.out.print("Digite a linha (0-2): ");
            linha = sc.nextInt();

            System.out.print("Digite a coluna (0-2): ");
            coluna = sc.nextInt();

        } while (!tabuleiro.jogar(simbolo, linha, coluna));
    }
}