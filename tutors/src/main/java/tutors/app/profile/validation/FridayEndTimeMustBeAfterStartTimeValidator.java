package tutors.app.profile.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import tutors.app.profile.form.TeacherEditForm;

public class FridayEndTimeMustBeAfterStartTimeValidator 
implements ConstraintValidator<FridayEndTimeMustBeAfterStartTime,TeacherEditForm>{

	private String message;

	@Override
	public void initialize(FridayEndTimeMustBeAfterStartTime constraintAnnotation) {
		message=constraintAnnotation.message();
	}

	@Override
	public boolean isValid(TeacherEditForm value,ConstraintValidatorContext context) {
		if(value.getFridayTimeFrom() == null || value.getFridayTimeTo() == null) {
			return true;
		}
		boolean isEndTimeMustBeAfterStartTime = value.getFridayTimeTo()
				.isAfter(value.getFridayTimeFrom());
		if(!isEndTimeMustBeAfterStartTime) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(message)
			.addPropertyNode("fridayTimeTo").addConstraintViolation();


		}

		return isEndTimeMustBeAfterStartTime;
	}


}
