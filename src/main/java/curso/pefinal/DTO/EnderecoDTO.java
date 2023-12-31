package curso.pefinal.DTO;

public class EnderecoDTO {

    private int id_endereco;
    private String rua;
    private String bairro;
    private int numero;
    private String complemento;
    private String cidade;
    private String cep;
    private int estado;

    // Contrutores de endereço
    public EnderecoDTO() {

    }

    // Falta a validação para poder inserir somente numero inteiro.
    public EnderecoDTO(String rua, String bairro, int numero, String complemento, String cidade, String cep, int estado) {
            this.rua = rua;
            this.bairro = bairro;
            this.numero = numero;
            this.complemento = complemento;
            this.cidade = cidade;
            this.cep = cep;
            this.estado = estado;

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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
