package com.metadesign.exercise.machine.components;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.metadesign.exercise.nutsAndbolts.ISmartSensor;
import com.metadesign.exercise.nutsAndbolts.ItemsAvailable;

public class CollectionBin implements ISmartSensor {
	
	private ArrayList<ItemsAvailable> collectibles;
	
	public CollectionBin(int maxSize) {
		
		this.collectibles = new ArrayList<ItemsAvailable> (maxSize);
		
	}
	
	@Override
	public boolean isEquipmentEmpty() { return this.collectibles.isEmpty(); }
	
	public void dropInBin(List<ItemsAvailable> fromRacks) {
		
		if (fromRacks.isEmpty())
			throw new java.lang.UnsupportedOperationException("Dropping from empty racks to bin");
		
		this.collectibles.addAll(fromRacks);
	}
	
	public List<ItemsAvailable> collectFromBin() {
		
		List<ItemsAvailable> fromBin = Collections.unmodifiableList(this.collectibles);
		this.collectibles.clear();
		return (fromBin);
	}
}
