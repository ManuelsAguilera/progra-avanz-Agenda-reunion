/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agenda.logic;

/**
 *
 * @author Manu
 */
import agenda.logic.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class testLogic {

    
    public static void main(String[] args) {
            // Crear una instancia de Agenda
            Agenda agenda = new Agenda();

            // Ruta del archivo .agd
            String filePath = "C:\\Users\\Manu\\Carrera\\progra-avanz-Agenda-reunion\\ProyectoSIA_2\\src\\jsonFiles\\defaultImport.agd";

            // Importar datos desde el archivo
            if (agenda.importarDatos(filePath))
            {
                System.out.println("Importado correcto");
            }
            else
            {
                return;
            }
                
        String fechaTexto = "01-10-2023";
        String nombre ="Reunión larga";
        Calendar fecha = agenda.parseDateToCalendar(fechaTexto);

        Meeting meeting = agenda.searchMeeting(fecha,nombre);

        System.out.println(meeting.getNombre());
        System.out.println(meeting.getDescripcion());
        System.out.println(meeting.getHora());
        
        System.out.println("Añadiendo nuevo meeting, y luego exportar");
        fechaTexto = "18-04-2004";
        fecha = agenda.parseDateToCalendar(fechaTexto);
        agenda.addMeeting(fecha,"TestExport","Añadiendo una descripcion bastante larga",2100);
        filePath = "C:\\Users\\Manu\\Carrera\\progra-avanz-Agenda-reunion\\ProyectoSIA_2\\src\\jsonFiles\\defaultExport.agd";


        if (agenda.exportarDatos(filePath))
        {
            System.out.println("Exportado correctamente");
        }
        else
        {
            System.out.println("Falta arreglar cosas");
        }
        
        
            
        }
}
