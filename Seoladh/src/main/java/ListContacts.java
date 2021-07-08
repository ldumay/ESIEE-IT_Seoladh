import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "Listcontacts")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListContacts {
	List<contact> Listcontacts = null;

	public List<contact> getListcontacts() {
		return Listcontacts;
	}

	public void setListcontacts(List<contact> listcontacts) {
		Listcontacts = listcontacts;
	}

}
