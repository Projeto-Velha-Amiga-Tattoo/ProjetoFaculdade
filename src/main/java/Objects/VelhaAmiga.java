package Objects;

public class VelhaAmiga {

    public static void main(String[] args) {

        Endereco e1 = new Endereco(1, "Rua Serra dos Cocais", "Jardim Panorama", 239, "casa", "Ipatinga", "35164232", "Minas Gerais");
        Cliente c1 = new Cliente(1,"Luan Vitor Martins Araujo","15583345640","31997514125","11/07/2000",e1);
        System.out.println(c1.exibirCliente());

    }
}
