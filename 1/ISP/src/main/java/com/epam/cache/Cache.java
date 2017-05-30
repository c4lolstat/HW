package com.epam.cache;

import java.util.Date;

public interface Cache<T> {

	// Basic cache operations
	public void put(String key, T value);

	public T get(String key);

	public void clear(String key);

	public void clearAll();
}
