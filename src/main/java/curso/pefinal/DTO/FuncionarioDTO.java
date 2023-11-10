package curso.pefinal.DTO;

public class FuncionarioDTO extends PessoaDTO {

    private int id_funcionario;
    private LoginDTO login;
    private int funcao;
    
    // Construtor de Funcionario
    public FuncionarioDTO() {

    }

    // Não coloquei validação para user,senha e função.
    
    public FuncionarioDTO(LoginDTO login, int funcao, String nome, String cpf, String telefone, String data_nasc, EnderecoDTO endereco) {
        super(nome, cpf, telefone, data_nasc, endereco);
        this.login = login;
        this.funcao = funcao;
    }

    // Getters and Setters
    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public LoginDTO getLogin() {
        return login;
    }

    public void setLogin(LoginDTO login) {
        this.login = login;
    }
    
    public int getFuncao() {
        return funcao;
    }

    public void setFuncao(int funcao) {
        this.funcao = funcao;
    }
}
