import java.util.*;
import java.util.ArrayList;

public class dayMeeting {
	private ArrayList<String> titleArr;
	private ArrayList<String> descriptionArr;
	private ArrayList<Integer> hourArr;
	
	public dayMeeting()
	{
		ArrayList<String> titleArr = new ArrayList<>();
		ArrayList<String> description = new ArrayList<>();
		ArrayList<Integer> hour = new ArrayList<>();
	}
	public void putMeeting(String title, String description, int hour)
  {  
		//modificar para agregar insertion Sort
  	titleArr.add(title);
    descriptionArr.add(description);
    hourArr.add(hour);
	}
	public  void popMeeting(String title)
  {
    int contador=-1;
    for (int i = 0; i < titlArr.size(); i++) {
      if (titleArr.get(i).equals(title) {
        contador=i;
        titleArr.remove(i);
        descriptionArr.remove(i);
        hourArr.remove(i);
      }  
    }
	}
  public void showMeeting()
  {
    
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