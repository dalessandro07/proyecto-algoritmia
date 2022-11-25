package proyecto;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

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
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		setTitle("Configurar cantidad \u00F3ptima");
		setBounds(100, 100, 495, 120);
		getContentPane().setLayout(null);

		lblCantOpt = new JLabel("Cantidad \u00F3ptima de unidades vendidas");
		lblCantOpt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantOpt.setBounds(10, 15, 241, 14);
		getContentPane().add(lblCantOpt);

		txtCantOpt = new JTextField();
		txtCantOpt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCantOpt.setBounds(261, 12, 77, 20);
		getContentPane().add(txtCantOpt);
		txtCantOpt.setColumns(10);
		txtCantOpt.setText("" + frmPrincipal.cantidadOptima);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAceptar.setBackground(new Color(0, 153, 255));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(380, 11, 89, 23);
		getContentPane().add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBackground(new Color(255, 153, 153));
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
