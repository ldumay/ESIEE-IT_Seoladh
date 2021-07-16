import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.lang3.StringEscapeUtils;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.hexidec.ekit.Ekit;

public class ViewCampagne extends JEditorPane {

	private JFrame frame;
	private JTextField textFieldSend;
	private JTextField textFieldSubject;
	private JTable table;
	private JTextField textFieldSMTP;
	private JPasswordField passwordField;
	private JTextField textFieldmailtest;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCampagne window = new ViewCampagne();
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
	public ViewCampagne() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		final JTextArea textAreaInfo = new JTextArea();
		final JLabel lblMessage = new JLabel("");
		lblMessage.setVisible(false);
		final Ekit ekit = new Ekit();
		frame.setResizable(false);
		final JPanel panMessage = new JPanel();
		panMessage.setBounds(0, 156, 939, 419);
		frame.getContentPane().add(panMessage);
		final JPanel panDest = new JPanel();
		panDest.setBounds(0, 156, 939, 419);
		frame.getContentPane().add(panDest);
		final JPanel panSend = new JPanel();
		panSend.setBounds(0, 156, 939, 419);
		frame.getContentPane().add(panSend);

		panMessage.setVisible(true);
		panDest.setVisible(false);
		panSend.setVisible(false);

		JLabel LabelPicture = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Seoladh.png")).getImage();
		LabelPicture.setIcon(new ImageIcon(img));
		LabelPicture.setBounds(0, 0, 320, 60);
		LabelPicture.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				FirstPage inter = new FirstPage();

			}
		});
		frame.getContentPane().setBackground(new Color(111, 168, 220));

		JPanel panMenu = new JPanel();
		panMenu.setBackground(Color.BLACK);
		panMenu.setBounds(49, 103, 842, 47);
		frame.getContentPane().add(panMenu);
		panMenu.setLayout(new BorderLayout(0, 0));

		JButton btnNewButton = new JButton("Message");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panMessage.setVisible(true);
				panDest.setVisible(false);
				panSend.setVisible(false);
			}
		});
		panMenu.add(btnNewButton, BorderLayout.WEST);

		JButton btnNewButton_1 = new JButton("Destinataire");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panMessage.setVisible(false);
				panDest.setVisible(true);
				panSend.setVisible(false);
			}
		});
		btnNewButton_1.setToolTipText("");
		panMenu.add(btnNewButton_1, BorderLayout.CENTER);

		JButton btnNewButton_2 = new JButton("Envoi");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panMessage.setVisible(false);
				panDest.setVisible(false);
				panSend.setVisible(true);
			}
		});
		panMenu.add(btnNewButton_2, BorderLayout.EAST);
		frame.getContentPane().add(LabelPicture);
		frame.setBounds(100, 100, 955, 614);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panMessage.setBackground(new Color(111, 168, 220));

		JPanel panelMessage = new JPanel();

		GroupLayout gl_panMessage = new GroupLayout(panMessage);
		gl_panMessage.setHorizontalGroup(gl_panMessage.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panMessage.createSequentialGroup().addGap(65)
						.addComponent(panelMessage, GroupLayout.PREFERRED_SIZE, 801, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(73, Short.MAX_VALUE)));
		gl_panMessage.setVerticalGroup(gl_panMessage.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panMessage.createSequentialGroup().addGap(6)
						.addComponent(panelMessage, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE).addContainerGap()));
		panMessage.setLayout(gl_panMessage);
		panDest.setBackground(new Color(111, 168, 220));
		File file = new File("ListesContact");
		File[] files = file.listFiles();
		String[] data = new String[files.length];
		int count = 0;
		for (File value : files) {
			if (value.getName().contains(".xml")) {
				System.out.println(value.getName());
				data[count] = value.getName();
				count = count + 1;
			}
		}

		JScrollPane scrollPane_1 = new JScrollPane();

		JScrollPane scrollPane_3 = new JScrollPane();
		GroupLayout gl_panDest = new GroupLayout(panDest);
		gl_panDest.setHorizontalGroup(gl_panDest.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panDest.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
						.addGap(20)
						.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 638, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(47, Short.MAX_VALUE)));
		gl_panDest.setVerticalGroup(gl_panDest.createParallelGroup(Alignment.LEADING).addGroup(gl_panDest
				.createSequentialGroup().addGap(31)
				.addGroup(gl_panDest.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(scrollPane_3, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(scrollPane_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))
				.addGap(29)));

		table = new JTable();
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Liste de contact", "Nombre de contact" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(136);
		table.getColumnModel().getColumn(1).setPreferredWidth(221);
		scrollPane_3.setViewportView(table);
		final JList listContact = new JList(data);
		listContact.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textAreaInfo.setText("Liste des email : ");
				JList theList = (JList) e.getSource();
				int index = theList.locationToIndex(e.getPoint());
				String fichierClick = theList.getModel().getElementAt(index).toString();
				File xmlDoc = new File("ListesContact/"+fichierClick);
				try {
				DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuild = dbFact.newDocumentBuilder();
				Document doc = dBuild.parse(xmlDoc);
				NodeList nList = doc.getElementsByTagName("Listcontacts");
				int countAutre = 0;
				Node nNode = nList.item(0);
				Element eElement = (Element) nNode;
				for(int i=0;i<nList.getLength();i++) {
					 nNode = nList.item(i);
					 eElement = (Element) nNode;
					if(eElement.getAttribute("id") != "") {
						textAreaInfo.setText(textAreaInfo.getText()+"\n"+ eElement.getElementsByTagName("email").item(0).getTextContent());
					}
				}
			} catch (ParserConfigurationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SAXException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (int i = 0; i < listContact.getModel().getSize(); i++) {
			File xmlDoc = new File("ListesContact/" + listContact.getModel().getElementAt(i).toString());
			try {
				
				DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuild = dbFact.newDocumentBuilder();
				Document doc = dBuild.parse(xmlDoc);
				NodeList nList = doc.getElementsByTagName("Listcontacts");
				model.addRow(
						new Object[] { String.valueOf(listContact.getModel().getElementAt(i)), nList.getLength()-1 });
			} catch (Exception e2) {
				System.out.println(e2);
			}

		}

		scrollPane_1.setViewportView(listContact);
		panDest.setLayout(gl_panDest);
		panSend.setBackground(new Color(111, 168, 220));

		JScrollPane scrollPane_2 = new JScrollPane();

		JLabel lblConfig = new JLabel("Configuration de l'envoi : ");
		lblConfig.setFont(new Font("Arial", Font.BOLD, 15));

		JLabel lbl = new JLabel("Email exp\u00E9diteur : ");
		lbl.setFont(new Font("Arial", Font.BOLD, 15));

		JLabel lblObjetDuMessage = new JLabel("Objet du message : ");
		lblObjetDuMessage.setFont(new Font("Arial", Font.BOLD, 15));

		textFieldSend = new JTextField();
		textFieldSend.setColumns(10);

		textFieldSubject = new JTextField();
		textFieldSubject.setColumns(10);

		JLabel lblAction = new JLabel("Action : ");
		lblAction.setFont(new Font("Arial", Font.BOLD, 15));

		JButton btnNewButton_8 = new JButton("Envoi sur une adresse test");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SendMail envoi = new SendMail();
				String bodyHTML = ekit.getDocumentCore();
				String body = "";
				int index = listContact.getSelectedIndex();
				String fichierClick = listContact.getModel().getElementAt(index).toString();
				File xmlDoc = new File("ListesContact/" + fichierClick);
				DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuild;
				try {
					lblMessage.setVisible(true);
					lblMessage.setText("En cours d'envoi");
					dBuild = dbFact.newDocumentBuilder();
					Document doc = dBuild.parse(xmlDoc);
					NodeList nList = doc.getElementsByTagName("Listcontacts");
					Node nNode = nList.item(0);
					Element eElement = (Element) nNode;
					for (int i = 1; i < nList.getLength(); i++) {
						body = bodyHTML;
						 nNode = nList.item(i);
						 eElement = (Element) nNode;
						if (eElement.getAttribute("id") != "") {
							body = StringEscapeUtils.unescapeHtml4(body);
							if(isInMessage("nom",body)) {
								body = SetFullMessage(body,"nom",eElement.getElementsByTagName("nom").item(0).getTextContent());
							}
							else if (isInMessage("Nom",body)) {
								body = SetFullMessage(body,"Nom",eElement.getElementsByTagName("nom").item(0).getTextContent());
							}
							if(isInMessage("prénom",body)) {
								body = SetFullMessage(body,"prénom",eElement.getElementsByTagName("prenom").item(0).getTextContent());
							}
							else if (isInMessage("Prénom",body)) {
								body = SetFullMessage(body,"Prénom",eElement.getElementsByTagName("prenom").item(0).getTextContent());
							}
							else if (isInMessage("prenom",body)) {
								body = SetFullMessage(body,"prenom",eElement.getElementsByTagName("prenom").item(0).getTextContent());
							}
							else if (isInMessage("Prenom",body)) {
								body = SetFullMessage(body,"Prenom",eElement.getElementsByTagName("prenom").item(0).getTextContent());
							}
							if(isInMessage("email",body)) {
								body = SetFullMessage(body,"email",eElement.getElementsByTagName("email").item(0).getTextContent());
							}
							else if (isInMessage("Email",body)) {
								body = SetFullMessage(body,"Email",eElement.getElementsByTagName("email").item(0).getTextContent());
							}
							else if (isInMessage("mail",body)) {
								body = SetFullMessage(body,"mail",eElement.getElementsByTagName("email").item(0).getTextContent());
							}
							else if (isInMessage("Mail",body)) {
								body = SetFullMessage(body,"Mail",eElement.getElementsByTagName("email").item(0).getTextContent());
							}
							if(isInMessage("Date de naissance",body)) {
								body = SetFullMessage(body,"Date de naissance",eElement.getElementsByTagName("Birthday").item(0).getTextContent());
							}
							
							if(checkIfNodeExists(doc,"/Listcontacts/Listcontacts/Titreautre")){
								if(isInMessage(eElement.getElementsByTagName("Titreautre").item(0).getTextContent(),body)){
									body = SetFullMessage(body,eElement.getElementsByTagName("Titreautre").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre").item(0).getTextContent());
								}
							}
							if(checkIfNodeExists(doc,"/Listcontacts/Listcontacts/Titreautre2")){
								if(isInMessage(eElement.getElementsByTagName("Titreautre2").item(0).getTextContent(),body)){
									body = SetFullMessage(body,eElement.getElementsByTagName("Titreautre2").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre2").item(0).getTextContent());
								}
							}
							if(checkIfNodeExists(doc,"/Listcontacts/Listcontacts/Titreautre3")){
								if(isInMessage(eElement.getElementsByTagName("Titreautre3").item(0).getTextContent(),body)){
									body = SetFullMessage(body,eElement.getElementsByTagName("Titreautre3").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre3").item(0).getTextContent());
								}
							}
							if(checkIfNodeExists(doc,"/Listcontacts/Listcontacts/Titreautre4")){
								if(isInMessage(eElement.getElementsByTagName("Titreautre4").item(0).getTextContent(),body)){
									body = SetFullMessage(body,eElement.getElementsByTagName("Titreautre4").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre4").item(0).getTextContent());
								}
							}
							if(checkIfNodeExists(doc,"/Listcontacts/Listcontacts/Titreautre5")){

								if(isInMessage(eElement.getElementsByTagName("Titreautre5").item(0).getTextContent(),body)){
									body = SetFullMessage(body,eElement.getElementsByTagName("Titreautre5").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre5").item(0).getTextContent());
								}
							}
							if(checkIfNodeExists(doc,"/Listcontacts/Listcontacts/Titreautre6")){
								if(isInMessage(eElement.getElementsByTagName("Titreautre6").item(0).getTextContent(),body)){
									body = SetFullMessage(body,eElement.getElementsByTagName("Titreautre6").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre6").item(0).getTextContent());
								}
							}
							if(checkIfNodeExists(doc,"/Listcontacts/Listcontacts/Titreautre7")){
								if(isInMessage(eElement.getElementsByTagName("Titreautre7").item(0).getTextContent(),body)){
									body = SetFullMessage(body,eElement.getElementsByTagName("Titreautre7").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre7").item(0).getTextContent());
								}
							}
							if(checkIfNodeExists(doc,"/Listcontacts/Listcontacts/Titreautre8")){
								if(isInMessage(eElement.getElementsByTagName("Titreautre8").item(0).getTextContent(),body)){
									body = SetFullMessage(body,eElement.getElementsByTagName("Titreautre8").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre8").item(0).getTextContent());
								}
							}
                envoi.SendMail(textFieldSend.getText(), passwordField.getText(), textFieldmailtest.getText(),textFieldSMTP.getText(), textFieldSubject.getText(), body);
						}
					}
					lblMessage.setText("Envoie terminé");
				} catch (SAXException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParserConfigurationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (DOMException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_8.setFont(new Font("Arial", Font.PLAIN, 15));

		JButton btnNewButton_9 = new JButton("Paramétrage SMTP");
		btnNewButton_9.setFont(new Font("Arial", Font.PLAIN, 15));

		JButton btnNewButton_8_1 = new JButton("R\u00E9aliser l'envoi complet");
		btnNewButton_8_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SendMail envoi = new SendMail();
				String bodyHTML = ekit.getDocumentCore();
				String body = "";
				int index = listContact.getSelectedIndex();
				String fichierClick = listContact.getModel().getElementAt(index).toString();
				File xmlDoc = new File("ListesContact/" + fichierClick);
				DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuild;
				try {
					lblMessage.setText("En cours d'envoi");
					dBuild = dbFact.newDocumentBuilder();
					Document doc = dBuild.parse(xmlDoc);
					NodeList nList = doc.getElementsByTagName("Listcontacts");
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					for (int i = 1; i < nList.getLength(); i++) {
						body = bodyHTML;
						Node nNode = nList.item(i);
						Element eElement = (Element) nNode;
						if (eElement.getAttribute("id") != "") {
							body = StringEscapeUtils.unescapeHtml4(body);
							if(isInMessage("nom",body)) {
								body = SetFullMessage(body,"nom",eElement.getElementsByTagName("nom").item(0).getTextContent());
							}
							else if (isInMessage("Nom",body)) {
								body = SetFullMessage(body,"Nom",eElement.getElementsByTagName("nom").item(0).getTextContent());
							}
							if(isInMessage("prénom",body)) {
								body = SetFullMessage(body,"prénom",eElement.getElementsByTagName("prenom").item(0).getTextContent());
							}
							else if (isInMessage("Prénom",body)) {
								body = SetFullMessage(body,"Prénom",eElement.getElementsByTagName("prenom").item(0).getTextContent());
							}
							else if (isInMessage("prenom",body)) {
								body = SetFullMessage(body,"prenom",eElement.getElementsByTagName("prenom").item(0).getTextContent());
							}
							else if (isInMessage("Prenom",body)) {
								body = SetFullMessage(body,"Prenom",eElement.getElementsByTagName("prenom").item(0).getTextContent());
							}
							if(isInMessage("email",body)) {
								body = SetFullMessage(body,"email",eElement.getElementsByTagName("email").item(0).getTextContent());
							}
							else if (isInMessage("Email",body)) {
								body = SetFullMessage(body,"Email",eElement.getElementsByTagName("email").item(0).getTextContent());
							}
							else if (isInMessage("mail",body)) {
								body = SetFullMessage(body,"mail",eElement.getElementsByTagName("email").item(0).getTextContent());
							}
							else if (isInMessage("Mail",body)) {
								body = SetFullMessage(body,"Mail",eElement.getElementsByTagName("email").item(0).getTextContent());
							}
							if(isInMessage("Date de naissance",body)) {
								body = SetFullMessage(body,"Date de naissance",eElement.getElementsByTagName("Birthday").item(0).getTextContent());
							}
							
							if(checkIfNodeExists(doc,"/Listcontacts/Listcontacts/Titreautre")){
								if(isInMessage(eElement.getElementsByTagName("Titreautre").item(0).getTextContent(),body)){
									body = SetFullMessage(body,eElement.getElementsByTagName("Titreautre").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre").item(0).getTextContent());
								}
							}
							if(checkIfNodeExists(doc,"/Listcontacts/Listcontacts/Titreautre2")){
								if(isInMessage(eElement.getElementsByTagName("Titreautre2").item(0).getTextContent(),body)){
									body = SetFullMessage(body,eElement.getElementsByTagName("Titreautre2").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre2").item(0).getTextContent());
								}
							}
							if(checkIfNodeExists(doc,"/Listcontacts/Listcontacts/Titreautre3")){
								if(isInMessage(eElement.getElementsByTagName("Titreautre3").item(0).getTextContent(),body)){
									body = SetFullMessage(body,eElement.getElementsByTagName("Titreautre3").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre3").item(0).getTextContent());
								}
							}
							if(checkIfNodeExists(doc,"/Listcontacts/Listcontacts/Titreautre4")){
								if(isInMessage(eElement.getElementsByTagName("Titreautre4").item(0).getTextContent(),body)){
									body = SetFullMessage(body,eElement.getElementsByTagName("Titreautre4").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre4").item(0).getTextContent());
								}
							}
							if(checkIfNodeExists(doc,"/Listcontacts/Listcontacts/Titreautre5")){

								if(isInMessage(eElement.getElementsByTagName("Titreautre5").item(0).getTextContent(),body)){
									body = SetFullMessage(body,eElement.getElementsByTagName("Titreautre5").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre5").item(0).getTextContent());
								}
							}
							if(checkIfNodeExists(doc,"/Listcontacts/Listcontacts/Titreautre6")){
								if(isInMessage(eElement.getElementsByTagName("Titreautre6").item(0).getTextContent(),body)){
									body = SetFullMessage(body,eElement.getElementsByTagName("Titreautre6").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre6").item(0).getTextContent());
								}
							}
							if(checkIfNodeExists(doc,"/Listcontacts/Listcontacts/Titreautre7")){
								if(isInMessage(eElement.getElementsByTagName("Titreautre7").item(0).getTextContent(),body)){
									body = SetFullMessage(body,eElement.getElementsByTagName("Titreautre7").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre7").item(0).getTextContent());
								}
							}
							if(checkIfNodeExists(doc,"/Listcontacts/Listcontacts/Titreautre8")){
								if(isInMessage(eElement.getElementsByTagName("Titreautre8").item(0).getTextContent(),body)){
									body = SetFullMessage(body,eElement.getElementsByTagName("Titreautre8").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre8").item(0).getTextContent());
								}
							}
							String mail = eElement.getElementsByTagName("email").item(0).getTextContent();
							envoi.SendMail(textFieldSend.getText(), passwordField.getText(), mail, textFieldSMTP.getText(), textFieldSubject.getText(), body);
						}
						lblMessage.setText("Envoie terminé");
					}
				} catch (SAXException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParserConfigurationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (DOMException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_8_1.setFont(new Font("Arial", Font.PLAIN, 15));

		JButton btnNewButton_8_1_1 = new JButton("Programmer l'envoi");
		btnNewButton_8_1_1.setFont(new Font("Arial", Font.PLAIN, 15));

		JLabel lblAction_1 = new JLabel("Param\u00E9trage : ");
		lblAction_1.setFont(new Font("Arial", Font.BOLD, 15));

		textFieldSMTP = new JTextField();
		textFieldSMTP.setColumns(10);
		textFieldSMTP.setText("smtp.gmail.com");

		JLabel lblNewLabel_1 = new JLabel("SMTP :");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));

		JLabel lblMotDePasse = new JLabel("Mot de passe exp\u00E9diteur : ");
		lblMotDePasse.setFont(new Font("Arial", Font.BOLD, 15));

		passwordField = new JPasswordField();
		
		textFieldmailtest = new JTextField();
		textFieldmailtest.setColumns(10);
		

		lblMessage.setFont(new Font("Arial", Font.BOLD, 15));
		GroupLayout gl_panSend = new GroupLayout(panSend);
		gl_panSend.setHorizontalGroup(
			gl_panSend.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panSend.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panSend.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panSend.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblAction_1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panSend.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panSend.createSequentialGroup()
								.addGap(18)
								.addGroup(gl_panSend.createParallelGroup(Alignment.LEADING)
									.addComponent(lblAction, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_panSend.createSequentialGroup()
										.addGap(13)
										.addGroup(gl_panSend.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_panSend.createSequentialGroup()
												.addComponent(btnNewButton_8_1, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
												.addGap(18)
												.addComponent(btnNewButton_8_1_1, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(lblMessage, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_panSend.createSequentialGroup()
												.addComponent(btnNewButton_8)
												.addGap(18)
												.addComponent(textFieldmailtest, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE))))))
							.addGroup(Alignment.LEADING, gl_panSend.createSequentialGroup()
								.addGap(50)
								.addGroup(gl_panSend.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblConfig, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(gl_panSend.createSequentialGroup()
										.addGroup(gl_panSend.createParallelGroup(Alignment.LEADING)
											.addComponent(lbl, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
											.addGroup(gl_panSend.createSequentialGroup()
												.addGap(2)
												.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
											.addComponent(lblObjetDuMessage, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblMotDePasse, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panSend.createParallelGroup(Alignment.LEADING)
											.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
											.addComponent(textFieldSubject, GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
											.addComponent(textFieldSMTP)
											.addComponent(textFieldSend, GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)))))))
					.addGap(44))
		);
		gl_panSend.setVerticalGroup(
			gl_panSend.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panSend.createSequentialGroup()
					.addGroup(gl_panSend.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panSend.createSequentialGroup()
							.addGap(25)
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panSend.createSequentialGroup()
							.addGap(54)
							.addComponent(lblConfig)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panSend.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbl, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldSend, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panSend.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMotDePasse, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panSend.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblObjetDuMessage, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldSubject, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(lblAction_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panSend.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(textFieldSMTP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblAction, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addGroup(gl_panSend.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_8)
								.addComponent(textFieldmailtest, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(33)
							.addGroup(gl_panSend.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMessage, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_8_1_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_8_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(29, Short.MAX_VALUE))
		);


		scrollPane_2.setViewportView(textAreaInfo);
		panSend.setLayout(gl_panSend);

		JLabel lblNewLabel = new JLabel("Gestions des campagnes");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(330, 24, 191, 14);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().getParent().getComponent(0);



		panelMessage.setLayout(new BorderLayout());

		panelMessage.add(ekit.getJMenuBar().getComponent(), BorderLayout.NORTH);
		panelMessage.add(ekit.getContentPane());
		ekit.setVisible(false);


	}
	public Boolean isInMessage(String regex,String texte) {
		Pattern pattern = Pattern.compile("\\{"+regex+"\\}");
        Matcher matcher = pattern.matcher(texte);
		return matcher.find();	
	}
	public String SetFullMessage(String texte , String Type,String element) {
		return texte.replace("{"+Type+"}", element);
	}
    private static boolean checkIfNodeExists(Document document, String xpathExpression) throws Exception 
    {
        boolean matches = false;
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
 
        try {
            XPathExpression expr = xpath.compile(xpathExpression);
            NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);          
            if(nodes != null  && nodes.getLength() > 0) {
                matches = true;
            }
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return matches;
    }
}
