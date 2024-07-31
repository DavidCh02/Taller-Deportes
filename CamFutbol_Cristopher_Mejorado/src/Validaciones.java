import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Validaciones {
    public static LocalDate leerFecha(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        LocalDate fecha = null;
        while (fecha == null) {
            System.out.println(mensaje);
            try {
                fecha = LocalDate.parse(scanner.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Fecha no válida. Intente de nuevo.");
            }
        }
        return fecha;
    }
}