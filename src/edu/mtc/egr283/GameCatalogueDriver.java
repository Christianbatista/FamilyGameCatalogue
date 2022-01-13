package edu.mtc.egr283;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*************************************************************
 * Class for handling the <code>GameCataloague</code>.
 * This is the class to handle all the records.
 *@author Christian Batista
 *@version 1.00 2019-14-03
 *Copyright (C) 2019 by Christian Batista. All rights reserved.
**/
public class GameCatalogueDriver {
	private static Scanner keyboard;
		
		public static void main(String[] args) {
			
			final String TAG = "Main: ";
		    String inFileName = "inputForGameCatalogue.txt";
		    String outFileName = "output.txt";
		    String searchString = "";
		    Scanner inFile = null;
		    keyboard = new Scanner(System.in);
		    PrintWriter outFile = null;
		    GameCatalogue theFlatFile = null;
		    Game foundGame = null;
		    
			try {
				inFile = new Scanner(new File(inFileName));
				outFile = new PrintWriter(new File(outFileName));
			} catch(FileNotFoundException fnfe) {
				System.out.println(TAG + "ERROR opening infile " + inFileName);
				System.out.println(fnfe.getMessage());
				System.out.println("in " + System.getProperty("user.dir"));
				System.out.flush();
				System.exit(1);
			}// Ending bracket of try-catch block
			
			outFile.printf("%s create and write out the empty file%n",TAG);
			theFlatFile = new GameCatalogue();
		    outFile.printf("%s%n", theFlatFile.toString());
		    
		    System.out.println("******EmptyFile***************" + theFlatFile.getSize() + "***************");
		    outFile.printf("%s empty file was created%n", TAG);
		    outFile.printf("%s read the data%n", TAG);
		    
		    theFlatFile.readFile(inFile);
		    
		    outFile.printf("%s the data has been read%n", TAG);
		    outFile.printf("%s write out the file%n%s%n",
	                TAG, theFlatFile.toString());
		    outFile.printf("%s done with the write%n", TAG);
		    System.out.println("******WritenFile**************" + theFlatFile.getSize() + "***************");
		    System.out.println("Do you want to add a game to the Catalogue?: ");
			String inputadd = keyboard.nextLine();
		do{
			if(inputadd.equalsIgnoreCase("Yes")) {
				System.out.println("Input Game items: ");
				
				Game addNewGame = new Game();
				addNewGame.createGame();
				
				theFlatFile.addGame(addNewGame);
				System.out.println("Is there another game you want to add to the Catalogue? input Yes or No ");
		    	inputadd = keyboard.next();
		    	if(inputadd.equalsIgnoreCase("Yes")) {
		    		continue;
		    	}// Ending bracket of if
			}// Ending bracket of if 
				
			outFile.printf("%s the data has been added%n", TAG);
			
		} while(inputadd.equalsIgnoreCase("Yes"));

	    System.out.println("Do you want to remove a game from the Catalogue?: ");
		String inputRemove = keyboard.nextLine();

		do {
			if(inputRemove.equalsIgnoreCase("Yes")) {
				System.out.println("Input the record number: ");
				int gameNumber = keyboard.nextInt();
				theFlatFile.removeGame(gameNumber);
				
				System.out.println("Is there another game you want to remove from the Catalogue? input Yes or No ");
		    	inputRemove = keyboard.next();
		    	if(inputadd.equalsIgnoreCase("Yes")) {
		    		continue;	
		    	} // Ending bracket of if
			}// Ending bracket of inner if
			
			outFile.printf("%s the data has been removed%n", TAG);
		} while(inputRemove.equalsIgnoreCase("Yes"));
		
			theFlatFile.sortCatalogue(); // Sort the data			    		    					
			outFile.printf("%s the data has been sorted%n%s%n", TAG, 
		    		theFlatFile.toString());
		    
		  //*********************************************************
		    // Find a particular item and print the record if found.
		    System.out.println("Is there a particular game you want to find? input Yes or No ");
		    String input = keyboard.next().toUpperCase();
		    
		    	do {
					
					if(input.equalsIgnoreCase("Yes")) {
		    			System.out.println("What is the name of the Game you are searching for?");
		    			String inputGame = keyboard.next();
			    
		    			searchString = new String(inputGame);
		    			outFile.printf("%s find the data item '%s'%n",
				                    TAG, searchString);
		    			foundGame = theFlatFile.findGame(searchString);

					    if(foundGame != null) {
					     outFile.printf("%s found record '%s'%n",TAG,
					                                foundGame.toString());
					     System.out.println("Your input is in the GameCatalogue");
					    } else {
					      outFile.printf("%s record %s not found%n",TAG,
					                                searchString);
					      System.out.println("Your input in not in the GameCatalogue");
					    }// Ending bracket of inner if-else
					    
					    System.out.println("Is there another game you want to search for?");
					    input = keyboard.next().toUpperCase();
					     continue;
					     
			    	} else if(input.equalsIgnoreCase("No")) {
			    		System.out.println("End of search");
			    	} else {
			    		System.out.println("You have entered a value that is not Yes or No.\n"+	
		    					"Please try again.");
				    	System.out.println("Is there a particular game you want to find? input Yes or No ");
				    	input = keyboard.next().toUpperCase();
				    	continue;
			    	}// Ending bracket of outer if else
		    		
		    		System.out.println("Would you like to continue to search?(yes/no)"); 
		    		input = keyboard.next().toUpperCase();
		    		
		    	} while(input.equalsIgnoreCase("Yes"));// Ending bracket of while loop
				System.out.println("End of program");
				
				keyboard.close();
		    inFile.close();
		    outFile.close();
		        
	}// Ending bracket of method main
		
}// Ending bracket of class GameCatalogueDriver