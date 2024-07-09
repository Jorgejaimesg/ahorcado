package com.ahorcado;

import java.util.Random;
import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) {
        // Lista de palabras predeterminadas
        String[] palabras = {
            "programacion", "java", "colombia", "ahorcado",
            "computadora", "teclado", "raton", "pantalla",
            "desarrollador", "aplicacion"
        };

        // Selección de una palabra al azar
        Random random = new Random();
        String palabra = palabras[random.nextInt(palabras.length)];

        // Palabra oculta con guiones bajos
        char[] adivinanza = new char[palabra.length()];
        for (int i = 0; i < palabra.length(); i++) {
            adivinanza[i] = '_';
        }

        // Variables del juego
        int intentos = 3;
        boolean acertado = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido al juego de Ahorcado!");
        System.out.println("Tienes 3 intentos para adivinar la palabra.");
        System.out.println(adivinanza);

        // Bucle del juego
        while (intentos > 0 && !acertado) {
            System.out.print("Introduce una letra o la palabra completa: ");
            String entrada = scanner.nextLine().toLowerCase();

            if (entrada.length() == 1) {
                // Comprobar si la letra está en la palabra
                char letra = entrada.charAt(0);
                boolean letraEncontrada = false;

                // Iterar a través de la palabra para ver si la letra existe
                for (int i = 0; i < palabra.length(); i++) {
                    if (palabra.charAt(i) == letra) {
                        adivinanza[i] = letra; // Reemplazar guion bajo con la letra adivinada
                        letraEncontrada = true;
                    }
                }

                if (!letraEncontrada) {
                    intentos--; // Reducir el número de intentos si la letra no se encuentra
                    System.out.println("Letra incorrecta. Te quedan " + intentos + " intentos.");
                } else {
                    System.out.println("¡Letra correcta!");
                }
            } else if (entrada.equals(palabra)) {
                // Si el usuario adivina la palabra completa correctamente
                acertado = true;
            } else {
                intentos--; // Reducir el número de intentos si la palabra completa es incorrecta
                System.out.println("Palabra incorrecta. Te quedan " + intentos + " intentos.");
            }

            // Comprobar si la palabra ha sido adivinada completamente
            if (new String(adivinanza).equals(palabra)) {
                acertado = true;
            }

            System.out.println(adivinanza); // Mostrar el estado actual de la palabra adivinada
        }

        if (acertado) {
            System.out.println("¡Felicidades! Has adivinado la palabra: " + palabra);
        } else {
            System.out.println("Has perdido. La palabra era: " + palabra);
        }

        scanner.close(); // Cerrar el escáner
    }
}
