package com.stream;

import java.io.PrintStream;
//Introduction to stream API	
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Test {
	
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) {
		
		List<Employee> ls = new ArrayList<>();
		ls.add(new Employee(1,"Hammad",22, 'M'));
		ls.add(new Employee(2,"Sikandar",62, 'M'));
		ls.add(new Employee(3,"Samina",52, 'F'));
		ls.add(new Employee(4,"Mittu",12, 'F'));
		
		
		//A sequence of elements supporting sequential and parallel 
		//aggregate operations (pipelines)
		//pipelines -> sequence of aggregate operations
		
		//A stream pipeline consists of a source (array, list, etc)
		//zero or more intermediate operations (such as filter, map, distinct)
		//terminal operations which produces a result (such as count or forEach)
		//cannot modify/delete objects of the stream while traversing it
		ls.stream().forEach(val -> out.println(val));
		
		
		//filter operation is a intermediate operation
		//whose parameter is a predicate interface
		//test method returns a boolean value
		ls.stream().filter((age) -> age.getAge() > 30).forEach((val) -> out.println(val));
		
		ls.stream().filter(s -> s.getName().startsWith("S")).filter((age) -> age.getAge() > 50).forEach(val -> out.println(val));
		
		long res = ls.stream().filter(s -> s.getName().startsWith("S")).filter((age) -> age.getAge() > 50).count();
		out.println(res);
		
		
		//mapToInt method returns an Intstream
		//which has many methods such as max,min,sum,avg
		int res2 = ls.stream().filter(s -> s.getName().
				startsWith("S")).
				filter((age) -> age.getAge() > 50).mapToInt((age) -> age.getAge()).sum();
		
		out.println(res2);
		
		//getAsDouble converts OptionalDouble --> Double
		double res3 = ls.stream().mapToInt(age -> age.getAge()).average().getAsDouble();
		out.println(res3);
		
		
		//sorting based on increasing order of age
		ls.stream()
				.sorted((o1,o2) -> Integer.valueOf(o1.getAge())
				.compareTo(Integer.valueOf(o2.getAge())))
				.forEach(val -> out.println(val));
		
		//sorting based on decreasing order of age
		ls.stream()
		.sorted((o1,o2) -> Integer.valueOf(o2.getAge())
		.compareTo(Integer.valueOf(o1.getAge())))
		.forEach(val -> out.println(val));
		
		//Collectors is a class which returns Collector which is an interface
		//Collectors.toList method returns a collector<T,A,R>
		//T - type of input --> Employee
		//A - hidden type --> ?
		//R - the result type --> List<Employee>
		List<Employee> employees = ls.stream()
		.filter(s -> s.getName().startsWith("S"))
		.filter((age) -> age.getAge() > 50)
		.collect(Collectors.toList());
		
		employees.forEach(val -> out.println(val));
		
		
		//after applying stream operations the original data-structure 
		//should not change
		ls.forEach(val -> out.println(val));
		
		//another way to sort by using comparing function
		//reversed method --> decreasing order
		//getName is the 'key' for sorting the list
		Collections.sort(ls, Comparator.comparing(Employee:: getName).reversed());
		ls.forEach(val -> out.println(val));
		
		//if want to sort in decreasing order use the reverse order method
		List<Integer> ls2 = new ArrayList<>();
		ls2.add(1);
		ls2.add(2);
		ls2.add(3);
		ls2.add(4);
		ls2.add(3);
		
		Collections.sort(ls2, Comparator.reverseOrder());
		ls2.forEach(val -> out.println(val));
		
		//reduce method --> terminal function
		int res4 = ls.stream()
		//classification function --> mapper
		//map method returns a normal stream
		.map(age -> age.getAge())
		.reduce(0, (a,b) -> a+b);
		out.println(res4);
		
		
		//distinct method returns distinct elements in the stream
		long res5 = ls2.stream().distinct().count();
		out.println(res5);
		
		
		
		List<String> ls3 = new ArrayList<>();
		ls3.add("Hammad");
		ls3.add("Sikandar");
		ls3.add("Samina");
		ls3.add("Hammad");
		
		
		//s -> s we can also use Function.identity()
		//String::new --> reference to a constructor
		
		Map<String,Long> mp8= ls3.stream().collect(Collectors.groupingBy(String::new,Collectors.counting()));
		out.println(mp8);
		
		//using method reference for printing the elements of the list
		PrintStream ps = new PrintStream(System.out);
		ls3.forEach(ps::println);
		
		
		//Unlike the reduce method, which always creates a new value 
		//when it processes an element the collect method modifies
		//or mutates, an existing value, so in general collect method is better
		//than reduce method and it is more efficient
		//collectors class is mainly used for user-defined datatype (collections)
				
		//Collectors.groupingBy returns a Map<K, List<T>> based 
		//on the classification function (which produces a key)
		//here key is gender --> character
		//so we are grouping by gender
		Map<Character, List<Employee>> mp = ls.stream()
		.collect(Collectors.groupingBy(g -> g.getGender()));
		
		out.println(mp);
		
		//downstream collector
		//multi-level reduction
		//performing a reduction operation on the values associated 
		//with a given key using the specified downstream Collector.
		Map<Character, List<String>> mp2 = ls.stream()
		.collect(Collectors.groupingBy(g -> g.getGender(),
				Collectors.mapping(Employee:: getName, Collectors.toList())));
		
		out.println(mp2);
		
		//reducing method
		//identity --> initial value
		//mapper --> the reducing operation apply this to all the stream elements
		//binaryoperator --> bifunction --> apply(T,U) --> it is
		//further used to reduce the mapped values
		//reducing method evaluates to a result/value
		Map<Character, Integer> mp3 = ls.stream()
		.collect(Collectors.groupingBy(g -> g.getGender(), 
		Collectors.reducing(0, age -> age.getAge(), (a,b) -> a+b)));
		
		out.println(mp3);
		
		//averagingInt method evaluates to a result/value
		//it retrieves the average age of persons grouped by gender
		Map<Character, Double> mp4 =  ls.stream()
		.collect(Collectors.groupingBy(g -> g.getGender(),
		Collectors.averagingInt(Employee:: getAge)));
		
		out.println(mp4);
		
		//comparator based on string length (increasing order)
		Comparator<String> cmp = Comparator.comparing(String:: length);
		
		//longest name grouped by gender
		Map<Character, String> mp5 = ls.stream().collect(Collectors.groupingBy(g -> g.getGender(), 
				Collectors.reducing("",Employee:: getName, BinaryOperator.maxBy(cmp))));
		
		out.println(mp5);
		
		//smallest name grouped by gender
		String max = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
		Map<Character, String> mp6 = ls.stream()
				.collect(Collectors.groupingBy(g -> g.getGender(), 
				Collectors.reducing(max,Employee:: getName, BinaryOperator.minBy(cmp))));
		
		out.println(mp6);
		
		//here Collectors.maxBy method returns a result of an optional type --> Optional<T>
		//Optional --> A container object which may or may not contain a non-null value 
		//If a value is present, isPresent() will return true and 
		//get() will return the value of the original type.
		//Collectors.maxBy() internally calls BinaryOperator.maxBy()
		
		Map<Character, Optional<String>> mp7 = ls.stream()
				.collect(Collectors.groupingBy(g -> g.getGender(), 
				Collectors.mapping(Employee:: getName, Collectors.maxBy(cmp))));
		
		out.println(mp7);
		
		for(char c: mp7.keySet()) {
			Optional<String> str = mp7.get(c);
			if(str.isPresent()) {
				out.println(c + " " + str.get());	
			}
		}
		
		
		out.close();
	}
}
