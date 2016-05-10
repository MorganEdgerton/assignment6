package js.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "meetings")
@XmlAccessorType(XmlAccessType.FIELD)
public class Meetings {
	    
    private List<String> meetings = null;
    
    public List<String> getMeetingList() {
    	return meetings;
    }
    
    public void setMeetingList(List<String> meetings) {
    	this.meetings = meetings;
    }

}
