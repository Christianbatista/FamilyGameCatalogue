package edu.mtc.egr283;

import java.util.Scanner;
/*************************************************************
 * Class for handling the <code>GameCataloague</code>.
 * This is the class to handle all the records.
 *@author Christian Batista
 *@version 1.00 2019-14-03
 *Copyright (C) 2019 by Christian Batista. All rights reserved.
**/
public class GameCatalogue {

		// Instance Variables
		static final String Tag = "FlatFile ";
		private SLL<Integer> index;
		private SLL<Game> recs;
		private int gameNumber;
		
		public GameCatalogue() {
			this.index = new SLL<Integer>();
			this.recs = new SLL<Game>();
			this.gameNumber = 0;
		}// Ending bracket of constructor
		
		/**
		 * Method to addGame to the GameCatalogue
		 * This method is where we collect
		 * @param newGame
		 */
		public void addGame(Game newGame) {
			this.recs.add(newGame, this.recs.size());
			this.index.add(this.gameNumber, this.index.size());
			++this.gameNumber;
		}// Ending bracket of method addRecord
				
		/**
		 * Method to findGame in the GameCatalogue by name of the game 
		 * @param nameToFind
		 */
		public Game findGame(String nameToFind) {
			
			Game rv = null;
			
			for(int i = 0; i < this.recs.size(); ++i) {
				if((this.recs.getDataAtPosition(i).compareName(nameToFind))) {
					rv = this.recs.getDataAtPosition(i);
					rv.toString();
					break;
				}// Ending bracket of if 
			}// Ending bracket of for loop
			
			return rv;
		} // Ending bracket of findGame
		
		public void removeGame(int gameNumber) {
			this.recs.remove(gameNumber);
			this.index.remove(gameNumber);
		}// Ending bracket of removeGame
		
			/**
			 * Accessor method to get the exact game
			 * @param indexToFind
			 * @return game value
			 */
			public Game getGame(int indexToFind) {
				Game rv = null;
				// wrap checking to make sure that this index in correct. include a if() make sure it it b/w the zero and the size()
					rv = this.recs.getDataAtPosition(this.index.getDataAtPosition(indexToFind));
			
				return rv;		
		}// Ending bracket of getGame
					
			public int getSize() {
			     if(this.recs.size() != this.index.size()) {
			       System.out.println("ERROR: unequal list sizes " +
			                          this.recs.size() + ", " +
			                          this.index.size());
			       System.exit(0);
			     }// Ending bracket of if 
			     return this.recs.size();
			   } // Ending bracket of method getSize
					
			/**************************************************************
		      * Method to read the file from an input <code>Scanner</code>
		      * file.  This reads the entire file.  As we read and store
		      * the records, we also store the subscripts in the index.
		      * @param inFile the <code>Scanner</code> from which to read
		     **/
		       public void readFile(Scanner inputFile) {
		    	   Game rec = null;

		         while(inputFile.hasNext()) { 
		           rec = new Game();
		           rec.readGame(inputFile);
		           this.recs.add(rec, this.recs.size());
		           this.index.add(this.gameNumber, this.index.size());
		           ++this.gameNumber;
		         }// Ending bracket of while loop
		       }// Ending bracket of method readFile			

		       
		    /*************************************************************** 
		     * Method calls the toString method in the Game class to print out the 
		     * name, minAge, maxAge, minPlayers, maxPlayers, minPlayTime, maxPlayTime
		    **/
		    public String toString() {
		    	 String s = "";
		    	 for(int i = 0; i < this.getSize(); ++i) {
		    		 s += String.format("%s(idx,rec) (%d,%d) %s%n", Tag, i, this.index.getDataAtPosition(i),
		    				 recs.getDataAtPosition(this.index.getDataAtPosition(i)).toString());
		    	 }// Ending bracket of for loop
		    	   return s;
		       }// Ending bracket of method toString
		       	       
		    /*************************************************************** 
		     * Method to sort the SLL records and their positions
		    **/
		    public void sortCatalogue() {
		    	int tempIndex;

		    	for(int length = this.getSize(); length > 1; --length) {
		    		for(int i = 0; i < length - 1; ++i) {
		               if(this.recs.getDataAtPosition(this.index.getDataAtPosition(i)).
		            		   compareTo(this.recs.getDataAtPosition(this.index.getDataAtPosition(i + 1))) > 0) {
		                 // below is our swap
		            	   tempIndex = this.index.getDataAtPosition(i);
		                this.index.setDataAtPosition(i, this.index.getDataAtPosition(i + 1));
		                this.index.setDataAtPosition(i + 1, tempIndex);
		               }// Ending bracket of if
		            }// Ending bracket of inner for loop
		         }// Ending bracket of outer for loop
		    }// Ending bracket of method sortCatalogue	       
		       		       
}// Ending bracket of GameCatalogue