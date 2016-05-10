package js.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "meeting")
public class Meeting {
	
	private String name;
	private String date;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}