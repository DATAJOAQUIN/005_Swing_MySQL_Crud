package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import config.Conexion;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import java.awt.event.ActionListener;
//import java.security.Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frmAccesoADatos;
	private JTextField txtUsuario;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmAccesoADatos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAccesoADatos = new JFrame();
		frmAccesoADatos.getContentPane().setBackground(Color.CYAN);
		frmAccesoADatos.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.ORANGE);
		lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNombre.setBounds(155, 40, 99, 38);
		frmAccesoADatos.getContentPane().add(lblNombre);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(Color.ORANGE);
		lblContrasea.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblContrasea.setBounds(155, 96, 99, 38);
		frmAccesoADatos.getContentPane().add(lblContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.setBackground(Color.GREEN);
		txtUsuario.setBounds(308, 51, 160, 20);
		frmAccesoADatos.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBackground(Color.GREEN);
		txtPassword.setBounds(308, 107, 160, 20);
		frmAccesoADatos.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnLogin = new JButton("Acceder");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				acceder();
			}
		});
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setBackground(Color.GREEN);
		btnLogin.setBounds(191, 183, 200, 60);
		frmAccesoADatos.getContentPane().add(btnLogin);
		frmAccesoADatos.setTitle("Acceso a datos");
		
		frmAccesoADatos.setBounds(100, 100, 599, 341);
		frmAccesoADatos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void acceder() {
		Connection conn=new Conexion().conectar();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM user where username=? AND password=?");
			ps.setString(1,txtUsuario.getText());
			ps.setString(2, txtPassword.getText());
			
			ResultSet rs= ps.executeQuery();//ejecutar la select
			
			//System.out.println(rs.next());
			
			if (rs.next()) {
				Principal p= new Principal() ;
				p.frmVentanaPrincipal.show();
			}else {
				JOptionPane.showMessageDialog(null, "error de login");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//cierra acceder
	
}//cierra clase
