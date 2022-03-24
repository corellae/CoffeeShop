package com.coffeeshop.app;

public final class Cafe {

	private int beansInStock = 0;
	private int milkIntStock = 0;

	public Coffee brew(CoffeeType coffeeType) {

		return brew(coffeeType, 1);
	}

	public Coffee brew(CoffeeType coffeeType, int quantity) {

		requirePositive(quantity);

		int requiredBeans = coffeeType.getRequiredBeans() * quantity;
		int requiredMilk = coffeeType.getRequiredMilk() * quantity;

		if (requiredBeans > beansInStock || requiredMilk > milkInStock) {
			throw new IllegalStateException();
		}

		beansInStock -= requiredBeans;
		milkInStock -= requiredMilk;
		return new Coffee(coffeeType, requiredBeans, requiredMilk);
	}

	public void restockBeans(weightInGrams) {
		requirePositive(weightInGrams);
		beansInStock += weightInGrams;
	}

	public void restockMilk(weightInGrams) {
		requirePositive(weightInGrams);
		milkInStock += wightInGrams;
	}

	private void requirePositive(int value) {
		if (value < 1) {
			throw new IllegalArgumentException();
		}
	}

	public int getBeansInStock() {
		return beansInStock;
	}

	public int getMilkInStock() {
		return milkInStock;
	}
}
