
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;


@XmlRootElement(name = "Contacts")
@XmlAccessorType(XmlAccessType.FIELD)
public class contact {
	@XmlAttribute()
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String Birthday;

	private String Titreautre;
	private String Detailautre;
	private String Titreautre2;
	private String Detailautre2;
	private String Titreautre3;
	private String Detailautre3;
	private String Titreautre4;
	private String Detailautre4;
	private String Titreautre5;
	private String Detailautre5;
	private String Titreautre6;
	private String Detailautre6;
	private String Titreautre7;
	private String Detailautre7;
	private String Titreautre8;
	private String Detailautre8;

	public contact() {
		
	}
	public contact(int id, String nom, String prenom, String email, String birthday) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		Birthday = birthday;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBirthday() {
		return Birthday;
	}
	public void setBirthday(String birthday) {
		Birthday = birthday;
	}
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitreautre() {
		return Titreautre;
	}
	public void setTitreautre(String titreautre) {
		Titreautre = titreautre;
	}
	public String getDetailautre() {
		return Detailautre;
	}
	public void setDetailautre(String detailautre) {
		Detailautre = detailautre;
	}
	public String getTitreautre2() {
		return Titreautre2;
	}
	public void setTitreautre2(String titreautre2) {
		Titreautre2 = titreautre2;
	}
	public String getDetailautre2() {
		return Detailautre2;
	}
	public void setDetailautre2(String detailautre2) {
		Detailautre2 = detailautre2;
	}
	public String getTitreautre3() {
		return Titreautre3;
	}
	public void setTitreautre3(String titreautre3) {
		Titreautre3 = titreautre3;
	}
	public String getDetailautre3() {
		return Detailautre3;
	}
	public void setDetailautre3(String detailautre3) {
		Detailautre3 = detailautre3;
	}
	public String getTitreautre4() {
		return Titreautre4;
	}
	public void setTitreautre4(String titreautre4) {
		Titreautre4 = titreautre4;
	}
	public String getDetailautre4() {
		return Detailautre4;
	}
	public void setDetailautre4(String detailautre4) {
		Detailautre4 = detailautre4;
	}
	public String getTitreautre5() {
		return Titreautre5;
	}
	public void setTitreautre5(String titreautre5) {
		Titreautre5 = titreautre5;
	}
	public String getDetailautre5() {
		return Detailautre5;
	}
	public void setDetailautre5(String detailautre5) {
		Detailautre5 = detailautre5;
	}
	public String getTitreautre6() {
		return Titreautre6;
	}
	public void setTitreautre6(String titreautre6) {
		Titreautre6 = titreautre6;
	}
	public String getDetailautre6() {
		return Detailautre6;
	}
	public void setDetailautre6(String detailautre6) {
		Detailautre6 = detailautre6;
	}
	public String getTitreautre7() {
		return Titreautre7;
	}
	public void setTitreautre7(String titreautre7) {
		Titreautre7 = titreautre7;
	}
	public String getDetailautre7() {
		return Detailautre7;
	}
	public void setDetailautre7(String detailautre7) {
		Detailautre7 = detailautre7;
	}
	public String getTitreautre8() {
		return Titreautre8;
	}
	public void setTitreautre8(String titreautre8) {
		Titreautre8 = titreautre8;
	}
	public String getDetailautre8() {
		return Detailautre8;
	}
	public void setDetailautre8(String detailautre8) {
		Detailautre8 = detailautre8;
	}
	@Override
	public String toString() {
		return "contact [nom=" + nom + ", prenom=" + prenom + ", email=" + email + "]";
	}
	

}
