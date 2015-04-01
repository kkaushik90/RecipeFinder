package com.finder.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.finder.model.FridgeItem;

public class FridgeRepository {

	private Map<String, FridgeItem> itemsInFridge;
	private static FridgeRepository fridgeRepository;

	public static FridgeRepository getInstance() {
		if (fridgeRepository == null)
			fridgeRepository = new FridgeRepository();
		return fridgeRepository;
	}

	private FridgeRepository() {
		itemsInFridge = new HashMap<String, FridgeItem>();
	}

	public FridgeItem getItemByName(String name) {
		return itemsInFridge.get(name);
	}

	public void setItemsInFridge(List<FridgeItem> itemsInFridgeList) {
		if (itemsInFridgeList == null || itemsInFridgeList.size() <= 0)
			return;
		for (FridgeItem item : itemsInFridgeList)
			itemsInFridge.put(item.getName(), item);
	}

	public void addFridgeItem(FridgeItem item) {
		if (item == null)
			throw new RuntimeException("Item cannot be null.");
		else if (itemsInFridge.keySet().contains(item.getName())) {
			itemsInFridge.get(item.getName()).addAmount(item.getAmount());
		}

		if (item != null) {
			itemsInFridge.put(item.getName(), item);
		}
	}

	// public List<FridgeItem> getItemsInFridgeWithoutOutOfDateSortedByDate() {
	// List<FridgeItem> sortedList = itemsInFridge;
	// Calendar today = Calendar.getInstance();
	// for (FridgeItem item : sortedList) {
	// if (item.getUseBy().before(today)) {
	// sortedList.remove(item);
	// }
	// }
	// Collections.sort(sortedList);
	// return sortedList;
	// }

}
