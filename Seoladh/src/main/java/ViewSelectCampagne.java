import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViewSelectCampagne {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSelectCampagne window = new ViewSelectCampagne();
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
	public ViewSelectCampagne() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 661, 342);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(111,168,220));
		frame.getContentPane().setLayout(null);
		
		JLabel LabelPicture = new JLabel("");
		frame.getContentPane().add(LabelPicture);
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
		
	}

}
