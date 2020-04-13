package tutors.app.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	//index画面に遷移
	@RequestMapping("index")
	String showIndex(Model model) {
		return "login/index";
	}
	
	@RequestMapping("/login")
    String showLoginForm(Model model) {
        //ログイン画面
        return "login/loginForm";
    }
}
