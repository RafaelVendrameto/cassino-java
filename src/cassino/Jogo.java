package cassino;

import java.util.Random;

public class Jogo {
    public Jogador jogador;
    public Jogador cassino;
    private Random dados = new Random();

    public Jogo(Jogador jogador) {
        this.jogador = jogador;
        this.cassino = new Jogador("CPU", 300);
    }

    public String jogar(){

        jogador.setNumeroSorteado((dados.nextInt(6) + 1) + (dados.nextInt(6) + 1));
        cassino.setNumeroSorteado((dados.nextInt(6) + 1) + (dados.nextInt(6) + 1));

        String msg = "";
        if (jogador.getNumeroSorteado() > cassino.getNumeroSorteado()){
            msg = "ganhou";
        }else if (jogador.getNumeroSorteado() < cassino.getNumeroSorteado()){
            msg = "perdeu";
        }else{
            msg = "empatou";
        }
        return msg;
    }

}
