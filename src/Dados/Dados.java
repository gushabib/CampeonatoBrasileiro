package Dados;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Dados {
    private static String currentDir = System.getProperty("user.dir");

    public static List<Cartoes> cartoes() {
        try{
            String filePath = currentDir + File.separator + "src" + File.separator + "Dados" + File.separator + "campeonato-brasileiro-cartoes.csv";
            List<Cartoes> cartoes = new CsvToBeanBuilder<Cartoes>(new FileReader(filePath))
                    .withType(Cartoes.class)
                    .build()
                    .parse();
            return cartoes;
        }catch (IOException e){
            System.err.println("Erro lendo ou avaliando arquivo CSV: " + e.getMessage());
            return null;
        }
    }

    public static List<Gols> gols() {
        try{
            String filePath = currentDir + File.separator + "src" + File.separator + "Dados" + File.separator + "campeonato-brasileiro-gols.csv";
            List<Gols> gols = new CsvToBeanBuilder<Gols>(new FileReader(filePath))
                    .withType(Gols.class)
                    .build()
                    .parse();
            return gols;
        }catch (IOException e){
            System.err.println("Erro lendo ou avaliando arquivo CSV: " + e.getMessage());
            return null;
        }
    }

    public static List<Estatisticas> estatisticas() {
        try{
            String filePath = currentDir + File.separator + "src" + File.separator + "Dados" + File.separator + "campeonato-brasileiro-estatisticas-full.csv";
            List<Estatisticas> estatisticas = new CsvToBeanBuilder<Estatisticas>(new FileReader(filePath))
                    .withType(Estatisticas.class)
                    .build()
                    .parse();
            return estatisticas;
        }catch (IOException e){
            System.err.println("Erro lendo ou avaliando arquivo CSV: " + e.getMessage());
            return null;
        }
    }

    public static List<Campeonato> campeonato() {
        try{
            String filePath = currentDir + File.separator + "src" + File.separator + "Dados" + File.separator + "campeonato-brasileiro-full.csv";
            List<Campeonato> campeonato = new CsvToBeanBuilder<Campeonato>(new FileReader(filePath))
                    .withType(Campeonato.class)
                    .build()
                    .parse();
            return campeonato;
        }catch (IOException e){
            System.err.println("Erro lendo ou avaliando arquivo CSV: " + e.getMessage());
            return null;
        }
    }

    public static List<Map.Entry<String, Long>> getTimeQueMaisVenceu2008() {
        return campeonato().stream()
                .filter(data -> data.getData().contains("2008"))
                .filter(campo -> !Objects.equals(campo.getVencedor(), "-"))
                .collect(Collectors.groupingBy(
                        vencedor -> vencedor.getVencedor(),
                        Collectors.counting())).entrySet().stream().filter(valor -> {
                    return valor.getValue().equals(getMaiorNumerosDePartidasVencidas2008());
                }).collect(Collectors.toList());
    }

    public static Long getMaiorNumerosDePartidasVencidas2008() {
        return campeonato().stream()
                .filter(data -> data.getData().contains("2008"))
                .filter(campo -> !Objects.equals(campo.getVencedor(), "-"))
                .collect(Collectors.groupingBy(
                        vencedor -> vencedor.getVencedor(),
                        Collectors.counting())).entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getValue).orElse(null);
    }

    public static String getEstadoComMenosJogos() {
        return campeonato().stream()
                .filter(jogo -> {
                    String[] dataParts = jogo.getData().toString().split("/");
                    int ano = Integer.parseInt(dataParts[2]);
                    return ano >= 2003 && ano <= 2022;
                }).collect(Collectors.groupingBy(
                        jogo -> jogo.getMandante_Estado(),
                        Collectors.counting()))
                .entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Nenhum jogo encontrado");
    }

    public static Map.Entry<String, Long> getJogadorQueMaisFezGols() {
        return gols().stream()
                .filter(gol -> !Objects.equals(gol.getTipo_de_gol(), "Gol Contra"))
                .collect(Collectors.groupingBy(jogador -> jogador.getAtleta(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();
    }

    public static Map.Entry<String, Long> getJogadorQueMaisFezGolsDePenalty() {
        return gols().stream()
                .filter(gol -> Objects.equals(gol.getTipo_de_gol(), "Penalty"))
                .collect(Collectors.groupingBy(jogador -> jogador.getAtleta(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();
    }

    public static Map.Entry<String, Long> getJogadorQueMaisFezGolsContra() {
        return gols().stream()
                .filter(gol -> Objects.equals(gol.getTipo_de_gol(), "Gol Contra"))
                .collect(Collectors.groupingBy(jogador -> jogador.getAtleta(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();
    }

    public static Map.Entry<String, Long> getJogadorQueMaisRecebeuCartoesAmarelos() {
        return cartoes().stream()
                .filter(cartao -> Objects.equals(cartao.getCartao(), "Amarelo"))
                .collect(Collectors.groupingBy(jogador -> jogador.getAtleta(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();
    }

    public static Map.Entry<String, Long> getJogadorQueMaisRecebeuCartoesVermelhos() {
        return cartoes().stream()
                .filter(cartao -> Objects.equals(cartao.getCartao(), "Vermelho"))
                .collect(Collectors.groupingBy(jogador -> jogador.getAtleta(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();
    }
}
