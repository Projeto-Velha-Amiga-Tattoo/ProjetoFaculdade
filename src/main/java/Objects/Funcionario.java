package Objects;

public class Funcionario extends Pessoa {

    private int id_funcionario;
    private String user;
    private String password;
    private String funcao;

    // Construtor de Funcionario
    public Funcionario() {

    }

    public Funcionario(int id_funcionario, String user, String password, String funcao, String nome, String cpf, String telefone, String data_nasc, Endereco endereco) {
        super(nome, cpf, telefone, data_nasc, endereco);
        this.id_funcionario = id_funcionario;
        this.user = user;
        this.password = password;
        this.funcao = funcao;
    }

    public String exibirFuncionario() {
        String str = "Nome do funcionario: " + getNome() + "\n" + "CPF: " + getCpf() + "\n"
                + "Telefone: " + getTelefone() + "\n" + "Data de nascimento: " + getData_nasc() + "\n" + "Endereço: "
                + getEndereco().getRua() + "," + getEndereco().getNumero() + "(" + getEndereco().getComplemento() + ")," + getEndereco().getBairro() + "," + getEndereco().getCidade() + "," + getEndereco().getEstado();
        return str;
    }

    // Getters and Setters
    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
