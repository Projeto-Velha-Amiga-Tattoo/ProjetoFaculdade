package curso.pefinal.DTO;

public class ClienteDTO extends PessoaDTO {

    private int id_cliente;
    private LoginDTO login; 
    
    // Construtor de Cliente
    public ClienteDTO() {

    }
    
    // Acredito que não tem nada de errado com essa classe, as validações estão sendo feitas na classe mãe.
    
    
    public ClienteDTO(LoginDTO login,String nome, String cpf, String telefone, String data_nasc, EnderecoDTO endereco) {
        super(nome, cpf, telefone, data_nasc, endereco);
        this.login = login;
    }

    // Getters and Setters
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public LoginDTO getLogin() {
        return login;
    }

    public void setLogin(LoginDTO login) {
        this.login = login;
    }
    
    

}
