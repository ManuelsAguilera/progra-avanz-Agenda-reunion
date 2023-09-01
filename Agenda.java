import java.util.HashMap;
import java.util.Calendar;
import java.util.ArrayList;

public class Agenda{
  private HashMap<Calendar, dayMeeting> reunions = new HashMap<>();
  
  public static void main(String[] args){
    Agenda agenda = new Agenda();
    Scanner scanner = new Scanner(System.in); 
    
    while(true){
      System.out.println("1. Agregar reunión");
      System.out.println("2. Eliminar reunión");
      System.out.println("3. Mostrar reuniones de una fecha");
      System.out.println("4. Salir");
      System.out.print("Seleccione una opción: ");
      int choice = scanner.nextInt();
      scanner.nextLine();

      switch(choice){
        case 1:
          System.out.print("Ingrese la fecha (dd-mm-yyyy): ");
          String date = scanner.nextLine();
          String newDate[] = date.split("-",3);
          Calendar dateCalendar = Calendar.getInstance();
          dateCalendar.set(Calendar.DATE, Integer.parseInt(newDate[0]));
          dateCalendar.set(Calendar.MONTH, Integer.parseInt(newDate[1]) - 1);
          dateCalendar.set(Calendar.YEAR, Integer.parseInt(newDate[2]));
          System.out.print("Ingrese el título de la reunión: ");
          String title = scanner.nextLine();
          System.out.print("Ingrese la descripción de la reunión: ");
          String description = scanner.nextLine();
          System.out.print("Ingrese la hora de la reunión: ");
          int hour = scanner.nextInt();
          dayMeeting reunion = new dayMeeting(title, description, hour);
          agenda.addReunion(dateCalendar, reunion);
          System.out.println("Reunión agregada con éxito.");
          break;
        case 2:
          
          break;
        case 3:
          
          break;
        case 4:
          System.out.println("Saliendo...");
          System.exit(0);
          break;
        default:
          System.out.println("Opción inválida.");
          break;
      }
    }
  }

  public void addReunion(Calendar key, dayMeeting data){
    
    //Pero si es que quieres poner más de una reunión en una fecha esto no sirve
    if(!reunions.containsKey(key)) {
      reunions.put(key, data);
    }
    else{ 
      System.out.println("");
    }    
  }
}


/*public class Agenda {
    private Map<Calendar, dayMeeting> reunions = new HashMap<>();
    private int[][] month = new int[7][7];

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Agregar reunión");
            System.out.println("2. Eliminar reunión");
            System.out.println("3. Mostrar reuniones de una fecha");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea después de leer el número

            switch (choice) {
                case 1:
                    System.out.print("Ingrese la fecha (dd-mm-yyyy): ");
                    String date = scanner.nextLine();
                    System.out.print("Ingrese el título de la reunión: ");
                    String title = scanner.nextLine();
                    System.out.print("Ingrese la descripción de la reunión: ");
                    String description = scanner.nextLine();
                    System.out.print("Ingrese la hora de la reunión: ");
                    int hour = scanner.nextInt();
                    Reunion reunion = new Reunion(title, description, hour);
                    agenda.addReunion(date, reunion);
                    System.out.println("Reunión agregada con éxito.");
                    break;
                case 2:
                    System.out.print("Ingrese la fecha (dd-mm-yyyy): ");
                    String deleteDate = scanner.nextLine();
                    System.out.print("Ingrese el título de la reunión a eliminar: ");
                    String deleteTitle = scanner.nextLine();
                    agenda.popReunion(deleteDate, deleteTitle);
                    System.out.println("Reunión eliminada, si existía.");
                    break;
                case 3:
                    System.out.print("Ingrese la fecha (dd-mm-yyyy): ");
                    String showDate = scanner.nextLine();
                    agenda.showDate(showDate);
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida, por favor seleccione una opción válida.");
            }
		}
    }

    public void addReunion(Calendar key, Reunion data) {
        // Verificar si el ArrayList existe
        if (!reunions.containsKey(key)) {
            dayMeeting newDay = new dayMeeting();
            reunions.put(key, reunion);
        }
        else
				{
					
				}
        
    }

    private int search(ArrayList<Reunion> target, String title) {
        for (int i = 0; i < target.size(); i++) {
            if (title.equals(target.get(i).getTitle())) {
                return i;
            }
        }
        return -1;
    }

    public void popReunion(String key, String title) {
        ArrayList<Reunion> aux = reunions.get(key);
        if (aux == null) {
            return;
        }

        int position = search(aux, title);

        if (position == -1) {
            return;
        }

        aux.remove(position);
    }

    public void showDate(String key) {
        ArrayList<Reunion> aux = reunions.get(key);
        if (aux == null) {
            return;
        }
        for (int i = 0; i < aux.size(); i++) {
            aux.get(i).printR();
        }
    }
}*/