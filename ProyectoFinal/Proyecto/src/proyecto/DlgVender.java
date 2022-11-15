package proyecto;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DlgVender extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblModelo;
	private JComboBox<String> cboModelo;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JScrollPane scp;
	private JTextArea txtS;
	private JLabel lblCantidad;
	private JTextField txtCantidad;

	public int contador = 0;
	public double totalImportes = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgVender dialog = new DlgVender();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgVender() {
		setTitle("Vender");
		setBounds(100, 100, 452, 290);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 25, 80, 14);
		contentPanel.add(lblModelo);

		cboModelo = new JComboBox<String>();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Cinza Plus", "Luxury", "Austria", "Yungay Mix", "Thalia" }));
		cboModelo.setBounds(100, 21, 148, 22);
		contentPanel.add(cboModelo);

		lblPrecio = new JLabel("Precio (S/.)");
		lblPrecio.setBounds(10, 50, 80, 14);
		contentPanel.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(100, 47, 148, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(325, 21, 89, 23);
		contentPanel.add(btnProcesar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(325, 46, 89, 23);
		contentPanel.add(btnBorrar);

		scp = new JScrollPane();
		scp.setBounds(10, 98, 404, 142);
		contentPanel.add(scp);

		txtS = new JTextArea();
		txtS.setEditable(false);
		scp.setViewportView(txtS);

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 73, 80, 14);
		contentPanel.add(lblCantidad);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(100, 70, 148, 20);
		contentPanel.add(txtCantidad);
		txtCantidad.setColumns(10);

		txtPrecio.setText("" + frmPrincipal.precio0);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(e);
		}
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
		if (e.getSource() == cboModelo) {
			actionPerformedcbo(e);
		}
	}

	protected void actionPerformedcbo(ActionEvent e) {
		int modelo;

		modelo = cboModelo.getSelectedIndex();

		switch (modelo) {
		case 0:
			txtPrecio.setText("" + frmPrincipal.precio0);
			break;
		case 1:
			txtPrecio.setText("" + frmPrincipal.precio1);
			break;
		case 2:
			txtPrecio.setText("" + frmPrincipal.precio2);
			break;
		case 3:
			txtPrecio.setText("" + frmPrincipal.precio3);
			break;
		default:
			txtPrecio.setText("" + frmPrincipal.precio4);
			break;

		}
	}

	protected void actionPerformedBtnProcesar(ActionEvent e) {
		contador++;

		// Declaración de variables
		int cantidad = 0, canobsequio;
		double impD, impC, impP, precio;
		String modelo1, tipo;

		// Validación de campo cantidad
		if (validarNumeros(txtCantidad.getText().trim())) {
			cantidad = Integer.parseInt(txtCantidad.getText());
		} else {
			JOptionPane.showMessageDialog(null, "Sólo se puede ingresar números", "Datos inválidos",
					JOptionPane.WARNING_MESSAGE);
			actionPerformedBtnBorrar(e);
			return;
		}

		// Lectura de datos
		modelo1 = "" + cboModelo.getSelectedItem();
		precio = Double.parseDouble(txtPrecio.getText());
		tipo = frmPrincipal.tipoObsequio;

		// Calculando el importe de compra
		switch (cboModelo.getSelectedIndex()) {
		case 0:
			impC = cantidad * frmPrincipal.precio0;
			break;
		case 1:
			impC = cantidad * frmPrincipal.precio1;
			break;
		case 2:
			impC = cantidad * frmPrincipal.precio2;
			break;
		case 3:
			impC = cantidad * frmPrincipal.precio3;
			break;
		default:
			impC = cantidad * frmPrincipal.precio4;
			break;
		}

		// Calculando el importe de descuento
		if (cantidad <= 5)
			impD = impC / 100 * frmPrincipal.porcentaje1;
		else if (cantidad <= 10)
			impD = impC / 100 * frmPrincipal.porcentaje2;
		else if (cantidad <= 15)
			impD = impC / 100 * frmPrincipal.porcentaje3;
		else
			impD = impC / 100 * frmPrincipal.porcentaje4;

		// Calculando el importe a pagar
		impP = impC - impD;

		// Asignando el total de importes
		totalImportes += impP;

		// Calculando el obsequio
		if (cantidad <= 5)
			canobsequio = cantidad * frmPrincipal.obsequioCantidad1;
		else if (cantidad <= 10)
			canobsequio = cantidad * frmPrincipal.obsequioCantidad2;
		else
			canobsequio = cantidad * frmPrincipal.obsequioCantidad3;

		// Salida de resultados
		txtS.setText("Boleta de Venta \n\n");
		txtS.append("Modelo\t\t: " + modelo1 + "\n");
		txtS.append("Precio\t\t: S/." + precio + "\n");
		txtS.append("Cantidad Adquirida\t: " + cantidad + "\n");
		txtS.append("Importe de Compra\t: S/." + impC + "\n");
		txtS.append("Importe de Descuento\t: S/." + impD + "\n");
		txtS.append("Importe a Pagar\t: S/." + impP + "\n");
		txtS.append("Tipo de obsequio\t: " + tipo + "\n");
		txtS.append("Unidades obsequiadas\t: " + canobsequio + "\n");

		// Mensaje de alerta
		if (contador % 5 == 0) {
			String mensaje;
			double porcentaje;

			porcentaje = totalImportes * 100 / frmPrincipal.cuotaDiaria;
			mensaje = "Venta Nro. " + contador + "\n" + "Importe total general acumulado: S/. " + totalImportes + "\n"
					+ "Porcentaje de la cuota diaria: " + porcentaje + "%";

			JOptionPane.showMessageDialog(null, mensaje, "Avance de ventas", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	private static boolean validarNumeros(String datos) {
		return datos.length() > 0 && datos.matches("[0-9]*");
	}

	protected void actionPerformedBtnBorrar(ActionEvent e) {
		txtCantidad.setText("");
		txtS.setText("");
		cboModelo.setSelectedIndex(0);
		txtCantidad.requestFocus();
	}
}
