package Objects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Pessoa {
    private String nome;
    private String cpf;
    private String telefone;
    private LocalDate data_nasc;
    private Endereco endereco;
    
    DateTimeFormatter data = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Construtores de Pessoa
    
    public Pessoa(){

    }

    public Pessoa(String nome, String cpf, String telefone, String data_nasc, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.data_nasc = LocalDate.parse(data_nasc,data);
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
        return data.format(data_nasc);
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = LocalDate.parse(data_nasc,data);
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
