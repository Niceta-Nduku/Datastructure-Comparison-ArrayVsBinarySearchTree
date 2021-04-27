  /**
      PowerArrayApp is an application that stores data into an array.
      It reads a CSV file and adds the data to an array and 
      prints out the data in the array either by specifying the date
      or printing all dates.
   @author Niceta Nduku NDKNIC001
*/

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*; 
import java.util.*;

public class PowerArrayApp{   
   
   public static int opNumber=0;

   private static PowerData[] getData() throws IOException, FileNotFoundException {
      /**
         This is the method that reads from the CVS file and captures all the required data into an array of 500 items.
         @param none
         @Returns an array of type PowerData
         @exeption IOException
         @exeption FileNotFoundException
         @see IOException
         @see FileNotFoundExceptio
      */

      // create the array of type powerData that is going to contain all the data
      PowerData[] dataArray = new PowerData[500];

      //read from the CVS file 
      BufferedReader bRead = new BufferedReader(new FileReader("../cleaned_data.csv"));

                
      bRead.readLine();//read the first line in the csv file and do nothing with it
      String line = bRead.readLine(); // the first line that contains the required data

      // initialise the values to be stored in the powerData object
      String dateTime;
      String power;
      String voltage;

      int arrayp = 0; // the integer that will be used to iterate through array


         while (line!=null){

            String[] allValues = line.split(",");// split at each comma to have an array of all the values
            dateTime=allValues[0];
            power=allValues[1];
            voltage=allValues[3];

            // add the data to the array by creating a new powerArray object with the above values
             dataArray[arrayp] = new PowerData(dateTime,power,voltage);

            line = bRead.readLine();
            // move to the next position in the array     
            arrayp++;  
         }
         
      return dataArray;
   }

   public static void printDateTime(String dateTime) throws IOException{
      /**
         This method takes in the date/time from the user,
         searches through the data to find a matching date/time 
         and prints out the data and the number of operations used. 
         @param string dateTime
         @Returns nothing
         @exeption IOException
         @see IOException
      */
     
      PowerData[] powerArray = getData();

      boolean entry = false;

      for (int i=0;i<500;i++){
         opNumber++;
         if ((((powerArray[i]).getDateTime()).compareTo(dateTime))==0){
            System.out.println(powerArray[i]);
            System.out.println(opNumber+ " ");
            //System.out.println(opNumber+ "\t");
            entry = true;
            break;
         }
      }
      if ( entry == false){
         System.out.println("Date/Time not found");
         System.out.println(opNumber+ " ");
      }
   }
   
   public static void printAllDateTimes() throws IOException{
      /**
         This method prints out all the data in the array
         @param none
         @Returns nothing
         @exeption IOException
         @see IOException
      */
      PowerData[] powerArray = getData();

      for (int i=0;i<500;i++){

         System.out.println(powerArray[i]);
      }
      System.out.println(opNumber+ " ");
   }

   public static void main(String [] args) throws IOException {
      /**
         This is the main method that runs the application 
         based on the user input.         
      */

      if (args.length==0){ //if the input is null, print all the powerData items in the array

         printAllDateTimes();
      }
      else // if the user inputs a string
         printDateTime(args[0]);

   }
}