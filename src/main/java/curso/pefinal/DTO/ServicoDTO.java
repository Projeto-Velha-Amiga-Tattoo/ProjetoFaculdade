package curso.pefinal.DTO;

public class ServicoDTO {

    private int id_servico;
    private String nome;

    //Construtores de Servico
    public ServicoDTO() {

    }

    public ServicoDTO(String nome) {
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
