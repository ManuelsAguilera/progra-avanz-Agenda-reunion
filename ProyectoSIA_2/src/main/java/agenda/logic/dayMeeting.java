package agenda.logic;

//import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;

public class dayMeeting {
    private ArrayList<String> titleArr;
    private ArrayList<String> descriptionArr;
    private ArrayList<Integer> hourArr;

    public dayMeeting()
    {
        titleArr = new ArrayList<>();
        descriptionArr = new ArrayList<>();
	hourArr = new ArrayList<>();
    }
    
    public String getTitle(String title)
    {
        for (int i = 0; i < titleArr.size(); i++)
        {
            if (titleArr.get(i).equals(title))
            {
                return title;
            }  
        }
        return null;
    }
    
    /*public String getTitle()
    {
        for (int i = 0; i < titleArr.size(); i++)
        {
            if (titleArr.get(i).equals(title))
            {
                return title;
            }  
        }
        return null;
    }*/
    
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
        //int contador=-1;
        for (int i = 0; i < titleArr.size(); i++)
        {
            if (titleArr.get(i).equals(title))
            {
                //contador=i;
                titleArr.remove(i);
                descriptionArr.remove(i);
                hourArr.remove(i);
            }  
        }
    }
  
    public void showMeeting(int hour)
    {
        for (int i = 0; i<hourArr.size();i++)
        {
            if (hourArr.get(i)==hour)
            {
                System.out.println(titleArr.get(i));
                System.out.println(descriptionArr.get(i));
                System.out.println(hourArr.get(i)); 
            }
        }
    }
  
    public void showMeeting(String title)
    {
        for (int i = 0; i<hourArr.size();i++)
        {
            if (titleArr.get(i).equals(title))
            {
                System.out.println(titleArr.get(i));
                System.out.println(descriptionArr.get(i));
                System.out.println(hourArr.get(i)); 
                System.out.println();
            }
        }
    }
	
    public void showMeeting()
    {
        for (int i = 0; i<hourArr.size();i++)
        {
            System.out.println(titleArr.get(i));
            System.out.println(descriptionArr.get(i));
            System.out.println(hourArr.get(i)); 
            System.out.println();
        }
    }
}



