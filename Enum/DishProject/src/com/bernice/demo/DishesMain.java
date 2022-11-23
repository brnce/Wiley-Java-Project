package com.bernice.demo;

public class DishesMain {
	public static void main(String[] args) {
		Dish dish=Dish.PASTA;
		
		dish.caloriesCheck();
		dish.showDishInfo();
		
        Dish dishes=Dish.RICE;
		
		dishes.caloriesCheck();
		dishes.showDishInfo();
		

	}
}
