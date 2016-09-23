package com.metadesign.exercise.machine.components;

import java.util.ArrayList;
import java.util.List;

import com.metadesign.exercise.nutsAndbolts.ItemsAvailable;

public class Rack {
	
	private final int    capacity;
	
	private int          countCurrentlyHolding;
	
	private ItemsAvailable     drink;
	
	public  Rack(int capacity,ItemsAvailable itemHeldInTheRack) {
		assert(capacity > 0);
		this.capacity              = capacity;
		this.countCurrentlyHolding = this.capacity;
	}
	
	public  boolean isFull() { return((this.countCurrentlyHolding == this.capacity) ? true : false); }
	
	public  boolean isEmpty() { return((this.countCurrentlyHolding == 0) ? true : false); }
	
	public  int     emptySlots() { return (this.capacity - this.countCurrentlyHolding); }
	
	public  int     availableItems()  { return this.countCurrentlyHolding; }
	
	public  int     replenish(int newSupply) {
		
		if (this.isFull())
			return (0);
		
		else {
			if (emptySlots() >= newSupply)
				this.countCurrentlyHolding += newSupply;
			else
				this.countCurrentlyHolding = this.capacity;
			return (emptySlots());
		}
	}
	
	public List<ItemsAvailable>      releaseFromRack(int howManyPurchased) {
		
		if (this.isEmpty()) {
			List<ItemsAvailable> itemsDispensed = new ArrayList<ItemsAvailable>(0);
			return (itemsDispensed);
		}
		else 
		if (howManyPurchased >= this.countCurrentlyHolding){ // We can sell only as many available
			List<ItemsAvailable> itemsDispensed = new ArrayList<ItemsAvailable>(0);
			for (int i = 0; i < this.countCurrentlyHolding; i++) 
				itemsDispensed.add(this.drink);
			
			this.countCurrentlyHolding = 0;
			return (itemsDispensed);
		}
		else {
			List<ItemsAvailable> itemsDispensed = new ArrayList<ItemsAvailable>(0);
			for (int i = 0; i < howManyPurchased; i++) 
				itemsDispensed.add(this.drink);
			
			this.countCurrentlyHolding -= howManyPurchased;
			return (itemsDispensed);
		}	
	}
}
