package com.skilldistillery.foodtruck.entities;

public class Foodtruck {
	private static int nextTruckId;
	private int id = 0;
	private String name;
	private String foodType;
	private int rating;
	
	
	public Foodtruck() {
		
	}
	public Foodtruck(String name, String foodType, int rating) {
		
		this.id = id + 1;
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
	}
	public static int getNextTruckId() {
		return nextTruckId;
	}
	public static void setNextTruckId(int nextTruckId) {
		Foodtruck.nextTruckId = nextTruckId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Foodtruck id: " + id + ", name: " + name + ", foodType: " + foodType + ", rating: " + rating + "";
	}
	
	
}
