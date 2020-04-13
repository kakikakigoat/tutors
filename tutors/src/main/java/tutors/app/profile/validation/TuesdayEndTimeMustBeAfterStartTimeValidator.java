package tutors.app.profile.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import tutors.app.profile.form.TeacherEditForm;

public class TuesdayEndTimeMustBeAfterStartTimeValidator 
implements ConstraintValidator<TuesdayEndTimeMustBeAfterStartTime,TeacherEditForm>{
	
	private String message;
	
	@Override
	public void initialize(TuesdayEndTimeMustBeAfterStartTime constraintAnnotation) {
		message=constraintAnnotation.message();
	}

	@Override
	public boolean isValid(TeacherEditForm value,ConstraintValidatorContext context) {
		if(value.getTuesdayTimeFrom() == null || value.getTuesdayTimeTo() == null) {
			return true;
		}
		boolean isEndTimeMustBeAfterStartTime = value.getTuesdayTimeTo()
				.isAfter(value.getTuesdayTimeFrom());
		if(!isEndTimeMustBeAfterStartTime) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(message)
					.addPropertyNode("tuesdayTimeTo").addConstraintViolation();
		
			
		}
		
		return isEndTimeMustBeAfterStartTime;
	}

}
