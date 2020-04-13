package tutors.app.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import tutors.domain.service.user.*;

import tutors.domain.model.*;


@Controller
@SessionAttributes(types = AccountForm.class)
public class AccountController {
	
	@Autowired
	UserService userService;
	@Autowired
	private PasswordEqualsValidator passwordEqualsValidator;
	//パスワード確認をオリジナルのバリデータに追加
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(passwordEqualsValidator);
	}
	
	@ModelAttribute
	public AccountForm setupForm() {
		return new AccountForm();
	}
	
	@GetMapping(value="signUp")
	String accountForm() {
		return "account/accountForm";
	}
	
	@PostMapping(value="signUp")
	String create(@Validated AccountForm form, 
			BindingResult bindingResult,
			Model model) {
		if(bindingResult.hasErrors()) {
			return "account/accountForm";
		}
		//同一のメールアドレスを検索
		User sameUser = userService.searchSameEmail(form.getMailAddress());
		//同じアドレスが存在した場合accountFormへリダイレクト
		if(sameUser != null) {
			model.addAttribute("sameEmail","このメールアドレスはすでに登録されています");
			return "account/accountForm";
		}
		return "redirect:/signUp/confirm";
	}	

	@GetMapping(value="signUp/confirm")
	String createFinish(AccountForm accountForm) {
		return "account/confirm";
	}
	
	@PostMapping(value="signUp/confirm")
	String confirm(@Validated AccountForm form,
			BindingResult bindingResult,
			SessionStatus status) {
		if(bindingResult.hasErrors()) {
			return "account/accountForm";
		}
		//ユーザーインスタンスに入力値を設定
		User user = new User();
		user.setProfileImage("default.jpg");
		user.setMailAddress(form.getMailAddress());
		user.setUserName(form.getUserName());
		userService.create(user,form.getPassword());
		//セッションを破棄
		status.setComplete();
		return "account/complete";
	}
	
	@GetMapping(value="signUp/complete")
	String complete() {
		return "account/complete";
	}
}
