package com.ideas2it.user_service.api.advice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TimeTrackerAnnotation creating custom annotation.
 * 
 * @author Vigneshwaran N
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TimeTrackerAnnotation {

}
