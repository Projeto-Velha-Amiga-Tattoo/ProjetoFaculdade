package Validacoes;

public class Cep {

    public static boolean validarCEP(String x) {
        boolean teste = false;
        teste = x.matches("[0-9]{8}");
        return teste;
    }

}
