package com.epam;

import com.epam.cache.CacheWithUsage;

public class Monitor<T> {

	private CacheWithUsage cache;

	public Monitor(CacheWithUsage cache) {
		this.cache = cache;
	}
	
	public void printInfo() {
		System.out.println("Cache info:");
		for (String key : cache.getKeys()) {
			System.out.println("Element: " + key);
			System.out.println("Last access: " + cache.getLastAccess(key));
			System.out.println("Number of hits: " + cache.getNumHits(key));
		}
	}
	
}
