package agenda.logic;

import java.util.Calendar;
import java.util.Scanner;

public class ProyectoSIA_2 { // Menú para probar nomás

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----- Agenda -----");
            System.out.println("1. Agregar reunión");
            System.out.println("2. Buscar reunión");
            System.out.println("3. Eliminar reunión");
            System.out.println("4. Mostrar reuniones en una fecha");
            System.out.println("5. Agregar Testeo");
            System.out.println("6. Mostrar todas las reuniones");
            System.out.println("7. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea
            
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la fecha (en el formato yyyy-MM-dd): ");
                    String fechaStr = scanner.nextLine();
                    Calendar fecha = parseFecha(fechaStr);

                    System.out.print("Ingrese el título de la reunión: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Ingrese la descripción de la reunión: ");
                    String descripcion = scanner.nextLine();

                    System.out.print("Ingrese la hora de la reunión: ");
                    int hora = scanner.nextInt();

                    agenda.addReunion(fecha, titulo, descripcion, hora);
                    System.out.println("Reunión agregada con éxito.");
                    break;
                
                case 2:
                    System.out.print("Ingrese la fecha (en el formato yyyy-MM-dd): ");
                    fechaStr = scanner.nextLine();
                    fecha = parseFecha(fechaStr);
                    
                    System.out.print("Ingrese el título de la reunión a buscar: ");
                    titulo = scanner.nextLine();
                    
                    agenda.searchMeeting(fecha, titulo);
                    //System.out.println("");
                    break;

                case 3:
                    System.out.print("Ingrese la fecha (en el formato yyyy-MM-dd): ");
                    fechaStr = scanner.nextLine();
                    fecha = parseFecha(fechaStr);

                    System.out.print("Ingrese el título de la reunión a eliminar: ");
                    titulo = scanner.nextLine();

                    agenda.popDayMeeting(fecha, titulo);
                    System.out.println("Reunión eliminada con éxito.");
                    break;

                case 4:
                    System.out.print("Ingrese la fecha (en el formato yyyy-MM-dd): ");
                    fechaStr = scanner.nextLine();
                    fecha = parseFecha(fechaStr);

                    agenda.showDate(fecha);
                    break;
		case 5:
                    System.out.println("Agregando testeos, se mostraran en pantalla:");
                    cargarDatosDePrueba(agenda);
                    break;
                case 6:
                    agenda.showAllReunions();
                    break;
                case 7:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }

    private static Calendar parseFecha(String fechaStr) {
        String[] partes = fechaStr.split("-", 3);
        int year = Integer.parseInt(partes[0]);
        int month = Integer.parseInt(partes[1]) - 1; // Calendar.MONTH se basa en 0 para enero
        int day = Integer.parseInt(partes[2]);

        Calendar fecha = Calendar.getInstance();
        fecha.set(year, month, day, 0, 0, 0);
        fecha.set(Calendar.MILLISECOND,0);
        
        return fecha;
    }
    private static void cargarDatosDePrueba(Agenda agenda) {
        // Test 1
        Calendar fecha1 = Calendar.getInstance();
        fecha1.set(2023, Calendar.JANUARY, 15); // 15 de enero de 2023
        System.out.println("Agregando reunión el " + fecha1.getTime());
        agenda.addReunion(fecha1, "Reunión 1", "Descripción de la Reunión 1", 14);

        // Test 2
        Calendar fecha2 = Calendar.getInstance();
        fecha2.set(2023, Calendar.FEBRUARY, 10); // 10 de febrero de 2023
        System.out.println("Agregando reunión el " + fecha2.getTime());
        agenda.addReunion(fecha2, "Reunión 2", "Descripción de la Reunión 2", 16);

        // Test 3
        Calendar fecha3 = Calendar.getInstance();
        fecha3.set(2023, Calendar.MARCH, 20); // 20 de marzo de 2023
        System.out.println("Agregando reunión el " + fecha3.getTime());
        agenda.addReunion(fecha3, "Reunión 3", "Descripción de la Reunión 3", 15);

        // Test 4
        Calendar fecha4 = Calendar.getInstance();
        fecha4.set(2023, Calendar.APRIL, 5); // 5 de abril de 2023
        System.out.println("Agregando reunión el " + fecha4.getTime());
        agenda.addReunion(fecha4, "Reunión 4", "Descripción de la Reunión 4", 13);

        // Test 5
        Calendar fecha5 = Calendar.getInstance();
        fecha5.set(2023, Calendar.MAY, 12); // 12 de mayo de 2023
        System.out.println("Agregando reunión el " + fecha5.getTime());
        agenda.addReunion(fecha5, "Reunión 5", "Descripción de la Reunión 5", 17);

        // Test 6
        Calendar fecha6 = Calendar.getInstance();
        fecha6.set(2023, Calendar.JUNE, 25); // 25 de junio de 2023
        System.out.println("Agregando reunión el " + fecha6.getTime());
        agenda.addReunion(fecha6, "Reunión 6", "Descripción de la Reunión 6", 14);

        // Test 7
        Calendar fecha7 = Calendar.getInstance();
        fecha7.set(2023, Calendar.JULY, 8); // 8 de julio de 2023
        System.out.println("Agregando reunión el " + fecha7.getTime());
        agenda.addReunion(fecha7, "Reunión 7", "Descripción de la Reunión 7", 16);

        // Test 8
        Calendar fecha8 = Calendar.getInstance();
        fecha8.set(2023, Calendar.AUGUST, 30); // 30 de agosto de 2023
        System.out.println("Agregando reunión el " + fecha8.getTime());
        agenda.addReunion(fecha8, "Reunión 8", "Descripción de la Reunión 8", 15);

        // Test 9
        Calendar fecha9 = Calendar.getInstance();
        fecha9.set(2023, Calendar.SEPTEMBER, 17); // 17 de septiembre de 2023
        System.out.println("Agregando reunión el " + fecha9.getTime());
        agenda.addReunion(fecha9, "Reunión 9", "Descripción de la Reunión 9", 13);

        System.out.println("Agregando reunión el " + fecha9.getTime());
        agenda.addReunion(fecha9, "Reunión 9.5", "Descripción de la Reunión 9.5", 14);
        // Test 10
        Calendar fecha10 = Calendar.getInstance();
        fecha10.set(2023, Calendar.OCTOBER, 3); // 3 de octubre de 2023
        System.out.println("Agregando reunión el " + fecha10.getTime());
        agenda.addReunion(fecha10, "Reunión 10", "Descripción de la Reunión 10", 14);
    }
}
