import Dados.Campeonato;

import java.util.List;

import static Dados.Dados.*;

public class Main {
    public static void main(String[] args) {
        // List<Cartoes> cartoes = cartoes();
        // List<Gols> gols = gols();
        //List<Estatisticas> estatisticas = estatisticas();
        List<Campeonato> campeonato = campeonato();

        if (!campeonato.isEmpty()) {
            System.out.println("Cartões lidos do CSV:");
            for (Campeonato campeonatos : campeonato) {
                System.out.println(campeonatos);
            }
        } else {
            System.out.println("Nenhum gol foi encontrado ou houve um erro ao ler o arquivo.");
        }
    }
}
