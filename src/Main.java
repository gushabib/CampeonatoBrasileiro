import funcoes.Dados;

public class Main {
    public static void main(String[] args) {

        System.out.println("Os times que mais venceram jogos no ano 2008, foram:");
        System.out.println(Dados.getTimeQueMaisVenceu2008());
        System.out.println(" ");
        System.out.println("O Estado que teve menos jogos dentro do período 2003 e 2022:");
        System.out.println(Dados.getEstadoComMenosJogos());
        System.out.println(" ");
        System.out.println("O jogador que mais fez gols");
        System.out.println(Dados.getJogadorQueMaisFezGols(false, "Gol Contra"));
        System.out.println(" ");
        System.out.println("O jogador que mais fez gols de pênaltis");
        System.out.println(Dados.getJogadorQueMaisFezGols(true, "Penalty"));
        System.out.println(" ");
        System.out.println("O jogador que mais fez gols contras");
        System.out.println(Dados.getJogadorQueMaisFezGols(true, "Gol Contra"));
        System.out.println(" ");
        System.out.println("O jogador que mais recebeu cartões amarelos");
        System.out.println(Dados.getJogadorQueMaisRecebeuCartoes("Amarelo"));
        System.out.println(" ");
        System.out.println("O jogador que mais recebeu cartões vermelhos");
        System.out.println(Dados.getJogadorQueMaisRecebeuCartoes("Vermelho"));
        System.out.println(" ");
        System.out.println("O placar da partida com mais gols");
        System.out.println(Dados.getPartidaComMaisGols());

    }

}
