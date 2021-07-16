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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Edit {

	private JFrame frame;
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

	private static void saveXMLContent(Document document, String xmlFile) {
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult("ListesContact/" + xmlFile);
			transformer.transform(domSource, streamResult);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

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
		frame.setBounds(100, 100, 990, 498);
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
		LabelPicture.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				FirstPage inter = new FirstPage();
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/Seoladh.png")).getImage();
		LabelPicture.setIcon(new ImageIcon(img));

		JButton btnAdd = new JButton("Ajout unique");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getRowCount() > 0) {
					String colonne[] = new String[table.getColumnCount()];
					for (int i = 0; i < colonne.length; i++) {
						colonne[i] = table.getColumnName(i);
					}
					PopUp.main(colonne,frame,listContact,table);
					frame.disable();
				}
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
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(315)
							.addComponent(lblNewLabel_1))
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
						.addComponent(LabelPicture, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(142)
									.addComponent(btnNettoyage, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 581, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
									.addGap(153)
									.addComponent(btnRetour, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addGap(70)))))
					.addContainerGap(164, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(LabelPicture, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnRetour, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNettoyage, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(29))
		);

		listContact.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JList theList = (JList) e.getSource();
				int index = theList.locationToIndex(e.getPoint());
				String fichierClick = theList.getModel().getElementAt(index).toString();
				File xmlDoc = new File("ListesContact/"+fichierClick);
				try {
					DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
					DocumentBuilder dBuild = dbFact.newDocumentBuilder();
					Document doc = dBuild.parse(xmlDoc);
					System.out.println(doc.getDocumentElement().getNodeName());
					NodeList nList = doc.getElementsByTagName("Listcontacts");
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					int countAutre = 0;
					Node nNode = nList.item(0);
					Element eElement = (Element) nNode;
					model.setColumnCount(4);
					try {
						System.out.println(eElement.getAttribute("Titreautre"));
						model.addColumn(eElement.getElementsByTagName("Titreautre").item(0).getTextContent());
						countAutre = countAutre+1;
					} catch (Exception e2) {
						
					}
					try {
						System.out.println(eElement.getAttribute("Titreautre2"));
						model.addColumn(eElement.getElementsByTagName("Titreautre2").item(0).getTextContent());
						countAutre = countAutre+1;
					} catch (Exception e2) {
						
					}
					try {
						System.out.println(eElement.getAttribute("Titreautre3"));
						model.addColumn(eElement.getElementsByTagName("Titreautre3").item(0).getTextContent());
						countAutre = countAutre+1;
					} catch (Exception e2) {
						
					}
					try {
						System.out.println(eElement.getAttribute("Titreautre4"));
						model.addColumn(eElement.getElementsByTagName("Titreautre4").item(0).getTextContent());
						countAutre = countAutre+1;
					} catch (Exception e2) {
						
					}
					try {
						System.out.println(eElement.getAttribute("Titreautre5"));
						model.addColumn(eElement.getElementsByTagName("Titreautre5").item(0).getTextContent());
						countAutre = countAutre+1;
					} catch (Exception e2) {
						
					}
					try {
						System.out.println(eElement.getAttribute("Titreautre6"));
						model.addColumn(eElement.getElementsByTagName("Titreautre6").item(0).getTextContent());
						countAutre = countAutre+1;
					} catch (Exception e2) {
						
					}
					try {
						System.out.println(eElement.getAttribute("Titreautre7"));
						model.addColumn(eElement.getElementsByTagName("Titreautre7").item(0).getTextContent());
						countAutre = countAutre+1;
					} catch (Exception e2) {
						
					}
					try {
						System.out.println(eElement.getAttribute("Titreautre8"));
						model.addColumn(eElement.getElementsByTagName("Titreautre8").item(0).getTextContent());
						countAutre = countAutre+1;
					} catch (Exception e2) {
						
					}
					for(int i=0;i<nList.getLength();i++) {
						 nNode = nList.item(i);
						 eElement = (Element) nNode;
						if(eElement.getAttribute("id") != "") {
							System.out.println("Listes contacts id : "+ eElement.getAttribute("id"));
							System.out.println("Listes contacts nom : "+eElement.getElementsByTagName("nom").item(0).getTextContent());
							switch (countAutre) {
							case 1:
								model.addRow(new Object[]{eElement.getElementsByTagName("nom").item(0).getTextContent(), eElement.getElementsByTagName("prenom").item(0).getTextContent(), eElement.getElementsByTagName("email").item(0).getTextContent(),eElement.getElementsByTagName("Birthday").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre").item(0).getTextContent()});
								break;
							case 2:
								model.addRow(new Object[]{eElement.getElementsByTagName("nom").item(0).getTextContent(), eElement.getElementsByTagName("prenom").item(0).getTextContent(), eElement.getElementsByTagName("email").item(0).getTextContent(),eElement.getElementsByTagName("Birthday").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre2").item(0).getTextContent()});
								break;
							case 3:
								model.addRow(new Object[]{eElement.getElementsByTagName("nom").item(0).getTextContent(), eElement.getElementsByTagName("prenom").item(0).getTextContent(), eElement.getElementsByTagName("email").item(0).getTextContent(),eElement.getElementsByTagName("Birthday").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre2").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre3").item(0).getTextContent()});
								break;
							case 4:
								model.addRow(new Object[]{eElement.getElementsByTagName("nom").item(0).getTextContent(), eElement.getElementsByTagName("prenom").item(0).getTextContent(), eElement.getElementsByTagName("email").item(0).getTextContent(),eElement.getElementsByTagName("Birthday").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre2").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre3").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre4").item(0).getTextContent()});
								break;
							case 5:
								model.addRow(new Object[]{eElement.getElementsByTagName("nom").item(0).getTextContent(), eElement.getElementsByTagName("prenom").item(0).getTextContent(), eElement.getElementsByTagName("email").item(0).getTextContent(),eElement.getElementsByTagName("Birthday").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre2").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre3").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre4").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre5").item(0).getTextContent()});
								break;
							case 6:
								model.addRow(new Object[]{eElement.getElementsByTagName("nom").item(0).getTextContent(), eElement.getElementsByTagName("prenom").item(0).getTextContent(), eElement.getElementsByTagName("email").item(0).getTextContent(),eElement.getElementsByTagName("Birthday").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre2").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre3").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre4").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre5").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre6").item(0).getTextContent()});
								break;
							case 7:
								model.addRow(new Object[]{eElement.getElementsByTagName("nom").item(0).getTextContent(), eElement.getElementsByTagName("prenom").item(0).getTextContent(), eElement.getElementsByTagName("email").item(0).getTextContent(),eElement.getElementsByTagName("Birthday").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre2").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre3").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre4").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre5").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre6").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre7").item(0).getTextContent()});
								break;
							case 8:
								model.addRow(new Object[]{eElement.getElementsByTagName("nom").item(0).getTextContent(), eElement.getElementsByTagName("prenom").item(0).getTextContent(), eElement.getElementsByTagName("email").item(0).getTextContent(),eElement.getElementsByTagName("Birthday").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre2").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre3").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre4").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre5").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre6").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre7").item(0).getTextContent(),eElement.getElementsByTagName("Detailautre8").item(0).getTextContent()});
								break;
							default:
								model.addRow(new Object[]{eElement.getElementsByTagName("nom").item(0).getTextContent(), eElement.getElementsByTagName("prenom").item(0).getTextContent(), eElement.getElementsByTagName("email").item(0).getTextContent(),eElement.getElementsByTagName("Birthday").item(0).getTextContent()});
								break;
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
				Document document = null;
				try {

					dBuild = dbFact.newDocumentBuilder();
					Document doc = dBuild.parse(xmlDoc);
					Node racine = doc.getFirstChild();
					NodeList list = racine.getChildNodes();
					NodeList nList = doc.getElementsByTagName("Listcontacts");
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					ArrayList<String> Listmail = new ArrayList<String>();
					ArrayList<Integer> id = new ArrayList<Integer>();
					for (int i = 0; i < nList.getLength(); i++) {
						Node nNode = nList.item(i);
						Element product = (Element) nList.item(i);
						Element eElement = (Element) nNode;
						if (eElement.getAttribute("id") != "") {
							contact c = new contact();
							c.setId(i - 1);
							c.setNom(eElement.getElementsByTagName("nom").item(0).getTextContent());
							c.setPrenom(eElement.getElementsByTagName("prenom").item(0).getTextContent());
							c.setBirthday(eElement.getElementsByTagName("Birthday").item(0).getTextContent());
							c.setEmail(eElement.getElementsByTagName("email").item(0).getTextContent());
							if (Listmail.contains(c.getEmail())) {
								id.add(i - 1);
							} else {
								Listmail.add(c.getEmail());
							}
							if (isMailAddr(c.getEmail()) != true) {
								id.add(i - 1);
							} else {
								Listmail.add(c.getEmail());
							}
							System.out.println(c.getId() + " " + c.getEmail());
						}

					}
					for (int i = 0; i < id.size(); i++) {
						System.out.println(id.get(i));
					}
					DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
					document = documentBuilder.parse(xmlDoc);
					for (int i = 0; i < id.size(); i++) {
						NodeList products = document.getElementsByTagName("Listcontacts");
						for (int j = 0; j < products.getLength(); j++) {
							Element product = (Element) products.item(j);
							Element idTag = (Element) product.getElementsByTagName("identifiant").item(0);
							if (idTag.getTextContent().equalsIgnoreCase(Integer.toString(id.get(i)))) {
								idTag.getParentNode().getParentNode().removeChild(products.item(j));
								break;
							}
						}
					}
					saveXMLContent(document, fichierClick);
					frame.dispose();
					main(null);

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
