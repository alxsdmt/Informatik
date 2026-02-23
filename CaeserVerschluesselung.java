import java.util.Scanner;

public class Caeser2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        
        while (isRunning) {
            System.out.println("Caeser Verschluesselung");
            System.out.println("1: Nachricht verschluesseln");
            System.out.println("2: nachricht entschluesseln (mt k)");
            System.out.println("3: nachricht entschluesseln (ohne k)");  
            System.out.println("4: Programm beenden");
            System.out.print("Bitte waehlen Sie eine Option aus (1/2/3 eingeben): ");
            
            int auswahl = scanner.nextInt();
            scanner.nextLine();
            
            if (auswahl == 1) {
                System.out.print("Geben Sie den zuverschluessenden Text ein: ");
                String text = scanner.nextLine();
                
                char[] charArr = text.toCharArray();
                
                System.out.print("Geben Sie die Verschiebung (k) ein: ");
                int k = scanner.nextInt();
                scanner.nextLine();
                
                System.out.println("Verschluesselter Text: " + verschluesseln(charArr, k));
            }
            
            if (auswahl == 2) {
                System.out.print("Geben Sie den verschluesselten Text ein: ");
                String text = scanner.nextLine();
                char[] charArr = text.toCharArray();
                System.out.print("Geben Sie die urspruenglichen Verschiebung (k) ein: ");
                int k = scanner.nextInt();
                scanner.nextLine();
                
                System.out.println("Entschluesselter Text: " + entschluesseln(charArr, k));
            }
            
            if (auswahl == 4) {
                isRunning = false;
            }
        }
    }

    public static String verschluesseln(char[] charArr, int k) {
        
        
        for (int i = 0; i < charArr.length; i++) {
            char zeichen = charArr[i];
            
            if (zeichen >= 'a' && zeichen <= 'z') {
                charArr[i] = (char) ((zeichen - 'a' + k + 26) % 26 + 'a');
                
            } else if (zeichen >= 'A' && zeichen<= 'Z') {
                charArr[i] = (char) ((zeichen - 'A' + k + 26) % 26 + 'A');
                
            } else {
                charArr[i] = zeichen;
            }
        }
        String string = String.valueOf(charArr);
        return string;
    }

    public static String entschluesseln(char[] charArr, int k) {
        return verschluesseln(charArr, -k);
    }
    
    public static int[] entschluesselnOhneK(char[] charArr) {
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        
        for (int i = 0; i <= charArr.length; i++) {
            for (char charaktere : charArr) {
                if (charaktere ==  (char) ( 'a' || 'b' || 'c' || 'd' || 'e' || 'f' || 'g' || 'h' || 'i' || 'j' || 'k' || 'l' || 'm' || 'n' || 'o' || 'p' || 'q' || 'r' || 's' || 't' || 'u' || 'v' || 'w' || 'x' || 'y' || 'z')) {
                    charAuftreten[i] = charAuftreten[i]++;
                } // end of if
            } // end of for
        } // end of for
        return charAuftreten;
    }
}
