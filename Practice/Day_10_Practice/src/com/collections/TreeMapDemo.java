package com.collections;

import java.io.PrintWriter;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapDemo {
	
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) {
		
		TreeMap<Integer,String> tmp = new TreeMap<>();
		
		tmp.put(25, "Hammad");
		tmp.put(5, "Samina");
		tmp.put(55, "Sikandar");
		tmp.put(45, "Mittu");
		
		out.println(tmp);
		
		
		tmp.forEach((it,st) -> out.println(it+" "+st));
		
		//key should be unique
		tmp.putIfAbsent(30, "Sikandar");
		out.println(tmp);
		
		
		tmp.computeIfAbsent(2, (val) -> {
			
			//takes key as the input (val)
			//computes value (function) based on the key
			int i;
			StringBuilder sb = new StringBuilder("");
			sb.append("Kajal");
			for(i=0;i<val;++i) 
				sb.append("*");
			
			return sb.toString();
			
		});
		
		out.println(tmp);
		
		
		tmp.computeIfPresent(5, (val1,val2) -> {
			
			//takes key and value both as an input and computes value 
			int i;
			StringBuilder sb = new StringBuilder("");
			sb.append(val2);
			for(i=0;i<val1;++i) 
				sb.append("#");
			
			return sb.toString();	
			
		});
		
		out.println(tmp);
		
		
		tmp.merge(25, "Hammad", (val1,val2) -> {
			
			//takes existing value as input and computes the new value
			//for the given key using bifunctional interface
			//return val1+ " " + val2;
			//method reference --> String::concat --> implicitly concatenates
			
			return val1.concat(val2);
		});
			
		tmp.merge(55, "Sikandar", String::concat);
		out.println(tmp);
		
		//returns the smallest key
		Integer key1 = tmp.firstKey();
		//returns the largest key
		Integer key2 = tmp.lastKey();
		
		out.println(key1 + " " +key2);
		out.println(tmp.get(key1) + " " + tmp.get(key2));

		Entry<Integer,String> et1 = tmp.firstEntry();
		out.println(et1.getKey() + " " + et1.getValue());
		
		Entry<Integer,String> et2 = tmp.lastEntry();
		out.println(et2.getKey() + " " + et2.getValue());

		//returns a map consisting of pairs, greater than or equal to the given input(key) 
		SortedMap<Integer,String> sm = tmp.tailMap(30);
		out.println(sm);
		
		//returns a map consisting of pairs, greater than the given input(key) 
		SortedMap<Integer,String> sm2 = tmp.tailMap(30, false);
		out.println(sm2);
		
		//returns a map consisting of pairs, strictly less than the given input(key) 
		SortedMap<Integer,String> sm3 = tmp.headMap(30);
		out.println(sm3);
		
		//returns a map consisting of pairs, less than or equal to the given input(key) 
		SortedMap<Integer,String> sm4 = tmp.headMap(30,true);
		out.println(sm4);
		
		
		out.close();
	}
}
