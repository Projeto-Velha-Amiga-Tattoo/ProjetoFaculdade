package Validacoes;

public class Nome {

    public static boolean validarNomes(String x) {
        boolean teste = false;
        String[] nome = x.split(" ");
        for (String n : nome) {
            teste = n.matches("^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ]+$");
            if (teste == false) {
                throw new IllegalArgumentException("Caracteres inválidos");
            }
        }
        return teste;
    }
    

    public static boolean validaString(String str) {
        boolean teste = str.matches("[a-zA-Z0-9]+");
        if (teste == false){
            throw new IllegalArgumentException("Caractere especial não é aceito");
        }
        return teste; 
    }

    public static boolean validarTamanho(String x) {
        boolean teste = false;
        if (x.length() < 5) {
            teste = true;
        } else {
            throw new IllegalArgumentException("Deve ser maior que 5 caracteres");
        }
        
        return teste;
    }

}
