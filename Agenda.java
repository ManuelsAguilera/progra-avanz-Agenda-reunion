import java.util.HashMap;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Scanner;

public class Agenda{
  private HashMap<Calendar, dayMeeting> reunions = new HashMap<>();
	
  public static void main(String[] args){
    Agenda agenda = new Agenda();
    Scanner scanner = new Scanner(System.in); 
    //agenda.inicializarDatosDePrueba();
		
    while(true){
      System.out.println("1. Agregar reunión");
      System.out.println("2. Eliminar reunión");
      System.out.println("3. Mostrar reuniones de una fecha");
      System.out.println("4. Mostrar todas las reuniones");
      System.out.println("5. Salir");
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
          System.out.print("Ingrese la hora de la reunión (HH:MM): ");
          String hour = scanner.nextLine();
          String newHour[] = hour.split(":",2);
          dateCalendar.set(Calendar.HOUR, Integer.parseInt(newHour[0]));
          dateCalendar.set(Calendar.MINUTE, Integer.parseInt(newHour[1]));
          //dayMeeting reunion = new dayMeeting(title,description,((int)hour));
          agenda.addReunion(dateCalendar,title,description,hour);
          break;
        case 2:
          System.out.print("Ingrese la fecha (dd-mm-yyyy): ");
          String deleteDate = scanner.nextLine();
          String newDelete[] = deleteDate.split("-",3);
          Calendar deleteCalendar = Calendar.getInstance();
          deleteCalendar.set(Calendar.DATE, Integer.parseInt(newDelete[0]));
          deleteCalendar.set(Calendar.MONTH, Integer.parseInt(newDelete[1]) - 1);
          deleteCalendar.set(Calendar.YEAR, Integer.parseInt(newDelete[2]));
          System.out.print("Ingrese el título de la reunión a eliminar: ");
          String deleteTitle = scanner.nextLine();
          agenda.popReunion(deleteCalendar, deleteTitle);
          break;
        case 3:
          System.out.print("Ingrese la fecha (dd-mm-yyyy): ");
          String showDate = scanner.nextLine();
          String newShow[] = deleteDate.split("-",3);
          Calendar showCalendar = Calendar.getInstance();
          showCalendar.set(Calendar.DATE, Integer.parseInt(newShow[0]));
          showCalendar.set(Calendar.MONTH, Integer.parseInt(newShow[1]) - 1);
          showCalendar.set(Calendar.YEAR, Integer.parseInt(newShow[2]));
          agenda.showDate(showCalendar);
          break;
        case 4:
          //agenda.showDate();
          break;
        case 5:
          System.out.println("Saliendo...");
          System.exit(0);
          break;
        default:
          System.out.println("Opción inválida.");
          break;
      }
    }
  }

	/*private void inicializarDatosDePrueba() {
    Calendar date1 = parseDate("01-09-2023");
    Calendar date2 = parseDate("02-09-2023");
    Calendar date3 = parseDate("03-09-2023");
    HashMap ReunionesCalendar date4 = parseDate("03-09-2023");
    Calendar date5 = parseDate("05-09-2023");
    Calendar date6 = parseDate("06-09-2023");
    
    Reunion reunion1 = new Reunion("Reunión 1", "Descripción 1", 10, 30);
    Reunion reunion2 = new Reunion("Reunión 2", "Descripción 2", 14, 0);
    Reunion reunion3 = new Reunion("Reunión 3", "Descripción 3", 16, 45);
    Reunion reunion4 = new Reunion("Reunión 4", "Descripción 4", 00, 45);
    Reunion reunion5 = new Reunion("Reunión 5", "Descripción 5", 13, 30);
    Reunion reunion6 = new Reunion("Reunión 6", "Descripción 6", 18, 20);
    
    addReunion(date1, reunion1);
    addReunion(date2, reunion2);
    addReunion(date3, reunion3);
    addReunion(date4, reunion4);
    addReunion(date5, reunion5);
    addReunion(date6, reunion6);
    
  }*/
	
  public void addReunion(Calendar key, String title,String description, int Hour){
		reunions.
		
  }

  private int search(ArrayList<dayMeeting> target, String title) {
    for (int i = 0; i < target.size(); i++) {
      if (title.equals(target.get(i).getTitle())) {
        return i;
      }
    }
    return -1;
  }

  public void popReunion(Calendar key, String title) {
    
    
  }
  //Sobrecargas
  public void showDate(Calendar key){
    ArrayList<dayMeeting> aux = reunions.get(key);
    if (aux == null) {
      return;
    }
    for (int i = 0; i < aux.size(); i++) {
      aux.get(i).printR();
    }
  }

  /*public void showDate(){
    ArrayList<Reunion> aux = reunions.get(key);
    if (aux == null) {
      return;
    }
    for (int i = 0; i < aux.size(); i++) {
      aux.get(i).printR();
    }
  }*/
  
}