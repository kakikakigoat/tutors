package tutors.app.account;

import java.io.Serializable;
import javax.validation.constraints.*;


public class AccountForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="ユーザー名を入力してください")
	@Size(min=1,max=12,message="ユーザー名の長さが不適切です")
	@Pattern(regexp="^[a-zA-Z0-9一-龥ぁ-んァ-ヶー#$@%&*._^(){}-]+$",message="不適切な文字が含まれています")
	private String userName;
	
	@NotEmpty(message="メールアドレスを入力してください")
	@Email(message="メールアドレスが不正です")
	private String mailAddress;
	
	@Size(min=8,max=12,message="パスワードは8~12文字の英数字で入力してください")
	@Pattern(regexp="^[a-zA-Z0-9]+$",message="パスワードは英数字で入力してください")
	private String password;
	private String confirmPassword;
	
	
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
}
