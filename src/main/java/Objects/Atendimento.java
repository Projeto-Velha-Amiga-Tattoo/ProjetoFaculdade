package Objects;

public class Atendimento {

    private int id_atendimento;
    private Agendamento agendamento;

    // Talvez dê para criar um metódo para exibir os dados do agendamento, igual fiz em outras classes.
    public Atendimento(int id_atendimento, Agendamento agendamento) {
        this.id_atendimento = id_atendimento;
        this.agendamento = agendamento;
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


}
