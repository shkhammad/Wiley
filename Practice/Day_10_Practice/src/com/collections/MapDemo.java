package com.collections;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapDemo {
	
	static PrintWriter out = new PrintWriter(System.out);
	
	static Map<String, List<String>> mp2 = new HashMap<>();
	
	public static void solve(String key, String value) {
		
		List<String> ls = mp2.get(key);
		
		if(ls == null) {
			ls = new ArrayList<>();
			ls.add(value);
			mp2.put(key, ls);
		}
		
		else {
			if(!ls.contains(value)) {
				ls.add(value);
				mp2.put(key,ls);
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		String s = "hammad";
		Map<Character,Integer> mp = new HashMap<>();
		
		for(char c: s.toCharArray())
			mp.put(c, mp.getOrDefault(c,0)+1);
		
		//using keyset method printing keys and values
		for(char c: mp.keySet()) 
			out.println(c + " " + mp.get(c));
		
		//entry-set is a collection-view of the map
		//i.e, a key-value pair
		//entryset method returns a set view of the mappings (entry)
		//present in the amp
		Set<Entry<Character,Integer>> st = mp.entrySet();
		Iterator<Entry<Character,Integer>> it1 = st.iterator();
		
		while(it1.hasNext()) {
			
			Entry<Character,Integer> entry = it1.next();
			//getkey returns the key corresponding to the entry
			//getvalue returns the value corresponding to the entry 
			out.println(entry.getKey() + " " + entry.getValue());
		}
		
		out.println(st);
		
		
		solve("Tata", "Aria");
		solve("Tata", "Nano");
		solve("BMW", "X3");
		solve("BMW", "X3");		
		solve("Audi", "Q5");
		
		
		out.println(mp2.toString());
		
		Set<Entry<String, List<String>>> st2 = mp2.entrySet();
		Iterator<Entry<String, List<String>>> it2 =	st2.iterator();
		
		while(it2.hasNext()) {
			Entry<String,List<String>> entry = it2.next();
			out.println(entry.getKey() + " " + entry.getValue());
		}
		
		Map<String, Map<String,Integer>> mp3 = new HashMap<>();
		
		Map<String,Integer> tmp = new HashMap<>();
		
		tmp.put("Hammad", 22);
		tmp.put("Sikandar", 62);
		
		Map<String,Integer> tmp2 = new HashMap<>();
		
		tmp2.put("Kaivan", 21);
		tmp2.put("Gauri", 23);
		
		mp3.put("Family",tmp);
		mp3.put("Friends",tmp2);
		
		out.println(mp3);
		
		Set<Entry<String, Map<String,Integer>>> st3 = mp3.entrySet();
		Iterator<Entry<String, Map<String,Integer>>> it3 = st3.iterator();
		
		while(it3.hasNext()) {
			Entry<String, Map<String,Integer>> entry = it3.next();
			out.println(entry.getKey());
			
			Map<String,Integer> map = entry.getValue();
			
			for(String s2: map.keySet()) {
				out.println(s2 + " " + map.get(s2));
			}
		}
		
		
		out.close();
	}
}
