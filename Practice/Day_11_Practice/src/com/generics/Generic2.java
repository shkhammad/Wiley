package com.generics;

public class Generic2<K,V> {
	
	//key-value mappings (pairs)
	private K key;
	private V value;
	
	public void put(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return this.key;
	}
	
	public V getValue() {
		return this.value;
	}
}
