package Objects;

public class Produto {
   private int id_produto;
   private String nome;
   private int estoque;
   private float valorCusto;
   private float valorVenda;
   
   //FALTAM AS VALIDAÇÕES PARA OS PRODUTOS

    public Produto(int id_produto, String nome, int estoque, float valorCusto, float valorVenda) {
        this.id_produto = id_produto;
        this.nome = nome;
        this.estoque = estoque;
        this.valorCusto = valorCusto;
        this.valorVenda = valorVenda;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public float getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(float valorCusto) {
        this.valorCusto = valorCusto;
    }

    public float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }
   
   
}
