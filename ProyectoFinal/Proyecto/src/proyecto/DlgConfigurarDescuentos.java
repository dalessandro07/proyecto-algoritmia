package proyecto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DlgConfigurarDescuentos extends JDialog implements ActionListener {
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JTextField txtMonto;
	private JTextField txtMonto1;
	private JTextField txtMonto2;
	private JTextField txtMonto3;
	private JLabel lblla5unidades;
	private JLabel lbl5a10unidades;
	private JLabel lbl11a15unidades;
	private JLabel lblmas15deunidades;
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
		setTitle("Configurar porcentajes de descuentos");
		getContentPane().setForeground(Color.BLACK);
		setBounds(100, 100, 450, 208);
		getContentPane().setLayout(null);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setForeground(Color.BLACK);
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(311, 51, 102, 23);
		getContentPane().add(btnAceptar);

		btnCancelar = new JButton("  Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(311, 85, 102, 23);
		getContentPane().add(btnCancelar);

		txtMonto = new JTextField();
		txtMonto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMonto.setText("7.5");
		txtMonto.setHorizontalAlignment(SwingConstants.LEFT);
		txtMonto.setBounds(145, 26, 86, 20);
		getContentPane().add(txtMonto);
		txtMonto.setColumns(10);

		txtMonto1 = new JTextField();
		txtMonto1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMonto1.setText("10.0");
		txtMonto1.setBounds(145, 57, 86, 20);
		getContentPane().add(txtMonto1);
		txtMonto1.setColumns(10);

		txtMonto2 = new JTextField();
		txtMonto2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMonto2.setText("12.5");
		txtMonto2.setBounds(145, 88, 86, 20);
		getContentPane().add(txtMonto2);
		txtMonto2.setColumns(10);

		txtMonto3 = new JTextField();
		txtMonto3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMonto3.setText("15.0");
		txtMonto3.setBounds(145, 121, 86, 20);
		getContentPane().add(txtMonto3);
		txtMonto3.setColumns(10);

		lblla5unidades = new JLabel("1 a 5 unidades");
		lblla5unidades.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblla5unidades.setBounds(10, 29, 97, 14);
		getContentPane().add(lblla5unidades);

		lbl5a10unidades = new JLabel("6 a 10 unidades");
		lbl5a10unidades.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl5a10unidades.setBounds(10, 60, 115, 14);
		getContentPane().add(lbl5a10unidades);

		lbl11a15unidades = new JLabel("11 a 15 unidades");
		lbl11a15unidades.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl11a15unidades.setBounds(10, 91, 115, 14);
		getContentPane().add(lbl11a15unidades);

		lblmas15deunidades = new JLabel("mas de 15 unidades");
		lblmas15deunidades.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblmas15deunidades.setBounds(10, 122, 125, 14);
		getContentPane().add(lblmas15deunidades);

		lblPorcentaje = new JLabel("%");
		lblPorcentaje.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPorcentaje.setBounds(235, 31, 46, 14);
		getContentPane().add(lblPorcentaje);

		lblPorcentaje1 = new JLabel("%");
		lblPorcentaje1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPorcentaje1.setBounds(235, 60, 46, 14);
		getContentPane().add(lblPorcentaje1);

		lblPorcentaje2 = new JLabel("%");
		lblPorcentaje2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPorcentaje2.setBounds(235, 91, 46, 14);
		getContentPane().add(lblPorcentaje2);

		lblPorcentaje3 = new JLabel("%");
		lblPorcentaje3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPorcentaje3.setForeground(Color.BLACK);
		lblPorcentaje3.setBounds(235, 124, 46, 14);
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

		dispose();

	}

	protected void actionPerformedBtnCancelar(ActionEvent e) {

		dispose();

	}
}
