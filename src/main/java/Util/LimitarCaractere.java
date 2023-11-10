package Util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LimitarCaractere extends PlainDocument{
    
    public enum tipoEntrada{
        INTEIRO,NOME, COMPLEMENTO, SENHA;
    };
    
    private int quantCaracteres;
    private tipoEntrada tpEntrada;

    public LimitarCaractere(int quantCaracteres, tipoEntrada tpEntrada) {
        this.quantCaracteres = quantCaracteres;
        this.tpEntrada = tpEntrada;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
       //conferir se é nulo ou se tem mais do que o número estipulado
        if(str == null || getLength() == quantCaracteres){
            return;
        }
        
        int totalCaracteres = getLength()+ str.length();
        //filtro de caracteres
        String regex = "";
        switch(tpEntrada){
            case INTEIRO: regex = "[^0-9,.]"; break;
            case NOME: regex = "[^\\p{IsLatin} ]"; break;
            case COMPLEMENTO: regex = "[^\\p{IsLatin} ,0-9]"; break;
            case SENHA: regex = "[^A-Z,a-z,0-9,!#@$%&_]";break;
        }
        
        //fazendo a substituição

        str = str.replaceAll(regex, "");
        
        
        
        if(totalCaracteres <= quantCaracteres){
            super.insertString(offs, str, a);
        }else{
            String nova = str.substring(0, quantCaracteres);
            super.insertString(offs, nova, a);
        }
        
    }
}
