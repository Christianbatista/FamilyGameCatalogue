package edu.mtc.egr283;
import java.util.Scanner;
/*************************************************************
 * Class for handling the data in a <code>Game</code>.
 * This is the class to handle a single Game-like record.
 *@author Christian Batista
 *@version 1.00 2019-14-03
 *Copyright (C) 2019 by Christian Batista. All rights reserved.
**/
public class Game implements Comparable<Object> {

	//Instance variables for the class
	private static final String DUMMYSTRING = "dummystring";
	private static final int DUMMYINT = Integer.MIN_VALUE;
	private String name;
	private int minAge;
	private int maxAge;
	private int minPlayers;
	private int maxPlayers;
	private int minPlayTime;
	private int maxPlayTime;
	Scanner s = new Scanner(System.in);
		
		/**
		 * Default Constructor
		 * We create the record and assign dummy
		 * values so as not to have null values.
		 */
		public Game() {
			this(Game.DUMMYSTRING, Game.DUMMYINT,Game.DUMMYINT,Game.DUMMYINT,Game.DUMMYINT,Game.DUMMYINT,Game.DUMMYINT);
		}//Ending bracket of default constructor
		
		/**
		 * Constructor
		 * We create the record and assign dummy
		 * values given by the incoming parameters.
		 * @param newName the value of the name
		 * @param newTeaching the value of the teaching
		 */
		public Game(String newName, int newMinAge,int newMaxAge, int newMinPlayers,int newMaxPlayers,
				int newMinPlayTime,int newMaxPlayTime) {
			this.setName(newName);
			this.setMinAge(newMinAge);
			this.setMaxAge(newMaxAge);
			this.setMinPlayers(newMinPlayers);
			this.setMaxPlayers(newMaxPlayers);
			this.setMinPlayTime(newMinPlayTime);
			this.setMaxPlayTime(newMaxPlayTime);
			
		}//Ending bracket of constructor

		/**
		 * @return the maxAge
		 */
		public int getMaxAge() {
			return maxAge;
		}// Ending bracket of getMaxAge

		/**
		 * @param maxAge the maxAge to set
		 */
		public void setMaxAge(int maxAge) {
			this.maxAge = maxAge;
		}// Ending bracket of setMaxAge

		/**
		 * @return the minPlayers
		 */
		public int getMinPlayers() {
			return minPlayers;
		}// Ending bracket of getMinPlayers

		/**
		 * @param minPlayers the minPlayers to set
		 */
		public void setMinPlayers(int minPlayers) {
			this.minPlayers = minPlayers;
		}// Ending bracket of method setMinPlayers

		/**
		 * @return the maxPlayer
		 */
		public int getMaxPlayers() {
			return maxPlayers;
		}// Ending bracket of method getMaxPlayers

		/**
		 * @param maxPlayer the maxPlayer to set
		 */
		public void setMaxPlayers(int maxPlayers) {
			this.maxPlayers = maxPlayers;
		}

		/**
		 * @return the minPlayTime
		 */
		public int getMinPlayTime() {
			return minPlayTime;
		}

		/**
		 * @param minPlayTime the minPlayTime to set
		 */
		public void setMinPlayTime(int minPlayTime) {
			this.minPlayTime = minPlayTime;
		}

		/**
		 * @return the maxPlayTime
		 */
		public int getMaxPlayTime() {
			return maxPlayTime;
		}

		/**
		 * @param maxPlayTime the maxPlayTime to set
		 */
		public void setMaxPlayTime(int maxPlayTime) {
			this.maxPlayTime = maxPlayTime;
		}

		/**
		 * Accessor method to get the <code>name</code>
		 * @return the value of <code>name</code>
		 * 
		 */
		public String getName() {
			return this.name;
		}//Ending bracket getName
		
		/**
		 * Mutator method to set the <code>name</code>
		 * @param newName the value of <code>name</code> to be set
		 */
		public void setName(String newName) {
			this.name = newName;
		}//Ending bracket setName
		
		/**
		 * @return the teaching
		 */
		public int getMinAge() {
			return this.minAge;
		}//Ending bracket getTeaching
		
		/**
		 * Mutator method to set the <code>name</code>
		 * @param newTeaching the value of <code>name</code> to be set
		 */
		public void setMinAge(int newMinAge) {
			this.minAge = newMinAge;
		}//Ending bracket setTeaching 
		
		/**
		 * @param name
		 * @return boolean- true or false
		 */
		public boolean compareName(String name) {
			return (this.getName().equals(name));
		}// Ending bracket of method compareName
		
		/**
		 * @param otherGame
		 * @return 
		 */
		public int compareTo(Object otherGame) {
			int rv = 0;
			
			if(otherGame instanceof Game) {
				Game temp = (Game) otherGame;
				if(this.getName().compareTo(temp.getName()) < 0) {
					rv = -1;
				}else if(this.getName().compareTo(temp.getName()) > 0){
					rv = +1;
				}// Ending bracket of if
			}// Ending bracket of outer if  
			return rv;
		}// Ending bracket of method compareTo
		
		/**
		 * @param inputFile
		 */
		public void readGame(Scanner inputFile) {
			if(inputFile.hasNext()) {
				this.setName(inputFile.next());
				this.setMinAge(inputFile.nextInt());
				this.setMaxAge(inputFile.nextInt());
				this.setMinPlayers(inputFile.nextInt());
				this.setMaxPlayers(inputFile.nextInt());
				this.setMinPlayTime(inputFile.nextInt());
				this.setMaxPlayTime(inputFile.nextInt());
					
			}// Ending bracket of if 
		}// Ending bracket of method readRecord
		
		/* 
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			String s;
			s = String.format("%-10s %4d %4d %4d %4d %4d %4d"
					+ "", this.getName(),
							this.getMinAge(),this.getMaxAge(),
							this.getMinPlayers(),this.getMaxPlayers(),
							this.getMinPlayTime(),this.getMaxPlayTime());
			return s;
		}// Ending bracket of method toString
		
		public void createGame() {
			
			String newName; 
			int newMinAge, newMaxPlayers, newMinPlayers, newMaxPlayTime, newMinPlayTime, newMaxAge;
			System.out.println("What is the name of the game");
			newName = s.next();
			this.setName(newName);
			System.out.println("What is the Minimum age of the game");
			newMinAge = s.nextInt();
			this.setMinAge(newMinAge);
			System.out.println("What is the Maximum age of the game");
			newMaxAge = s.nextInt();
			this.setMaxAge(newMaxAge);
			System.out.println("What is the Minimum number of players");
			newMinPlayers = s.nextInt();
			this.setMinPlayers(newMinPlayers);
			System.out.println("What is the Maximum number of players");
			newMaxPlayers = s.nextInt();
			this.setMaxPlayers(newMaxPlayers);
			System.out.println("What is the minimum playe time");
			newMinPlayTime = s.nextInt();
			this.setMinPlayTime(newMinPlayTime);
			System.out.println("What is the Maximum play time");
			newMaxPlayTime = s.nextInt();
			this.setMaxPlayTime(newMaxPlayTime);
						
		}// Ending bracket of method createGame
}// Ending bracket of class Game
