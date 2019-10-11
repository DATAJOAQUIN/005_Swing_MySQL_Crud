package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;

public class Principal {

	public JFrame frmVentanaPrincipal;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmVentanaPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVentanaPrincipal = new JFrame();
		frmVentanaPrincipal.getContentPane().setBackground(Color.GREEN);
		frmVentanaPrincipal.getContentPane().setForeground(Color.BLACK);
		frmVentanaPrincipal.setTitle("Ventana principal");
		frmVentanaPrincipal.setBounds(100, 100, 639, 349);
		frmVentanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVentanaPrincipal.getContentPane().setLayout(null);
		
		JLabel lblAccesoOk = new JLabel("ACCESO OK");
		lblAccesoOk.setForeground(Color.MAGENTA);
		lblAccesoOk.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblAccesoOk.setBounds(28, 23, 228, 56);
		frmVentanaPrincipal.getContentPane().add(lblAccesoOk);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"id", "usuario", "contrase\u00F1a", "estatus"},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(119, 119, 375, 130);
		frmVentanaPrincipal.getContentPane().add(table);
	}
}
