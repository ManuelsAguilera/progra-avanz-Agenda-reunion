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
	private int insertSort(int data)
	{
		for (int i = 0; i < hourArr.size(); i++)
			{
				if (data == hourArr.get(i))
				{
					hourArr.add(data,i);
					return i;
				}
			}
		hourArr.add(data)
		return hourArr.size();
	}
  
	public void putMeeting(String title, String description, int hour)
  {  
		//Modificar para agregar insertion Sort
  	int index = insertSort(hour);
    descriptionArr.add(description,index);
    hourArr.add(hour,index);
    
	}
  
	public void popMeeting(String title)
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
  
  public void showMeeting(int hour)
  {
    for (int i = 0; i<hourArr.size();i++){
      if (hourArr.get(i).equals(hour)){
        titleArr.get(i).printR();
        descriptionArr.get(i).printR();
        hourArr.get(i).printR(); 
      }
    }
  }
	public void showMeeting(String title)
  {
    for (int i = 0; i<hourArr.size();i++){
      if (titleArr.get(i).equals(title) ){
        titleArr.get(i).printR();
        descriptionArr.get(i).printR();
        hourArr.get(i).printR(); 
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