package Dados;

public class Campeonato {
    private String ID;
    private String rodata;
    private String data;
    private String hora;
    private String mandante;
    private String visitante;
    private String formacao_mandante;
    private String formacao_visitante;
    private String tecnico_mandante;
    private String tecnico_visitante;
    private String vencedor;
    private String arena;
    private String mandante_Placar;
    private String visitante_Placar;
    private String mandante_Estado;
    private String visitante_Estado;

    public String getID() {
        return ID;
    }

    public String getRodata() {
        return rodata;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getMandante() {
        return mandante;
    }

    public String getVisitante() {
        return visitante;
    }

    public String getFormacao_mandante() {
        return formacao_mandante;
    }

    public String getFormacao_visitante() {
        return formacao_visitante;
    }

    public String getTecnico_mandante() {
        return tecnico_mandante;
    }

    public String getTecnico_visitante() {
        return tecnico_visitante;
    }

    public String getVencedor() {
        return vencedor;
    }

    public String getArena() {
        return arena;
    }

    public String getMandante_Placar() {
        return mandante_Placar;
    }

    public String getVisitante_Placar() {
        return visitante_Placar;
    }

    public String getMandante_Estado() {
        return mandante_Estado;
    }

    public String getVisitante_Estado() {
        return visitante_Estado;
    }

    @Override
    public String toString() {
        return "Jogo: " +
                "ID='" + ID + '\'' +
                ", rodada='" + rodata + '\'' +
                ", data='" + data + '\'' +
                ", mandante='" + mandante + '\'' +
                ", visitante='" + visitante + '\'' +
                ", mandante_Placar='" + mandante_Placar + '\'' +
                ", visitante_Placar='" + visitante_Placar + '\'' +
                ' ';
    }
}
