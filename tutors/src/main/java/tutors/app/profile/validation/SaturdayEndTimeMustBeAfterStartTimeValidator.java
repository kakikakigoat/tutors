package tutors.app.profile.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import tutors.app.profile.form.TeacherEditForm;

public class SaturdayEndTimeMustBeAfterStartTimeValidator 
implements ConstraintValidator<SaturdayEndTimeMustBeAfterStartTime,TeacherEditForm>{
	
	private String message;
	
	@Override
	public void initialize(SaturdayEndTimeMustBeAfterStartTime constraintAnnotation) {
		message=constraintAnnotation.message();
	}

	@Override
	public boolean isValid(TeacherEditForm value,ConstraintValidatorContext context) {
		if(value.getSaturdayTimeFrom() == null || value.getSaturdayTimeTo() == null) {
			return true;
		}
		boolean isEndTimeMustBeAfterStartTime = value.getSaturdayTimeTo()
				.isAfter(value.getSaturdayTimeFrom());
		if(!isEndTimeMustBeAfterStartTime) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(message)
					.addPropertyNode("saturdayTimeTo").addConstraintViolation();
		
			
		}
		
		return isEndTimeMustBeAfterStartTime;
	}

}