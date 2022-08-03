package delivery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Restaurant {
	private String name,category;
	
	private class Dish{
		private String name;
		float price;
		
		public Dish(String name, float price) {
			this.name = name;
			this.price = price;
		}

		public String getName() {
			return name;
		}

		public float getPrice() {
			return price;
		}
		
		public boolean inRange(float min, float max) {
			if(price>=min && price<=max)
				return true;
			return false;
		}
		
	}
	
	private List<Dish> dishes=new ArrayList<>();
	private List<Integer> orders=new ArrayList<>();
	private List<Integer> ratings=new ArrayList<>();
	
	public Restaurant(String name, String category) {
		this.name = name;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	
	public List<Dish> getDishes() {
		return dishes;
	}

	public List<String> getDishesNames() {
		dishes.sort(Comparator.comparing(Dish::getName));
		return dishes.stream().flatMap(d->Stream.of(d.getName())).collect(Collectors.toList());
	}
	
	public void addDish(String name, float price) {
		Dish d=new Dish(name,price);
		dishes.add(d);
	}
	
	public boolean dishIsPresent(String name) {
		for(Dish d: dishes)
			if(d.getName().equals(name))
				return true;
		return false;
	}
	
	
	public List<String> getDishesByPrice(float min, float max) {
		List<String> list=dishes.stream().filter(d-> d.inRange(min, max) )
				          .flatMap(d->Stream.of(d.getName()))
				          .collect(Collectors.toList());
		return list;
	}
	
	public void addOrder(int number) {
		orders.add(number);
	}
	
	public void addRating(int rating) {
		ratings.add(rating);
	}
	
	public float avgRating() {
		float avg=0;
		for(Integer i: ratings)
			avg+=i;
		avg/=ratings.size();
		return avg;
	}
	public boolean isRated() {
		if(ratings.isEmpty())
			return false;
		return true;
	}
	
	public long numOrders() {
		long i;
		if(orders.isEmpty())
			i=0;
		else 
		   i=(long)orders.size();
		return i;
	}
	
	

}
