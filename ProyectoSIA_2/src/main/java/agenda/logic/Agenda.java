package agenda.logic;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import java.util.HashMap;
import java.util.Calendar;
import java.util.Date;
//import java.util.Scanner;

public class Agenda {
    private HashMap<Calendar, dayMeeting> reunions;
    private Meeting actualMeeting;
    
    public Agenda(){
        reunions =  new HashMap<Calendar, dayMeeting>();
        actualMeeting = null;
        
        
    }
        
    
    public void addMeeting(Calendar key, String title, String description, int hour)
    {
        if (!reunions.containsKey(key))
        {
            reunions.put(key, new dayMeeting());
        }
        Meeting newMeeting = new Meeting(title,description,hour);
        
        reunions.get(key).putMeeting(newMeeting);
        
                
        
    }
    
    public Meeting getActualMeeting() { //Observar ultimo buscado.
        return actualMeeting;
    }
    
    public void setActualMeeting(Meeting meeting) {
        actualMeeting.setNombre(actualMeeting.getNombre());
        actualMeeting.setDescripcion(meeting.getDescripcion());
        actualMeeting.setHora(meeting.getHora());

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
            actualMeeting = meeting;
            return meeting;
        } else {
            System.out.println("No se encontraron reuniones con el título especificado en la fecha.");
            return null;
        }
    }
    
    public void clear() {
        reunions.clear();
    }
    
    public Calendar parseDateToCalendar(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = dateFormat.parse(dateString);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar;
        } catch (ParseException e) {
            return null; // Return null if the input string is not in the expected format
        }
    }
    
    

    public Calendar getFecha(Meeting data) {
        if (data == null) {
            System.out.println("El objeto Meeting es nulo.");
            return null;
        }

        // Itera sobre las reuniones en la agenda para buscar la fecha
        for (HashMap.Entry<Calendar, dayMeeting> entry : reunions.entrySet()) {
            dayMeeting dayMeetings = entry.getValue();

            for (Meeting meeting : dayMeetings.getMeetings()) {
                if (meeting.equals(data)) {
                    // Si se encuentra una reunión que coincide con el objeto Meeting proporcionado,
                    // devuelve la fecha asociada a esa reunión.
                    return entry.getKey();
                }
            }
    }

    // Si no se encuentra la reunión, muestra un mensaje y devuelve null.
    System.out.println("No se encontró una fecha relacionada al objeto Meeting.");
    return null;
}
    //Exportar e importar

    public boolean importarDatos(String filePath) {
            try {
                // Limpiar la agenda actual
                reunions.clear();

                // Crear un lector de archivos
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                String line;

                // Leer cada línea del archivo
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split("\\|");

                    if (data.length == 4) {
                        // Obtener datos de la reunión desde el archivo
                        String fechaStr = data[0];
                        String nombre = data[1];
                        String descripcion = data[2];
                        int hora = Integer.parseInt(data[3]);

                        // Parsear la fecha (puedes ajustar este paso según el formato de fecha que uses)
                        // Aquí se asume que fechaStr es una representación de fecha válida
                        // Puedes usar SimpleDateFormat u otra clase según tu formato de fecha
                        Calendar fecha = parseDateToCalendar(fechaStr);

                        // Agregar la reunión a la agenda
                        addMeeting(fecha, nombre, descripcion, hora);
                    }
                }

                // Cerrar el lector de archivos
                reader.close();
                return true;
            } catch (IOException e) {
                System.out.println("Error al importar datos desde el archivo: " + e.getMessage());
                return false;
            }
        }
    
    private String calendarToString(Calendar instance) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        return dateFormat.format(instance.getTime());
    }
    public boolean exportarDatos(String filePath) {
        try {
            // Crear un escritor de archivos
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

            
            // Iterar sobre las reuniones en la agenda y escribir en el archivo
            for (HashMap.Entry<Calendar, dayMeeting> entry : reunions.entrySet()) {
                Calendar fecha = entry.getKey();
                dayMeeting dayMeetings = entry.getValue();

                for (Meeting meeting : dayMeetings.getMeetings()) {
                    String fechaStr = calendarToString(fecha);
                    String nombre = meeting.getNombre();
                    String descripcion = meeting.getDescripcion();
                    int hora = meeting.getHora();

                    // Escribir la línea en el archivo
                    String line = fechaStr + "|" + nombre + "|" + descripcion + "|" + hora;
                    writer.write(line);
                    writer.newLine();
                }
            }

            // Cerrar el escritor de archivos
            writer.close();
            
            return true;
        } catch (IOException e) {
            System.out.println("Error al exportar la agenda: " + e.getMessage());
            return false;
        }
    }

        public void exportarReporte(String filePath) {
        try {
            // Crear un escritor de archivos
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            
            // Obtener el mes y año actual
            Calendar today = Calendar.getInstance();
            int mesActual = today.get(Calendar.MONTH);
            int añoActual = today.get(Calendar.YEAR);
            
            // Escribir el encabezado del informe mensual
            writer.write("Reporte Mensual:");
            writer.newLine();
            
            for (HashMap.Entry<Calendar, dayMeeting> entry : reunions.entrySet()) {
                Calendar fecha = entry.getKey();
                
                // Verificar si la fecha pertenece al mes actual y año actual
                if (fecha.get(Calendar.MONTH) == mesActual && fecha.get(Calendar.YEAR) == añoActual) {
                    // Formatear la fecha en el informe
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    String fechaStr = dateFormat.format(fecha.getTime());
                    
                    writer.write("Fecha: " + fechaStr);
                    writer.newLine();
                    
                    dayMeeting dayMeetings = entry.getValue();
                    
                    for (Meeting meeting : dayMeetings.getMeetings()) {
                        // Escribir el título y la hora de la reunión
                        writer.write("    Título: " + meeting.getNombre() + ", Hora: " + meeting.getHora());
                        writer.newLine();
                        
                        // Escribir la descripción de la reunión
                        writer.write("    Descripción: " + meeting.getDescripcion());
                        writer.newLine();
                    }
                }
            }

            // Cerrar el escritor de archivos
            writer.close();
            
            System.out.println("Informe mensual exportado con éxito.");
        } catch (IOException e) {
            System.out.println("Error al exportar el informe mensual: " + e.getMessage());
        }
    }

}
    
