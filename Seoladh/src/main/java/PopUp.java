import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.swing.JButton;
import java.awt.event.ActionEvent;

public class PopUp extends JFrame {

	private JFrame frame;
	private JTextField textFieldEmail;
	private JTextField textFieldBirthday;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JLabel lblAutre;
	private JTextField textFieldAutre;
	private JTextField textFieldAutre2;
	private JLabel lblAutre2;
	private JTextField textFieldAutre3;
	private JLabel lblAutre3;
	private JTextField textFieldAutre4;
	private JLabel lblAutre4;
	private JTextField textFieldAutre5;
	private JLabel lblAutre5;
	private JTextField textFieldAutre6;
	private JLabel lblAutre6;
	private JTextField textFieldAutre7;
	private JLabel lblAutre7;
	private JTextField textFieldAutre8;
	private JLabel lblAutre8;

	/**
	 * Launch the application.
	 */
	public static void main(final String[] args , final JFrame oldFrame,final JList listContact,final JTable table) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					PopUp window = new PopUp(args,oldFrame,listContact,table);
					window.frame.setLocation(oldFrame.getX()+oldFrame.getWidth(),oldFrame.getY());
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PopUp(String[] args,JFrame oldFrame,JList listContact,JTable table) {
		initialize(args,oldFrame,listContact,table);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String[] colonnes,final JFrame oldFrame,final JList listContact,final JTable table) {
		int nbelement = colonnes.length-4;
		frame = new JFrame("Seoladh");
		frame.setBounds(100, 100, 337, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(111,168,220));
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setBounds(25, 43, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(134, 43, 86, 20);
		frame.getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldBirthday = new JTextField();
		textFieldBirthday.setBounds(134, 118, 86, 20);
		frame.getContentPane().add(textFieldBirthday);
		textFieldBirthday.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setBounds(25, 68, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Pr\u00E9nom");
		lblNewLabel_2.setBounds(25, 93, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Date de naissance");
		lblNewLabel_3.setBounds(10, 118, 114, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		textFieldNom = new JTextField();
		textFieldNom.setColumns(10);
		textFieldNom.setBounds(134, 68, 86, 20);
		frame.getContentPane().add(textFieldNom);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setColumns(10);
		textFieldPrenom.setBounds(134, 93, 86, 20);
		frame.getContentPane().add(textFieldPrenom);
		
		lblAutre = new JLabel("Autre");
		lblAutre.setBounds(20, 143, 107, 14);
		frame.getContentPane().add(lblAutre);
		
		textFieldAutre = new JTextField();
		textFieldAutre.setColumns(10);
		textFieldAutre.setBounds(134, 143, 86, 20);
		frame.getContentPane().add(textFieldAutre);
		
		textFieldAutre2 = new JTextField();
		textFieldAutre2.setColumns(10);
		textFieldAutre2.setBounds(134, 169, 86, 20);
		frame.getContentPane().add(textFieldAutre2);
		
		lblAutre2 = new JLabel("Autre");
		lblAutre2.setBounds(20, 169, 107, 14);
		frame.getContentPane().add(lblAutre2);
		
		textFieldAutre3 = new JTextField();
		textFieldAutre3.setColumns(10);
		textFieldAutre3.setBounds(134, 197, 86, 20);
		frame.getContentPane().add(textFieldAutre3);
		
		lblAutre3 = new JLabel("Autre");
		lblAutre3.setBounds(20, 197, 107, 14);
		frame.getContentPane().add(lblAutre3);
		
		textFieldAutre4 = new JTextField();
		textFieldAutre4.setColumns(10);
		textFieldAutre4.setBounds(134, 222, 86, 20);
		frame.getContentPane().add(textFieldAutre4);
		
		lblAutre4 = new JLabel("Autre");
		lblAutre4.setBounds(20, 222, 107, 14);
		frame.getContentPane().add(lblAutre4);
		
		textFieldAutre5 = new JTextField();
		textFieldAutre5.setColumns(10);
		textFieldAutre5.setBounds(134, 247, 86, 20);
		frame.getContentPane().add(textFieldAutre5);
		
		lblAutre5 = new JLabel("Autre");
		lblAutre5.setBounds(20, 247, 107, 14);
		frame.getContentPane().add(lblAutre5);
		
		textFieldAutre6 = new JTextField();
		textFieldAutre6.setColumns(10);
		textFieldAutre6.setBounds(134, 272, 86, 20);
		frame.getContentPane().add(textFieldAutre6);
		
		lblAutre6 = new JLabel("Autre");
		lblAutre6.setBounds(20, 272, 107, 14);
		frame.getContentPane().add(lblAutre6);
		
		textFieldAutre7 = new JTextField();
		textFieldAutre7.setColumns(10);
		textFieldAutre7.setBounds(134, 297, 86, 20);
		frame.getContentPane().add(textFieldAutre7);
		
		lblAutre7 = new JLabel("Autre");
		lblAutre7.setBounds(20, 297, 107, 14);
		frame.getContentPane().add(lblAutre7);
		
		textFieldAutre8 = new JTextField();
		textFieldAutre8.setColumns(10);
		textFieldAutre8.setBounds(134, 322, 86, 20);
		frame.getContentPane().add(textFieldAutre8);
		
		lblAutre8 = new JLabel("Autre");
		lblAutre8.setBounds(20, 322, 107, 14);
		frame.getContentPane().add(lblAutre8);
		
		JButton btnAdd = new JButton("Ajouter");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Nomfichier;
				
				contact c1 = new contact();
				ListContacts contacts = new ListContacts();
				contacts.setListcontacts(new ArrayList<contact>());
				int count = 0;
				int index = listContact.getSelectedIndex();
				Nomfichier = listContact.getModel().getElementAt(index).toString();
				for (int i = 0; i < table.getRowCount(); i++) {
					contact c = new contact();
					System.out.println(table.getValueAt(i, 0));
					switch (table.getColumnCount()) {
					case 4:
						c.setId(i);
						c.setIdentifiant(i);
						c.setNom(table.getValueAt(i, 0).toString());
						c.setPrenom(table.getValueAt(i, 1).toString());
						c.setEmail(table.getValueAt(i, 2).toString());
						c.setBirthday(table.getValueAt(i, 3).toString());
						break;
					case 5 :
						c.setId(i);
						c.setIdentifiant(i);
						c.setNom(table.getValueAt(i, 0).toString());
						c.setPrenom(table.getValueAt(i, 1).toString());
						c.setEmail(table.getValueAt(i, 2).toString());
						c.setBirthday(table.getValueAt(i, 3).toString());
						c.setDetailautre(table.getValueAt(i, 4).toString());
						c.setTitreautre(table.getColumnName(4));
						break;
					case 6 :
						c.setId(i);
						c.setIdentifiant(i);
						c.setNom(table.getValueAt(i, 0).toString());
						c.setPrenom(table.getValueAt(i, 1).toString());
						c.setEmail(table.getValueAt(i, 2).toString());
						c.setBirthday(table.getValueAt(i, 3).toString());
						c.setDetailautre(table.getValueAt(i, 4).toString());
						c.setTitreautre(table.getColumnName(4));
						c.setDetailautre2(table.getValueAt(i, 5).toString());
						c.setTitreautre2(table.getColumnName(5));
						break;
					case 7 :
						c.setId(i);
						c.setIdentifiant(i);
						c.setNom(table.getValueAt(i, 0).toString());
						c.setPrenom(table.getValueAt(i, 1).toString());
						c.setEmail(table.getValueAt(i, 2).toString());
						c.setBirthday(table.getValueAt(i, 3).toString());
						c.setDetailautre(table.getValueAt(i, 4).toString());
						c.setTitreautre(table.getColumnName(4));
						c.setDetailautre2(table.getValueAt(i, 5).toString());
						c.setTitreautre2(table.getColumnName(5));
						c.setDetailautre3(table.getValueAt(i, 6).toString());
						c.setTitreautre3(table.getColumnName(6));
						break;
					case 8 :
						c.setId(i);
						c.setIdentifiant(i);
						c.setNom(table.getValueAt(i, 0).toString());
						c.setPrenom(table.getValueAt(i, 1).toString());
						c.setEmail(table.getValueAt(i, 2).toString());
						c.setBirthday(table.getValueAt(i, 3).toString());
						c.setDetailautre(table.getValueAt(i, 4).toString());
						c.setTitreautre(table.getColumnName(4));
						c.setDetailautre2(table.getValueAt(i, 5).toString());
						c.setTitreautre2(table.getColumnName(5));
						c.setDetailautre3(table.getValueAt(i, 6).toString());
						c.setTitreautre3(table.getColumnName(6));
						c.setDetailautre4(table.getValueAt(i, 7).toString());
						c.setTitreautre4(table.getColumnName(7));
						break;
					case 9 :
						c.setId(i);
						c.setIdentifiant(i);
						c.setNom(table.getValueAt(i, 0).toString());
						c.setPrenom(table.getValueAt(i, 1).toString());
						c.setEmail(table.getValueAt(i, 2).toString());
						c.setBirthday(table.getValueAt(i, 3).toString());
						c.setDetailautre(table.getValueAt(i, 4).toString());
						c.setTitreautre(table.getColumnName(4));
						c.setDetailautre2(table.getValueAt(i, 5).toString());
						c.setTitreautre2(table.getColumnName(5));
						c.setDetailautre3(table.getValueAt(i, 6).toString());
						c.setTitreautre3(table.getColumnName(6));
						c.setDetailautre4(table.getValueAt(i, 7).toString());
						c.setTitreautre4(table.getColumnName(7));
						c.setDetailautre5(table.getValueAt(i, 8).toString());
						c.setTitreautre5(table.getColumnName(8));
						break;
					case 10 :
						c.setId(i);
						c.setIdentifiant(i);
						c.setNom(table.getValueAt(i, 0).toString());
						c.setPrenom(table.getValueAt(i, 1).toString());
						c.setEmail(table.getValueAt(i, 2).toString());
						c.setBirthday(table.getValueAt(i, 3).toString());
						c.setDetailautre(table.getValueAt(i, 4).toString());
						c.setTitreautre(table.getColumnName(4));
						c.setDetailautre2(table.getValueAt(i, 5).toString());
						c.setTitreautre2(table.getColumnName(5));
						c.setDetailautre3(table.getValueAt(i, 6).toString());
						c.setTitreautre3(table.getColumnName(6));
						c.setDetailautre4(table.getValueAt(i, 7).toString());
						c.setTitreautre4(table.getColumnName(7));
						c.setDetailautre5(table.getValueAt(i, 8).toString());
						c.setTitreautre5(table.getColumnName(8));
						c.setDetailautre6(table.getValueAt(i, 9).toString());
						c.setTitreautre6(table.getColumnName(9));
						break;
					case 11 :
						c.setId(i);
						c.setIdentifiant(i);
						c.setNom(table.getValueAt(i, 0).toString());
						c.setPrenom(table.getValueAt(i, 1).toString());
						c.setEmail(table.getValueAt(i, 2).toString());
						c.setBirthday(table.getValueAt(i, 3).toString());
						c.setDetailautre(table.getValueAt(i, 4).toString());
						c.setTitreautre(table.getColumnName(4));
						c.setDetailautre2(table.getValueAt(i, 5).toString());
						c.setTitreautre2(table.getColumnName(5));
						c.setDetailautre3(table.getValueAt(i, 6).toString());
						c.setTitreautre3(table.getColumnName(6));
						c.setDetailautre4(table.getValueAt(i, 7).toString());
						c.setTitreautre4(table.getColumnName(7));
						c.setDetailautre5(table.getValueAt(i, 8).toString());
						c.setTitreautre5(table.getColumnName(8));
						c.setDetailautre6(table.getValueAt(i, 9).toString());
						c.setTitreautre6(table.getColumnName(9));
						c.setDetailautre7(table.getValueAt(i, 10).toString());
						c.setTitreautre7(table.getColumnName(10));
						break;
					case 12 :
						c.setId(i);
						c.setIdentifiant(i);
						c.setNom(table.getValueAt(i, 0).toString());
						c.setPrenom(table.getValueAt(i, 1).toString());
						c.setEmail(table.getValueAt(i, 2).toString());
						c.setBirthday(table.getValueAt(i, 3).toString());
						c.setDetailautre(table.getValueAt(i, 4).toString());
						c.setTitreautre(table.getColumnName(4));
						c.setDetailautre2(table.getValueAt(i, 5).toString());
						c.setTitreautre2(table.getColumnName(5));
						c.setDetailautre3(table.getValueAt(i, 6).toString());
						c.setTitreautre3(table.getColumnName(6));
						c.setDetailautre4(table.getValueAt(i, 7).toString());
						c.setTitreautre4(table.getColumnName(7));
						c.setDetailautre5(table.getValueAt(i, 8).toString());
						c.setTitreautre5(table.getColumnName(8));
						c.setDetailautre6(table.getValueAt(i, 9).toString());
						c.setTitreautre6(table.getColumnName(9));
						c.setDetailautre7(table.getValueAt(i, 10).toString());
						c.setTitreautre7(table.getColumnName(10));
						c.setDetailautre8(table.getValueAt(i, 11).toString());
						c.setTitreautre8(table.getColumnName(11));
						break;
					default:
						break;
					}
					contacts.getListcontacts().add(c);
					count = i;
				}
				if (textFieldNom.isVisible()) {
					c1.setNom(textFieldNom.getText());
				}
				if (textFieldEmail.isVisible()) {
					c1.setEmail(textFieldEmail.getText());
				}
				if (textFieldPrenom.isVisible()) {
					c1.setPrenom(textFieldPrenom.getText());
				}
				if (textFieldBirthday.isVisible()) {
					c1.setBirthday(textFieldBirthday.getText());
				}
				if(textFieldAutre.isVisible()) {
					c1.setDetailautre(textFieldAutre.getText());
					c1.setTitreautre(lblAutre.getText());
				}
				if(textFieldAutre2.isVisible()) {
					c1.setDetailautre2(textFieldAutre2.getText());
					c1.setTitreautre2(lblAutre2.getText());
				}
				if(textFieldAutre3.isVisible()) {
					c1.setDetailautre3(textFieldAutre3.getText());
					c1.setTitreautre3(lblAutre3.getText());
				}
				if(textFieldAutre4.isVisible()) {
					c1.setDetailautre4(textFieldAutre4.getText());
					c1.setTitreautre4(lblAutre4.getText());
				}
				if(textFieldAutre5.isVisible()) {
					c1.setDetailautre5(textFieldAutre5.getText());
					c1.setTitreautre5(lblAutre5.getText());
				}
				if(textFieldAutre6.isVisible()) {
					c1.setDetailautre6(textFieldAutre6.getText());
					c1.setTitreautre6(lblAutre6.getText());
				}
				if(textFieldAutre7.isVisible()) {
					c1.setDetailautre7(textFieldAutre7.getText());
					c1.setTitreautre7(lblAutre7.getText());
				}
				if(textFieldAutre8.isVisible()) {
					c1.setDetailautre8(textFieldAutre8.getText());
					c1.setTitreautre8(lblAutre8.getText());
				}
				c1.setId(count+1);
				c1.setIdentifiant(count+1);
				contacts.getListcontacts().add(c1);
				JAXBContext context;
				try {
					context = JAXBContext.newInstance(ListContacts.class);
				    Marshaller m = context.createMarshaller();
				    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				    m.marshal(contacts,new File("ListesContact\\"+Nomfichier));
				}
				catch (JAXBException e1) {

				}
				oldFrame.enable();
				listContact.clearSelection();
				listContact.setSelectedIndex(listContact.getSelectedIndex());
			    frame.dispose();
				
			}
		});
		btnAdd.setBounds(232, 327, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		lblAutre.setVisible(false);
		textFieldAutre.setVisible(false);
		lblAutre2.setVisible(false);
		textFieldAutre2.setVisible(false);
		lblAutre3.setVisible(false);
		textFieldAutre3.setVisible(false);
		lblAutre4.setVisible(false);
		textFieldAutre4.setVisible(false);
		lblAutre5.setVisible(false);
		textFieldAutre5.setVisible(false);
		lblAutre6.setVisible(false);
		textFieldAutre6.setVisible(false);
		lblAutre7.setVisible(false);
		textFieldAutre7.setVisible(false);
		lblAutre8.setVisible(false);
		textFieldAutre8.setVisible(false);
		
		
		switch (nbelement) {
		case 1:
			lblAutre.setVisible(true);
			textFieldAutre.setVisible(true);
			lblAutre.setText(colonnes[4]);
			frame.setBounds(100, 100, 337, 238);
			btnAdd.setBounds(224, 143, 86, 20);
			break;
		case 2:
			lblAutre.setVisible(true);
			textFieldAutre.setVisible(true);
			lblAutre2.setVisible(true);
			textFieldAutre2.setVisible(true);
			lblAutre.setText(colonnes[4]);
			lblAutre2.setText(colonnes[5]);
			frame.setBounds(100, 100, 337, 253);
			btnAdd.setBounds(224, 169, 86, 20);
			break;
		case 3:
			lblAutre.setVisible(true);
			textFieldAutre.setVisible(true);
			lblAutre2.setVisible(true);
			textFieldAutre2.setVisible(true);
			lblAutre3.setVisible(true);
			textFieldAutre3.setVisible(true);
			lblAutre.setText(colonnes[4]);
			lblAutre2.setText(colonnes[5]);
			lblAutre3.setText(colonnes[6]);
			frame.setBounds(100, 100, 337, 268);
			btnAdd.setBounds(224, 197, 86, 20);
			break;
		case 4:
			lblAutre.setVisible(true);
			textFieldAutre.setVisible(true);
			lblAutre2.setVisible(true);
			textFieldAutre2.setVisible(true);
			lblAutre3.setVisible(true);
			textFieldAutre3.setVisible(true);
			lblAutre4.setVisible(true);
			textFieldAutre4.setVisible(true);
			lblAutre.setText(colonnes[4]);
			lblAutre2.setText(colonnes[5]);
			lblAutre3.setText(colonnes[6]);
			lblAutre4.setText(colonnes[7]);
			frame.setBounds(100, 100, 337, 283);
			btnAdd.setBounds(224, 222, 86, 20);
			break;
		case 5:
			lblAutre.setVisible(true);
			textFieldAutre.setVisible(true);
			lblAutre2.setVisible(true);
			textFieldAutre2.setVisible(true);
			lblAutre3.setVisible(true);
			textFieldAutre3.setVisible(true);
			lblAutre4.setVisible(true);
			textFieldAutre4.setVisible(true);
			lblAutre5.setVisible(true);
			textFieldAutre5.setVisible(true);
			lblAutre.setText(colonnes[4]);
			lblAutre2.setText(colonnes[5]);
			lblAutre3.setText(colonnes[6]);
			lblAutre4.setText(colonnes[7]);
			lblAutre5.setText(colonnes[8]);
			frame.setBounds(100, 100, 337, 305);
			btnAdd.setBounds(224, 247, 86, 20);
			break;
		case 6:
			lblAutre.setVisible(true);
			textFieldAutre.setVisible(true);
			lblAutre2.setVisible(true);
			textFieldAutre2.setVisible(true);
			lblAutre3.setVisible(true);
			textFieldAutre3.setVisible(true);
			lblAutre4.setVisible(true);
			textFieldAutre4.setVisible(true);
			lblAutre5.setVisible(true);
			textFieldAutre5.setVisible(true);
			lblAutre6.setVisible(true);
			textFieldAutre6.setVisible(true);
			lblAutre.setText(colonnes[4]);
			lblAutre2.setText(colonnes[5]);
			lblAutre3.setText(colonnes[6]);
			lblAutre4.setText(colonnes[7]);
			lblAutre5.setText(colonnes[8]);
			lblAutre6.setText(colonnes[9]);
			frame.setBounds(100, 100, 337, 335);
			btnAdd.setBounds(134, 272, 86, 20);
			break;
		case 7:
			lblAutre.setVisible(true);
			textFieldAutre.setVisible(true);
			lblAutre2.setVisible(true);
			textFieldAutre2.setVisible(true);
			lblAutre3.setVisible(true);
			textFieldAutre3.setVisible(true);
			lblAutre4.setVisible(true);
			textFieldAutre4.setVisible(true);
			lblAutre5.setVisible(true);
			textFieldAutre5.setVisible(true);
			lblAutre6.setVisible(true);
			textFieldAutre6.setVisible(true);
			lblAutre7.setVisible(true);
			textFieldAutre7.setVisible(true);
			lblAutre.setText(colonnes[4]);
			lblAutre2.setText(colonnes[5]);
			lblAutre3.setText(colonnes[6]);
			lblAutre4.setText(colonnes[7]);
			lblAutre5.setText(colonnes[8]);
			lblAutre6.setText(colonnes[9]);
			lblAutre7.setText(colonnes[10]);
			frame.setBounds(100, 100, 337, 365);
			btnAdd.setBounds(134, 297, 86, 20);
			break;
		case 8:
			lblAutre.setVisible(true);
			textFieldAutre.setVisible(true);
			lblAutre2.setVisible(true);
			textFieldAutre2.setVisible(true);
			lblAutre3.setVisible(true);
			textFieldAutre3.setVisible(true);
			lblAutre4.setVisible(true);
			textFieldAutre4.setVisible(true);
			lblAutre5.setVisible(true);
			textFieldAutre5.setVisible(true);
			lblAutre6.setVisible(true);
			textFieldAutre6.setVisible(true);
			lblAutre7.setVisible(true);
			textFieldAutre7.setVisible(true);
			lblAutre8.setVisible(true);
			textFieldAutre8.setVisible(true);
			lblAutre.setText(colonnes[4]);
			lblAutre2.setText(colonnes[5]);
			lblAutre3.setText(colonnes[6]);
			lblAutre4.setText(colonnes[7]);
			lblAutre5.setText(colonnes[8]);
			lblAutre6.setText(colonnes[9]);
			lblAutre7.setText(colonnes[10]);
			lblAutre7.setText(colonnes[11]);
			frame.setBounds(100, 100, 337, 395);
			btnAdd.setBounds(224, 322, 107, 14);
			break;
		default:
			frame.setBounds(100, 100, 337, 181);
			btnAdd.setBounds(224, 118, 86, 20);
			break;
		}
		
		
		
	}



}
