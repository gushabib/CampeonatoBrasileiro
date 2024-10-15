import Dados.Dados;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

//        O time que mais venceu jogos no ano 2008
        var maiorNumerosDePartidasVencidas2008 =  Dados.campeonato().stream()
                .filter(data -> data.getData().contains("2008"))
                .filter(campo -> !Objects.equals(campo.getVencedor(), "-"))
                .collect(Collectors.groupingBy(
                        vencedor -> vencedor.getVencedor(),
                        Collectors.counting())).entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getValue).orElse(null);

        var timeQueMaisVenceu2008 = Dados.campeonato().stream()
                .filter(data -> data.getData().contains("2008"))
                .filter(campo -> !Objects.equals(campo.getVencedor(), "-"))
                .collect(Collectors.groupingBy(
                        vencedor -> vencedor.getVencedor(),
                        Collectors.counting())).entrySet().stream().filter(valor -> {
                    return valor.getValue().equals(maiorNumerosDePartidasVencidas2008);
                }).collect(Collectors.toList());






        //System.out.println(timeQueMaisVenceu2008.toString().split("=")[1].split("]")[0]);
        System.out.println(timeQueMaisVenceu2008);
//        O Estado que teve menos jogos dentro do período 2003 e 2022
//        O jogador que mais fez gols
//        O jogador que mais fez gols de pênaltis
//        O jogador que mais fez gols contras
//        O jogador que mais recebeu cartões amarelos
//        O jogador que mais recebeu cartões vermelhos
//        O placar da partida com mais gols.



    }
}
