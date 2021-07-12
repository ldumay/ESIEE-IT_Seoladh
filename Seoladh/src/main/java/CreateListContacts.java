import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.BorderLayout;

import javax.swing.CellEditor;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CreateListContacts {

	private JFrame frmSeoladh;
	private JTextField TxbNameFile;
	private JTextField TxbNewElement;
	private int CountWindow = 0;
	private JTable tableListe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateListContacts window = new CreateListContacts();
					window.frmSeoladh.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreateListContacts() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSeoladh = new JFrame();
		frmSeoladh.setTitle("Seoladh");
		frmSeoladh.setBounds(100, 100, 1082, 770);
		frmSeoladh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSeoladh.getContentPane().setBackground(new Color(111,168,220));
		
		JLabel lblNewLabel_4 = new JLabel("Nom du fichier");
		
		TxbNameFile = new JTextField();
		TxbNameFile.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Nom nouveaux \u00E9l\u00E9ment");
		
		TxbNewElement = new JTextField();
		TxbNewElement.setColumns(10);
		
		final JLabel lblMessage = new JLabel("New label");
		lblMessage.setFont(new Font("Arial", Font.BOLD, 16));
		
		JButton btnNewElem = new JButton("Nouveau \u00E9l\u00E9ment");
		lblMessage.setVisible(false);
		
		JButton btnCreate = new JButton("Cr\u00E9e Liste");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BreakThanos:
				if(null == null) {

				lblMessage.setVisible(false);
				DefaultTableModel model = (DefaultTableModel) tableListe.getModel();

				//sauvegarde la derniere selection
				tableListe.setColumnSelectionAllowed(true);
			    tableListe.setRowSelectionAllowed(true);
			    if (tableListe.getCellEditor() != null) {
			    	tableListe.getCellEditor().stopCellEditing();
			    }
				if(TxbNameFile.getText().equals("")) {
					TxbNameFile.setText("contact");
				}
					
				String[] temp ,nom = new String[tableListe.getRowCount()] ,prenom = new String[tableListe.getRowCount()] ,email = new String[tableListe.getRowCount()] ,birthday = new String[tableListe.getRowCount()],DetailAutre = new String[tableListe.getRowCount()],DetailAutre2 = new String[tableListe.getRowCount()],DetailAutre3 = new String[tableListe.getRowCount()],DetailAutre4 = new String[tableListe.getRowCount()],DetailAutre5 = new String[tableListe.getRowCount()],DetailAutre6 = new String[tableListe.getRowCount()],DetailAutre7 = new String[tableListe.getRowCount()],DetailAutre8 = new String[tableListe.getRowCount()];
				String Titreautre = null,Titreautre2 = null,Titreautre3 = null,Titreautre4 = null,Titreautre5 = null,Titreautre6 = null,Titreautre7 = null,Titreautre8 = null;

				
				for (int i = 0; i < tableListe.getRowCount(); i++){
					if(tableListe.getValueAt(i, 0) == null || tableListe.getValueAt(i, 0).equals("")) {
						tableListe.setColumnSelectionInterval(0, 0);
						tableListe.setRowSelectionInterval(i, i);
					    lblMessage.setVisible(true);
					    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 1");
						break BreakThanos;
					}
				else {
					email[i] = tableListe.getValueAt(i, 0).toString();
				}
					
				}
				
				for (int i = 0; i < tableListe.getRowCount(); i++){
					if(tableListe.getValueAt(i, 1) == null || tableListe.getValueAt(i, 1).equals("")) {
						tableListe.setColumnSelectionInterval(1, 1);
						tableListe.setRowSelectionInterval(i, i);
					    lblMessage.setVisible(true);
					    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 2");
						break BreakThanos;
					}
					else {
						nom[i] = tableListe.getValueAt(i, 1).toString();
						
					}
					}
				for (int i = 0; i < tableListe.getRowCount(); i++){
					if(tableListe.getValueAt(i, 2) == null || tableListe.getValueAt(i, 2).equals("")) {
						tableListe.setColumnSelectionInterval(2, 2);
						tableListe.setRowSelectionInterval(i, i);
					    lblMessage.setVisible(true);
					    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 3");
						break BreakThanos;
					}
					else {
						prenom[i] = tableListe.getValueAt(i, 2).toString();
					}	
					}
				
				for (int i = 0; i < tableListe.getRowCount(); i++){
					if(tableListe.getValueAt(i, 3) == null || tableListe.getValueAt(i, 3).equals("")) {
						tableListe.setColumnSelectionInterval(3, 3);
						tableListe.setRowSelectionInterval(i, i);
					    lblMessage.setVisible(true);
					    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 4");
						break BreakThanos;
					}
					else {
						birthday[i] = tableListe.getValueAt(i, 3).toString();
						}
					}
				if(CountWindow == 1) {
					Titreautre = tableListe.getColumnName(4);
					for (int i = 0; i < tableListe.getRowCount(); i++){
						if(tableListe.getValueAt(i, 4) == null || tableListe.getValueAt(i, 4).equals("")) {
							tableListe.setColumnSelectionInterval(4, 4);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 5");
							break BreakThanos;
						}
						else {
							DetailAutre[i] = tableListe.getValueAt(i, 4).toString();
							
						}
						
					}
				}
				if(CountWindow == 2) {
					Titreautre = tableListe.getColumnName(4);
					Titreautre2 = tableListe.getColumnName(5);
					for (int i = 0; i < tableListe.getRowCount(); i++){
						if(tableListe.getValueAt(i, 4) == null || tableListe.getValueAt(i, 4).equals("")) {
							tableListe.setColumnSelectionInterval(4, 4);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 5");
							break BreakThanos;
						}
						if(tableListe.getValueAt(i, 5) == null || tableListe.getValueAt(i, 5).equals("")) {
							tableListe.setColumnSelectionInterval(5, 5);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 6");
							break BreakThanos;
						}
						else {
							DetailAutre[i] = tableListe.getValueAt(i, 4).toString();
							DetailAutre2[i] = tableListe.getValueAt(i, 5).toString();
						}

					}
				}
				if(CountWindow == 3) {
					Titreautre = tableListe.getColumnName(4);
					Titreautre2 = tableListe.getColumnName(5);
					Titreautre3 = tableListe.getColumnName(6);
					for (int i = 0; i < tableListe.getRowCount(); i++){
						if(tableListe.getValueAt(i, 4) == null || tableListe.getValueAt(i, 4).equals("")) {
							tableListe.setColumnSelectionInterval(4, 4);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 5");
							break BreakThanos;
						}
						if(tableListe.getValueAt(i, 5) == null || tableListe.getValueAt(i, 5).equals("")) {
							tableListe.setColumnSelectionInterval(5, 5);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 6");
							break BreakThanos;
						}
						if(tableListe.getValueAt(i, 6) == null || tableListe.getValueAt(i, 6).equals("")) {
							tableListe.setColumnSelectionInterval(6, 6);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 7");
							break BreakThanos;
						}
						else {
							DetailAutre[i] = tableListe.getValueAt(i, 4).toString();
							DetailAutre2[i] = tableListe.getValueAt(i, 5).toString();
							DetailAutre3[i] = tableListe.getValueAt(i, 6).toString();
						}

					}
				}
				if(CountWindow == 4) {
					Titreautre = tableListe.getColumnName(4);
					Titreautre2 = tableListe.getColumnName(5);
					Titreautre3 = tableListe.getColumnName(6);
					Titreautre4 = tableListe.getColumnName(7);
					for (int i = 0; i < tableListe.getRowCount(); i++){
						if(tableListe.getValueAt(i, 4) == null || tableListe.getValueAt(i, 4).equals("")) {
							tableListe.setColumnSelectionInterval(4, 4);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 5");
							break BreakThanos;
						}
						if(tableListe.getValueAt(i, 5) == null || tableListe.getValueAt(i, 5).equals("")) {
							tableListe.setColumnSelectionInterval(5, 5);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 6");
							break BreakThanos;
						}
						if(tableListe.getValueAt(i, 6) == null || tableListe.getValueAt(i, 6).equals("")) {
							tableListe.setColumnSelectionInterval(6, 6);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 7");
							break BreakThanos;
						}
						if(tableListe.getValueAt(i, 7) == null || tableListe.getValueAt(i, 7).equals("")) {
							tableListe.setColumnSelectionInterval(7, 7);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 8");
							break BreakThanos;
						}
						else {
							DetailAutre[i] = tableListe.getValueAt(i, 4).toString();
							DetailAutre2[i] = tableListe.getValueAt(i, 5).toString();
							DetailAutre3[i] = tableListe.getValueAt(i, 6).toString();
							DetailAutre4[i] = tableListe.getValueAt(i, 7).toString();
						}

					}
				}
				if(CountWindow == 5) {
					Titreautre = tableListe.getColumnName(4);
					Titreautre2 = tableListe.getColumnName(5);
					Titreautre3 = tableListe.getColumnName(6);
					Titreautre4 = tableListe.getColumnName(7);
					Titreautre5 = tableListe.getColumnName(8);
					for (int i = 0; i < tableListe.getRowCount(); i++){
						if(tableListe.getValueAt(i, 4) == null || tableListe.getValueAt(i, 4).equals("")) {
							tableListe.setColumnSelectionInterval(4, 4);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 5");
							break BreakThanos;
						}
						if(tableListe.getValueAt(i, 5) == null || tableListe.getValueAt(i, 5).equals("")) {
							tableListe.setColumnSelectionInterval(5, 5);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 6");
							break BreakThanos;
						}
						if(tableListe.getValueAt(i, 6) == null || tableListe.getValueAt(i, 6).equals("")) {
							tableListe.setColumnSelectionInterval(6, 6);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 7");
							break BreakThanos;
						}
						if(tableListe.getValueAt(i, 7) == null || tableListe.getValueAt(i, 7).equals("")) {
							tableListe.setColumnSelectionInterval(7, 7);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 8");
							break BreakThanos;
						}
						if(tableListe.getValueAt(i, 8) == null || tableListe.getValueAt(i, 8).equals("")) {
							tableListe.setColumnSelectionInterval(8, 8);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 9");
							break BreakThanos;
						}
						else {
							DetailAutre[i] = tableListe.getValueAt(i, 4).toString();
							DetailAutre2[i] = tableListe.getValueAt(i, 5).toString();
							DetailAutre3[i] = tableListe.getValueAt(i, 6).toString();
							DetailAutre4[i] = tableListe.getValueAt(i, 7).toString();
							DetailAutre5[i] = tableListe.getValueAt(i, 8).toString();
						}

					}
				}
				if(CountWindow == 6) {
					Titreautre = tableListe.getColumnName(4);
					Titreautre2 = tableListe.getColumnName(5);
					Titreautre3 = tableListe.getColumnName(6);
					Titreautre4 = tableListe.getColumnName(7);
					Titreautre5 = tableListe.getColumnName(8);
					Titreautre6 = tableListe.getColumnName(9);
					for (int i = 0; i < tableListe.getRowCount(); i++){
						if(tableListe.getValueAt(i, 4) == null || tableListe.getValueAt(i, 4).equals("")) {
							tableListe.setColumnSelectionInterval(4, 4);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 5");
							break BreakThanos;
						}
						if(tableListe.getValueAt(i, 5) == null || tableListe.getValueAt(i, 5).equals("")) {
							tableListe.setColumnSelectionInterval(5, 5);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 6");
							break BreakThanos;
						}
						if(tableListe.getValueAt(i, 6) == null || tableListe.getValueAt(i, 6).equals("")) {
							tableListe.setColumnSelectionInterval(6, 6);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 7");
							break BreakThanos;
						}
						if(tableListe.getValueAt(i, 7) == null || tableListe.getValueAt(i, 7).equals("")) {
							tableListe.setColumnSelectionInterval(7, 7);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 8");
							break BreakThanos;
						}
						if(tableListe.getValueAt(i, 8) == null || tableListe.getValueAt(i, 8).equals("")) {
							tableListe.setColumnSelectionInterval(8, 8);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 9");
							break BreakThanos;
						}
						if(tableListe.getValueAt(i, 9) == null || tableListe.getValueAt(i, 9).equals("")) {
							tableListe.setColumnSelectionInterval(9, 9);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 10");
							break BreakThanos;
						}
						else {
							DetailAutre[i] = tableListe.getValueAt(i, 4).toString();
							DetailAutre2[i] = tableListe.getValueAt(i, 5).toString();
							DetailAutre3[i] = tableListe.getValueAt(i, 6).toString();
							DetailAutre4[i] = tableListe.getValueAt(i, 7).toString();
							DetailAutre5[i] = tableListe.getValueAt(i, 8).toString();
							DetailAutre6[i] = tableListe.getValueAt(i, 9).toString();
						}

					}
				}
				if(CountWindow == 7) {
					Titreautre = tableListe.getColumnName(4);
					Titreautre2 = tableListe.getColumnName(5);
					Titreautre3 = tableListe.getColumnName(6);
					Titreautre4 = tableListe.getColumnName(7);
					Titreautre5 = tableListe.getColumnName(8);
					Titreautre6 = tableListe.getColumnName(9);
					Titreautre7 = tableListe.getColumnName(10);
					for (int i = 0; i < tableListe.getRowCount(); i++){
						if(tableListe.getValueAt(i, 4) == null || tableListe.getValueAt(i, 4).equals("")) {
							tableListe.setColumnSelectionInterval(4, 4);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 5");
							break BreakThanos;
						}
						if(tableListe.getValueAt(i, 5) == null || tableListe.getValueAt(i, 5).equals("")) {
							tableListe.setColumnSelectionInterval(5, 5);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 6");
							break BreakThanos;
						}
						if(tableListe.getValueAt(i, 6) == null || tableListe.getValueAt(i, 6).equals("")) {
							tableListe.setColumnSelectionInterval(6, 6);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 7");
							break BreakThanos;
						}
						if(tableListe.getValueAt(i, 7) == null || tableListe.getValueAt(i, 7).equals("")) {
							tableListe.setColumnSelectionInterval(7, 7);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 8");
							break BreakThanos;
						}
						if(tableListe.getValueAt(i, 8) == null || tableListe.getValueAt(i, 8).equals("")) {
							tableListe.setColumnSelectionInterval(8, 8);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 9");
							break BreakThanos;
						}
						if(tableListe.getValueAt(i, 9) == null || tableListe.getValueAt(i, 9).equals("")) {
							tableListe.setColumnSelectionInterval(9, 9);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 10");
							break BreakThanos;
						}
						if(tableListe.getValueAt(i, 10) == null || tableListe.getValueAt(i, 10).equals("")) {
							tableListe.setColumnSelectionInterval(10, 10);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 11");
							break BreakThanos;
						}
						else {
							DetailAutre[i] = tableListe.getValueAt(i, 4).toString();
							DetailAutre2[i] = tableListe.getValueAt(i, 5).toString();
							DetailAutre3[i] = tableListe.getValueAt(i, 6).toString();
							DetailAutre4[i] = tableListe.getValueAt(i, 7).toString();
							DetailAutre5[i] = tableListe.getValueAt(i, 8).toString();
							DetailAutre6[i] = tableListe.getValueAt(i, 9).toString();
							DetailAutre7[i] = tableListe.getValueAt(i, 10).toString();
						}

					}
				}
				if(CountWindow == 8) {
					Titreautre = tableListe.getColumnName(4);
					Titreautre2 = tableListe.getColumnName(5);
					Titreautre3 = tableListe.getColumnName(6);
					Titreautre4 = tableListe.getColumnName(7);
					Titreautre5 = tableListe.getColumnName(8);
					Titreautre6 = tableListe.getColumnName(9);
					Titreautre7 = tableListe.getColumnName(10);
					Titreautre8 = tableListe.getColumnName(11);
					
					for (int i = 0; i < tableListe.getRowCount(); i++){
						if(tableListe.getValueAt(i, 4) == null || tableListe.getValueAt(i, 4).equals("")) {
							tableListe.setColumnSelectionInterval(4, 4);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 5");
							break BreakThanos;
						}
						if(tableListe.getValueAt(i, 5) == null || tableListe.getValueAt(i, 5).equals("")) {
							tableListe.setColumnSelectionInterval(5, 5);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 6");
							break BreakThanos;
						}
						if(tableListe.getValueAt(i, 6) == null || tableListe.getValueAt(i, 6).equals("")) {
							tableListe.setColumnSelectionInterval(6, 6);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 7");
							break BreakThanos;
						}
						if(tableListe.getValueAt(i, 7) == null || tableListe.getValueAt(i, 7).equals("")) {
							tableListe.setColumnSelectionInterval(7, 7);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 8");
							break BreakThanos;
						}
						if(tableListe.getValueAt(i, 8) == null || tableListe.getValueAt(i, 8).equals("")) {
							tableListe.setColumnSelectionInterval(8, 8);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 9");
							break BreakThanos;
						}
						if(tableListe.getValueAt(i, 9) == null || tableListe.getValueAt(i, 9).equals("")) {
							tableListe.setColumnSelectionInterval(9, 9);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 10");
							break BreakThanos;
						}
						if(tableListe.getValueAt(i, 10) == null || tableListe.getValueAt(i, 10).equals("")) {
							tableListe.setColumnSelectionInterval(10, 10);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 11");
							break BreakThanos;
						}
						if(tableListe.getValueAt(i, 11) == null || tableListe.getValueAt(i, 11).equals("")) {
							tableListe.setColumnSelectionInterval(11, 11);
							tableListe.setRowSelectionInterval(i, i);
						    lblMessage.setVisible(true);
						    lblMessage.setText("Il vous manque un élement a la ligne "+(i+1)+" colonne 12");
							break BreakThanos;
						}
						else {
							DetailAutre[i] = tableListe.getValueAt(i, 4).toString();
							DetailAutre2[i] = tableListe.getValueAt(i, 5).toString();
							DetailAutre3[i] = tableListe.getValueAt(i, 6).toString();
							DetailAutre4[i] = tableListe.getValueAt(i, 7).toString();
							DetailAutre5[i] = tableListe.getValueAt(i, 8).toString();
							DetailAutre6[i] = tableListe.getValueAt(i, 9).toString();
							DetailAutre7[i] = tableListe.getValueAt(i, 10).toString();
							DetailAutre8[i] = tableListe.getValueAt(i, 11).toString();
						}

					}
				}
				ListContacts contacts = new ListContacts();
				contacts.setListcontacts(new ArrayList<contact>());
				for(int i = 0; i< email.length;i++) {
					contact c = new contact();
					c.setId(i);
					try {
						c.setNom(nom[i]);
					} catch (Exception e2) {
					    lblMessage.setVisible(true);
					    lblMessage.setText("Erreur Il y a moins de Nom que d'email");

					}
					try {
						c.setPrenom(prenom[i]);
					} catch (Exception e2) {
					    lblMessage.setVisible(true);
					    lblMessage.setText("Erreur Il y a moins de Prénom que d'email");

					}
					try {
						c.setEmail(email[i]);
					} catch (Exception e2) {
					    lblMessage.setVisible(true);
					    lblMessage.setText("Erreur veuillez verifier la liste Email");

					}
					try {
						c.setBirthday(birthday[i]);
					} catch (Exception e2) {
					    lblMessage.setVisible(true);
					    lblMessage.setText("Erreur Il y a moins de Date de naissance que d'email");

					}
					//contact c = new contact(i+1,nom[i],prenom[i],email[i],birthday[i]);
					if (CountWindow == 1) {
						try {
							c.setTitreautre(Titreautre);
							c.setDetailautre(DetailAutre[i]);
						} catch (Exception e2) {
						    lblMessage.setVisible(true);
						    lblMessage.setText("Erreur Il y a moins de "+Titreautre+" que d'email");

						}
					}
					else {
						c.setTitreautre(null);
						c.setDetailautre(null);
					}
					if (CountWindow == 2) {
						try {
							c.setTitreautre(Titreautre);
							c.setDetailautre(DetailAutre[i]);
							c.setTitreautre2(Titreautre2);
							c.setDetailautre2(DetailAutre2[i]);
						} catch (Exception e2) {
						    lblMessage.setVisible(true);
						    lblMessage.setText("Erreur Il y a moins de "+Titreautre2+" que d'email");

						}	
					}
					else {
						c.setDetailautre2(null);
						c.setTitreautre2(null);
					}
					if (CountWindow == 3) {
						try {
							c.setTitreautre(Titreautre);
							c.setDetailautre(DetailAutre[i]);
							c.setTitreautre2(Titreautre2);
							c.setDetailautre2(DetailAutre2[i]);
							c.setDetailautre3(DetailAutre3[i]);
							c.setTitreautre3(Titreautre3);
						} catch (Exception e2) {
						    lblMessage.setVisible(true);
						    lblMessage.setText("Erreur Il y a moins de "+Titreautre3+" que d'email");

						}
						
					}
					else {
						c.setDetailautre3(null);
						c.setTitreautre3(null);
					}
					if (CountWindow == 4) {
						try {
							c.setTitreautre(Titreautre);
							c.setDetailautre(DetailAutre[i]);
							c.setTitreautre2(Titreautre2);
							c.setDetailautre2(DetailAutre2[i]);
							c.setDetailautre3(DetailAutre3[i]);
							c.setTitreautre3(Titreautre3);
							c.setDetailautre4(DetailAutre4[i]);
							c.setTitreautre4(Titreautre4);
						} catch (Exception e2) {
						    lblMessage.setVisible(true);
						    lblMessage.setText("Erreur Il y a moins de "+Titreautre4+" que d'email");

						}
						
					}
					else {
						c.setDetailautre4(null);
						c.setTitreautre4(null);
					}
					if (CountWindow == 5) {
						try {
							c.setTitreautre(Titreautre);
							c.setDetailautre(DetailAutre[i]);
							c.setTitreautre2(Titreautre2);
							c.setDetailautre2(DetailAutre2[i]);
							c.setDetailautre3(DetailAutre3[i]);
							c.setTitreautre3(Titreautre3);
							c.setDetailautre4(DetailAutre4[i]);
							c.setTitreautre4(Titreautre4);
							c.setDetailautre5(DetailAutre5[i]);
							c.setTitreautre5(Titreautre5);
						} catch (Exception e2) {
						    lblMessage.setVisible(true);
						    lblMessage.setText("Erreur Il y a moins de "+Titreautre5+" que d'email");

						}
						
					}
					else {
						c.setDetailautre5(null);
						c.setTitreautre5(null);
					}	
					if (CountWindow == 6) {
						try {
							c.setTitreautre(Titreautre);
							c.setDetailautre(DetailAutre[i]);
							c.setTitreautre2(Titreautre2);
							c.setDetailautre2(DetailAutre2[i]);
							c.setDetailautre3(DetailAutre3[i]);
							c.setTitreautre3(Titreautre3);
							c.setDetailautre4(DetailAutre4[i]);
							c.setTitreautre4(Titreautre4);
							c.setDetailautre5(DetailAutre5[i]);
							c.setTitreautre5(Titreautre5);
							c.setDetailautre6(DetailAutre6[i]);
							c.setTitreautre6(Titreautre6);
						} catch (Exception e2) {
						    lblMessage.setVisible(true);
						    lblMessage.setText("Erreur Il y a moins de "+Titreautre6+" que d'email");

						}
						
					}
					else {
						c.setDetailautre6(null);
						c.setTitreautre6(null);
					}
					if (CountWindow == 7) {
						try {
							c.setTitreautre(Titreautre);
							c.setDetailautre(DetailAutre[i]);
							c.setTitreautre2(Titreautre2);
							c.setDetailautre2(DetailAutre2[i]);
							c.setDetailautre3(DetailAutre3[i]);
							c.setTitreautre3(Titreautre3);
							c.setDetailautre4(DetailAutre4[i]);
							c.setTitreautre4(Titreautre4);
							c.setDetailautre5(DetailAutre5[i]);
							c.setTitreautre5(Titreautre5);
							c.setDetailautre6(DetailAutre6[i]);
							c.setTitreautre6(Titreautre6);
							c.setDetailautre7(DetailAutre7[i]);
							c.setTitreautre7(Titreautre7);
						} catch (Exception e2) {
						    lblMessage.setVisible(true);
						    lblMessage.setText("Erreur Il y a moins de "+Titreautre7+" que d'email");
						}
						
					}
					else {
						c.setDetailautre7(null);
						c.setTitreautre7(null);
					}
					if (CountWindow == 8) {
						try {
							c.setTitreautre(Titreautre);
							c.setDetailautre(DetailAutre[i]);
							c.setTitreautre2(Titreautre2);
							c.setDetailautre2(DetailAutre2[i]);
							c.setDetailautre3(DetailAutre3[i]);
							c.setTitreautre3(Titreautre3);
							c.setDetailautre4(DetailAutre4[i]);
							c.setTitreautre4(Titreautre4);
							c.setDetailautre5(DetailAutre5[i]);
							c.setTitreautre5(Titreautre5);
							c.setDetailautre6(DetailAutre6[i]);
							c.setTitreautre6(Titreautre6);
							c.setDetailautre7(DetailAutre7[i]);
							c.setTitreautre7(Titreautre7);
							c.setDetailautre8(DetailAutre8[i]);
							c.setTitreautre8(Titreautre8);
						} catch (Exception e2) {
						    lblMessage.setVisible(true);
						    lblMessage.setText("Erreur Il y a moins de "+Titreautre8+" que d'email");
						}
						
					}
					else {
						c.setDetailautre8(null);
						c.setTitreautre8(null);
					}
					contacts.getListcontacts().add(c);
					}
					JAXBContext context;
					try {
							context = JAXBContext.newInstance(ListContacts.class);
					       Marshaller m = context.createMarshaller();
					       m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
					       m.marshal(contacts,new File("ListesContact\\"+TxbNameFile.getText()+".xml"));
					       TxbNameFile.setText("");
					       lblMessage.setVisible(true);
					       lblMessage.setText("Votre Liste de contact a bien été crée");
					       frmSeoladh.dispose();
					       ViewContact inter = new ViewContact();
					       inter.main(null);
					       
					} catch (JAXBException e1) {
					    lblMessage.setVisible(true);
					    lblMessage.setText("Erreur veuillez verifier les champs");
						e1.printStackTrace();

					}
				}

				
			}
			
		});

		btnNewElem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) tableListe.getModel();
				tableListe.setColumnSelectionAllowed(true);
			    tableListe.setRowSelectionAllowed(true);
			    if (tableListe.getCellEditor() != null) {
			    	tableListe.getCellEditor().stopCellEditing();
			    }
				if (!TxbNewElement.getText().equals("")) {
				CountWindow = CountWindow + 1;
				switch (CountWindow) {
				case 1:
					model.addColumn(TxbNewElement.getText());
					break;
				case 2:
					model.addColumn(TxbNewElement.getText());
					break;
				case 3:
					model.addColumn(TxbNewElement.getText());
					break;
				case 4:
					model.addColumn(TxbNewElement.getText());
					break;
				case 5:
					model.addColumn(TxbNewElement.getText());
					break;
				case 6:
					model.addColumn(TxbNewElement.getText());
					break;
				case 7:
					model.addColumn(TxbNewElement.getText());
					break;
				case 8:
					model.addColumn(TxbNewElement.getText());
					break;
				default:
					CountWindow = 8;
					break;
				}
				TxbNewElement.setText("");
				
				}
				else {
					lblMessage.setVisible(true);
				    lblMessage.setText("Erreur veuillez rentré un nom dans le champs texte pour crée un nouvelle éléments");
				}
			}
		});
		
		JButton btnDeleteElem = new JButton("Supprimer \u00E9l\u00E9ment");
		btnDeleteElem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) tableListe.getModel();
				tableListe.setColumnSelectionAllowed(true);
			    tableListe.setRowSelectionAllowed(true);
			    if (tableListe.getCellEditor() != null) {
			    	tableListe.getCellEditor().stopCellEditing();
			    }
				switch (CountWindow) {
				case 1:
					model.setColumnCount(CountWindow+4-1);
					break;
				case 2:
					model.setColumnCount(CountWindow+4-1);
					break;
				case 3:
					model.setColumnCount(CountWindow+4-1);
					break;
				case 4:
					model.setColumnCount(CountWindow+4-1);
					break;
				case 5:
					model.setColumnCount(CountWindow+4-1);
					break;
				case 6:
					model.setColumnCount(CountWindow+4-1);
					break;
				case 7:
					model.setColumnCount(CountWindow+4-1);
					break;
				case 8:
					model.setColumnCount(CountWindow+4-1);
					break;
				default:
					CountWindow = 0;
					break;
				}
				if(CountWindow != 0) {
				CountWindow = CountWindow - 1;
				}
				
			}
		});
		
		JLabel LabelPicture = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Seoladh.png")).getImage();
		LabelPicture.setIcon(new ImageIcon(img));
		
		JLabel lblNewLabel_7 = new JLabel("Gestion Listes");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 25));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnAddLigne = new JButton("Ajouter Ligne");
		btnAddLigne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) tableListe.getModel();
				model.setRowCount(model.getRowCount()+1);
			}
		});
		
		JButton btnDeleteLigne = new JButton("Supprimer Ligne");
		btnDeleteLigne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) tableListe.getModel();
				model.setRowCount(model.getRowCount()-1);
			}
		});


		
		
		GroupLayout groupLayout = new GroupLayout(frmSeoladh.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(LabelPicture, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
							.addGap(37)
							.addComponent(lblNewLabel_7))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(51)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 903, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(TxbNewElement, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(41)
									.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(TxbNameFile)))
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnCreate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewElem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(31)
									.addComponent(btnDeleteElem)
									.addGap(31)
									.addComponent(btnAddLigne)
									.addGap(18)
									.addComponent(btnDeleteLigne, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(lblMessage, GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE)))))
					.addGap(26))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addComponent(LabelPicture, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addComponent(lblNewLabel_7)))
					.addGap(87)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 445, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCreate)
						.addComponent(TxbNameFile, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(lblMessage, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(btnNewElem)
						.addComponent(btnDeleteElem)
						.addComponent(TxbNewElement, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddLigne)
						.addComponent(btnDeleteLigne))
					.addGap(163))
		);
		
		tableListe = new JTable();
		tableListe.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Email", "Nom", "Pr\u00E9nom", "Date de naissance"
			}
		));
		LabelPicture.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmSeoladh.dispose();
				FirstPage inter = new FirstPage();
				
			}
		});
		tableListe.getColumnModel().getColumn(3).setPreferredWidth(140);
		scrollPane.setViewportView(tableListe);
		frmSeoladh.getContentPane().setLayout(groupLayout);
		System.out.println(LabelPicture.getBounds());
	}
}
