import java.util.Scanner;

public class CaeserVerschluesselung {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("--- Caeser Verschluesselung ---");
            System.out.println("1: Nachricht verschlüsseln");
            System.out.println("2: Nachricht entschlüsseln"); // Arbeitsauftrag 3 [cite: 54]
            System.out.println("3: Beenden");
            System.out.print("Bitte wählen Sie eine Option: ");

            int auswahl = scanner.nextInt();
            scanner.nextLine();

            if (auswahl == 1) {
                System.out.print("Geben Sie die Nachricht ein: ");
                String text = scanner.nextLine();
                System.out.print("Geben Sie die Verschiebung (k) ein: ");
                int k = scanner.nextInt();
                scanner.nextLine();

                String ergebnis = verschluesseln(text, k);
                System.out.println("Verschlüsselter Text: " + ergebnis);
            }

            if (auswahl == 2) {
                System.out.print("Geben Sie den verschlüsselten Text ein: ");
                String text = scanner.nextLine();
                System.out.print("Geben Sie die ursprünglichen Verschiebung (k) ein: ");
                int k = scanner.nextInt();
                scanner.nextLine();

                String ergebnis = entschluesseln(text, k);
                System.out.println("Entschlüsselter Text: " + ergebnis);
            }

            if (auswahl == 3) {
                isRunning = false;
            }
        }
    }

    public static String verschluesseln(String text, int k) {
        String verschluesselterText = "";

        for (int i = 0; i < text.length(); i++) {
            char zeichen = text.charAt(i);

            if (zeichen >= 'a' && zeichen <= 'z') {
                char verschluesselteZeichen = (char) ((zeichen - 'a' + k + 26) % 26 + 'a');
                verschluesselterText += verschluesselteZeichen;
            } else if (zeichen >= 'A' && zeichen<= 'Z') {
                char verschluesselteZeichen = (char) ((zeichen - 'A' + k + 26) % 26 + 'A');
                verschluesselterText += verschluesselteZeichen;
            } else {
                verschluesselterText += zeichen;
            }
        }

        return verschluesselterText;
    }

    public static String entschluesseln(String text, int k) {
        return verschluesseln(text, -k);
    }
}
