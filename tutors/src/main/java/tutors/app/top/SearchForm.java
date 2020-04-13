package tutors.app.top;

import tutors.domain.model.Region;
import tutors.domain.model.Subject;

public class SearchForm {
	private int page;
	private Subject subject;
	private Region region;
	
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	
}
