package Objects;

public class Servico {

    private int id_servico;
    private String nome;

    //Construtores de Servico
    public Servico() {

    }

    public Servico(int id_servico, String nome) {
        this.id_servico = id_servico;
        this.nome = nome;
    }

    //Getters and Setters
    public int getId_servico() {
        return id_servico;
    }

    public void setId_servico(int id_servico) {
        this.id_servico = id_servico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
