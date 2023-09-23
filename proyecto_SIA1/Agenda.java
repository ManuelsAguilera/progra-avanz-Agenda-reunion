import java.util.Map;
import java.util.HashMap;
import java.util.Calendar;
import java.util.Scanner;

public class Agenda {
    private HashMap<Calendar, dayMeeting> reunions = new HashMap<>();

    public void addReunion(Calendar key, String title, String description, int Hour) {
        if (!reunions.containsKey(key)) {
            reunions.put(key, new dayMeeting());
        }
        reunions.get(key).putMeeting(title, description, Hour);
        return;
    }

    /**public dayMeeting searchMeeting(Calendar key, String title) {
      if (!reunions.containsKey(key)) {
          System.out.println("No existe el elemento buscado");
          return null;
      }
  
      dayMeeting dayMeetings = reunions.get(key);
      if (dayMeetings.searchMeeting(title) != null) {
          return dayMeetings;
      } else {
          System.out.println("No se encontraron reuniones con el título especificado en la fecha.");
          return null;
      }
    }
**/


  public void popDayMeeting(Calendar key, String title) {
        if (!reunions.containsKey(key)) {
            System.out.println("El elemento que se quiere eliminar no existe");
            return;
        }
        reunions.get(key).popMeeting(title);
        return;
  }

  public void popDayMeeting(Calendar key) {
        if (!reunions.containsKey(key)) {
            System.out.println("El elemento que se deseaba eliminar no existe");
            return;
        }
        reunions.remove(key);
        return;
    }

  public void showDate(Calendar key) {
      for (Map.Entry<Calendar, dayMeeting> entry : reunions.entrySet()) {
          Calendar fechaEnMapa = entry.getKey();
          if (isSameDay(fechaEnMapa, key)) {
              entry.getValue().showMeeting();
              return;
          }
      }
      System.out.println("El elemento que se deseaba mostrar no existe");
  }
  
  private boolean isSameDay(Calendar cal1, Calendar cal2) {
      return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
             cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
             cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
  }
  
  public void showDate(Calendar key, String title) {
      boolean found = false; // Indicador para verificar si se encontró al menos una reunión
  
      for (Map.Entry<Calendar, dayMeeting> entry : reunions.entrySet()) {
          Calendar fechaEnMapa = entry.getKey();
          if (isSameDay(fechaEnMapa, key)) {
              dayMeeting dayMeetings = entry.getValue();
              dayMeetings.showMeeting(title);
              found = true;
          }
      }
  
      if (!found) {
          System.out.println("No se encontraron reuniones para la fecha proporcionada.");
      }
  }
}
