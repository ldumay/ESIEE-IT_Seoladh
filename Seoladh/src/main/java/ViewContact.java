import java.awt.EventQueue;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.AbstractListModel;

public class ViewContact {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewContact window = new ViewContact();
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
	public ViewContact() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 681, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
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
		JList listContact = new JList(data);


		
		
		listContact.setBounds(10, 93, 267, 141);
		frame.getContentPane().add(listContact);
		
		JLabel lblNewLabel = new JLabel("Listes de contact");
		lblNewLabel.setBounds(10, 68, 142, 14);
		frame.getContentPane().add(lblNewLabel);
		
	}
}
