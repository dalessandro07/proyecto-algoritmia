package proyecto;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgConfigurarCantidadOptima extends JDialog implements ActionListener {
	private JLabel lblCantOpt;
	private JTextField txtCantOpt;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgConfigurarCantidadOptima dialog = new DlgConfigurarCantidadOptima();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DlgConfigurarCantidadOptima() {
		setBounds(100, 100, 495, 120);
		getContentPane().setLayout(null);
		
		lblCantOpt = new JLabel("Cantidad \u00F3ptima de unidades vendidas");
		lblCantOpt.setBounds(10, 15, 231, 14);
		getContentPane().add(lblCantOpt);
		
		txtCantOpt = new JTextField();
		txtCantOpt.setBounds(239, 12, 77, 20);
		getContentPane().add(txtCantOpt);
		txtCantOpt.setColumns(10);
		txtCantOpt.setText(""+frmPrincipal.cantidadOptima);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(380, 11, 89, 23);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(380, 45, 89, 23);
		getContentPane().add(btnCancelar);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}
	
	
	
	protected void actionPerformedBtnAceptar(ActionEvent e) {
			frmPrincipal.cantidadOptima = Integer.parseInt(txtCantOpt.getText());
			dispose();
		
		}
		
		
	
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
	
	
}
