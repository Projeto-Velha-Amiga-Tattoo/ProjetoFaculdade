package Objects;

public class Cliente extends Pessoa {

    private int id_cliente;

    // Construtor de Cliente
    public Cliente() {

    }

    public Cliente(int id_cliente, String nome, String cpf, String telefone, String data_nasc, Endereco endereco) {
        super(nome, cpf, telefone, data_nasc, endereco);
        this.id_cliente = id_cliente;
    }

    public String exibirCliente() {
        String str = "Nome do cliente: " + getNome() + "\n" + "CPF: " + getCpf() + "\n"
                + "Telefone: " + getTelefone() + "\n" + "Data de nascimento: " + getData_nasc() + "\n" + "Endereço: "
                + getEndereco().getRua() + "," + getEndereco().getNumero() + "(" + getEndereco().getComplemento() + ")," + getEndereco().getBairro() + "," + getEndereco().getCidade() + "," + getEndereco().getEstado();
        return str;
    }

    // Getters and Setters
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
}
