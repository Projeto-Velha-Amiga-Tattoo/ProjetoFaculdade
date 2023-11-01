package Objects;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pedido {

    private int id_pedido;
    private Fornecedor fornecedor;
    private LocalDate data_pedido;
    private ArrayList<Produto> arrPedido;

    DateTimeFormatter data = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Pedido(int id_pedido, Fornecedor fornecedor, String data_pedido, ArrayList<Produto> arrPedido) {
        this.id_pedido = id_pedido;
        this.fornecedor = fornecedor;
        this.data_pedido = LocalDate.parse(data_pedido, data);
        this.arrPedido = arrPedido;

    }

    // Metodos ArayList
    public void addPedido(Produto pedido) {
        this.arrPedido.add(pedido);
    }

    public void getAllPedido() {
        for (Produto pedido : arrPedido) {
            System.out.println("-" + pedido.getNome());
        }
    }

    // Getters and Setters
    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getData_pedido() {
        return data_pedido.format(data);
    }

    public void setData_pedido(String data_pedido) {
        this.data_pedido = LocalDate.parse(data_pedido, data);
    }

    public ArrayList<Produto> getArrPedido() {
        return arrPedido;
    }

    public void setArrAtendimento(ArrayList<Produto> arrPedido) {
        this.arrPedido = arrPedido;
    }

}
