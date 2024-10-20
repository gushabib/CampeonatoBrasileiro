package funcoes;
import Dados.*;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class GetDados {
    private static String currentDir = System.getProperty("user.dir");

    public static List<Cartoes> cartoes() {
        try{
            Path filePath = Paths.get(currentDir, "src", "Dados", "campeonato-brasileiro-cartoes.csv");
            List<Cartoes> cartoes = new CsvToBeanBuilder<Cartoes>(new FileReader(String.valueOf(filePath)))
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
            Path filePath = Paths.get(currentDir, "src", "Dados", "campeonato-brasileiro-gols.csv");
            List<Gols> gols = new CsvToBeanBuilder<Gols>(new FileReader(String.valueOf(filePath)))
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
            Path filePath = Paths.get(currentDir, "src", "Dados", "campeonato-brasileiro-estatisticas-full.csv");
            List<Estatisticas> estatisticas = new CsvToBeanBuilder<Estatisticas>(new FileReader(String.valueOf(filePath)))
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
            Path filePath = Paths.get(currentDir, "src", "Dados", "campeonato-brasileiro-full.csv");
            List<Campeonato> campeonato = new CsvToBeanBuilder<Campeonato>(new FileReader(String.valueOf(filePath)))
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
        Map<String, Long> vencedores2008 = campeonato().stream()
                .filter(data -> data.getData().contains("2008"))
                .filter(campo -> !Objects.equals(campo.getVencedor(), "-"))
                .collect(Collectors.groupingBy(vencedor -> vencedor.getVencedor(), Collectors.counting()));

        Long maxVitorias = vencedores2008.values().stream()
                .max(Long::compare)
                .orElse(0L);

        return vencedores2008.entrySet().stream()
                .filter(entrada -> entrada.getValue().equals(maxVitorias)).collect(Collectors.toList());
    }


    public static Map.Entry<String, Long> getEstadoComMenosJogos() {
        return campeonato().stream()
                .filter(jogo -> {
                    String[] dataAno = jogo.getData().toString().split("/");
                    int ano = Integer.parseInt(dataAno[2]);
                    return ano >= 2003 && ano <= 2022;
                }).collect(Collectors.groupingBy(
                        jogo -> jogo.getMandante_Estado(),
                        Collectors.counting()))
                .entrySet().stream()
                .min(Map.Entry.comparingByValue()).get();
    }

    public static Map.Entry<String, Long> getJogadorQueMaisFezGols(Boolean teste, String tipoGol) {
        if(teste){
            return gols().stream()
                    .filter(gol -> Objects.equals(gol.getTipo_de_gol(), tipoGol))
                    .collect(Collectors.groupingBy(jogador -> jogador.getAtleta(), Collectors.counting()))
                    .entrySet().stream().max(Map.Entry.comparingByValue()).get();
        }else{
            return gols().stream()
                    .filter(gol -> !Objects.equals(gol.getTipo_de_gol(), tipoGol))
                    .collect(Collectors.groupingBy(jogador -> jogador.getAtleta(), Collectors.counting()))
                    .entrySet().stream().max(Map.Entry.comparingByValue()).get();
        }
    }

    public static Map.Entry<String, Long> getJogadorQueMaisRecebeuCartoes(String cor) {
        return cartoes().stream()
                .filter(cartao -> Objects.equals(cartao.getCartao(), cor))
                .collect(Collectors.groupingBy(jogador -> jogador.getAtleta(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();
    }

    public static List<Campeonato> getPartidaComMaisGols() {
        var idPartidaComMaisGols =  GetDados.gols().stream()
                .collect(Collectors.groupingBy(partida_id -> partida_id.getPartida_id(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();

        return GetDados.campeonato().stream()
                .filter(entrada -> entrada.getID().equals(idPartidaComMaisGols)).collect(Collectors.toList());
    }
}
