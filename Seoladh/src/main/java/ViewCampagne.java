import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class ViewCampagne extends JEditorPane{

	private JFrame frame;
	private JTextField textFieldSend;
	private JTextField textFieldSubject;
	private JTable table;

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
		frame.getContentPane().setBackground(new Color(111,168,220));
		
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
		
		
		panMessage.setBackground(new Color(111,168,220));
		JButton btnNewButton_3 = new JButton("Templates");
		
		JButton btnNewButton_4 = new JButton("Structures mails");
		
		JButton btnNewButton_5 = new JButton("Cr\u00E9ation");
		
		JButton btnNewButton_6 = new JButton("Vos templates");
		
		JButton btnNewButton_7 = new JButton("Retour");
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panMessage = new GroupLayout(panMessage);
		gl_panMessage.setHorizontalGroup(
			gl_panMessage.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panMessage.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_panMessage.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnNewButton_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_6, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_7, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 739, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(42, Short.MAX_VALUE))
		);
		gl_panMessage.setVerticalGroup(
			gl_panMessage.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panMessage.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_panMessage.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panMessage.createSequentialGroup()
							.addComponent(btnNewButton_3)
							.addGap(33)
							.addComponent(btnNewButton_4)
							.addGap(31)
							.addComponent(btnNewButton_5)
							.addGap(36)
							.addComponent(btnNewButton_6)
							.addGap(36)
							.addComponent(btnNewButton_7)))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		
		JEditorPane editorPane = new JEditorPane();
		scrollPane.setViewportView(editorPane);
		panMessage.setLayout(gl_panMessage);
		panDest.setBackground(new Color(111,168,220));
		
		File file = new File("ListesContact");
		File[] files = file.listFiles();
		String[] data = new String[files.length];
		int count = 0;
		for( File value : files) {
			if(value.getName().contains(".xml")) {
			System.out.println(value.getName());
			data[count] = value.getName();
			count = count +1;
			}
		}
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JScrollPane scrollPane_3 = new JScrollPane();
		GroupLayout gl_panDest = new GroupLayout(panDest);
		gl_panDest.setHorizontalGroup(
			gl_panDest.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panDest.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 638, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(47, Short.MAX_VALUE))
		);
		gl_panDest.setVerticalGroup(
			gl_panDest.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panDest.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_panDest.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(scrollPane_3, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(scrollPane_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))
					.addGap(29))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Liste de contact", "Nombre de contact"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(136);
		table.getColumnModel().getColumn(1).setPreferredWidth(221);
		scrollPane_3.setViewportView(table);
		final JList listContact = new JList(data);

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (int i = 0; i < listContact.getModel().getSize(); i++) {
			File xmlDoc = new File("ListesContact/"+listContact.getModel().getElementAt(i).toString());
			try {
			DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuild = dbFact.newDocumentBuilder();
			Document doc = dBuild.parse(xmlDoc);
			NodeList nList = doc.getElementsByTagName("Listcontacts");
			model.addRow(new Object[]{String.valueOf(listContact.getModel().getElementAt(i)), nList.getLength()});
			}
			catch (Exception e2) {
				System.out.println(e2);
			}
			
		}

		scrollPane_1.setViewportView(listContact);
		panDest.setLayout(gl_panDest);
		panSend.setBackground(new Color(111,168,220));
		
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
		btnNewButton_8.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JButton btnNewButton_8_1 = new JButton("R\u00E9aliser l'envoi complet");
		btnNewButton_8_1.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JButton btnNewButton_8_1_1 = new JButton("Programmer l'envoi");
		btnNewButton_8_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		GroupLayout gl_panSend = new GroupLayout(panSend);
		gl_panSend.setHorizontalGroup(
			gl_panSend.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panSend.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panSend.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panSend.createSequentialGroup()
							.addGap(50)
							.addGroup(gl_panSend.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblConfig, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_panSend.createSequentialGroup()
									.addGroup(gl_panSend.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblObjetDuMessage, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lbl, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panSend.createParallelGroup(Alignment.LEADING)
										.addComponent(textFieldSubject, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldSend, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_panSend.createSequentialGroup()
							.addGap(18)
							.addComponent(lblAction, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panSend.createSequentialGroup()
							.addGap(31)
							.addGroup(gl_panSend.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panSend.createSequentialGroup()
									.addComponent(btnNewButton_8_1, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnNewButton_8_1_1, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnNewButton_8))))
					.addContainerGap(245, Short.MAX_VALUE))
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
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panSend.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblObjetDuMessage, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldSubject, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(55)
							.addComponent(lblAction, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(btnNewButton_8)
							.addGap(33)
							.addGroup(gl_panSend.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_8_1_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_8_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		
		JTextArea textArea = new JTextArea();
		scrollPane_2.setViewportView(textArea);
		panSend.setLayout(gl_panSend);
		
		JLabel lblNewLabel = new JLabel("Gestions des campagnes");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(330, 24, 191, 14);
		frame.getContentPane().add(lblNewLabel);
		
		
	}
}
