package Objects;

import java.util.ArrayList;

public class Atendimento {

    private int id_atendimento;
    private Agendamento agendamento;
    private ArrayList<Produto> arrAtendimento;

    // Talvez dê para criar um metódo para exibir os dados do agendamento, igual fiz em outras classes.
    public Atendimento(int id_atendimento, Agendamento agendamento, ArrayList<Produto> arrAtendimento) {
        this.id_atendimento = id_atendimento;
        this.agendamento = agendamento;
        this.arrAtendimento = arrAtendimento;
    }

    // Métodos do ArrayList
    public void addAtendimento(Produto atendimento) {
        this.arrAtendimento.add(atendimento);
    }

    public void getAllAtendimento() {
        for (int i = 0; i < this.arrAtendimento.size(); i++) {
            System.out.println();
        }
    }

    // Getters and Setters
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

    public ArrayList<Produto> getArrAtendimento() {
        return arrAtendimento;
    }

    public void setArrAtendimento(ArrayList<Produto> arrAtendimento) {
        this.arrAtendimento = arrAtendimento;
    }

}
