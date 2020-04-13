package tutors.app.profile.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import tutors.app.profile.form.TeacherEditForm;

public class EndTimeMustBeAfterStartTimeValidator 
		implements ConstraintValidator<EndTimeMustBeAfterStartTime,TeacherEditForm>{
	
	private String message;
	
	@Override
	public void initialize(EndTimeMustBeAfterStartTime constraintAnnotation) {
		message=constraintAnnotation.message();
	}

	@Override
	public boolean isValid(TeacherEditForm value,ConstraintValidatorContext context) {
		if(value.getMondayTimeFrom() == null || value.getMondayTimeTo() == null) {
			return true;
		}
		boolean isEndTimeMustBeAfterStartTime = value.getMondayTimeTo()
				.isAfter(value.getMondayTimeFrom());
		if(!isEndTimeMustBeAfterStartTime) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(message)
					.addPropertyNode("mondayTimeTo").addConstraintViolation();
		
			
		}
		
		return isEndTimeMustBeAfterStartTime;
	}
	
}
