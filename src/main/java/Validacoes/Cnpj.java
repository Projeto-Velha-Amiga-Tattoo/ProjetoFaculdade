package Validacoes;

public class Cnpj {

    public static boolean validarCNPJ(String x) {

        boolean teste = false;
        teste = x.matches("[0-9]{14}");
        return teste;
    }

    public static boolean CNPJVerdadeiro(String x) {

        boolean teste = false;
        int dv1 = 0, dv2 = 0, cont = 5, soma = 0;
        for (int y = 0; y < 12; y++) {
            soma += Character.getNumericValue(x.charAt(y)) * cont;
            cont--;
            if (cont == 1) {
                cont = 9;
            }
        }
        dv1 = 11 - (soma % 11);
        if (dv1 == 1) {
            dv1 = 0;
        }
        System.out.println("Digito 1: " + dv1);
        if (dv1 == Character.getNumericValue(x.charAt(12))) {
            cont = 6;
            soma = 0;
            for (int z = 0; z < 13; z++) {
                soma += Character.getNumericValue(x.charAt(z)) * cont;
                cont--;
                if (cont == 1) {
                    cont = 9;
                }
            }
            dv2 = 11 - (soma % 11);
            if (dv2 == 1) {
                dv2 = 0;
            }
            System.out.println("Digito 2: " + dv2);
            if (dv2 == Character.getNumericValue(x.charAt(13))) {
                teste = true;
            }
        }
        return teste;
    }
}
