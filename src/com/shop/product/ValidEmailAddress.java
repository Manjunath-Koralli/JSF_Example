package com.shop.product;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = EmailAddressValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)

public @interface ValidEmailAddress {
	
	String message() default "Please enter a valid e-mail address.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
