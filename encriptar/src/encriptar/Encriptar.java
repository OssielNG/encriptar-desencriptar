/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptar;

import java.util.Scanner;

/**
 *
 * @author ossiel
 */
public class Encriptar {
public static String encriptar(String texto, String clave) {
        int tamañoTexto = texto.length()-1;
        int tamañoClave = clave.length()-1;
        int temp, p = 0;
        String encriptado = "";
        int textoAscci[] = new int[tamañoTexto];
        int claveAscci[] = new int[tamañoClave];

        for (int i = 0; i <= tamañoTexto; i++) {
            textoAscci[i] = texto.charAt(i);
        }

        for (int i = 0; i <= tamañoClave; i++) {
            claveAscci[i] = clave.charAt(i);
        }

        //encriptar
        for (int i = 0; i <= tamañoTexto; i++) {
            p++;
            if (p >= tamañoClave) {
                p = 0;
            }
            temp = textoAscci[i] + claveAscci[p];
            if (temp > 255) {
                temp = temp - 255;
            }
            encriptado = encriptado + (char) temp;
        }
        return encriptado;
    }

    public static String desencriptar(String texto, String clave) {
        int tamañoTexto = texto.length();
        int tamañoClave = clave.length();
        int temp, p = 0;
        String desencriptado = "";
        int textoAscci[] = new int[tamañoTexto];
        int claveAscci[] = new int[tamañoClave];

        for (int i = 0; i <= tamañoTexto; i++) {
            textoAscci[i] = texto.charAt(i);
        }

        for (int i = 0; i <= tamañoClave; i++) {
            claveAscci[i] = clave.charAt(i);
        }

        //desencriptar
        for (int i = 0; i <= tamañoTexto; i++) {
            p++;
            if (p >= tamañoClave) {
                p = 0;
            }
            temp = textoAscci[i] + claveAscci[p];
            if (temp < 0) {
                temp = temp + 256;
            }
            desencriptado = desencriptado + (char) temp;
        }
        return desencriptado;

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Encriptar(1) o Desencriptar(2)");
        int n = sc.nextInt();
        
        if(n == 1){
            System.out.println("escribe la frase");
            String palabra = sc.next();
            System.out.println("escribe la clave");
            String key = sc.next();
            encriptar(palabra, key);
            System.out.println("La clave es:"+" "+ key);
        }else{
            System.out.println("escribe la codificacion");
            String palabra = sc.next();
            System.out.println("escribe la clave");
            String key = sc.next();
            desencriptar(palabra, key);
        }
    }
    
}
