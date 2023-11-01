package Objects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Venda {

    private int id_venda;
    private LocalDate data_venda;
    private Cliente cliente;
    private Funcionario funcionario;
    private ArrayList<Produto> arrVenda;

    // Não sei se o ArrayList está certo.
    DateTimeFormatter data = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Venda(int id_venda, String data_venda, Cliente cliente, Funcionario funcionario, ArrayList<Produto> arrVenda) {
        this.id_venda = id_venda;
        this.data_venda = LocalDate.parse(data_venda, data);
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.arrVenda = arrVenda;
    }

    // Métodos do ArrayList
    public void addVenda(Produto venda) {
        this.arrVenda.add(venda);
    }

    public void getAllVenda() {
        for (Produto venda : arrVenda) {
            System.out.println("-" + venda.getNome());
        }
    }

    // Getters and Setters
    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public String getData_venda() {
        return data_venda.format(data);
    }

    public void setData_venda(String data_venda) {
        this.data_venda = LocalDate.parse(data_venda, data);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public ArrayList<Produto> getArrVenda() {
        return arrVenda;
    }

    public void setArrVenda(ArrayList<Produto> arrVenda) {
        this.arrVenda = arrVenda;
    }

}
