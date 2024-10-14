package Dados;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Data {

    public static List<Cartoes> cartoes() {
        try{
            String currentDir = System.getProperty("user.dir");
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


}
