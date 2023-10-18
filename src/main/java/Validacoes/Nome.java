package Validacoes;

public class Nome {

    public static boolean validarNomes(String x) {
        boolean teste = false;
        String[] nome = x.split(" ");
        for (String n : nome) {
            teste = n.matches("^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ]+$");
            if (teste == false) {
                break;
            }
        }
        return teste;
    }
    

    public static boolean validaString(String str) {
        return str.matches("[a-zA-Z0-9]+");
    }

    public static boolean validarTamanho(String x) {
        boolean teste = false;
        if (x.length() < 5) {
            teste = true;
        }
        return teste;
    }

}
