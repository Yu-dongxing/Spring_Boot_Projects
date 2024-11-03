package com.yuxs.anno;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;
import java.lang.reflect.Field;

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
public @interface State {
    String message() default "State参数的值只能是已发布或者是草稿";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
