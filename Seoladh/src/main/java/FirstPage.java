import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;


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
		
		final JFrame frame = new JFrame("Seoladh");
		frame.setResizable(false);
		frame.setSize(800,500);
		JPanel pan = new JPanel();
		pan.setBackground(new Color(111,168,220));
		JButton btnContact = new JButton("");
		btnContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ViewContact inter = new ViewContact();
				inter.main(null);
			}
		});
		btnContact.setBorderPainted(false); 
		btnContact.setContentAreaFilled(false); 
		btnContact.setFocusPainted(false); 
		btnContact.setOpaque(false);
		Image img = new ImageIcon(this.getClass().getResource("/Gestion Contacts.png")).getImage();
		btnContact.setIcon(new ImageIcon(img));
		btnContact.setBounds(20,20,150,30);
		JButton btnListe = new JButton("");
		btnListe.setFont(new Font("Arial", Font.BOLD, 16));
		btnListe.setBorderPainted(false); 
		btnListe.setContentAreaFilled(false); 
		btnListe.setFocusPainted(false); 
		btnListe.setOpaque(false);
		Image img3 = new ImageIcon(this.getClass().getResource("/library.png")).getImage();
		btnListe.setIcon(new ImageIcon(img3));
		btnListe.setBounds(20,20,150,30);
		btnListe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		frame.getContentPane().add(pan);
		JButton btnCampagne = new JButton("");
		btnCampagne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ViewCampagne inter = new ViewCampagne();
				inter.main(null);
			}
		});
		btnCampagne.setBorderPainted(false); 
		btnCampagne.setContentAreaFilled(false); 
		btnCampagne.setFocusPainted(false); 
		btnCampagne.setOpaque(false);
		Image img4 = new ImageIcon(this.getClass().getResource("/Gestion Campagnes.png")).getImage();
		btnCampagne.setIcon(new ImageIcon(img4));
		btnCampagne.setBounds(20,20,150,30);
		Image img2 = new ImageIcon(this.getClass().getResource("/Seoladh.png")).getImage();
		
		JLabel lblNewLabel = new JLabel("Gestion Contacts");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel lblNewLabel_1 = new JLabel("Biblioth\u00E8que");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel lblNewLabel_2 = new JLabel("Gestion Campagnes");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel LabelPicture = new JLabel("");
		LabelPicture.setIcon(new ImageIcon(img2));
		GroupLayout gl_pan = new GroupLayout(pan);
		gl_pan.setHorizontalGroup(
			gl_pan.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pan.createSequentialGroup()
					.addGroup(gl_pan.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pan.createSequentialGroup()
							.addGroup(gl_pan.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pan.createSequentialGroup()
									.addContainerGap(79, Short.MAX_VALUE)
									.addComponent(btnContact, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
									.addGap(55)
									.addComponent(btnCampagne))
								.addGroup(gl_pan.createSequentialGroup()
									.addGap(86)
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
									.addComponent(lblNewLabel_2)))
							.addGap(65))
						.addGroup(gl_pan.createSequentialGroup()
							.addGap(204)
							.addComponent(LabelPicture, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_pan.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pan.createSequentialGroup()
							.addGap(8)
							.addComponent(btnListe, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pan.createSequentialGroup()
							.addGap(40)
							.addComponent(lblNewLabel_1)))
					.addGap(65))
		);
		gl_pan.setVerticalGroup(
			gl_pan.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pan.createSequentialGroup()
					.addGap(58)
					.addComponent(LabelPicture, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
					.addGroup(gl_pan.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnContact, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pan.createSequentialGroup()
							.addGroup(gl_pan.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnListe, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCampagne))
							.addGap(15)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pan.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_1))
					.addGap(65))
		);
		pan.setLayout(gl_pan);
		frame.setVisible(true);
	
	}
}
