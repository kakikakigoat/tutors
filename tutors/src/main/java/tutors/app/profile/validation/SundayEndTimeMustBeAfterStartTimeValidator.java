package tutors.app.profile.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import tutors.app.profile.form.TeacherEditForm;

public class SundayEndTimeMustBeAfterStartTimeValidator 
implements ConstraintValidator<SundayEndTimeMustBeAfterStartTime,TeacherEditForm>{
	
	private String message;
	
	@Override
	public void initialize(SundayEndTimeMustBeAfterStartTime constraintAnnotation) {
		message=constraintAnnotation.message();
	}

	@Override
	public boolean isValid(TeacherEditForm value,ConstraintValidatorContext context) {
		if(value.getSundayTimeFrom() == null || value.getSundayTimeTo() == null) {
			return true;
		}
		boolean isEndTimeMustBeAfterStartTime = value.getSundayTimeTo()
				.isAfter(value.getSundayTimeFrom());
		if(!isEndTimeMustBeAfterStartTime) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(message)
					.addPropertyNode("sundayTimeTo").addConstraintViolation();
		
			
		}
		
		return isEndTimeMustBeAfterStartTime;
	}

}
