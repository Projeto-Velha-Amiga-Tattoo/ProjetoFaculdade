package curso.pefinal.DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AgendamentoDTO {

    private int id_agendamento;
    private int funcionario;
    private int cliente;
    private int horario;
    private String data;
    private String observacao;
    private int servico;

    
    // Construtores de Agendamento

    public AgendamentoDTO() {

    }

    public AgendamentoDTO(int id_agendamento, int funcionario, int cliente, String data, int horario, int servico, String observacao) {
        this.id_agendamento = id_agendamento;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.data = data;
        this.horario = horario;
        this.servico = servico;
        this.observacao = observacao;
    }

    // Getters and Setters
    public int getId_agendamento() {
        return id_agendamento;
    }

    public void setId_agendamento(int id_agendamento) {
        this.id_agendamento = id_agendamento;
    }

    public int getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(int funcionario) {
        this.funcionario = funcionario;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public int getServico() {
        return servico;
    }

    public void setServico(int servico) {
        this.servico = servico;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
