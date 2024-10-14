package Dados;

public class Cartoes {
    private String partida_id;
    private String rodata;
    private String clube;
    private String cartao;
    private String atleta;
    private String num_camisa;
    private String posicao;
    private String minuto;


    public String getPartida_id() {
        return partida_id;
    }

    public void setPartida_id(String partida_id) {
        this.partida_id = partida_id;
    }

    public String getRodata() {
        return rodata;
    }

    public void setRodata(String rodata) {
        this.rodata = rodata;
    }

    public String getClube() {
        return clube;
    }

    public void setClube(String clube) {
        this.clube = clube;
    }

    public String getCartao() {
        return cartao;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }

    public String getAtleta() {
        return atleta;
    }

    public void setAtleta(String atleta) {
        this.atleta = atleta;
    }

    public String getNum_camisa() {
        return num_camisa;
    }

    public void setNum_camisa(String num_camisa) {
        this.num_camisa = num_camisa;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getMinuto() {
        return minuto;
    }

    public void setMinuto(String minuto) {
        this.minuto = minuto;
    }

    @Override
    public String toString() {
        return "Cartoes{" +
                "partida_id='" + partida_id + '\'' +
                ", rodata='" + rodata + '\'' +
                ", clube='" + clube + '\'' +
                ", cartao='" + cartao + '\'' +
                ", atleta='" + atleta + '\'' +
                ", num_camisa='" + num_camisa + '\'' +
                ", posicao='" + posicao + '\'' +
                ", minuto='" + minuto + '\'' +
                '}';
    }
}
