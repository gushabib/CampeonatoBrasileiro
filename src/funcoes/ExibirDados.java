package funcoes;

public class ExibirDados {

    public static String timesMaisVencedores2008 = GetDados.getTimeQueMaisVenceu("2008").toString();
    public static String estadoComMenosJogos = String.valueOf(GetDados.getEstadoComMenosJogos(2003, 2022));
    public static String jogadorMaisGols = String.valueOf(GetDados.getJogadorQueMaisFezGols(false, "Gol Contra"));
    public static String jogadorMaisPenaltis = String.valueOf(GetDados.getJogadorQueMaisFezGols(true, "Penalty"));
    public static String jogadorMaisGolsContra = String.valueOf(GetDados.getJogadorQueMaisFezGols(true, "Gol Contra"));
    public static String jogadorMaisAmarelos = String.valueOf(GetDados.getJogadorQueMaisRecebeuCartoes("Amarelo"));
    public static String jogadorMaisVermelhos = String.valueOf(GetDados.getJogadorQueMaisRecebeuCartoes("Vermelho"));
    public static String partidaComMaisGols = GetDados.getPartidaComMaisGols().toString();

    public static void exibirDados (){

        System.out.println("======================================================");
        System.out.println("Estatísticas do Campeonato Brasileiro - 2003 a 2023");
        System.out.println("======================================================");

        System.out.println("Os times que mais venceram jogos em 2008 foram: " + timesMaisVencedores2008);

        System.out.println("\nO estado que teve menos jogos entre 2003 e 2022 foi: " + estadoComMenosJogos);

        System.out.println("\nO jogador que mais marcou gols (excluindo gols contra): " + jogadorMaisGols);

        System.out.println("\nO jogador que mais marcou gols de pênalti: " + jogadorMaisPenaltis);

        System.out.println("\nO jogador que mais marcou gols contra (ou seja, em seu próprio gol): " + jogadorMaisGolsContra);

        System.out.println("\nO jogador que mais recebeu cartões amarelos: " + jogadorMaisAmarelos);

        System.out.println("\nO jogador que mais recebeu cartões vermelhos: " + jogadorMaisVermelhos);

        System.out.println("\nO placar da partida com mais gols: " + partidaComMaisGols);
        System.out.println("======================================================");
    }
}