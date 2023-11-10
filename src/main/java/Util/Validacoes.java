package Util;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Year;

public class Validacoes {
    public static boolean CPFVerdadeiro(String cpf){
        
        boolean teste = false;
        int contTeste = 0;
        cpf.charAt(0);
        for(int i = 1; i < 11; i++){
            if(cpf.charAt(i) == cpf.charAt(0)){
                contTeste++;
            }else{
                break;
            }
        }
        if(contTeste != 10){
            int dv1 = 0 ,dv2 = 0, cont = 10,soma = 0;
            for(int y = 0; y < 9 ;y++){
               soma += Character.getNumericValue(cpf.charAt(y)) * cont; 
               cont--;
            }
            dv1 = 11 - (soma % 11);
            if(dv1 == 10 || dv1 == 11){
                dv1 = 0;
            }
            if(dv1 == Character.getNumericValue(cpf.charAt(9))){
                cont = 11;
                soma = 0;
                for(int y = 0; y < 10 ;y++){
                    if( y == 9){
                        soma += dv1 * cont;
                    }else{
                        soma += Character.getNumericValue(cpf.charAt(y)) * cont; 
                        cont--;
                    }
                }
                dv2 = 11 - (soma % 11);
                if(dv2 == 10 || dv1 == 11){
                    dv2 = 0;
                }
                if(dv2 == Character.getNumericValue(cpf.charAt(10))){
                    teste = true;
                }
            }
        }
        
        return teste;
    }
   
    public static boolean dataVerdadeira(String data){
        
        boolean teste = true;
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        
        int anoF = Integer.parseInt(ano);
        int mesF = Integer.parseInt(mes);
        int diaF = Integer.parseInt(dia);
        
        if(anoF < 1927 || anoF > Year.now().getValue()){
            return false;
        }else if(mesF > 12 || mesF < 1){
            return false;
        }else if(diaF > 31 || diaF < 1){
            return false;
        }else if((mesF == 4 || mesF == 6 || mesF == 9 || mesF == 11) && diaF > 30 ){
            return false;
        }else if(mesF == 2 && diaF > 29 ){
            return false;
        }else if(mesF == 2 && diaF > 28 && anoF % 4 != 0){
            return false;
        }
        
        return teste;
    }
    
    public static boolean dataFutura(String data){
        
        boolean teste = true;
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        
        int anoF = Integer.parseInt(ano);
        int mesF = Integer.parseInt(mes);
        int diaF = Integer.parseInt(dia);
        
        Date hoje = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataHoje = sdf.format(hoje);
        
        String diah = dataHoje.substring(0, 2);
        String mesh = dataHoje.substring(3, 5);
        String anoh = dataHoje.substring(6);
        
        int anoHF = Integer.parseInt(anoh);
        int mesHF = Integer.parseInt(mesh);
        int diaHF = Integer.parseInt(diah);
        
        if(anoF < anoHF){
            return false;
        }else if(mesF < mesHF){
            return false;
        }else if(diaF < diaHF){
            return false;
        }
        
        return teste;
    }
}
