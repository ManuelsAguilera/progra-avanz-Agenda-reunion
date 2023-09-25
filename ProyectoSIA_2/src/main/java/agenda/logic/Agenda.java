package agenda.logic;

import java.util.Map;
import java.util.HashMap;
import java.util.Calendar;
//import java.util.Scanner;

public class Agenda {
    private HashMap<Calendar, dayMeeting> reunions = new HashMap<>();
    
    public void addReunion(Calendar key, String title, String description, int hour)
    {
        if (!reunions.containsKey(key))
        {
            reunions.put(key, new dayMeeting());
        }
        reunions.get(key).putMeeting(title, description, hour);
    }

    public void searchMeeting(Calendar key, String title)
    {
        
        if (!reunions.containsKey(key)) 
        {
            System.out.println("No existe el elemento buscado");
            return;
        }
        
        dayMeeting dayMeetings = reunions.get(key);
        if (dayMeetings.getTitle(title) != null) 
        {
            showDate(key,title);
        } else 
        {
            System.out.println("No se encontraron reuniones con el título especificado en la fecha.");
        }
    }


    public void popDayMeeting(Calendar key, String title)
    {
        if (!reunions.containsKey(key))
        {
            System.out.println("El elemento que se quiere eliminar no existe");
            return;
        }
        reunions.get(key).popMeeting(title);
    }

    public void popDayMeeting(Calendar key)
    {
        if (!reunions.containsKey(key))
        {
            System.out.println("El elemento que se deseaba eliminar no existe");
            return;
        }
        reunions.remove(key);
    }
    
    public void showDate(Calendar key) {
        boolean foundMeetings = false;
            
        /*
        if (!reunions.containsKey(key))
        {
            System.out.println("El elemento que se deseaba ver no existe");
            return;
        }*/
        
        for (Map.Entry<Calendar, dayMeeting> entry : reunions.entrySet()) {
            Calendar fechaEnMapa = entry.getKey();
        
            if (isSameDay(fechaEnMapa, key)) {
                entry.getValue().showMeeting();
                foundMeetings = true;
            }
        }

        if (!foundMeetings) {
            System.out.println("No se encontraron reuniones en la fecha específicada");
        }
    }
  
    private boolean isSameDay(Calendar cal1, Calendar cal2)
    {
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
             cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
             cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
    }
    
    public void showDate(Calendar key, String title) {
        boolean foundMeeting = false;

        for (Map.Entry<Calendar, dayMeeting> entry : reunions.entrySet()) {
            Calendar fechaEnMapa = entry.getKey();
            dayMeeting meeting = entry.getValue();

            if (isSameDay(fechaEnMapa, key) && meeting.getTitle(title).equals(title)) {
                meeting.showMeeting();
                foundMeeting = true;
            }
        }

        if (!foundMeeting) {
            System.out.println("No matching meetings found for the specified date and title");
        }
    }
    
    public void showAllReunions() {
        for (Map.Entry<Calendar, dayMeeting> entry : reunions.entrySet()) {
            Calendar date = entry.getKey();
            dayMeeting meeting = entry.getValue();

            System.out.println("Date: " + date.getTime());
            meeting.showMeeting();
        }
    }
    
}
