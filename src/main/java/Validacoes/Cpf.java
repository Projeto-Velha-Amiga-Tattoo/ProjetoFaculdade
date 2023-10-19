package Validacoes;

public class Cpf {

    public static boolean validarCPF(String x) {
        boolean teste = false;
        teste = x.matches("[0-9]{11}");
        if (teste == false){
            throw new IllegalArgumentException("O CPF não está no formato correto.");
        }
        return teste;
    }

    public static boolean CPFVerdadeiro(String x) {
        boolean teste = false;
        int dv1 = 0, dv2 = 0, cont = 10, soma = 0;
        for (int y = 0; y < 9; y++) {
            soma += Character.getNumericValue(x.charAt(y)) * cont;
            cont--;
        }
        dv1 = 11 - (soma % 11);
        if (dv1 > 9) {
            dv1 = 0;
        }
        if (dv1 == Character.getNumericValue(x.charAt(9))) {   
            cont = 11;
            soma = 0;
            for (int y = 0; y < 10; y++) {
                if (y == 9) {
                    soma += dv1 * cont;
                } else {
                    soma += Character.getNumericValue(x.charAt(y)) * cont;
                    cont--;
                }
            }
            dv2 = 11 - (soma % 11);
            if (dv2 > 9) {
                dv2 = 0;
            }
            if (dv2 == Character.getNumericValue(x.charAt(10))) {
                teste = true;
            } else{
                teste = false;
                throw new IllegalArgumentException("O CPF não existe.");
            }
        } else {
            throw new IllegalArgumentException("O CPF não existe.");
        }
        return teste;
    }

}
