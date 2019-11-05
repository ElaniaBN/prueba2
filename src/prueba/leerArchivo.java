package prueba;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class leerArchivo {
    //Atributos variables globales
     String linea;   //Almacenamiento de lineas del archivo
     String contenido;  //Almacenamiento de datos de archivo
     String nombreArchivo;  //Almacenamiento de nombre de archivo
     String textoSinEspacios ;    //Almacenamiento de texto sin errores
     String[] cadenas;  //Almacenamiento de cadenas por cada linea
    String cadenaErrores = "";
    
    public void imprimirArchivoErrores( ){    
        String archivoErrores = nombreArchivo + ("-HUGO-errores.txt");     
        try {
            File fichero = new File(archivoErrores);    // Crea un archivo le adiciona el nombreArchivo clientes.txt
            FileWriter escritor= new FileWriter(fichero,true); // Permite que se pueda escribir en el archivo
            BufferedWriter buffer = new BufferedWriter(escritor);
            PrintWriter escribir = new PrintWriter(buffer);
            escribir.write(cadenaErrores);
            escribir.close();
        }catch(IOException ex){
            System.out.println("Error al escribir en el archivo, No existe");
        }
    }   
    
    public void leerArchivo(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese nombre del archivo, sin la extension .hugo");   //Ingreso de nombreArchivo de archivo
        nombreArchivo = entrada.next();    //Variable de almacenamiento de nombreArchivo de archivo
        String archivo = nombreArchivo + (".hugo");
           
        try{
            File fichero = new File(archivo);    
            FileReader lector = new FileReader(fichero);    
            BufferedReader buffer = new  BufferedReader(lector);
           
            String aux = "";
            while((linea = buffer.readLine())!= null){    // recorre el archivo hasta el final 
                aux += " \n" + linea;
            }
            contenido = aux;
            buffer.close(); //Cierre de buffer
            lector.close(); //Cieere de lector
        }catch(IOException ex){
            System.out.println("Error al leer el archivo, No existe"); 
        }
    }
    
    public void archivoSinEspacios(){
        String regex = "\\s{2,}";//Mas de dos espacios
        Pattern pattern = Pattern.compile(regex);
        int contador = -1;
        cadenas = contenido.split("[\\n]");
        
        for (String cadena : cadenas) {
            Matcher matcher = pattern.matcher(cadena);
            contador++;
            if (!matcher.find()) {
                cadenaErrores +=  contador + " " + cadena + "\n";
            } else {
                cadenaErrores += contador + " " + cadena + "\n" + " Error 001 espacios duplicados" + "\n";
            }
        }
    }
    
     
    
    public void estructuraGeneral(){
        int contadorTokens = 0;
        String nombre= nombreArchivo.toUpperCase();
        
        StringTokenizer token = new StringTokenizer(textoSinEspacios,"\n",true);
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
    
    public void archivoLogo(){
        String textoContenido = contenido;
        textoContenido = textoContenido.replaceAll("( )+", " ").trim();
        
        String archivo = nombreArchivo + (".lgo");
        
        try {
            File fichero = new File(archivo);    // Crea un archivo le adiciona el nombreArchivo clientes.txt
            FileWriter escritor= new FileWriter(fichero); // Permite que se pueda escribir en el archivo
            BufferedWriter buffer = new BufferedWriter(escritor); 
            buffer.write(textoContenido);
            buffer.close();
        }catch(IOException ex){
            System.out.println("Error al escribir en el archivo, No existe"); 
        }
    }
    
    
    
    
   
}
