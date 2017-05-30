package com.epam.data;

import java.util.ArrayList;
import java.util.Collections;

public class MemoryDataStore<T> implements DataStore<T>{

	private ArrayList<T> store = new ArrayList<T>();

	@Override
	public void add(T t) {
		store.add(t);
	}
	@Override
	public Iterable<T> list() {
		return Collections.unmodifiableCollection(store);
	}

}
