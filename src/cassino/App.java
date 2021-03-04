package cassino;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Bem Vindo ao Cassino!");
        System.out.print("Digite seu nome para começarmos: ");
        Jogador jogador = new Jogador(ler.nextLine(), 100);
        Jogo jogo = new Jogo(jogador);
        System.out.println(jogo.jogador.getNome() + ", será jogado dois dados para você, e dois para a CPU.");
        System.out.println("Quem tirar a maior soma, vance e leva a aposta");

        while (jogo.jogador.getSaldo() > 0){
            System.out.println("Seu saldo é de " + jogo.jogador.getSaldo());
            System.out.println("Saldo da CPU é de " + jogo.cassino.getSaldo());
            System.out.println();
            System.out.print("Faça uma aposta de 20, 40, 60, 80 ou 100: ");
            int aposta = ler.nextInt();
            if (jogador.getSaldo() < aposta) {
                System.out.println("Por favor digite uma aposta menor que seu saldo.");
            }

            String jogada = jogo.jogar();
            String msg = "";
            if (jogada.equals("ganhou")){
                jogo.jogador.setSaldo(jogo.jogador.getSaldo() + aposta);
                jogo.cassino.setSaldo(jogo.cassino.getSaldo() - aposta);
                msg = jogo.jogador.getNome() + " Ganhou!";
            }else if (jogada.equals("perdeu")){
                jogo.jogador.setSaldo(jogo.jogador.getSaldo() - aposta);
                jogo.cassino.setSaldo(jogo.cassino.getSaldo() + aposta);
                msg = jogo.cassino.getNome() + " Ganhou!";
            }else if (jogada.equals("empatou")){
                msg = "Empatou!";
            }
            System.out.println(msg);
            System.out.println("Os números sorteados do " + jogo.jogador.getNome() + " são " + jogo.jogador.getNumeroSorteado());
            System.out.println("Os números sorteados do " + jogo.cassino.getNome() + " são " + jogo.cassino.getNumeroSorteado());
            System.out.println();
        }

        System.out.println("Seu saldo zerou, você perdeu!");

    }
}
