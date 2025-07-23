package ui;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
            System.out.print(mensagem);
            String line = in.nextLine(); 
            return Integer.parseInt(line.trim().replaceAll(" ", ""));
        }
    }

    public static double lerDouble(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String line = in.nextLine().trim().replace(",", "."); 
            return Double.parseDouble(line);
        }
    }

    public static LocalDate lerData(String mensagem) {
        while (true) {
            System.out.print(mensagem + " (formato DD/MM/AAAA): ");
            String dataStr = in.nextLine().trim(); 
            return LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
    }
 
    public static BigDecimal lerBigDecimal(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String line = in.nextLine().trim().replace(",", ".");
            return new BigDecimal(line);
        }
    }
}