package com.finder.repositories;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.finder.model.FridgeItem;

public class FridgeRepository {

	private List<FridgeItem> itemsInFridge;
	private Map<String, FridgeItem> itemsInFridgeMap;
	private static FridgeRepository fridgeRepository;

	public static FridgeRepository getInstance() {
		if (fridgeRepository == null)
			fridgeRepository = new FridgeRepository();
		return fridgeRepository;
	}

	private FridgeRepository() {
		itemsInFridgeMap = new HashMap<String, FridgeItem>();
		itemsInFridge = new ArrayList<FridgeItem>();
	}

	public List<FridgeItem> getItemsInFridge() {
		return itemsInFridge;
	}

	public FridgeItem getItemByName(String name) {
		return itemsInFridgeMap.get(name);
	}

	public List<FridgeItem> getItemsInFridgeWithoutOutOfDateSortedByDate() {
		List<FridgeItem> sortedList = itemsInFridge;
		Calendar today = Calendar.getInstance();
		for (FridgeItem item : sortedList) {
			if (item.getUseBy().before(today)) {
				sortedList.remove(item);
			}
		}
		Collections.sort(sortedList);
		return sortedList;
	}

	public void setItemsInFridge(List<FridgeItem> itemsInFridge) {
		if (itemsInFridge == null || itemsInFridge.size() <= 0)
			return;
		this.itemsInFridge = itemsInFridge;
		for (FridgeItem item : itemsInFridge)
			itemsInFridgeMap.put(item.getName(), item);
	}

	public void addFridgeItem(FridgeItem item) {
		if (item != null) {
			itemsInFridge.add(item);
			itemsInFridgeMap.put(item.getName(), item);
		}
	}

}
