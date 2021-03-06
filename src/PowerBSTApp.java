/**
  PowerArrayApp is an application that reads data values from a Binary Search tree.
  It reads a CSV file and adds the data to a Binary Search Tree and 
  prints out the data in the array either by specifying the date
  or printing all dates.
  @author Niceta Nduku NDKNIC001
*/
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*; 
import java.util.*;

public class PowerBSTApp{ 
	private static BinarySearchTree getData() throws IOException, FileNotFoundException {
		/**
         This is the method that reads from the CVS file and captures all the required data into a binary search tree.
         @param none
         @Returns a Binary Search tree with PowerData items
         @exeption IOException
         @exeption FileNotFoundException
         @see IOException
         @see FileNotFoundExceptio
      	*/
      
		BinarySearchTree powerDataBST = new BinarySearchTree();

		// read from the CVS file 
		BufferedReader bRead = new BufferedReader(new FileReader("../cleaned_data.csv"));

		    
		String ignoreline = bRead.readLine();//read the first line in the csv file and do nothing with it
		String line = bRead.readLine(); // the first line that contains the required data

		// initialise the values to be stored in the powerData object
		String dateTime;
		String power;
		String voltage;
	
		while (line!=null){

			String[] allValues = line.split(",");// split at each comma to have an array of all the values
			dateTime=allValues[0];
			power=allValues[1];
			voltage=allValues[3];

			// add the data to the tree by creating a new powerArray object with the above values
			powerDataBST.insert(new PowerData(dateTime,power,voltage));

			line = bRead.readLine();     

		}
         
      return powerDataBST;
   }

    public static void printDateTime(String dateTime) throws IOException{
    	/**
         This method takes in the date/time from the user,
         searches through the data to find a matching date/time 
         and prints out the data 
         @param string dateTime
         @Returns nothing
         @exeption IOException
         @see IOException
     	 */
     	BinarySearchTree powerBST = getData();

		if(powerBST.find(dateTime) == null){
			System.out.println("Date/Time not found");
			System.out.println(powerBST.getOpcount()+ " ");
      //System.out.println(powerBST.getOpcount()+ "\t");
		}

		else{
			powerBST.getOpcount();
			System.out.println(getData().find(dateTime));
			//getData().find(dateTime);
			System.out.println(powerBST.getOpcount()+ " ");
      //System.out.println(powerBST.getOpcount()+ "\t");
		}
	}
   
   	public static void printAllDateTimes() throws IOException{
		/**
         This method prints out all the data in the Binary Search Tree
         @param none
         @Returns nothing
         @exeption IOException
         @see IOException
      	*/
      BinarySearchTree powerBST = getData();
   		powerBST.display();
      System.out.println(powerBST.getOpcount()+ " ");
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

