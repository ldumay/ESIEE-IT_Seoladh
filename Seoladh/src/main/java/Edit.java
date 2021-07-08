import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Edit {

	private JFrame frame;
	private JTableHeader Theader;
	private JTable table;
	final JFileChooser fc = new JFileChooser();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edit window = new Edit();
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
	public Edit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public static boolean isMailAddr(String mail) {
		if (mail == null)
			return false;
		Pattern macPattern = Pattern.compile("^[a-z0-9_.-]+@[a-z0-9.-]{2,}\\.([\\w]+)$");
		Matcher m = macPattern.matcher(mail.toLowerCase());
		return m.matches();
	}

	private void initialize() {
		frame = new JFrame();

		frame.getContentPane().setBackground(new Color(111, 168, 220));
		frame.setBounds(100, 100, 1096, 498);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		File file = new File("ListesContact");
		File[] files = file.listFiles();
		String[] data = new String[files.length];
		final JList listContact = new JList(data);
		int count = 0;
		for (File value : files) {
			if (value.getName().contains(".xml")) {
				System.out.println(value.getName());
				data[count] = value.getName();
				count = count + 1;
			}
		}

		JLabel lblNewLabel = new JLabel("Listes de contact");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(null);

		JLabel lblNewLabel_1 = new JLabel("");

		JLabel LabelPicture = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Seoladh.png")).getImage();
		LabelPicture.setIcon(new ImageIcon(img));

		JButton btnAdd = new JButton("Ajout unique");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ViewContact inter = new ViewContact();
				inter.main(null);
			}
		});

		JButton btnNettoyage = new JButton("Nettoyage");

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(315).addComponent(lblNewLabel_1))
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
						.addComponent(LabelPicture, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup().addGap(142).addComponent(btnNettoyage,
										GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false).addGroup(
										Alignment.LEADING,
										groupLayout.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
												.addGap(86).addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 581,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup().addGap(202)
												.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 97,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(btnRetour, GroupLayout.PREFERRED_SIZE, 97,
														GroupLayout.PREFERRED_SIZE)
												.addGap(70)))))
				.addContainerGap(19, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblNewLabel_1)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(LabelPicture, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addGap(40).addComponent(lblNewLabel).addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnRetour, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnNettoyage, GroupLayout.PREFERRED_SIZE, 34,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 34,
												GroupLayout.PREFERRED_SIZE)))
						.addGap(29)));

		listContact.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JList theList = (JList) e.getSource();
				int index = theList.locationToIndex(e.getPoint());
				String fichierClick = theList.getModel().getElementAt(index).toString();
				File xmlDoc = new File("ListesContact/" + fichierClick);
				try {
					DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
					DocumentBuilder dBuild = dbFact.newDocumentBuilder();
					Document doc = dBuild.parse(xmlDoc);
					System.out.println(doc.getDocumentElement().getNodeName());
					NodeList nList = doc.getElementsByTagName("Listcontacts");
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					for (int i = 0; i < nList.getLength(); i++) {
						Node nNode = nList.item(i);
						Element eElement = (Element) nNode;
						if (eElement.getAttribute("id") != "") {
							System.out.println("Listes contacts id : " + eElement.getAttribute("id"));
							System.out.println("Listes contacts nom : "
									+ eElement.getElementsByTagName("nom").item(0).getTextContent());

							model.addRow(new Object[] { eElement.getElementsByTagName("nom").item(0).getTextContent(),
									eElement.getElementsByTagName("prenom").item(0).getTextContent(),
									eElement.getElementsByTagName("email").item(0).getTextContent(),
									eElement.getElementsByTagName("Birthday").item(0).getTextContent() });
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
		scrollPane_1.setViewportView(listContact);
		listContact.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listContact.setToolTipText("");

		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nom", "Pr\u00E9nom", "Email", "Date de naissance" }));
		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);

		btnNettoyage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = listContact.getSelectedIndex();
				String fichierClick = listContact.getModel().getElementAt(index).toString();
				File xmlDoc = new File("ListesContact/" + fichierClick);
				DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuild;
				try {
					dBuild = dbFact.newDocumentBuilder();
					Document doc = dBuild.parse(xmlDoc);
					NodeList nList = doc.getElementsByTagName("Listcontacts");
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					for (int i = 0; i < nList.getLength(); i++) {
						Node nNode = nList.item(i);
						Element eElement = (Element) nNode;
						String mail = eElement.getElementsByTagName("email").item(0).getTextContent();
						ListContacts contacts = new ListContacts();
						contacts.setListcontacts(new ArrayList<contact>());
						contact c = new contact();
						c.setNom(eElement.getElementsByTagName("nom").item(0).getTextContent());
						c.setPrenom(eElement.getElementsByTagName("prenom").item(0).getTextContent());
						c.setBirthday(eElement.getElementsByTagName("Birthday").item(0).getTextContent());
						c.setEmail(mail);
						JAXBContext context;
						if (isMailAddr(mail) != true) {
							System.out.println("coucou" + mail);
							 try {
		                            context = JAXBContext.newInstance(ListContacts.class);
		                           Marshaller m = context.createMarshaller();
		                           m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		                           m.marshal(contacts,new File("ListesContact\\"+fichierClick));
		                           frame.dispose();
		                           Edit inter = new Edit();
		                           inter.main(null);

		                    } catch (JAXBException e1) {		                       
		                        e1.printStackTrace();

		                    }
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

	}
}
