package proyecto;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DlgConfigurarCuotaDiaria extends JDialog implements ActionListener {
	private JLabel lblCuotaDiaria;
	private JTextField txtCuotaDiaria;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgConfigurarCuotaDiaria dialog = new DlgConfigurarCuotaDiaria();
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
	public DlgConfigurarCuotaDiaria() {
		setTitle("Configurar cuota diaria");
		setBounds(100, 100, 450, 132);
		getContentPane().setLayout(null);

		lblCuotaDiaria = new JLabel("Cuota diaria esperada (S/.)");
		lblCuotaDiaria.setBounds(10, 26, 158, 14);
		getContentPane().add(lblCuotaDiaria);

		txtCuotaDiaria = new JTextField();
		txtCuotaDiaria.setBounds(178, 23, 126, 20);
		getContentPane().add(txtCuotaDiaria);
		txtCuotaDiaria.setColumns(10);
		txtCuotaDiaria.setText("" + frmPrincipal.cuotaDiaria);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(337, 22, 89, 23);
		getContentPane().add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(337, 56, 89, 23);
		getContentPane().add(btnCancelar);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}

	protected void actionPerformedBtnAceptar(ActionEvent e) {
		if (validarNumeros(txtCuotaDiaria.getText().trim())) {
			frmPrincipal.cuotaDiaria = Double.parseDouble(txtCuotaDiaria.getText());
			dispose();
		} else {
			String mensaje, titulo;

			titulo = "Datos Incorrectos";
			mensaje = "Solo se permite el ingreso de números";

			JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
			txtCuotaDiaria.requestFocus();
			txtCuotaDiaria.setText("");
		}

	}

	private static boolean validarNumeros(String datos) {
		return datos.length() > 0 && datos.matches("[0-9]*\\.?[0-9]*");
	}

	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
}
