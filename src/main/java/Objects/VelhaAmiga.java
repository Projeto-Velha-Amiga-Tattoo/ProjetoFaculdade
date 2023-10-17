package Objects;

public class VelhaAmiga {
    public static void main(String[] args) {
      
      Endereco e1 = new Endereco(1,"Rua Serra xxxx xxxxxx","Jardim xxxxx",0,"casa","Ipaxxxx","3516xxxx","Minas Gerais");
      Endereco e2 = new Endereco(2,"Av Jk","Jardim xxxxxx",0,"loja","Ipaxxxxxx","3516xxxx","Minas Gerais");
      Funcionario f1 = new Funcionario(1,"luan","12344","tatuador","Luan Vixxx xxxxxx","155xxxxxx40","3199751xxxx","11/07/2000",e1);  
      Cliente c1 = new Cliente(1,"Leonardo xxxxxxxx","637xxxxxx00","3199xxxxxx09","26/12/2005",e2);
      
      Agendamento a1 = new Agendamento(1,f1,c1,"17/10/2023 15:30:00","nada a observar");
      
      System.out.println(a1.exibirAgendamento());
        
        
    }
}
