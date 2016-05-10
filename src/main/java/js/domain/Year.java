package js.domain;

import javax.xml.bind.annotation.XmlRootElement;

import js.domain.Meetings;

@XmlRootElement(name = "year")
public class Year {
	
	private String year;
	Meetings meetings;
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
    public void setMeetings(Meetings meetings){
    	this.meetings = meetings;   	
    }
	
	
}