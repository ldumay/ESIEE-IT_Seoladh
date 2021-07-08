import java.io.File;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
public class test {
	private JAXBContext context;
	public static void main(String[] args) {

		try {
		convertObjectToXML();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}
	 private static void convertObjectToXML() throws JAXBException, FileNotFoundException {
		 	ListContacts contacts = new ListContacts();
		 	contacts.setListcontacts(new ArrayList<contact>());
		 	contact c1 = new contact(1,1,"Paula","paul","test@gmail.com","000000");
		 	contact c2 = new contact(2,2,"test","test","merde@gmail.com","01050404");
		 	contacts.getListcontacts().add(c1);
		 	contacts.getListcontacts().add(c2);
	        JAXBContext context = JAXBContext.newInstance(ListContacts.class);
	        Marshaller m = context.createMarshaller();
	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	        m.marshal(contacts,new File("ListesContact\\caca.xml"));
	    }

}
