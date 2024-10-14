package Dados;

public class Gols {
    private String partida_id;
    private String rodata;
    private String clube;
    private String atleta;
    private String minuto;
    private String tipo_de_gol;

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

    public String getAtleta() {
        return atleta;
    }

    public void setAtleta(String atleta) {
        this.atleta = atleta;
    }

    public String getMinuto() {
        return minuto;
    }

    public void setMinuto(String minuto) {
        this.minuto = minuto;
    }

    public String getTipo_de_gol() {
        return tipo_de_gol;
    }

    public void setTipo_de_gol(String tipo_de_gol) {
        this.tipo_de_gol = tipo_de_gol;
    }

    @Override
    public String toString() {
        return "Gols{" +
                "partida_id='" + partida_id + '\'' +
                ", rodata='" + rodata + '\'' +
                ", clube='" + clube + '\'' +
                ", atleta='" + atleta + '\'' +
                ", minuto='" + minuto + '\'' +
                ", tipo_de_gol='" + tipo_de_gol + '\'' +
                '}';
    }
}
