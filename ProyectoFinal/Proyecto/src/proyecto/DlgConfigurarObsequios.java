package proyecto;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DlgConfigurarObsequios extends JDialog implements ActionListener, KeyListener {
	private JTextField txtTipoObsequio;
	private JTextField txtObsequioCantidad1;
	private JTextField txtObsequioCantidad2;
	private JTextField txtObsequioCantidad3;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConfigurarObsequios dialog = new DlgConfigurarObsequios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConfigurarObsequios() {
		getContentPane().setBackground(SystemColor.control);
		setTitle("Configurar Obsequios");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JLabel lblTipoObsequio = new JLabel("Tipo de Obsequio");
		lblTipoObsequio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipoObsequio.setBounds(10, 31, 128, 19);
		getContentPane().add(lblTipoObsequio);

		JLabel lblObsequioCantidad1 = new JLabel("1 a 5 Unidades");
		lblObsequioCantidad1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblObsequioCantidad1.setBounds(10, 93, 128, 19);
		getContentPane().add(lblObsequioCantidad1);

		JLabel lblObsequioCantidad2 = new JLabel("6 a 10 Unidades");
		lblObsequioCantidad2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblObsequioCantidad2.setBounds(10, 153, 128, 18);
		getContentPane().add(lblObsequioCantidad2);

		JLabel lblObsequioCantidad3 = new JLabel("11 a m\u00E1s Unidades");
		lblObsequioCantidad3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblObsequioCantidad3.setBounds(10, 217, 128, 18);
		getContentPane().add(lblObsequioCantidad3);

		txtTipoObsequio = new JTextField();
		txtTipoObsequio.addKeyListener(this);
		txtTipoObsequio.setForeground(new Color(0, 0, 0));
		txtTipoObsequio.setBackground(new Color(255, 255, 255));
		txtTipoObsequio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTipoObsequio.setBounds(148, 31, 96, 19);
		getContentPane().add(txtTipoObsequio);
		txtTipoObsequio.setColumns(10);
		txtTipoObsequio.setText(frmPrincipal.tipoObsequio);

		txtObsequioCantidad1 = new JTextField();
		txtObsequioCantidad1.addKeyListener(this);
		txtObsequioCantidad1.setBackground(new Color(255, 255, 255));
		txtObsequioCantidad1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtObsequioCantidad1.setColumns(10);
		txtObsequioCantidad1.setBounds(148, 93, 96, 19);
		getContentPane().add(txtObsequioCantidad1);
		txtObsequioCantidad1.setText("" + frmPrincipal.obsequioCantidad1);

		txtObsequioCantidad2 = new JTextField();
		txtObsequioCantidad2.addKeyListener(this);
		txtObsequioCantidad2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtObsequioCantidad2.setColumns(10);
		txtObsequioCantidad2.setBounds(148, 153, 96, 19);
		getContentPane().add(txtObsequioCantidad2);
		txtObsequioCantidad2.setText("" + frmPrincipal.obsequioCantidad2);

		txtObsequioCantidad3 = new JTextField();
		txtObsequioCantidad3.addKeyListener(this);
		txtObsequioCantidad3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtObsequioCantidad3.setColumns(10);
		txtObsequioCantidad3.setBounds(148, 217, 96, 19);
		getContentPane().add(txtObsequioCantidad3);
		txtObsequioCantidad3.setText("" + frmPrincipal.obsequioCantidad3);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(new Color(0, 153, 255));
		btnAceptar.addActionListener(this);
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAceptar.setBounds(296, 32, 109, 31);
		getContentPane().add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(255, 153, 153));
		btnCancelar.addActionListener(this);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(296, 94, 109, 31);
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

		frmPrincipal.tipoObsequio = txtTipoObsequio.getText();
		frmPrincipal.obsequioCantidad1 = Integer.parseInt(txtObsequioCantidad1.getText());
		frmPrincipal.obsequioCantidad2 = Integer.parseInt(txtObsequioCantidad2.getText());
		frmPrincipal.obsequioCantidad3 = Integer.parseInt(txtObsequioCantidad3.getText());

		dispose();
	}

	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}

	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtObsequioCantidad3) {
			keyTypedTxtObsequioCantidad3(e);
		}
		if (e.getSource() == txtObsequioCantidad2) {
			keyTypedTxtObsequioCantidad2(e);
		}
		if (e.getSource() == txtObsequioCantidad1) {
			keyTypedTxtObsequioCantidad1(e);
		}
		if (e.getSource() == txtTipoObsequio) {
			keyTypedTxtTipoObsequio(e);
		}
	}

	public void keyTypedTxtTipoObsequio(KeyEvent e) {

		char validar = e.getKeyChar();

		if (Character.isDigit(validar)) {
			getToolkit().beep();
			e.consume();

			JOptionPane.showMessageDialog(rootPane, "Por favor, ingresar solo letras ¡Gracias!");
		}
	}

	private void keyTypedTxtObsequioCantidad1(KeyEvent e) {
		// TODO Auto-generated method stub

		char validar = e.getKeyChar();

		if (Character.isLetter(validar)) {
			getToolkit().beep();
			e.consume();

			JOptionPane.showMessageDialog(rootPane, "Por favor, ingresar solo numeros ¡Gracias!");
		}
	}

	private void keyTypedTxtObsequioCantidad2(KeyEvent e) {
		// TODO Auto-generated method stub

		char validar = e.getKeyChar();

		if (Character.isLetter(validar)) {
			getToolkit().beep();
			e.consume();

			JOptionPane.showMessageDialog(rootPane, "Por favor, ingresar solo numeros ¡Gracias!");
		}
	}

	protected void keyTypedTxtObsequioCantidad3(KeyEvent e) {
		char validar = e.getKeyChar();

		if (Character.isLetter(validar)) {
			getToolkit().beep();
			e.consume();

			JOptionPane.showMessageDialog(rootPane, "Por favor, ingresar solo numeros ¡Gracias!");
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
