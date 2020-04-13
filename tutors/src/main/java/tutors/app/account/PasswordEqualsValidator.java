package tutors.app.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;


@Component
public class PasswordEqualsValidator implements Validator{
	@Autowired
	private Validator validator;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return AccountForm.class.isAssignableFrom(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.invokeValidator(validator,target,errors);
		AccountForm form = (AccountForm)target;
		String password = form.getPassword();
		String confirmPassword = form.getConfirmPassword();
		if(!password.equals(confirmPassword)) {
			errors.rejectValue("confirmPassword","PasswordEqualsValidator.accountForm.password",
					"確認パスワードが異なっています");
		}
		
	}
}
