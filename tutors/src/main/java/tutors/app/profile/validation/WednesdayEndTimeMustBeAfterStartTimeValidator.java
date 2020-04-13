package tutors.app.profile.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import tutors.app.profile.form.TeacherEditForm;

public class WednesdayEndTimeMustBeAfterStartTimeValidator
implements ConstraintValidator<WednesdayEndTimeMustBeAfterStartTime,TeacherEditForm>{
	
	private String message;
	
	@Override
	public void initialize(WednesdayEndTimeMustBeAfterStartTime constraintAnnotation) {
		message=constraintAnnotation.message();
	}

	@Override
	public boolean isValid(TeacherEditForm value,ConstraintValidatorContext context) {
		if(value.getWednesdayTimeFrom() == null || value.getWednesdayTimeTo() == null) {
			return true;
		}
		boolean isEndTimeMustBeAfterStartTime = value.getWednesdayTimeTo()
				.isAfter(value.getWednesdayTimeFrom());
		if(!isEndTimeMustBeAfterStartTime) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(message)
					.addPropertyNode("wednesdayTimeTo").addConstraintViolation();
		
			
		}
		
		return isEndTimeMustBeAfterStartTime;
	}

}