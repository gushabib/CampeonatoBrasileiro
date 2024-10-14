package Dados;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

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


}
