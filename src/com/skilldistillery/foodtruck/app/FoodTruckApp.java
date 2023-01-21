package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.Foodtruck;

public class FoodTruckApp {
	// This main food truck app does NOT pass in the id value for any foodtruck
	// fleet of Foodtrucks
	private Foodtruck[] fleet = new Foodtruck[MAX_FLEET];
	private static int MAX_FLEET = 5;
	private static int numOfFoodTruck = 0;
	private Scanner customer = new Scanner(System.in);

	public static void main(String[] args) {
		FoodTruckApp ftApp = new FoodTruckApp();
		ftApp.truckInput();
		ftApp.menuOptions();
		

	}


	public void truckInput() {
		String name;
		String foodType;
		int rating;

		for (int i = 0; numOfFoodTruck < MAX_FLEET; i++) {
			System.out.println("Enter the name of the food truck OR type quit to continue: ");
			name = customer.nextLine();
			if (name.equalsIgnoreCase("quit")) {
				
				break;
			}

			System.out.println("Enter the food type: ");
			foodType = customer.nextLine();
			System.out.println("Enter your rating for the truck from 1 to 5: ");
			rating = customer.nextInt();
			customer.nextLine();
			Foodtruck truck = new Foodtruck(name, foodType, rating);
			fleet[i] = truck;
		}
	}

	public void menuOptions() {
		String option;
		boolean running = true;
		do {
			System.out.println("Please choose a number from the Menu:");
			System.out.println("---------------MENU---------------");
			System.out.println("1. List all existing food trucks");
			System.out.println("2. See the average rating of food trucks");
			System.out.println("3. Display the highest rated food truck");
			System.out.println("4. quit");
			
			option = customer.nextLine(); 
			
			switch (option) {
			case "1":
				System.out.println();
				break;
			case "2":
				System.out.println("The food trucks' combined average ratings are: ");
				break;
			case "3":
				System.out.println("The Highest rated food truck is: ");		//add \n (newlines) for each
				break;
			case "4":
				System.out.println("Thank you for your input, have a nice day");
				running = false;
				break;

			default:
				System.err.println("Error: Please enter an appropriate option.");

			}

		} while (running);
		customer.close();
	}
}
