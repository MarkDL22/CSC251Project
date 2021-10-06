import java.util.*; 
import java.io.*;

public class RoomDemo1
{
   public static void main(String[] args)
   {
      try
      {
         File file = new File("Rooms.txt");
         
         Scanner inputFile = new Scanner(file);
      
         String name = "", shadeAmount = "";
         double length = 0.0;
         double width = 0.0;
         int li = 0, mo = 0, ab = 0;
         
         ArrayList<Room> rooms = new ArrayList<Room>();
         
         while(inputFile.hasNext())
         {
            name = inputFile.nextLine();
            length = inputFile.nextDouble();
            width = inputFile.nextDouble();
            shadeAmount = inputFile.next();
            
            if(inputFile.hasNext())
            { 
               inputFile.nextLine();
               inputFile.nextLine();
            }
            
            Room r = new Room(name, length, width, shadeAmount);
            
            rooms.add(r);
         }
         
         inputFile.close();
         
         for(int i =0; i < rooms.size(); i++)
         {     
            System.out.println("Room Name: " + rooms.get(i).getName());
            System.out.println("Room Area (in square feet): " + rooms.get(i).getArea());
            System.out.println("Amount of Shade: " + rooms.get(i).getShadeAmount());
            if (rooms.get(i).getShadeAmount().equalsIgnoreCase("Little")) {
               li++;}
            if (rooms.get(i).getShadeAmount().equalsIgnoreCase("Moderate")) {
               mo++;}
            if (rooms.get(i).getShadeAmount().equalsIgnoreCase("Abundant")) {
               ab++;}
            System.out.printf("BTUs Per Hour needed: %,.0f\n ", rooms.get(i).getCoolingCapacityNeeded());
            System.out.println();
         }
         
         System.out.println("Number of rooms with little shade: " + li);
         System.out.println("Numbers of rooms with moderate shade: " + mo);
         System.out.println("Number of rooms with abundant shade: " + ab);
      }
      catch(IOException ex)
      {
         System.out.println("Something went wrong reading the file: " + ex.getMessage());
      }
   }
}