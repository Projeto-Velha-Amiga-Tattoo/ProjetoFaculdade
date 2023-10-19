package Validacoes;

public class Cep {

    public static boolean validarCEP(String x) {
        boolean teste = false;
        teste = x.matches("[0-9]{8}");
        if (teste == false) {
            throw new IllegalArgumentException("CEP informado é inválido.");
        }
        return teste;
    }

}
