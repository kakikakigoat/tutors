package tutors.app.profile.form;

import java.io.Serializable;
import tutors.domain.model.User;

import javax.validation.constraints.Size;


public class StudentEditForm implements Serializable{
	private static final long serialVersionUID = 1L;

	
	private String ageClass;
	
	@Size(max=300,message="教師への要望は最大300字までです。")
	private String request;
	
	private User user;

	public String getAgeClass() {
		return ageClass;
	}
	public void setAgeClass(String ageClass) {
		this.ageClass = ageClass;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
