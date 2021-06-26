import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class CreateListContacts {

	private JFrame frmSeoladh;
	private JTextField TxbNameFile;
	private JTextField TxbNewElement;
	private int CountWindow = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateListContacts window = new CreateListContacts();
					window.frmSeoladh.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreateListContacts() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSeoladh = new JFrame();
		frmSeoladh.setTitle("Seoladh");
		frmSeoladh.setBounds(100, 100, 1825, 873);
		frmSeoladh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JTextArea textAreaNom = new JTextArea();
		textAreaNom.setWrapStyleWord(true);
		textAreaNom.setLineWrap(true);
		
		final JTextArea textAreaEmail = new JTextArea();
		textAreaEmail.setWrapStyleWord(true);
		textAreaEmail.setLineWrap(true);
		
		final JTextArea textAreaPrenom = new JTextArea();
		textAreaPrenom.setWrapStyleWord(true);
		textAreaPrenom.setLineWrap(true);
		
		final JTextArea textAreaBirthday = new JTextArea();
		textAreaBirthday.setWrapStyleWord(true);
		textAreaBirthday.setLineWrap(true);
		
		JLabel lblNewLabel = new JLabel("Listes Nom");
		
		JLabel lblNewLabel_1 = new JLabel("Listes Pr\u00E9nom");
		
		JLabel lblNewLabel_2 = new JLabel("Listes Email");
		
		JLabel lblNewLabel_3 = new JLabel("Listes Date de naissance");
		
		final JLabel lblTitreAutre = new JLabel("New label");
		
		JLabel lblNewLabel_4 = new JLabel("Nom du fichier");
		
		TxbNameFile = new JTextField();
		TxbNameFile.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Nom nouveaux \u00E9l\u00E9ment");
		
		TxbNewElement = new JTextField();
		TxbNewElement.setColumns(10);
		
		final JLabel lblMessage = new JLabel("New label");
		lblMessage.setFont(new Font("Arial", Font.BOLD, 16));
		
		JButton btnNewElem = new JButton("Nouveau \u00E9l\u00E9ment");
		final JLabel lblTitreAutre2 = new JLabel("New label");

		final JTextArea textAreaAutre2 = new JTextArea();
		textAreaAutre2.setText("void");
		
		final JTextArea textAreaAutre3 = new JTextArea();
		textAreaAutre3.setText("void");
		
		final JLabel lblTitreAutre3 = new JLabel("New label");
		
		final JTextArea textAreaAutre4 = new JTextArea();
		textAreaAutre4.setText("void");
		
		final JLabel lblTitreAutre4 = new JLabel("New label");
		
		final JTextArea textAreaAutre5 = new JTextArea();
		textAreaAutre5.setText("void");
		
		final JLabel lblTitreAutre5 = new JLabel("New label");
		
		final JLabel lblTitreAutre6 = new JLabel("New label");
		
		final JTextArea textAreaAutre6 = new JTextArea();
		textAreaAutre6.setText("void");
		
		final JTextArea textAreaAutre8 = new JTextArea();
		textAreaAutre8.setText("void");
		
		final JLabel lblTitreAutre8 = new JLabel("New label");
		
		final JLabel lblTitreAutre7 = new JLabel("New label");
		
		final JTextArea textAreaAutre7 = new JTextArea();
		textAreaAutre7.setText("void");
		
		lblTitreAutre.setVisible(false);
		lblTitreAutre2.setVisible(false);
		lblTitreAutre3.setVisible(false);
		lblTitreAutre4.setVisible(false);
		lblTitreAutre5.setVisible(false);
		lblTitreAutre6.setVisible(false);
		lblTitreAutre7.setVisible(false);
		lblTitreAutre8.setVisible(false);
		lblMessage.setVisible(false);
		final JTextArea textAreaAutre = new JTextArea();
		textAreaAutre.setText("void");
		textAreaAutre.setWrapStyleWord(true);
		textAreaAutre.setLineWrap(true);
		textAreaAutre.setVisible(false);
		textAreaAutre2.setVisible(false);
		textAreaAutre3.setVisible(false);
		textAreaAutre4.setVisible(false);
		textAreaAutre5.setVisible(false);
		textAreaAutre6.setVisible(false);
		textAreaAutre7.setVisible(false);
		textAreaAutre8.setVisible(false);
		
		JButton btnCreate = new JButton("Cr\u00E9e Liste");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMessage.setVisible(false);
				if(TxbNameFile.getText() == "") {
					TxbNameFile.setText("contact");
				}
					
				String regex = ";";
				String Newligne="\n";
				String[] temp,nom ,prenom ,email,birthday,DetailAutre,DetailAutre2,DetailAutre3,DetailAutre4,DetailAutre5,DetailAutre6,DetailAutre7,DetailAutre8;
				String Titreautre,Titreautre2,Titreautre3,Titreautre4,Titreautre5,Titreautre6,Titreautre7,Titreautre8;
				nom = textAreaNom.getText().split(regex);
				temp = textAreaNom.getText().split(Newligne);
				if (nom.length<temp.length) {
					nom = temp;	
				}

				prenom = textAreaPrenom.getText().split(regex);
				temp = textAreaPrenom.getText().split(Newligne);
				if (prenom.length<temp.length) {
					prenom = temp;	
				}
				email = textAreaEmail.getText().split(regex);
				temp = textAreaEmail.getText().split(Newligne);
				if (email.length<temp.length) {
					email = temp;	
				}
				birthday = textAreaBirthday.getText().split(regex);
				temp = textAreaBirthday.getText().split(Newligne);
				if (birthday.length<temp.length) {
					birthday = temp;	
				}
				DetailAutre = textAreaAutre.getText().split(regex);
				temp = textAreaAutre.getText().split(Newligne);
				if (DetailAutre.length<temp.length) {
					DetailAutre = temp;	
				}
				DetailAutre2 = textAreaAutre2.getText().split(regex);
				temp = textAreaAutre2.getText().split(Newligne);
				if (DetailAutre2.length<temp.length) {
					DetailAutre2 = temp;	
				}
				DetailAutre3 = textAreaAutre3.getText().split(regex);
				temp = textAreaAutre3.getText().split(Newligne);
				if (DetailAutre3.length<temp.length) {
					DetailAutre3 = temp;	
				}
				DetailAutre4 = textAreaAutre4.getText().split(regex);
				temp = textAreaAutre4.getText().split(Newligne);
				if (DetailAutre4.length<temp.length) {
					DetailAutre4 = temp;	
				}
				DetailAutre5 = textAreaAutre5.getText().split(regex);
				temp = textAreaAutre5.getText().split(Newligne);
				if (DetailAutre5.length<temp.length) {
					DetailAutre5 = temp;	
				}
				DetailAutre6 = textAreaAutre6.getText().split(regex);
				temp = textAreaAutre6.getText().split(Newligne);
				if (DetailAutre6.length<temp.length) {
					DetailAutre6 = temp;	
				}
				DetailAutre7 = textAreaAutre7.getText().split(regex);
				temp = textAreaAutre7.getText().split(Newligne);
				if (DetailAutre7.length<temp.length) {
					DetailAutre7 = temp;	
				}
				DetailAutre8 = textAreaAutre8.getText().split(regex);
				temp = textAreaAutre8.getText().split(Newligne);
				if (DetailAutre8.length<temp.length) {
					DetailAutre8 = temp;	
				}				
				Titreautre = lblTitreAutre.getText();
				Titreautre2 = lblTitreAutre2.getText();
				Titreautre3 = lblTitreAutre3.getText();
				Titreautre4 = lblTitreAutre4.getText();
				Titreautre5 = lblTitreAutre5.getText();
				Titreautre6 = lblTitreAutre6.getText();
				Titreautre7 = lblTitreAutre7.getText();
				Titreautre8 = lblTitreAutre8.getText();
				ListContacts contacts = new ListContacts();
				contacts.setListcontacts(new ArrayList<contact>());
				BreakInfinit:
				if(!email[0].equals("")) {
					if(nom[0].equals("")) {
						nom = null;
					    lblMessage.setVisible(true);
					    lblMessage.setText("Erreur votre liste de nom est vide");
					    break BreakInfinit;
					}
					if(prenom[0].equals("")) {
						prenom = null;
					    lblMessage.setVisible(true);
					    lblMessage.setText("Erreur votre liste de prénom est vide");
					    break BreakInfinit;
					}
					if(birthday[0].equals("")) {
						birthday = null;
					    lblMessage.setVisible(true);
					    lblMessage.setText("Erreur votre liste de date de naissance est vide");
					    break BreakInfinit;
					}
					if(DetailAutre[0].equals("")) {
						DetailAutre = null;
					    lblMessage.setVisible(true);
					    lblMessage.setText("Erreur votre liste de "+ lblTitreAutre.getText().replace("Listes ", "") +" est vide");
					    break BreakInfinit;
					}
					if(DetailAutre2[0].equals("")) {
						DetailAutre2 = null;
					    lblMessage.setVisible(true);
					    lblMessage.setText("Erreur votre liste de "+ lblTitreAutre2.getText().replace("Listes ", "") +" est vide");
					    break BreakInfinit;
					}
					if(DetailAutre3[0].equals("")) {
						DetailAutre3 = null;
					    lblMessage.setVisible(true);
					    lblMessage.setText("Erreur votre liste de "+ lblTitreAutre3.getText().replace("Listes ", "") +" est vide");
					    break BreakInfinit;
					}
					if(DetailAutre4[0].equals("")) {
						DetailAutre4 = null;
					    lblMessage.setVisible(true);
					    lblMessage.setText("Erreur votre liste de "+ lblTitreAutre4.getText().replace("Listes ", "") +" est vide");
					    break BreakInfinit;
					}
					if(DetailAutre5[0].equals("")) {
						DetailAutre5 = null;
					    lblMessage.setVisible(true);
					    lblMessage.setText("Erreur votre liste de "+ lblTitreAutre5.getText().replace("Listes ", "") +" est vide");
					    break BreakInfinit;
					}
					if(DetailAutre6[0].equals("")) {
						DetailAutre6 = null;
					    lblMessage.setVisible(true);
					    lblMessage.setText("Erreur votre liste de "+ lblTitreAutre6.getText().replace("Listes ", "") +" est vide");
					    break BreakInfinit;
					}
					if(DetailAutre7[0].equals("")) {
						DetailAutre7 = null;
					    lblMessage.setVisible(true);
					    lblMessage.setText("Erreur votre liste de "+ lblTitreAutre7.getText().replace("Listes ", "") +" est vide");
					    break BreakInfinit;
					}
					if(DetailAutre8[0].equals("")) {
						DetailAutre8 = null;
					    lblMessage.setVisible(true);
					    lblMessage.setText("Erreur votre liste de "+ lblTitreAutre8.getText().replace("Listes ", "") +" est vide");
					    break BreakInfinit;
					}
					if(nom.length > email.length) {
					    lblMessage.setVisible(true);
					    lblMessage.setText("Erreur Il a plus de Nom que d'email");
					    break BreakInfinit;
					}
					if(prenom.length > email.length) {
					    lblMessage.setVisible(true);
					    lblMessage.setText("Erreur Il a plus de Prénom que d'email");
					    break BreakInfinit;
					}
					if(birthday.length > email.length) {
					    lblMessage.setVisible(true);
					    lblMessage.setText("Erreur Il a plus de Date de naissance que d'email");
					    break BreakInfinit;
					}
					if(DetailAutre.length > email.length) {
					    lblMessage.setVisible(true);
					    lblMessage.setText("Erreur Il a plus de "+ lblTitreAutre.getText().replace("Listes ", "") +" que d'email");
					    break BreakInfinit;
					}
					if(DetailAutre2.length > email.length) {
					    lblMessage.setVisible(true);
					    lblMessage.setText("Erreur Il a plus de "+ lblTitreAutre2.getText().replace("Listes ", "") +" que d'email");
					    break BreakInfinit;
					}
					if(DetailAutre3.length > email.length) {
					    lblMessage.setVisible(true);
					    lblMessage.setText("Erreur Il a plus de "+ lblTitreAutre3.getText().replace("Listes ", "") +" que d'email");
					    break BreakInfinit;
					}
					if(DetailAutre4.length > email.length) {
					    lblMessage.setVisible(true);
					    lblMessage.setText("Erreur Il a plus de "+ lblTitreAutre4.getText().replace("Listes ", "") +" que d'email");
					    break BreakInfinit;
					}
					if(DetailAutre5.length > email.length) {
					    lblMessage.setVisible(true);
					    lblMessage.setText("Erreur Il a plus de "+ lblTitreAutre5.getText().replace("Listes ", "") +" que d'email");
					    break BreakInfinit;
					}
					if(DetailAutre6.length > email.length) {
					    lblMessage.setVisible(true);
					    lblMessage.setText("Erreur Il a plus de "+ lblTitreAutre6.getText().replace("Listes ", "") +" que d'email");
					    break BreakInfinit;
					}
					if(DetailAutre7.length > email.length) {
					    lblMessage.setVisible(true);
					    lblMessage.setText("Erreur Il a plus de "+ lblTitreAutre7.getText().replace("Listes ", "") +" que d'email");
					    break BreakInfinit;
					}
					if(DetailAutre8.length > email.length) {
					    lblMessage.setVisible(true);
					    lblMessage.setText("Erreur Il a plus de "+ lblTitreAutre8.getText().replace("Listes ", "") +" que d'email");
					    break BreakInfinit;
					}
				for(int i = 0; i< email.length;i++) {
					contact c = new contact();
					c.setId(i);
					try {
						c.setNom(nom[i]);
					} catch (Exception e2) {
					    lblMessage.setVisible(true);
					    lblMessage.setText("Erreur Il a moins de Nom que d'email");
					    break BreakInfinit;
					}
					try {
						c.setPrenom(prenom[i]);
					} catch (Exception e2) {
					    lblMessage.setVisible(true);
					    lblMessage.setText("Erreur Il a moins de Prénom que d'email");
					    break BreakInfinit;
					}
					try {
						c.setEmail(email[i]);
					} catch (Exception e2) {
					    lblMessage.setVisible(true);
					    lblMessage.setText("Erreur veuillez verifier la liste Email");
					    break BreakInfinit;
					}
					try {
						c.setBirthday(birthday[i]);
					} catch (Exception e2) {
					    lblMessage.setVisible(true);
					    lblMessage.setText("Erreur Il a moins de Date de naissance que d'email");
					    break BreakInfinit;
					}
					//contact c = new contact(i+1,nom[i],prenom[i],email[i],birthday[i]);
					if (!"void".equals(textAreaAutre.getText())) {
						try {
							c.setDetailautre(DetailAutre[i]);
						} catch (Exception e2) {
						    lblMessage.setVisible(true);
						    lblMessage.setText("Erreur Il a moins de "+lblTitreAutre.getText().replace("Listes ", "")+" que d'email");
						    break BreakInfinit;
						}
					}
					else {
						c.setDetailautre(null);
					}
					if (!"New label".equals(lblTitreAutre.getText())) {
						c.setTitreautre(Titreautre.replace("Listes ", ""));
					}
					else {
						c.setTitreautre(null);
					}	
					
					if (!"void".equals(textAreaAutre2.getText())) {
						try {
							c.setDetailautre2(DetailAutre2[i]);
						} catch (Exception e2) {
						    lblMessage.setVisible(true);
						    lblMessage.setText("Erreur Il a moins de "+lblTitreAutre2.getText().replace("Listes ", "")+" que d'email");
						    break BreakInfinit;
						}
						
					}
					else {
						c.setDetailautre2(null);
					}
					if (!"New label".equals(lblTitreAutre2.getText())) {
						c.setTitreautre2(Titreautre2.replace("Listes ", ""));
					}
					else {
						c.setTitreautre2(null);
					}	
					if (!"void".equals(textAreaAutre3.getText())) {
						try {
							c.setDetailautre3(DetailAutre3[i]);
						} catch (Exception e2) {
						    lblMessage.setVisible(true);
						    lblMessage.setText("Erreur Il a moins de "+lblTitreAutre3.getText().replace("Listes ", "")+" que d'email");
						    break BreakInfinit;
						}
						
					}
					else {
						c.setDetailautre3(null);
					}
					if (!"New label".equals(lblTitreAutre3.getText())) {
						c.setTitreautre3(Titreautre3.replace("Listes ", ""));
					}
					else {
						c.setTitreautre3(null);
					}	
					if (!"void".equals(textAreaAutre4.getText())) {
						try {
							c.setDetailautre4(DetailAutre4[i]);
						} catch (Exception e2) {
						    lblMessage.setVisible(true);
						    lblMessage.setText("Erreur Il a moins de "+lblTitreAutre4.getText().replace("Listes ", "")+" que d'email");
						    break BreakInfinit;
						}
						
					}
					else {
						c.setDetailautre4(null);
					}
					if (!"New label".equals(lblTitreAutre4.getText())) {
						c.setTitreautre4(Titreautre4.replace("Listes ", ""));
					}
					else {
						c.setTitreautre4(null);
					}	
					if (!"void".equals(textAreaAutre5.getText())) {
						try {
							c.setDetailautre5(DetailAutre5[i]);
						} catch (Exception e2) {
						    lblMessage.setVisible(true);
						    lblMessage.setText("Erreur Il a moins de "+lblTitreAutre5.getText().replace("Listes ", "")+" que d'email");
						    break BreakInfinit;
						}
						
					}
					else {
						c.setDetailautre5(null);
					}
					if (!"New label".equals(lblTitreAutre5.getText())) {
						c.setTitreautre5(Titreautre5.replace("Listes ", ""));
					}
					else {
						c.setTitreautre5(null);
					}	
					if (!"void".equals(textAreaAutre6.getText())) {
						try {
							c.setDetailautre6(DetailAutre6[i]);
						} catch (Exception e2) {
						    lblMessage.setVisible(true);
						    lblMessage.setText("Erreur Il a moins de "+lblTitreAutre6.getText().replace("Listes ", "")+" que d'email");
						    break BreakInfinit;
						}
						
					}
					else {
						c.setDetailautre6(null);
					}
					if (!"New label".equals(lblTitreAutre6.getText())) {
						c.setTitreautre6(Titreautre6.replace("Listes ", ""));
					}
					else {
						c.setTitreautre6(null);
					}	
					if (!"void".equals(textAreaAutre7.getText())) {
						try {
							c.setDetailautre7(DetailAutre7[i]);
						} catch (Exception e2) {
						    lblMessage.setVisible(true);
						    lblMessage.setText("Erreur Il a moins de "+lblTitreAutre7.getText().replace("Listes ", "")+" que d'email");
						    break BreakInfinit;
						}
						
					}
					else {
						c.setDetailautre7(null);
					}
					if (!"New label".equals(lblTitreAutre7.getText())) {
						c.setTitreautre7(Titreautre7.replace("Listes ", ""));
					}
					else {
						c.setTitreautre7(null);
					}	
					if (!"void".equals(textAreaAutre8.getText())) {
						try {
							c.setDetailautre8(DetailAutre8[i]);
						} catch (Exception e2) {
						    lblMessage.setVisible(true);
						    lblMessage.setText("Erreur Il a moins de "+lblTitreAutre8.getText().replace("Listes ", "")+" que d'email");
						    break BreakInfinit;
						}
						
					}
					else {
						c.setDetailautre8(null);
					}
					if (!"New label".equals(lblTitreAutre8.getText())) {
						c.setTitreautre8(Titreautre8.replace("Listes ", ""));
					}
					else {
						c.setTitreautre8(null);
					}	
					contacts.getListcontacts().add(c);
					}
					JAXBContext context;
					try {
							context = JAXBContext.newInstance(ListContacts.class);
					       Marshaller m = context.createMarshaller();
					       m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
					       m.marshal(contacts,new File("ListesContact\\"+TxbNameFile.getText()+".xml"));
					       textAreaNom.setText("");
					       textAreaPrenom.setText("");
					       textAreaEmail.setText("");
					       textAreaBirthday.setText("");
					       if(!"void".equals(textAreaAutre.getText())){
					    	   textAreaAutre.setText("");
					       }
					       if(!"void".equals(textAreaAutre2.getText())){
					    	   textAreaAutre2.setText("");
					       }
					       if(!"void".equals(textAreaAutre3.getText())){
					    	   textAreaAutre3.setText("");
					       }
					       if(!"void".equals(textAreaAutre4.getText())){
					    	   textAreaAutre4.setText("");
					       }
					       if(!"void".equals(textAreaAutre5.getText())){
					    	   textAreaAutre5.setText("");
					       }
					       if(!"void".equals(textAreaAutre6.getText())){
					    	   textAreaAutre6.setText("");
					       }
					       if(!"void".equals(textAreaAutre7.getText())){
					    	   textAreaAutre7.setText("");
					       }
					       if(!"void".equals(textAreaAutre8.getText())){
					    	   textAreaAutre8.setText("");
					       }
					       TxbNameFile.setText("");
					       lblMessage.setVisible(true);
					       lblMessage.setText("Votre Liste de contact a bien été crée");
					       
					} catch (JAXBException e1) {
					    lblMessage.setVisible(true);
					    lblMessage.setText("Erreur veuillez verifier les champs");
						e1.printStackTrace();

					}
				}
				else {
				    lblMessage.setVisible(true);
				    lblMessage.setText("Erreur la liste Email contient aucun email");
				}
				
			}
		});

		btnNewElem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!TxbNewElement.getText().equals("")) {
					
				switch (CountWindow) {
				case 1:
					lblTitreAutre.setVisible(true);
					lblTitreAutre.setText("Listes "+TxbNewElement.getText());
					textAreaAutre.setText("");
					textAreaAutre.setVisible(true);
					break;
				case 2:
					lblTitreAutre2.setVisible(true);
					lblTitreAutre2.setText("Listes "+TxbNewElement.getText());
					textAreaAutre2.setText("");
					textAreaAutre2.setVisible(true);
					break;
				case 3:
					lblTitreAutre3.setVisible(true);
					lblTitreAutre3.setText("Listes "+TxbNewElement.getText());
					textAreaAutre3.setText("");
					textAreaAutre3.setVisible(true);
					break;
				case 4:
					lblTitreAutre4.setVisible(true);
					lblTitreAutre4.setText("Listes "+TxbNewElement.getText());
					textAreaAutre4.setText("");
					textAreaAutre4.setVisible(true);
					break;
				case 5:
					lblTitreAutre5.setVisible(true);
					lblTitreAutre5.setText("Listes "+TxbNewElement.getText());
					textAreaAutre5.setText("");
					textAreaAutre5.setVisible(true);
					break;
				case 6:
					lblTitreAutre6.setVisible(true);
					lblTitreAutre6.setText("Listes "+TxbNewElement.getText());
					textAreaAutre6.setText("");
					textAreaAutre6.setVisible(true);
					break;
				case 7:
					lblTitreAutre7.setVisible(true);
					lblTitreAutre7.setText("Listes "+TxbNewElement.getText());
					textAreaAutre7.setText("");
					textAreaAutre7.setVisible(true);
					break;
				case 8:
					lblTitreAutre8.setVisible(true);
					lblTitreAutre8.setText("Listes "+TxbNewElement.getText());
					textAreaAutre8.setText("");
					textAreaAutre8.setVisible(true);
					break;
				default:
					CountWindow = 8;
					break;
				}
				TxbNewElement.setText("");
				CountWindow = CountWindow + 1;
				}
			}
		});
		
		JButton btnDeleteElem = new JButton("Supprimer \u00E9l\u00E9ment");
		btnDeleteElem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CountWindow = CountWindow - 1;
				switch (CountWindow) {
				case 1:
					lblTitreAutre.setVisible(false);
					lblTitreAutre.setText("New label");
					textAreaAutre.setText("void");
					textAreaAutre.setVisible(false);
					break;
				case 2:
					lblTitreAutre2.setVisible(false);
					lblTitreAutre2.setText("New label");
					textAreaAutre2.setText("void");
					textAreaAutre2.setVisible(false);
					break;
				case 3:
					lblTitreAutre3.setVisible(false);
					lblTitreAutre3.setText("New label");
					textAreaAutre3.setText("void");
					textAreaAutre3.setVisible(false);
					break;
				case 4:
					lblTitreAutre4.setVisible(false);
					lblTitreAutre4.setText("New label");
					textAreaAutre4.setText("void");
					textAreaAutre4.setVisible(false);
					break;
				case 5:
					lblTitreAutre5.setVisible(false);
					lblTitreAutre5.setText("New label");
					textAreaAutre5.setText("void");
					textAreaAutre5.setVisible(false);
					break;
				case 6:
					lblTitreAutre6.setVisible(false);
					lblTitreAutre6.setText("New label");
					textAreaAutre6.setText("void");
					textAreaAutre6.setVisible(false);
					break;
				case 7:
					lblTitreAutre7.setVisible(false);
					lblTitreAutre7.setText("New label");
					textAreaAutre7.setText("void");
					textAreaAutre7.setVisible(false);
					break;
				case 8:
					lblTitreAutre8.setVisible(false);
					lblTitreAutre8.setText("New label");
					textAreaAutre8.setText("void");
					textAreaAutre8.setVisible(false);
					break;
				default:
					CountWindow = 1;
					break;
				}
				
				
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel("Attention les valeurs doivent \u00EAtre s\u00E9p\u00E9r\u00E9s d'un ; ou d'un retour a la ligne");
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setFont(new Font("Arial Black", Font.BOLD, 16));
		

		
		
		GroupLayout groupLayout = new GroupLayout(frmSeoladh.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(416)
									.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(TxbNameFile, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnCreate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(4)
									.addComponent(TxbNewElement, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnNewElem)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(25)
									.addComponent(lblMessage, GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnDeleteElem)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(40)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_2))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textAreaNom, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
								.addComponent(textAreaEmail, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
							.addGap(33)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_1))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(4)
									.addComponent(textAreaPrenom, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textAreaBirthday, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)))
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTitreAutre)
								.addComponent(lblTitreAutre2))
							.addGap(65)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textAreaAutre2)
								.addComponent(textAreaAutre, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblTitreAutre3)
									.addGap(65)
									.addComponent(textAreaAutre3, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblTitreAutre4)
									.addGap(65)
									.addComponent(textAreaAutre4, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblTitreAutre5)
									.addGap(65)
									.addComponent(textAreaAutre5, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblTitreAutre6)
									.addGap(65)
									.addComponent(textAreaAutre6, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblTitreAutre7)
									.addGap(65)
									.addComponent(textAreaAutre7, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblTitreAutre8)
									.addGap(65)
									.addComponent(textAreaAutre8, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_6)))
					.addContainerGap(68, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addComponent(lblNewLabel_6)
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblNewLabel)
									.addComponent(textAreaPrenom, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblTitreAutre)
									.addComponent(textAreaAutre, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
									.addComponent(textAreaNom, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_1))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(5)
									.addComponent(lblTitreAutre3))
								.addComponent(textAreaAutre3, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))
							.addGap(61)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(5)
									.addComponent(lblTitreAutre4))
								.addComponent(textAreaAutre4, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblNewLabel_2)
									.addComponent(lblTitreAutre2)
									.addComponent(textAreaAutre2, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
									.addComponent(textAreaEmail, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_3)
									.addComponent(textAreaBirthday, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(5)
									.addComponent(lblTitreAutre5))
								.addComponent(textAreaAutre5, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))
							.addGap(61)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(5)
									.addComponent(lblTitreAutre6))
								.addComponent(textAreaAutre6, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(5)
									.addComponent(lblTitreAutre7))
								.addComponent(textAreaAutre7, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))
							.addGap(61)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(5)
									.addComponent(lblTitreAutre8))
								.addComponent(textAreaAutre8, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))))
					.addGap(67)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_4)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(TxbNameFile, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnCreate)
							.addComponent(lblMessage, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(TxbNewElement, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewElem)
						.addComponent(btnDeleteElem))
					.addGap(39))
		);
		frmSeoladh.getContentPane().setLayout(groupLayout);
	}
}
