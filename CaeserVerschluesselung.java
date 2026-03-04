import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class CaeserVerschluesselung {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println();
            System.out.println("Caeser Verschluesselung");
            System.out.println("1: Nachricht verschluesseln");
            System.out.println("2: Nachricht entschluesseln (mit k)");
            System.out.println("3: Nachricht entschluesseln (ohne k)");
            System.out.println("4: Nachricht verschluesseln (polyalphabetisch)");
            System.out.println("5: Programm beenden");
            System.out.print("Bitte waehlen Sie eine Option (1–4): ");

            int auswahl = scanner.nextInt();
            scanner.nextLine();

            if (auswahl == 1) {
                System.out.print("Geben Sie den zu verschluesselnden Text ein: ");
                String text = scanner.nextLine();
                char[] charArr = text.toCharArray();

                System.out.print("Geben Sie die Verschiebung (k) ein: ");
                int k = scanner.nextInt();
                scanner.nextLine();

                System.out.println(verschluesseln(charArr, k));
            }

            else if (auswahl == 2) {
                System.out.print("Geben Sie den verschluesselten Text ein: ");
                String text = scanner.nextLine();
                char[] charArr = text.toCharArray();

                System.out.print("Geben Sie die Verschiebung (k) ein: ");
                int k = scanner.nextInt();
                scanner.nextLine();

                System.out.println(entschluesseln(charArr, k));
            }

            else if (auswahl == 3) {
                System.out.print("Geben Sie den verschluesselten Text ein: ");
                String text = scanner.nextLine();
                char[] charArr = text.toCharArray();

                int k = wahrscheinlichstesK(charArr);
                System.out.println(entschluesseln(Arrays.copyOf(charArr, charArr.length), k));
            }

            else if (auswahl == 4) {
                System.out.print("Geben Sie den zu verschluesselnden Text ein: ");
                String text = scanner.nextLine();
                char[] charArr = text.toCharArray();


               polyalphabetischeVerschluesselung(charArr);
            }

            else if (auswahl == 5) {
                isRunning = false;
            }
        }

        scanner.close();
    }

    public static String verschluesseln(char[] charArr, int k) {
        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[i];

            if (c >= 'a' && c <= 'z') {
                charArr[i] = (char) ((c - 'a' + k + 26) % 26 + 'a');
            } else if (c >= 'A' && c <= 'Z') {
                charArr[i] = (char) ((c - 'A' + k + 26) % 26 + 'A');
            }
        }
        return String.valueOf(charArr);
    }

    public static String entschluesseln(char[] charArr, int k) {
        return verschluesseln(charArr, -k);
    }

    public static int wahrscheinlichstesK(char[] charArr) {
        int[] haeufigkeit = new int[26];

        for (char c : charArr) {
            if (c >= 'a' && c <= 'z') {
                haeufigkeit[c - 'a']++;
            } else if (c >= 'A' && c <= 'Z') {
                haeufigkeit[c - 'A']++;
            }
        }

        int maxIndex = 0;
        for (int i = 1; i < haeufigkeit.length; i++) {
            if (haeufigkeit[i] > haeufigkeit[maxIndex]) {
                maxIndex = i;
            }
        }

        int indexE = 'e' - 'a';
        return (maxIndex - indexE + 26) % 26;
    }

    public static void polyalphabetischeVerschluesselung(char[] charArr){
        Random rnd = new Random();
        int[] key = new int[charArr.length];


        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[i];

            if (c >= 'a' && c <= 'z') {
                key[i] = rnd.nextInt(26);
                charArr[i] = (char) ((c - 'a' + key[i] + 26) % 26 + 'a');
            } else if (c >= 'A' && c <= 'Z') {
                key[i] = rnd.nextInt(26);
                charArr[i] = (char) ((c - 'A' + key[i] + 26) % 26 + 'A');
            }
        }

        System.out.println(String.valueOf(charArr));
        System.out.println("Key: " + Arrays.toString(key));

    }
}
