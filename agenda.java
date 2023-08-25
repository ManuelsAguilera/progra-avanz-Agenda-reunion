import java.util.*;

public class agenda {
    public static void main(String[] args) {
        // Nested HashMap to store reunions
        Map<String, Map<String, String>> reunions = new HashMap<>();

        // Adding a reunion
        addReunion(reunions, "2023-08-25", "10:00 AM", "Team Meeting", "Discuss project updates");

        // Retrieving a reunion
        String date = "2023-08-25";
        Map<String, String> reunionDetails = reunions.get(date);
        if (reunionDetails != null) {
            String hour = reunionDetails.get("hour");
            String title = reunionDetails.get("title");
            String description = reunionDetails.get("description");
            System.out.println("Reunion on " + date);
            System.out.println("Hour: " + hour);
            System.out.println("Title: " + title);
            System.out.println("Description: " + description);
        } else {
            System.out.println("No reunion found for " + date);
        }
    }

    // Method to add a reunion
    public static void addReunion(Map<String, Map<String, String>> reunions, String date, String hour, String title, String description) {
        Map<String, String> reunionDetails = new HashMap<>();
        reunionDetails.put("hour", hour);
        reunionDetails.put("title", title);
        reunionDetails.put("description", description);
        reunions.put(date, reunionDetails);
    }
}