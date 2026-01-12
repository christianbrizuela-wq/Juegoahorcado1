import java.util.Scanner;
import java.util.Random;

public class Ahorcado {
    static String[] palabras = {"JAVA", "CODIGO", "SNAKE"};
    static String palabra = palabras[new Random().nextInt(3)];
    static boolean[] acertadas = new boolean[palabra.length()];
    static int vidas = 6;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (vidas > 0) {
            System.out.print("\u001B[H\u001B[2J");
            mostrarEstado();
            System.out.print("Letra: ");
            char letra = sc.next().toUpperCase().charAt(0);
            if (!adivinar(letra)) vidas--;
            if (ganaste()) break;
        }
        System.out.print("\u001B[H\u001B[2J");
        mostrarEstado();
        if (vidas > 0) System.out.println("GANASTE!");
        else System.out.println("PERDISTE: " + palabra);
    }

    static boolean adivinar(char l) {
        boolean acierto = false;
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == l) {
                acertadas[i] = true;
                acierto = true;
            }
        }
        return acierto;
    }

    static boolean ganaste() {
        for (boolean b : acertadas) if (!b) return false;
        return true;
    }

    static void mostrarEstado() {
        System.out.println("Vidas: " + vidas);
        System.out.print("Palabra: ");
        for (int i = 0; i < palabra.length(); i++) {
            if (acertadas[i]) System.out.print(palabra.charAt(i));
            else System.out.print("_ ");
        }
        System.out.println();
    }
}