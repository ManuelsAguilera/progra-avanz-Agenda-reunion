import java.util.*;

public class Reunion {
	private String title;
	private String descripcion;
	private int hora;

	public Reunion(String titulo, String descrip, int nuevaHora) {
		title = titulo;
		descripcion = descrip;
		hora = nuevaHora;
	}

	public String getTitle() {
		return title;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getHora() {
		return hora;
	}

	public void printR() {
		System.out.println("Titulo: " + title);
		System.out.println("Descripcion: " + descripcion);
		System.out.println("Hora: " + hora);
	}
}
