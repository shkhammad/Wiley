package com.annotations;

//Reflection API for annotations
import java.lang.reflect.Method;

public class Annotate {
	
	@Simple(place = "Mumbai")
	@Simple(place="Bangalore", name = "Samina")
	public static void method1() {
		
		
		
	}
	
	public static void method2(int val1, double val2) {
		
	}
	
	
	public static void main(String[] args) {
		
		
		@SuppressWarnings("rawtypes")
		Class[] classes = new Class[2];
		classes[0] = int.class; 
		classes[1] = double.class; 
		
		@SuppressWarnings("rawtypes")
		Class[] classes2 = new Class[0];
		
		
		try {
			//for getting a particular method which is annotated
			Method m1 = Annotate.class.getMethod("method1", classes2);
			System.out.println(m1.getName());
			
			Method m2 = Annotate.class.getMethod("method2", classes);
			System.out.println(m2.getName());
		} 
		
		catch (NoSuchMethodException e) {
			e.printStackTrace();
		} 
		
		catch (SecurityException e) {
			e.printStackTrace();
		}
		
		//for getting all the methods of the given class
		Method methods[] = Annotate.class.getMethods();
		
		for(Method m: methods) {
			
			Simple[] simples = m.getAnnotationsByType(Simple.class);
			int i,n=simples.length;
			
			for(i=0;i<n;++i) {
				System.out.println(simples[i].place());
				System.out.println(simples[i].name());
				System.out.println(simples[i].date());
			}		
		}
		
		
	}
}	
