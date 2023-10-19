package Validacoes;

public class Telefone {

    public static boolean validarTelefone(String x) {
        boolean teste = false;
        teste = x.matches("[0-9]{11,12}");
        if (teste == false){
            throw new IllegalArgumentException("O número informado não é valido.");
        }
        return teste;
    }

}
