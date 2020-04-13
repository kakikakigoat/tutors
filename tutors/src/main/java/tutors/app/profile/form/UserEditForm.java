package tutors.app.profile.form;

import java.io.Serializable;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import tutors.domain.model.Region;

public class UserEditForm implements Serializable{
	private static final long serialVersionUID = 1L;

	@NotEmpty(message="ユーザー名を入力してください")
	@Size(min=1,max=12,message="ユーザー名の長さが不適切です")
	@Pattern(regexp="[^ 　]+",message="空白は入力できません")
	private String userName;
	
	@Range(min=0 , max= 100,message="0から100までの数値を入力してください" )
	private Integer age;
	
	private String gender;
	
	@Size(max=300,message="自己紹介は300字が最大です")
	private String selfIntroduction;
	private Region region;
	
	private String profileImage;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSelfIntroduction() {
		return selfIntroduction;
	}
	public void setSelfIntroduction(String selfIntroduction) {
		this.selfIntroduction = selfIntroduction;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	
}
