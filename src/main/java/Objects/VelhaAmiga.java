package Objects;

public class VelhaAmiga {
    public static void main(String[] args) {
      Endereco e1 = new Endereco(1,"Rua Serra xxxx xxxxxx","Jardim xxxxx",0,"casa","Ipaxxxx","3516xxxx","Minas Gerais");
      Funcionario f1 = new Funcionario(1,"luan","12344","tatuador","Luan Vixxx xxxxxx","155xxxxxx40","3199751xxxx","11/07/2000",e1);  
      System.out.println(f1.getEndereco().getRua());
      System.out.println(f1.getEndereco().getCidade());
      System.out.println(f1.getData_nasc());
        
        
    }
}
