import Dados.Cartoes;

import java.util.List;

import static Dados.Data.cartoes;

public class Main {
    public static void main(String[] args) {
        List<Cartoes> cartoes = cartoes();

        if (!cartoes.isEmpty()) {
            System.out.println("Cartões lidos do CSV:");
            for (Cartoes cartao : cartoes) {
                System.out.println(cartao);
            }
        } else {
            System.out.println("Nenhum cartão foi encontrado ou houve um erro ao ler o arquivo.");
        }
    }
}
