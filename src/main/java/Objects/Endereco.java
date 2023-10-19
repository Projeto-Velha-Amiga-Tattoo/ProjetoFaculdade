package Objects;

public class Endereco {

    private int id_endereco;
    private String rua;
    private String bairro;
    private int numero;
    private String complemento;
    private String cidade;
    private String cep;
    private String estado;

    // Contrutores de endereço
    public Endereco() {

    }

    // Falta a validação para poder inserir somente numero inteiro.
    // Quando imprime a mensagem de erro ainda não é possivel informar qual dado foi digitado errado, talvez seja possivel usando try/catch.
    public Endereco(int id_endereco, String rua, String bairro, int numero, String complemento, String cidade, String cep, String estado) {
        try {
            Validacoes.Nome.validarNomes(rua);
            Validacoes.Nome.validarNomes(bairro);
            Validacoes.Nome.validarNomes(cidade);
            Validacoes.Cep.validarCEP(cep);
            this.id_endereco = id_endereco;
            this.rua = rua;
            this.bairro = bairro;
            this.numero = numero;
            this.complemento = complemento;
            this.cidade = cidade;
            this.cep = cep;
            this.estado = estado;
            System.out.println("Dados corretos");

        } catch (IllegalArgumentException e) {
            System.out.println("Ocorreu um erro na criação do objeto: " + e.getMessage());
        }

    }

    //Getters and Setters
    // Não está fazendo as validaçoes dentro desses métodos, não sei se pode.
    public int getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
