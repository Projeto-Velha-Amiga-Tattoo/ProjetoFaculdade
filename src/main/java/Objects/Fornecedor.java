package Objects;

public class Fornecedor {

    private int id_fornecedor;
    private String nome;
    private String cnpj;
    private String telefone;
    private Endereco endereco;

    @SuppressWarnings("empty-statement")
    public Fornecedor(int id_fornecedor, String nome, String cnpj, String telefone, Endereco endereco) {
        try {
            if (Validacoes.Nome.validarNomes(cnpj) && Validacoes.Cnpj.validarCNPJ(cnpj) && Validacoes.Cnpj.CNPJVerdadeiro(cnpj) && Validacoes.Telefone.validarTelefone(cnpj)) {
                this.id_fornecedor = id_fornecedor;
                this.nome = nome;
                this.cnpj = cnpj;
                this.telefone = telefone;
                this.endereco = endereco;
            } else {
                throw new IllegalArgumentException("Dados inválidos.");
            }
        } catch (IllegalArgumentException e){
           System.out.println("Erro na criação do objeto: " + e.getMessage());
        }
  
    }     
    
    public String exibirFornecedor() {
        String str = "Fornecedor: " + getNome() + "\n" + "CNPJ: " + getCnpj() + "\n"
                + "Telefone: " + getTelefone() + "\n" + "Endereço: "
                + getEndereco().getRua() + "," + getEndereco().getNumero() + "(" + getEndereco().getComplemento() + ")," + getEndereco().getBairro() + "," + getEndereco().getCidade() + "," + getEndereco().getEstado();
        return str;
    }
    

    public int getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    

}
