
package Objects;
import java.util.Date;

public class Cliente extends Pessoa {
    private int id_cliente;

    // Construtor de Cliente

    public Cliente() {
        
    }

    public Cliente(int id_cliente, String nome, String cpf, String telefone, String data_nasc, Endereco endereco) {
        super(nome, cpf, telefone, data_nasc, endereco);
        this.id_cliente = id_cliente;
    }

    
    


    // Getters and Setters

    public int getId_cliente(){
        return id_cliente;
    }

    public void setId_cliente(int id_cliente){
        this.id_cliente = id_cliente;
    }
}
