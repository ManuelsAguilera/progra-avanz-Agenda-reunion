import java.util.Scanner;

public class Main
{
    private static void agregar(String[] arr,String data,int len)
    {
        arr[len] = data;
        return;
    }
    private static void agregar(int[] arr, int data,int len)
    {
        arr[len] = data;
        return;
    }
   private static void writeArr(String[] array,int cont)
   {
       for (int i = 0; i < cont; i++)
       {
           System.out.print(array[i]+"; ");
       }
       System.out.println();
   }
   private static void writeArr(int[] array,int cont)
   {
       for (int i = 0; i < cont; i++)
       {
           System.out.print(array[i]+"; ");
       }
       System.out.println();
   }
   private static int buscarRut(String[] rut,String key,int len)
   {
       for (int i = 0; i <= len; i++)
       {
           if (rut[i].equals(key) )
           {
               return i;
           }
       }
       return -1;
   }
    private static void eliminar(String[] rut,String[] nombre,int[] edad,int pos,int len)
    {
        rut[pos] = rut[len];
        nombre[pos] = nombre[len];
        edad[pos] = edad[len];
        
    }

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int max_length = 100;
		int len = 0;
		int opcion;
		
		String[] nombre = new String[max_length];
		String[] rut = new String[max_length];
		int[] edad = new int[max_length];
		
		while (true)
		{
		    System.out.println("Selecciona la opcion:");
		    System.out.println("1: agregar / 2: eliminar / 3: mostrar");
		    opcion = in.nextInt();
		    
		    switch (opcion)
		    {
		        case 1:
		            in.nextLine();
		            System.out.println("Nombre: " ); 
		            agregar(nombre,in.nextLine(),len);
		            System.out.println("rut: ");
		            agregar(rut,in.nextLine(),len);
		            System.out.println("edad: ");
		            agregar(edad,in.nextInt(),len);
		            len++;
		            break;
		        case 2:
		            in.nextLine();
		            
		            int pos = buscarRut(rut,in.nextLine(),len);
		            
		            if (pos != -1)
		            {
		                eliminar(rut,nombre,edad,pos,len);
		                len--;
		            }
		            else{
		                System.out.println("No existe la posicion");
		            }
		            break;
		        case 3:
		            
		            System.out.println("Nombre: " ); 
		            writeArr(nombre,len);
		            System.out.println("rut: ");
		            writeArr(rut,len);
		            System.out.println("edad: ");
		            writeArr(edad,len);
		            break;
		    }
		    
		}  
		
		
		
	}
}
