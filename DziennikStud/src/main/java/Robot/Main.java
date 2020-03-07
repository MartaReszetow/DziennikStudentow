package Robot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Robot robot = new Robot(100, "Robocik", true);
        Scanner scanner = new Scanner(System.in);

        String komenda;

        do {
            System.out.println("Podaj komendę:");
            System.out.println(" - ruch [KROK_LEWA, KROK_PRAWA, RUCH_REKA_LEWA, RUCH_REKA_PRAWA, SKOK]");
            System.out.println(" - naladuj");
            System.out.println(" - włącz");
            System.out.println(" - wyłacz");
            komenda = scanner.nextLine();
            if (komenda.equalsIgnoreCase("włącz")) {
                robot.włącz();
            } else if (komenda.equalsIgnoreCase("wyłącz")) {
                robot.wyłącz();
            } else if (komenda.equalsIgnoreCase("naładuj")) {
                robot.naladujRobota();
            } else if (komenda.startsWith("ruch")) {
                String[] slowa = komenda.split(" "); // dziele komende na slowa
                String rodzajRuchu = slowa[1];

                // String -> enum odpowiedniego typu
                RuchRobota ruch = RuchRobota.valueOf(rodzajRuchu.toUpperCase());
                robot.poruszRObotem(ruch);
            }
        }
        while
        (!komenda.equalsIgnoreCase("quit"));
    }
}

