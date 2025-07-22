package ui;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputUtils {

    private static Scanner in = new Scanner(System.in); 

 
    public static void closeScanner() {
        if (in != null) {
            in.close();
        }
    }


    public static String lerString(String mensagem) {
        System.out.print(mensagem);
        return in.nextLine();
    }

    public static int lerInt(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                String line = in.nextLine(); 
                return Integer.parseInt(line.trim().replaceAll(" ", ""));
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
            }
        }
    }

    public static double lerDouble(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                String line = in.nextLine().trim().replace(",", "."); 
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um valor numérico (ex: 10.50).");
            }
        }
    }

    public static LocalDate lerData(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem + " (formato DD/MM/AAAA): ");
                String dataStr = in.nextLine().trim(); 
                return LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data inválido. Por favor, use DD/MM/AAAA.");
            }
        }
    }

 
    public static BigDecimal lerBigDecimal(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                String line = in.nextLine().trim().replace(",", ".");
                return new BigDecimal(line);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um valor numérico (ex: 10.50).");
            }
        }
    }


	
	}
