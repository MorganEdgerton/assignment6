package js.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "years")
@XmlAccessorType(XmlAccessType.FIELD)
public class Years {
	    
    private List<String> years = null; //previously 'year'
    
    public List<String> getYearList() {
    	return years;
    }
    
    public void setYearList(List<String> years) {
    	this.years = years;
    }

}
