package com.dsa;

import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
	
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) {
		
		//can be done by specifying the ordering of the objects
		//by using comparator as well
		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
			
			@Override
			public int compare(Pair p1, Pair p2) {
				return p2.getValue() - p1.getValue();
			}
			
		});
		
		pq.offer(new Pair(0,10));
		pq.offer(new Pair(1,30));
		pq.offer(new Pair(2,50));
		pq.offer(new Pair(3,20));
		
		out.println(pq.poll());
		out.println(pq.poll());
		out.println(pq.poll());
		out.println(pq.poll());
		
		
		PriorityQueue<Pair> pq2 = new PriorityQueue<>((p1,p2) -> 
			{
				return p1.getValue() - p2.getValue();
			}
		);
		
		pq2.offer(new Pair(0,37));
		pq2.offer(new Pair(1,27));
		pq2.offer(new Pair(2,17));
		pq2.offer(new Pair(3,7));
		
		out.println(pq2.poll());
		out.println(pq2.poll());
		out.println(pq2.poll());
		out.println(pq2.poll());
		
		
		out.close();
		
	}
}
