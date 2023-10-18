package Validacoes;

public class Telefone {

    public static boolean validarTelefone(String x) {
        boolean teste = false;
        teste = x.matches("[0-9]{10,11}");
        return teste;
    }

}
