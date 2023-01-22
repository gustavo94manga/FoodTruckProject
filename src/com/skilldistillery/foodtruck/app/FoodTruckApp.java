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
	private int counter = 0;

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
			counter++;
		}
	}

	public void menuOptions() {
		String option;
		boolean running = true; //
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
				for (int i = 0; i < counter; i++) {
					System.out.println("The Truck ID is: " + fleet[i].getId());
					System.out.println("The food truck name is: " + fleet[i].getName());
					System.out.println("The food type is: " + fleet[i].getFoodType());
				}
				System.out.println("Choose another option to see the rating \n");
				break;

			case "2":
				int sum = 0;
				double avg = 0.0;
				for (int i = 0; i < counter; i++) {
					sum += fleet[i].getRating();
				}
				avg = sum / counter;
				System.out.println("The food trucks' combined average ratings are: " + avg + "\n");
				break;

			case "3":
				int highest = 0;
				Foodtruck highestNumber = fleet[0];
				for (int i = 0; i < counter; i++) {
					Foodtruck highestAvg = fleet[i];
					if (highestAvg.getRating() > highest) {
						highest = highestAvg.getRating();
						highestNumber = highestAvg;
					}
				}
				System.out.println("The Highest rated food truck is: " + highestNumber + "\n"); // add \n (newlines) for
																								// each
				break;

			case "4":
				System.out.println("Thank you for your input, have a nice day");
				running = false;
				break;

			default:
				System.err.println("Error: Please enter an appropriate option. \n");

			}

		} while (running);
		customer.close();
	}
}
