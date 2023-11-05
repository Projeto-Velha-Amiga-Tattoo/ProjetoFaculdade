package Validacoes;

import java.time.Year;

public class Data {

    public static boolean dataVerdadeira(String data) {

        boolean teste = true;
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);

        int anoF = Integer.parseInt(ano);
        int mesF = Integer.parseInt(mes);
        int diaF = Integer.parseInt(dia);

        if (anoF < 1927 || anoF > Year.now().getValue()) {
            throw new IllegalArgumentException("Data invalida");

        } else if (mesF > 12 || mesF < 1) {
            throw new IllegalArgumentException("Data invalida");

        } else if (diaF > 31 || diaF < 1) {
            throw new IllegalArgumentException("Data invalida");

        } else if ((mesF == 4 || mesF == 6 || mesF == 9 || mesF == 11) && diaF > 30) {
            throw new IllegalArgumentException("Data invalida");

        } else if (mesF == 2 && diaF > 29) {
            throw new IllegalArgumentException("Data invalida");

        } else if (mesF == 2 && diaF > 28 && anoF % 4 != 0) {
            throw new IllegalArgumentException("Data invalida");

        }
        return teste;
    }

}
