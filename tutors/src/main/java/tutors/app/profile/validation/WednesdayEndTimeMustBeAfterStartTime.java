package tutors.app.profile.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Documented
@Constraint(validatedBy= {WednesdayEndTimeMustBeAfterStartTimeValidator.class})
@Target({TYPE,ANNOTATION_TYPE})
@Retention(RUNTIME)
public @interface WednesdayEndTimeMustBeAfterStartTime {
	String message() default "{tutors.app.profile.validation.WednesdayEndTimeMustBeAfterStartTime.message}";

	Class<?>[]groups() default{};

	Class<? extends Payload>[] payload() default{};

	@Target({METHOD,FIELD,ANNOTATION_TYPE,CONSTRUCTOR,PARAMETER})
	@Retention(RUNTIME)
	@Documented
	public @interface List{
		WednesdayEndTimeMustBeAfterStartTime[] value();
	}

}