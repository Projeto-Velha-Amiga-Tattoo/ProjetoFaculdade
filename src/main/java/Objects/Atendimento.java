
package Objects;

import java.util.ArrayList;

public class Atendimento {
    private int id_atendimento;
    private Agendamento agendamento;
    private ArrayList<Produto> produtos = new ArrayList<>();
    
    // ..... Não sei se esse ArrayList de produto está feito corretamente, ao gerar o construtor pela IDE ele não foi pra dentro do construtor  
    // E não testei essa parte ainda
    // Talvez dê para criar um metódo para exibir os dados do agendamento, igual fiz em outras classes.
    
    public Atendimento(int id_atendimento, Agendamento agendamento) {
        this.id_atendimento = id_atendimento;
        this.agendamento = agendamento;
    }
    
    

    public int getId_atendimento() {
        return id_atendimento;
    }

    public void setId_atendimento(int id_atendimento) {
        this.id_atendimento = id_atendimento;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
    
    
}
