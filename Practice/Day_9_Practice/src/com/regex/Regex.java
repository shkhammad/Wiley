package com.regex;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
	
	public static void main(String... args) {
		
		//Example 1
		String s = "+91-889881\\*^%^&&8001^&%^$%";
		String s12 = "abbcdef";
		
		//regex pattern
		String pattern = "[^A-Za-z0-9]";
		String p2 = "[acdebf]";
		
		s = s.replaceAll(pattern, "");
		s12 = s12.replaceAll(p2, "");
		
		System.out.println(s);
		System.out.println(s12);
		
		
		/*Example 2
		
		 Quantifiers (matches for preceding character/group)
		 	
		 	* - matches 0 or more instances of preceding character/group
		 	+ - matches 1 or more instances of preceding character/group 
		 	? - matches exactly 0 or 1 instances of preceding character/group	
		 	{n} - matches exactly n instances of preceding character/group	
		 	{n,m} - matches min n or max m instances of preceding character/group
		 	{n,} - matches min n or more instances of preceding character/group	 	
		*/
		
		String s2 = "ab";
		String pattern2 = "abc*";
		System.out.println(s2.matches(pattern2));
		
		String s3 = "ab";
		String pattern3 = "abc+";
		System.out.println(s3.matches(pattern3));
		
		String s4 = "abcc";
		String pattern4 = "abc?";
		System.out.println(s4.matches(pattern4));
		
		String s5 = "abccc";
		String pattern5 = "abc{3}";
		System.out.println(s5.matches(pattern5));
		
		String s6 = "abc";
		String pattern6 = "abc{2,4}";
		System.out.println(s6.matches(pattern6));
		
		String s7 = "abccccccc";
		String pattern7 = "abc{1,}";
		System.out.println(s7.matches(pattern7));
		
		//here 'xyz' is treated as a group
		String s8 = "abcxyzxyz";
		String pattern8 = "abc(xyz)*";
		System.out.println(s8.matches(pattern8));
		
		String s9 = "abcxyzxyzxyz";
		String pattern9 = "abc(xyz){1,2}";
		System.out.println(s9.matches(pattern9));
		
		
		
		
		/*Example 3
		
		 Character Classes 
		 	
		 	\d - matches a single digit character
		 	\w - matches a single word character
		 	\s = matches a single whitespace character
		 	\D - matches a single non-digit character
		 	\W - matches a single non-digit and non-word character (special characters - &,*,$ etc)
		 	
		*/
		
		String s10 = "123";
		String pattern10 = "\\d{3}";
		System.out.println(s10.matches(pattern10));
		
		String s11 = "abd";
		String pattern11 = "\\w{3}";
		System.out.println(s11.matches(pattern11));
		
		String s13 = "  ";
		String pattern12 = "\\s{2}";
		System.out.println(s13.matches(pattern12));
		
		String s14 = "abd";
		String pattern14 = "\\D{3}";
		System.out.println(s14.matches(pattern14));
		
		String s15 = "\\\\\\";
		String pattern15 = "\\W{1,3}";
		System.out.println(s15.matches(pattern15));
		
		String s16 = "123abc";
		String pattern16 = "\\d{1,3}\\w{1,3}";
		System.out.println(s16.matches(pattern16));
		
		
		
		//Example 4
		//Bracket Expressions
		//[] --> choose any one character
		
		String s17 = "bat";
		String pattern17 = "[ta]at";
		System.out.println(s17.matches(pattern17));
		
		String s18 = "bat";
		String pattern18 = "[a-z]at";
		System.out.println(s18.matches(pattern18));
		
		
		String s19 = "A8tat";
		String pattern19 = "[A-Za-z0-9]{3}at";
		System.out.println(s19.matches(pattern19));
		
		String s20 = "#@at";
		String pattern20 = "[^A-Za-z0-9]{2}at";
		System.out.println(s20.matches(pattern20));
		
		
		//'OR' Operator
		String s21 = "aef";
		String pattern21 = "a(b|c|d|123|ef)";
		System.out.println(s21.matches(pattern21));
		
		
		//(Dot)'.' Operator --> matches any single character
		String s22 = "aex";
		String pattern22 = "ae.";
		System.out.println(s22.matches(pattern22));
		
		
		String s23 = "aefasjkjakldfj83u09uaz898**((&";
		String pattern23 = ".*";
		System.out.println(s23.matches(pattern23));
		
		
		//Example 5
		//Pattern and Matcher classes
		
		//Greedy --> considers only one substring
		Pattern p = Pattern.compile("aa.*bb");
		Matcher m = p.matcher("aacbbhjhjjhaacbb");
		
		//System.out.println(m.results().count());
		m.reset();
		
		while(m.find()) {
			System.out.println(m.start());
			System.out.println(m.group());
		}
		
		//Non-greedy (?) --> considers every substring
		//can be used with +?, *? and {}?
		
		Pattern p1 = Pattern.compile("aa.*?bb");
		Matcher m1 = p1.matcher("aacbbhjhjjhaacbb");
		
		//System.out.println(m1.results().count());
		m1.reset();
		
		while(m1.find()) {
			System.out.println(m1.start());
			System.out.println(m1.group());
		}
		
		Pattern p4 = Pattern.compile("ww.{1,}?ww");
		Matcher m3 = p4.matcher("wwaawwwwaaww"); 
		
		//System.out.println(m3.results().count());
		m3.reset();
		
		while(m3.find()) {
			System.out.println(m3.start());
			System.out.println(m3.group());
		}
		
		
		
		//Example 6
		String pattern24 = "w{3}\\.(dezlearn|dez)\\.(com|us)";
		String s24 = "www.dez.us";
		System.out.println(s24.matches(pattern24));
		
		
		String pattern25 = "\\$[0-9]{1,}\\.[0-9]{1,}";
		String s25 = "The price of vegetables is $100000000000.10007 and fruits is $4900000.20008";
		
		Pattern p3 = Pattern.compile(pattern25);
		
		Matcher m2 = p3.matcher(s25);
		
		while(m2.find()) {
			System.out.println(m2.group());
		}
		
		
		//Example 7
		//Number Ranges
		
		//0-99
		String pattern26 = "[0-9]{1,2}";
		String s26 = "20";
		System.out.println(s26.matches(pattern26));		
		
		//0-1000
		String pattern27 = "[0-9]{1,3}|1000";
		String s27 = "879";
		System.out.println(s27.matches(pattern27));
		
		//99-9999
		String pattern28 = "99|[1-9][0-9][0-9][0-9]?";
		String s28 = "9999";
		System.out.println(s28.matches(pattern28));
		
		//25-75
		String pattern29 = "2[5-9]|[3-6][0-9]|7[0-5]";
		String s29 = "70";
		System.out.println(s29.matches(pattern29));
		
		//220-240
		String pattern30 = "2[2-3][0-9]|240";
		String s30 = "235";
		System.out.println(s30.matches(pattern30));
		
		
	}
}
