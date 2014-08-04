package leetcode.design;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and
 * set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * 
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should
 * invalidate the least recently used item before inserting a new item.
 * 
 */
public class LRUCache {

	// The key here is hashmap + doubly linked list
	// to ensure O(1) removal of an entry by reference!

	private final LinkedHashMap<Integer, Integer>	map;

	// use contain rather than inheritance to avoid exposing additional methods to user

	public LRUCache(final int capacity) {
		map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {

			private static final long	serialVersionUID	= 1L;

			@Override
			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
				return size() > capacity;
			}
		};
	}

	// O(1), O(1) space
	public int get(int key) {
		Integer value = map.get(key);
		if (value == null)
			return -1;
		return value;
	}

	// O(1), O(1) space
	public void set(int key, int value) {
		map.put(key, value);
	}

}
