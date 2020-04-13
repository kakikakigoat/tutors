package tutors.app.profile.form;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import tutors.app.profile.validation.EndTimeMustBeAfterStartTime;
import tutors.app.profile.validation.FridayEndTimeMustBeAfterStartTime;
import tutors.app.profile.validation.SaturdayEndTimeMustBeAfterStartTime;
import tutors.app.profile.validation.SundayEndTimeMustBeAfterStartTime;
import tutors.app.profile.validation.ThirtyMinutesUnit;
import tutors.app.profile.validation.ThursdayEndTimeMustBeAfterStartTime;
import tutors.app.profile.validation.TuesdayEndTimeMustBeAfterStartTime;
import tutors.app.profile.validation.WednesdayEndTimeMustBeAfterStartTime;
import tutors.domain.model.Subject;

@EndTimeMustBeAfterStartTime(message="終了時刻は開始時刻より前にしてください")
@TuesdayEndTimeMustBeAfterStartTime(message="終了時刻は開始時刻より前にしてください")
@WednesdayEndTimeMustBeAfterStartTime(message="終了時刻は開始時刻より前にしてください")
@ThursdayEndTimeMustBeAfterStartTime(message="終了時刻は開始時刻より前にしてください")
@FridayEndTimeMustBeAfterStartTime(message="終了時刻は開始時刻より前にしてください")
@SaturdayEndTimeMustBeAfterStartTime(message="終了時刻は開始時刻より前にしてください")
@SundayEndTimeMustBeAfterStartTime(message="終了時刻は開始時刻より前にしてください")
public class TeacherEditForm {
	//--------teacherテーブルへの保存-----------
	private int teacherUserId;
	private int maxWage;
	
	@Range(min = 1000, max = 10000, message = "100から10000までの数値を入力してください")
	private int minWage;
	@Size(max = 300, message = "指導方針は最大300字までです。")
	private String policy;
	
	//---------teacher_subjectテーブルへの保存---------
	//教科の出力
	private List<Subject> subList = new ArrayList<>();
	//教科の入力値を受け取る
	@Size(max=5,message="教科数の選択は5つまでです。")
	private int[] selectedSubjects;

	
	//-----------lessonMenuテーブルへの保存-------------
	private String dayOfTheWeek;
	//各曜日の時間を出力
	private List<LocalTime> timeList = new ArrayList<>();
	//各曜日の入力値を受け取る
	@ThirtyMinutesUnit(message="30分単位で入力してください")
	private LocalTime mondayTimeFrom;
	@ThirtyMinutesUnit(message="30分単位で入力してください")
	private LocalTime tuesdayTimeFrom;
	@ThirtyMinutesUnit(message="30分単位で入力してください")
	private LocalTime wednesdayTimeFrom;
	@ThirtyMinutesUnit(message="30分単位で入力してください")
	private LocalTime thursdayTimeFrom;
	@ThirtyMinutesUnit(message="30分単位で入力してください")
	private LocalTime fridayTimeFrom;
	@ThirtyMinutesUnit(message="30分単位で入力してください")
	private LocalTime saturdayTimeFrom;
	@ThirtyMinutesUnit(message="30分単位で入力してください")
	private LocalTime sundayTimeFrom;
	
	@ThirtyMinutesUnit(message="30分単位で入力してください")
	private LocalTime mondayTimeTo;
	@ThirtyMinutesUnit(message="30分単位で入力してください")
	private LocalTime tuesdayTimeTo;
	@ThirtyMinutesUnit(message="30分単位で入力してください")
	private LocalTime wednesdayTimeTo;
	@ThirtyMinutesUnit(message="30分単位で入力してください")
	private LocalTime thursdayTimeTo;
	@ThirtyMinutesUnit(message="30分単位で入力してください")
	private LocalTime fridayTimeTo;
	@ThirtyMinutesUnit(message="30分単位で入力してください")
	private LocalTime saturdayTimeTo;
	@ThirtyMinutesUnit(message="30分単位で入力してください")
	private LocalTime sundayTimeTo;
	
	
	
	
	public List<Subject> getSubList() {
		return subList;
	}

	public void setSubList(List<Subject> subList) {
		this.subList = subList;
	}
	
	public int[] getSelectedSubjects() {
		return selectedSubjects;
	}

	public void setSelectedSubjects(int[] selectedSubjects) {
		this.selectedSubjects = selectedSubjects;
	}

	public LocalTime getMondayTimeFrom() {
		return mondayTimeFrom;
	}

	public void setMondayTimeFrom(LocalTime mondayTimeFrom) {
		this.mondayTimeFrom = mondayTimeFrom;
	}

	public LocalTime getTuesdayTimeFrom() {
		return tuesdayTimeFrom;
	}

	public void setTuesdayTimeFrom(LocalTime tuesdayTimeFrom) {
		this.tuesdayTimeFrom = tuesdayTimeFrom;
	}

	public LocalTime getWednesdayTimeFrom() {
		return wednesdayTimeFrom;
	}

	public void setWednesdayTimeFrom(LocalTime wednesdayTimeFrom) {
		this.wednesdayTimeFrom = wednesdayTimeFrom;
	}

	public LocalTime getThursdayTimeFrom() {
		return thursdayTimeFrom;
	}

	public void setThursdayTimeFrom(LocalTime thursdayTimeFrom) {
		this.thursdayTimeFrom = thursdayTimeFrom;
	}

	public LocalTime getFridayTimeFrom() {
		return fridayTimeFrom;
	}

	public void setFridayTimeFrom(LocalTime fridayTimeFrom) {
		this.fridayTimeFrom = fridayTimeFrom;
	}

	public LocalTime getSaturdayTimeFrom() {
		return saturdayTimeFrom;
	}

	public void setSaturdayTimeFrom(LocalTime saturdayTimeFrom) {
		this.saturdayTimeFrom = saturdayTimeFrom;
	}

	public LocalTime getSundayTimeFrom() {
		return sundayTimeFrom;
	}

	public void setSundayTimeFrom(LocalTime sundayTimeFrom) {
		this.sundayTimeFrom = sundayTimeFrom;
	}

	public LocalTime getMondayTimeTo() {
		return mondayTimeTo;
	}

	public void setMondayTimeTo(LocalTime mondayTimeTo) {
		this.mondayTimeTo = mondayTimeTo;
	}

	public LocalTime getTuesdayTimeTo() {
		return tuesdayTimeTo;
	}

	public void setTuesdayTimeTo(LocalTime tuesdayTimeTo) {
		this.tuesdayTimeTo = tuesdayTimeTo;
	}

	public LocalTime getWednesdayTimeTo() {
		return wednesdayTimeTo;
	}

	public void setWednesdayTimeTo(LocalTime wednesdayTimeTo) {
		this.wednesdayTimeTo = wednesdayTimeTo;
	}

	public LocalTime getThursdayTimeTo() {
		return thursdayTimeTo;
	}

	public void setThursdayTimeTo(LocalTime thursdayTimeTo) {
		this.thursdayTimeTo = thursdayTimeTo;
	}

	public LocalTime getFridayTimeTo() {
		return fridayTimeTo;
	}

	public void setFridayTimeTo(LocalTime fridayTimeTo) {
		this.fridayTimeTo = fridayTimeTo;
	}

	public LocalTime getSaturdayTimeTo() {
		return saturdayTimeTo;
	}

	public void setSaturdayTimeTo(LocalTime saturdayTimeTo) {
		this.saturdayTimeTo = saturdayTimeTo;
	}

	public LocalTime getSundayTimeTo() {
		return sundayTimeTo;
	}

	public void setSundayTimeTo(LocalTime sundayTimeTo) {
		this.sundayTimeTo = sundayTimeTo;
	}

	public List<LocalTime> getTimeList() {
		return timeList;
	}

	public void setTimeList(List<LocalTime> timeList) {
		this.timeList = timeList;
	}

	public int getTeacherUserId() {
		return teacherUserId;
	}

	public void setTeacherUserId(int teacherUserId) {
		this.teacherUserId = teacherUserId;
	}

	public int getMaxWage() {
		return maxWage;
	}

	public void setMaxWage(int maxWage) {
		this.maxWage = maxWage;
	}

	public int getMinWage() {
		return minWage;
	}

	public void setMinWage(int minWage) {
		this.minWage = minWage;
	}

	public String getPolicy() {
		return policy;
	}

	public void setPolicy(String policy) {
		this.policy = policy;
	}

	public String getDayOfTheWeek() {
		return dayOfTheWeek;
	}

	public void setDayOfTheWeek(String dayOfTheWeek) {
		this.dayOfTheWeek = dayOfTheWeek;
	}

}


