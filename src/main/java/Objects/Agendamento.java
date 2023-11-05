package Objects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Agendamento {

    private int id_agendamento;
    private Funcionario funcionario;
    private Cliente cliente;
    private LocalDate data;
    private String horario;
    private String observacao;
    private Servico servico;

    DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Construtores de Agendamento
    public Agendamento() {

    }

    public Agendamento(Funcionario funcionario, Cliente cliente, String data, String horario, Servico servico, String observacao) {
        try {
            Validacoes.Data.dataVerdadeira(horario);
            this.funcionario = funcionario;
            this.cliente = cliente;
            this.data = LocalDate.parse(horario, date);
            this.horario = horario;
            this.servico = servico;
            this.observacao = observacao;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro na criação do objeto: " + e.getMessage());
        }
    }

    public String exibirAgendamento() {
        String str = "Nome do cliente: " + getCliente().getNome() + "\n" + "Funcionario: " + getFuncionario().getNome() + "\n" + "Data do agendamento: " + getHorario() + "\n" + "Serviço agendado: " + getServico().getNome() + "\n" + "Observação: " + getObservacao();
        return str;
    }

    // Getters and Setters
    public int getId_agendamento() {
        return id_agendamento;
    }

    public void setId_agendamento(int id_agendamento) {
        this.id_agendamento = id_agendamento;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getData() {
        return data.format(date);
    }

    public void setData(String data) {
        try {
            Validacoes.Data.dataVerdadeira(horario);
            this.data = LocalDate.parse(horario, date);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro na criação do objeto: " + e.getMessage());
        }

    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
  

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
