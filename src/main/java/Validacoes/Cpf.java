package Validacoes;

public class Cpf {

    public static boolean validarCPF(String x) {
        boolean teste = false;
        teste = x.matches("[0-9]{11}");
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
        if (dv1 == 10) {
            dv1 = 0;
        }
        System.out.println("Digito 1: " + dv1);
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
            if (dv2 == 10) {
                dv2 = 0;
            }
            System.out.println("Digito 2: " + dv2);
            if (dv2 == Character.getNumericValue(x.charAt(10))) {
                teste = true;
            }
        }
        return teste;
    }
}
