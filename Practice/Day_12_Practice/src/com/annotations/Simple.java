package com.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;

//documented means it becomes a part of the java documentation
@Documented 


//annotation (interface) type Simple

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Simple_Result.class)
public @interface Simple {
	//annotation type elements --> date, name, place
	String name() default "Hammad";
	String date() default "03-08-2000";
	String place();
}


