package agenda.logic;

//import java.util.*;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Calendar;

public class dayMeeting {
    private ArrayList<Meeting> meetings;
    
    public dayMeeting()
    {
        meetings = new ArrayList<Meeting>();
    }
    
    public ArrayList<Meeting> getMeetings()
    {
        return (ArrayList<Meeting>) meetings.clone();
    }
    
    public dayMeeting(Calendar Fecha) // Para probar si funciona
    {
        meetings = new ArrayList<Meeting>();
        System.out.println("Debug: inicializada lista fecha"+Fecha.toString());
    }
    
    // Inserción ordenada según hora
    public void putMeeting(Meeting meeting) {
    int index = 0;
    for (int i = 0; i < meetings.size(); i++) {
        if (meeting.getHora() > meetings.get(i).getHora()) {
            index++;
        } else {
            break;
        }
    }
    meetings.add(index, meeting);
    }

    // Búsqueda según título
    public Meeting searchMeeting(String title) {
        for (Meeting meeting : meetings) {
            if (meeting.getNombre().equals(title)) {
                return meeting;
            }
        }
        return null;
    }

    // Eliminación según título
    public void popMeeting(String title) {
        meetings.removeIf(meeting -> meeting.getNombre().equals(title));
    }

    // Eliminación según hora
    public void popMeeting(int hour) {
        meetings.removeIf(meeting -> meeting.getHora() == hour);
    }


    
}
    