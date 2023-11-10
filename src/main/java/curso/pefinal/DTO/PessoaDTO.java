package curso.pefinal.DTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class PessoaDTO {

    private String nome;
    private String cpf;
    private String telefone;
    private String data_nasc;
    private EnderecoDTO endereco;


    // Construtores de Pessoa
    public PessoaDTO() {

    }

    // recebendo 'data_nasc' no formato de String no construtor
    public PessoaDTO(String nome, String cpf, String telefone, String data_nasc, EnderecoDTO endereco) {
            this.nome = nome;
            this.cpf = cpf;
            this.telefone = telefone;
            this.data_nasc = data_nasc;
            this.endereco = endereco;

    
    }

//Getters and setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
       this.telefone = telefone;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

}
