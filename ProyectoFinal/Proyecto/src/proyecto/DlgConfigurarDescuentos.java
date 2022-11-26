package proyecto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DlgConfigurarDescuentos extends JDialog implements ActionListener {
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JTextField txtPorcentaje1;
	private JTextField txtPorcentaje2;
	private JTextField txtPorcentaje3;
	private JTextField txtPorcentaje4;
	private JLabel lblDesc1;
	private JLabel lblDesc2;
	private JLabel lblDesc3;
	private JLabel lblDesc4;
	private JLabel lblPorcentaje;
	private JLabel lblPorcentaje1;
	private JLabel lblPorcentaje2;
	private JLabel lblPorcentaje3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgConfigurarDescuentos dialog = new DlgConfigurarDescuentos();
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
	public DlgConfigurarDescuentos() {
		setTitle("Configurar porcentajes de descuento");
		getContentPane().setForeground(Color.BLACK);
		setBounds(100, 100, 450, 208);
		getContentPane().setLayout(null);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(new Color(0, 153, 255));
		btnAceptar.setForeground(Color.BLACK);
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(311, 51, 102, 23);
		getContentPane().add(btnAceptar);

		btnCancelar = new JButton("  Cancelar");
		btnCancelar.setBackground(new Color(255, 153, 153));
		btnCancelar.addActionListener(this);
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(311, 85, 102, 23);
		getContentPane().add(btnCancelar);

		txtPorcentaje1 = new JTextField();
		txtPorcentaje1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPorcentaje1.setHorizontalAlignment(SwingConstants.LEFT);
		txtPorcentaje1.setBounds(143, 26, 102, 20);
		getContentPane().add(txtPorcentaje1);
		txtPorcentaje1.setColumns(10);
		txtPorcentaje1.setText("" + frmPrincipal.porcentaje1);

		txtPorcentaje2 = new JTextField();
		txtPorcentaje2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPorcentaje2.setBounds(143, 56, 102, 20);
		getContentPane().add(txtPorcentaje2);
		txtPorcentaje2.setColumns(10);
		txtPorcentaje2.setText("" + frmPrincipal.porcentaje2);

		txtPorcentaje3 = new JTextField();
		txtPorcentaje3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPorcentaje3.setBounds(143, 87, 102, 20);
		getContentPane().add(txtPorcentaje3);
		txtPorcentaje3.setColumns(10);
		txtPorcentaje3.setText("" + frmPrincipal.porcentaje3);

		txtPorcentaje4 = new JTextField();
		txtPorcentaje4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPorcentaje4.setBounds(143, 120, 102, 20);
		getContentPane().add(txtPorcentaje4);
		txtPorcentaje4.setColumns(10);
		txtPorcentaje4.setText("" + frmPrincipal.porcentaje4);

		lblDesc1 = new JLabel("1 a 5 unidades");
		lblDesc1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDesc1.setBounds(10, 29, 115, 14);
		getContentPane().add(lblDesc1);

		lblDesc2 = new JLabel("6 a 10 unidades");
		lblDesc2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDesc2.setBounds(10, 60, 115, 14);
		getContentPane().add(lblDesc2);

		lblDesc3 = new JLabel("11 a 15 unidades");
		lblDesc3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDesc3.setBounds(10, 91, 125, 14);
		getContentPane().add(lblDesc3);

		lblDesc4 = new JLabel("M\u00E1s de 15 unidades");
		lblDesc4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDesc4.setBounds(10, 122, 133, 14);
		getContentPane().add(lblDesc4);

		lblPorcentaje = new JLabel("%");
		lblPorcentaje.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPorcentaje.setBounds(255, 32, 46, 14);
		getContentPane().add(lblPorcentaje);

		lblPorcentaje1 = new JLabel("%");
		lblPorcentaje1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPorcentaje1.setBounds(255, 60, 46, 14);
		getContentPane().add(lblPorcentaje1);

		lblPorcentaje2 = new JLabel("%");
		lblPorcentaje2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPorcentaje2.setBounds(255, 89, 46, 14);
		getContentPane().add(lblPorcentaje2);

		lblPorcentaje3 = new JLabel("%");
		lblPorcentaje3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPorcentaje3.setForeground(Color.BLACK);
		lblPorcentaje3.setBounds(255, 123, 46, 14);
		getContentPane().add(lblPorcentaje3);

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

		// Validación de campo porcentaje

		if (!validarNumeros(txtPorcentaje1.getText().trim()) || !validarNumeros(txtPorcentaje2.getText().trim())
				|| !validarNumeros(txtPorcentaje3.getText().trim())
				|| !validarNumeros(txtPorcentaje4.getText().trim())) {
			mostrarAlerta("Sólo se puede ingresar números", "Datos inválidos", JOptionPane.WARNING_MESSAGE);
			return;
		}

		frmPrincipal.porcentaje1 = asignarPorcentaje(txtPorcentaje1.getText());
		frmPrincipal.porcentaje2 = asignarPorcentaje(txtPorcentaje2.getText());
		frmPrincipal.porcentaje3 = asignarPorcentaje(txtPorcentaje3.getText());
		frmPrincipal.porcentaje4 = asignarPorcentaje(txtPorcentaje4.getText());
		dispose();

	}

	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}

	// Método - Asignar porcentaje
	double asignarPorcentaje(String porcentaje) {
		return Double.parseDouble(porcentaje);
	}

	// Método - Mostrar alerta
	void mostrarAlerta(String mensaje, String titulo, int icono) {
		JOptionPane.showMessageDialog(this, mensaje, titulo, icono);
	}

	// Método - Validar números
	boolean validarNumeros(String datos) {
		return datos.length() > 0 && datos.matches("[0-9]*\\.?[0-9]*");
	}

}
