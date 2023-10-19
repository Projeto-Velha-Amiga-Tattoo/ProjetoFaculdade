package Validacoes;

public class Telefone {

    public static boolean validarTelefone(String x) {
        boolean teste = false;
        teste = x.matches("[0-9]{11,12}");
        return teste;
    }

}
