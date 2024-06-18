package orgFiuba.tpjava.Model;

import java.util.Scanner;

public class ServicioDeUserInput {
    private static Scanner scanner;

    public static void setScanner(Scanner scanner) {
        ServicioDeUserInput.scanner = scanner;
    }

    public static void inicializarScanner() {
        scanner = new Scanner(System.in);
    }

    public static String input() {
        return scanner.nextLine();
    }
}
