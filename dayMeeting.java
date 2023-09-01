import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;

public class dayMeeting {
	private ArrayList<String> titleArr;
	private ArrayList<String> descriptionArr;
	private ArrayList<Integer> hourArr;

	public static void main(String[] args)
	{
		dayMeeting manyana = new dayMeeting();
		manyana.putMeeting("Progra avanzada", "Ir a clases",1100);
		manyana.putMeeting("Progra avanzada2","ayudantia",1300);
		manyana.putMeeting("Etica Cristiana","Aburrirme",1400);
		manyana.showAllMeeting();
		manyana.popMeeting("Progra avanzada2");
		manyana.showMeeting("Progra avanzada2");

		return;
	}
	
	public dayMeeting()
	{
		titleArr = new ArrayList<>();
		descriptionArr = new ArrayList<>();
		hourArr = new ArrayList<>();
	}
  
  
	public void putMeeting(String title, String description, int hour)
  {  
    for (int i = 0; i < hourArr.size(); i++)
    {
      if (hour < hourArr.get(i))
      {
        hourArr.add(i,hour);
        titleArr.add(i,title);
        descriptionArr.add(i, description);
        return;
      }
    }
    hourArr.add(hour);
    titleArr.add(title);
    descriptionArr.add(description);
	}
  
	public void popMeeting(String title)
  {
    int contador=-1;
    for (int i = 0; i < titleArr.size(); i++) {
      if (titleArr.get(i).equals(title)) {
        contador=i;
        titleArr.remove(i);
        descriptionArr.remove(i);
        hourArr.remove(i);
      }  
    }
	}
  
  public void showMeeting(int hour)
  {
    for (int i = 0; i<hourArr.size();i++){
      if (hourArr.get(i)==hour){
        System.out.println(titleArr.get(i));
        System.out.println(descriptionArr.get(i));
        System.out.println(hourArr.get(i)); 
      }
    }
  }
	public void showMeeting(String title)
  {
    for (int i = 0; i<hourArr.size();i++){
      if (titleArr.get(i).equals(title) ){
        System.out.println(titleArr.get(i));
        System.out.println(descriptionArr.get(i));
        System.out.println(hourArr.get(i)); 
        System.out.println();
      }
    }
  }

  public void showAllMeeting(){
    for(String titulo : titleArr){
      showMeeting(titulo);
    }
  }
}


/**
public static void insertionSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            
            // Mueve los elementos del array que son mayores que la 'key' una posición adelante
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
**/