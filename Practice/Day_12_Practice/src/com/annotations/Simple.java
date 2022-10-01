package com.annotations;

import java.lang.annotation.Documented;

//documented means it becomes a part of the java documentation
@Documented 


//annotation (interface) type Simple
public @interface Simple {
	//annotation type elements --> date, name, place
	String name() default "Hammad";
	String date() default "03-08-2000";
	String place();
}
