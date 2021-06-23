import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FirstPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstPage window = new FirstPage();
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
	public FirstPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		
		JButton btnMail = new JButton("Gestion des mails");
		JButton btnContact = new JButton("Gestions des contacts");
		JButton btnListe = new JButton("Gestion des listes");
		JButton btnCampagne = new JButton("Gestion des Campagnes");
		btnMail.setBounds(20,20,150,30);
		btnContact.setBounds(20,20,150,30);
		btnListe.setBounds(20,20,150,30);
		btnCampagne.setBounds(20,20,150,30);
		
		final JFrame frame = new JFrame("Seoladh HUB");
		frame.setSize(800,500);
		JPanel pan = new JPanel();
		pan.add(btnMail);
		pan.add(btnContact);
		pan.add(btnListe);
		pan.add(btnCampagne);
		frame.getContentPane().add(pan);

		frame.setVisible(true);
		btnMail.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Interface inter = new Interface();
				inter.main(null);
			}
		});
	
	}

}
