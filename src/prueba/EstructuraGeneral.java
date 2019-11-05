package prueba;

import java.util.StringTokenizer;

public class EstructuraGeneral {
    StringTokenizer token;  //Tokens
    
    public void estructuraGeneral(String nombreArchivo, String textoSinEspacios){
        int contadorTokens = 0;
        String nombre= nombreArchivo.toUpperCase();
        token = new StringTokenizer(textoSinEspacios, "\n",true);
        System.out.println("token" + token.countTokens());
         /*
        int totalTokens = token.countTokens();
        String []tokens = new String[totalTokens];
        while(token.hasMoreTokens()){
            String str = token.nextToken();
            tokens[contadorTokens]= String.valueOf(str);
            System.out.println(contadorTokens+ " tokens " + token.nextToken());
            contadorTokens++;
        }*/
    }
    
  
}
