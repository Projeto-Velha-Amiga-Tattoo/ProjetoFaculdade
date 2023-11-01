package Objects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {

    private String nome;
    private String cpf;
    private String telefone;
    private LocalDate data_nasc;
    private Endereco endereco;

    //classe responsável por formatar um padrão diferente do formato ISO 
    DateTimeFormatter data = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Construtores de Pessoa
    public Pessoa() {

    }

    // recebendo 'data_nasc' no formato de String no construtor
    public Pessoa(String nome, String cpf, String telefone, String data_nasc, Endereco endereco) {
        try {
            Validacoes.Nome.validarNomes(nome);
            Validacoes.Cpf.validarCPF(cpf);
            Validacoes.Cpf.CPFVerdadeiro(cpf);
            Validacoes.Telefone.validarTelefone(telefone);
            this.nome = nome;
            this.cpf = cpf;
            this.telefone = telefone;
            // convertendo data do tipo String ("dd/MM/yyyy") para LocalDate (yyyy-MM-dd)
            this.data_nasc = LocalDate.parse(data_nasc, data);
            this.endereco = endereco;

        } catch (IllegalArgumentException e) {
            System.out.println("Erro na criação do objeto: " + e.getMessage());
        }

    }

//Getters and setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        try {
            Validacoes.Nome.validarNomes(nome);

            this.nome = nome;

        } catch (IllegalArgumentException e) {
            System.out.println("Erro na criação do objeto: " + e.getMessage());
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        try {

            Validacoes.Cpf.validarCPF(cpf);
            Validacoes.Cpf.CPFVerdadeiro(cpf);

            this.cpf = cpf;

        } catch (IllegalArgumentException e) {
            System.out.println("Erro na criação do objeto: " + e.getMessage());
        }
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        try {

            Validacoes.Telefone.validarTelefone(telefone);

            this.telefone = telefone;

        } catch (IllegalArgumentException e) {
            System.out.println("Erro na criação do objeto: " + e.getMessage());
        }
    }

    public String getData_nasc() {
        return data.format(data_nasc);
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = LocalDate.parse(data_nasc, data);
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
