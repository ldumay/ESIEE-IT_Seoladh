import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
public class Interface {
	private JFrame frame;
	private JTextField TbxTo;
	private JTextField TbxtObjet;
	private JTextField TbxEmail;
	private JTextField TbxSMTP;
	private JPasswordField TbxPassword;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
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
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u00C0");
		lblNewLabel.setBounds(88, 92, 20, 14);
		panel.add(lblNewLabel);
		
		TbxTo = new JTextField();
		TbxTo.setBounds(166, 89, 312, 20);
		panel.add(TbxTo);
		TbxTo.setColumns(10);
		
		TbxtObjet = new JTextField();
		TbxtObjet.setBounds(166, 141, 312, 20);
		panel.add(TbxtObjet);
		TbxtObjet.setColumns(10);
		
		final JTextArea RtbBody = new JTextArea();
		RtbBody.setBounds(166, 196, 312, 141);
		panel.add(RtbBody);
		
		JLabel lblNewLabel_1 = new JLabel("Objet");
		lblNewLabel_1.setBounds(88, 144, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Message");
		lblNewLabel_2.setBounds(88, 201, 68, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("R\u00E9glages");
		lblNewLabel_3.setBounds(51, 381, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("E-mail :");
		lblNewLabel_4.setBounds(110, 416, 46, 14);
		panel.add(lblNewLabel_4);
		
		TbxEmail = new JTextField();
		TbxEmail.setBounds(166, 413, 160, 20);
		panel.add(TbxEmail);
		TbxEmail.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Mot de passe :");
		lblNewLabel_5.setBounds(70, 441, 86, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("SMTP :");
		lblNewLabel_6.setBounds(336, 416, 46, 14);
		panel.add(lblNewLabel_6);
		
		TbxSMTP = new JTextField();
		TbxSMTP.setBounds(392, 413, 86, 20);
		panel.add(TbxSMTP);
		TbxSMTP.setColumns(10);
		
		JButton btnSend = new JButton("Envoyer");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SendMail.SendMail(TbxEmail.getText(),TbxPassword.getText(),TbxTo.getText(),TbxSMTP.getText(),TbxtObjet.getText(),RtbBody.getText());
			}
		});
		btnSend.setBounds(564, 437, 89, 23);
		panel.add(btnSend);
		
		TbxPassword = new JPasswordField();
		TbxPassword.setBounds(166, 438, 160, 20);
		panel.add(TbxPassword);
		}
}
