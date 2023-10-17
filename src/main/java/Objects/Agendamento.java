
package Objects;

public class Agendamento {
   private int id_agendamento;
    private Funcionario funcionario;
    private Cliente cliente;
    //Data : Date
    //Horario : Date
    private String observacao;


    // Construtores de Agendamento
    
    public Agendamento(){

    }

    public Agendamento(int id_agendamento, Funcionario funcionario, Cliente cliente, String observacao) {
        this.id_agendamento = id_agendamento;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.observacao = observacao;
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    } 
}
