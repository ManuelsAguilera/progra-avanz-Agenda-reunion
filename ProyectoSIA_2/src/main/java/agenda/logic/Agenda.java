package agenda.logic;


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
        Meeting newMeeting = new Meeting(title,description,hour);
        
        reunions.get(key).putMeeting(newMeeting);
    }
    
    

    public Meeting popDayMeeting(Calendar key, String title) {
        if (!reunions.containsKey(key)) {
            System.out.println("El elemento que se quiere eliminar no existe");
            return null;
        }
        
        dayMeeting meetings = reunions.get(key);
        
        Meeting meeting = meetings.searchMeeting(title);
        if (meeting != null) {
            meetings.popMeeting(title);
        } else {
            System.out.println("No se encontraron reuniones con el título especificado en la fecha.");
        }
        return meeting;
    }

    public dayMeeting popDayMeeting(Calendar key) {
        if (!reunions.containsKey(key)) {
            System.out.println("El elemento que se deseaba eliminar no existe");
            return null;
        }
        return reunions.remove(key);
    }
    
public Meeting searchMeeting(Calendar key, String title) {
        if (!reunions.containsKey(key)) {
            System.out.println("No existe el elemento buscado");
            return null;
        }

        dayMeeting dayMeetings = reunions.get(key);
        Meeting meeting = dayMeetings.searchMeeting(title);
        if (meeting != null) {
            return meeting;
        } else {
            System.out.println("No se encontraron reuniones con el título especificado en la fecha.");
            return null;
        }
    }

  
}
    