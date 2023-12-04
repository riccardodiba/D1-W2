package ese1;

import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        int[] array = generateRandomArray(5, 1, 10);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            printArray(array);

            System.out.print("Inserisci un numero (0 per uscire): ");
            int numero = scanner.nextInt();

            if (numero == 0) {
                break;
            }

            System.out.print("Inserisci la posizione (0-4): ");
            int posizione = scanner.nextInt();

            try {
                updateArray(array, posizione, numero);
            } catch (ArrayIndexOutOfBoundsException e) {
                logger.errore("Errore: Posizione non valida. Inserisci un numero compreso tra 0 e 4.");
            }
        }
    }

    private static int[] generateRandomArray(int length, int min, int max) {
        int[] array = new int[length];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }

        return array;
    }

    private static void printArray(int[] array) {
        System.out.println("Array corrente: " + Arrays.toString(array));
    }

    private static void updateArray(int[] array, int posizione, int numero) {
        if (posizione < 0 || posizione >= array.length) {
            throw new ArrayIndexOutOfBoundsException("Posizione non valida");
        }

        array[posizione] = numero;
    }
}
