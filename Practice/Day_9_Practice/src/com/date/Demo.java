package com.date;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Formatter;
import java.util.Locale;

public class Demo {
	public static void main(String[] args) {
		
		//Date Class in Java - Default Pattern is --> [uuuu - MM - dd] or [uuuu - MMM - dd]
		LocalDate d1 = LocalDate.of(2022,7,25);
		LocalDate d2 = LocalDate.now();
		LocalDate d3 = d2.plus(2, ChronoUnit.DAYS);
		LocalDate d4 = d1.minus(5, ChronoUnit.MONTHS);
		LocalDate d5 = LocalDate.of(2022,Month.FEBRUARY, 20);
		String s1 = "2021-11-11";
		LocalDate d6 = LocalDate.parse(s1);
		
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);
		System.out.println(d4);
		System.out.println(d5);
		System.out.println(d6);
		
		
		//Time class in Java
		LocalTime t1 = LocalTime.of(0, 53);
		LocalTime t2 = LocalTime.now();
		
		System.out.println(t1);
		System.out.println(t2);
		
		
		//Date-Time class in java
		LocalDateTime dt1 = LocalDateTime.now();
		LocalDateTime dt2 = LocalDateTime.of(2022, 8, 3, 12, 30, 55);
		LocalDateTime dt3 = LocalDateTime.of(d5, t2);
		
		
		System.out.println(dt1);
		System.out.println(dt2);
		System.out.println(dt3);
	
		
		//Period class for difference between two dates
		Period p1 = Period.between(d1,d2);
		Period p2 = Period.between(LocalDate.of(2022, 01, 01),LocalDate.now());
		Period p3 = Period.ofYears(2).plusDays(2).plusMonths(2);
		
		
		System.out.println(p1.getDays());		
		System.out.println("Months: " + p2.getMonths() + " and Days: " + p2.getDays());
		System.out.println(p3);
		System.out.println(p3.toTotalMonths());
		
		
		
		//Duration class for difference between time
		Duration du1 = Duration.between(LocalTime.of(3, 0), LocalTime.of(5, 2));
		du1 = du1.plusHours(2);
		
		System.out.println(du1);
		System.out.println(du1.toMinutes());
		//System.out.println(du1.toSeconds());
		
		
		
		//Date-Time-Formatter class for custom formatting
		String s2 = "30/07/2022";
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("[dd/MM/uuuu]");
		LocalDate d7 = LocalDate.parse(s2,dtf1);
		String s3 = "03-Aug-00";
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("[dd-MMM-uu]");
		LocalDate d8 = LocalDate.parse(s3, dtf2);
			
		LocalDate d9 = LocalDate.of(2022,9,20);
		DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("[dd MMM uuu]");
		//formats the date into string of the desired pattern
		String temp  = d9.format(dtf3);
		//converts string to date in the default format
		//i.e [uuuu-MM -dd]
		//here custom formatter is passed for reference
		LocalDate d10 = LocalDate.parse(temp, dtf3);
		
		System.out.println(d7);
		System.out.println(d8);
		System.out.println(temp);
		System.out.println(d10);
		
		//DayOfWeek is an enum representing the days of week
		//Locale class represents a specific geographical region
		DayOfWeek dayOfWeek = DayOfWeek.TUESDAY;	
		System.out.println(dayOfWeek.getValue());
		System.out.println(dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US));
		System.out.println(dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ITALIAN));
		
		//class models a single instantaneous point on the time-line
		//This might be used to record event time-stamps in the application
		Instant instant = Instant.now();
		System.out.println(instant);
		System.out.println(instant.getNano());
		
		
		
	}	
		
}
