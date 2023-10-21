package Objects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Agendamento {

    private int id_agendamento;
    private Funcionario funcionario;
    private Cliente cliente;
    private LocalDateTime horario;
    private String observacao;
    private Servico servico;

    
    // DATA já está com esse formatador, portanto acho que não precisa de um validador.
    DateTimeFormatter data = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    // Construtores de Agendamento

    public Agendamento() {

    }

    public Agendamento(int id_agendamento, Funcionario funcionario, Cliente cliente, String horario, Servico servico, String observacao) {
        this.id_agendamento = id_agendamento;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.horario = LocalDateTime.parse(horario, data);
        this.servico = servico;
        this.observacao = observacao;
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

    public String getHorario() {
        return data.format(horario);
    }

    public void setHorario(String horario) {
        this.horario = LocalDateTime.parse(horario, data);
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
