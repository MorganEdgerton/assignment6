package js;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import js.domain.Year;
import js.domain.Years;
import js.services.EavesdropService;

@Path("/")
public class HelloWorldResource {
	
	EavesdropService eavesdropService;
	
	public HelloWorldResource() {
		this.eavesdropService = new EavesdropService();
	}
	
	@GET
	@Path("/helloworld")
	@Produces("text/html")
	public String helloWorld() {
		System.out.println("Inside helloworld");
		
		return "solum table";
	}
	
	@GET
	@Path("/")
	@Produces("application/xml")
	public StreamingOutput numMeetings() throws ServletException, IOException{
		final Map<String,Integer> table = new TreeMap<String, Integer>();
		String source = "http://eavesdrop.openstack.org/meetings/solum_team_meeting/";
		
		//for loop through amt of years
		ArrayList<String> allYears = EavesdropService.parseProjects(source);
		int numMeetings;
		for(String y: allYears){
			numMeetings = EavesdropService.meetingsPerYear(source, y);
			table.put(y.substring(0, y.length()-1), numMeetings);
		}
		System.out.println(table);
		
		//getNumMeetings(allMeetings);
		//call service to get all meetings per year
//		final Years years = new Years();
//		years.setYearList(allYears);
		
		//return counts in json format	    
	    return new StreamingOutput() {
	         public void write(OutputStream outputStream) throws IOException, WebApplicationException {
	        		 outputTable(outputStream, table);
	        		 System.out.println("it returned");
	         }
	      };		

	}
	
//	protected void outputYears(OutputStream os, Years years) throws IOException {
//		try { 
//			JAXBContext jaxbContext = JAXBContext.newInstance(Years.class);
//			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//	 
//			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//			jaxbMarshaller.marshal(years, os);
//		} catch (JAXBException jaxb) {
//			jaxb.printStackTrace();
//			throw new WebApplicationException();
//		}
//	}
	
	  protected void outputTable(OutputStream os, Map<String, Integer> table) throws IOException { //TODO: implement getId() and getProj() and uncomment
	      PrintStream writer = new PrintStream(os);
	      writer.println("<table>");
	      for(Map.Entry<String, Integer> entry : table.entrySet()){
	    	  writer.println("<count>");
	      	  writer.println("   <year>" + entry.getKey() + "</year>");
	      	  writer.println("   <numMeetings>" + entry.getValue() + "</numMeetings>");
	      	  writer.println("</count>");
	      }
	      writer.println("</table>");
	   }
	
	
	
}
