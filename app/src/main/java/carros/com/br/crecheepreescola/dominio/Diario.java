package carros.com.br.crecheepreescola.dominio;

/**
 * Created by Dayvison_Not on 21/03/2018.
 */

public class Diario {

    private int id;
    private String nome;
    private String presenca;
    private String data;
    private String mamadeira;
    private String lancheManha;
    private String almoco;
    private String lancheTarde;
    private String jantar;
    private String remedios;
    private String obsRemedios;
    private String participacao;
    private String sono;
    private String tempoSono;
    private String evacuacao;
    private String resumoDia;
    private int aluno_id;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPresenca() {
        return presenca;
    }

    public void setPresenca(String presenca) {
        this.presenca = presenca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMamadeira() {
        return mamadeira;
    }

    public void setMamadeira(String mamadeira) {
        this.mamadeira = mamadeira;
    }

    public String getLancheManha() {
        return lancheManha;
    }

    public void setLancheManha(String lancheManha) {
        this.lancheManha = lancheManha;
    }

    public String getAlmoco() {
        return almoco;
    }

    public void setAlmoco(String almoco) {
        this.almoco = almoco;
    }

    public String getLancheTarde() {
        return lancheTarde;
    }

    public void setLancheTarde(String lancheTarde) {
        this.lancheTarde = lancheTarde;
    }

    public String getJantar() {
        return jantar;
    }

    public void setJantar(String jantar) {
        this.jantar = jantar;
    }

    public String getRemedios() {
        return remedios;
    }

    public void setRemedios(String remedios) {
        this.remedios = remedios;
    }

    public String getObsRemedios() {
        return obsRemedios;
    }

    public void setObsRemedios(String obsRemedios) {
        this.obsRemedios = obsRemedios;
    }

    public String getParticipacao() {
        return participacao;
    }

    public void setParticipacao(String participacao) {
        this.participacao = participacao;
    }

    public String getSono() {
        return sono;
    }

    public void setSono(String sono) {
        this.sono = sono;
    }

    public String getTempoSono() {
        return tempoSono;
    }

    public void setTempoSono(String tempoSono) {
        this.tempoSono = tempoSono;
    }

    public String getEvacuacao() {
        return evacuacao;
    }

    public void setEvacuacao(String evacuacao) {
        this.evacuacao = evacuacao;
    }

    public String getResumoDia() {
        return resumoDia;
    }

    public void setResumoDia(String resumoDia) {
        this.resumoDia = resumoDia;
    }

    public int getAluno_id() {
        return aluno_id;
    }

    public void setAluno_id(int aluno_id) {
        this.aluno_id = aluno_id;
    }
}