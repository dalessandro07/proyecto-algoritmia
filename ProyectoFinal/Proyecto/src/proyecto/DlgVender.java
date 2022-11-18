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
import java.awt.Color;
import java.awt.Font;

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
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModelo.setBounds(10, 25, 80, 14);
		contentPanel.add(lblModelo);

		cboModelo = new JComboBox<String>();
		cboModelo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboModelo.setBackground(new Color(255, 255, 204));
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Cinza Plus", "Luxury", "Austria", "Yungay Mix", "Thalia" }));
		cboModelo.setBounds(100, 21, 148, 22);
		contentPanel.add(cboModelo);

		lblPrecio = new JLabel("Precio (S/.)");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecio.setBounds(10, 50, 80, 14);
		contentPanel.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(100, 47, 148, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);

		btnProcesar = new JButton("Procesar");
		btnProcesar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnProcesar.setBackground(new Color(255, 153, 153));
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(325, 21, 89, 23);
		contentPanel.add(btnProcesar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBorrar.setBackground(new Color(0, 153, 255));
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(325, 46, 89, 23);
		contentPanel.add(btnBorrar);

		scp = new JScrollPane();
		scp.setBounds(10, 98, 404, 142);
		contentPanel.add(scp);

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantidad.setBounds(10, 73, 80, 14);
		contentPanel.add(lblCantidad);

		txtCantidad = new JTextField();
		txtCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCantidad.setBounds(100, 70, 148, 20);
		contentPanel.add(txtCantidad);
		txtCantidad.setColumns(10);

		txtPrecio.setText("" + frmPrincipal.precio0);
		
				txtS = new JTextArea();
				txtS.setBounds(12, 99, 402, 140);
				contentPanel.add(txtS);
				txtS.setEditable(false);
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
			mostrarAlerta("Sólo se puede ingresar números", "Datos inválidos", JOptionPane.WARNING_MESSAGE);
			actionPerformedBtnBorrar(e);
			return;
		}

		// Lectura de datos
		modelo1 = "" + cboModelo.getSelectedItem();
		precio = Double.parseDouble(txtPrecio.getText());
		tipo = frmPrincipal.tipoObsequio;

		// Calculando el importe de compra
		impC = calcularImporteCompra(cantidad);

		// Calculando el importe de descuento
		impD = calcularImporteDescuento(impC, cantidad);

		// Calculando el importe a pagar
		impP = calcularImporteAPagar(impC, impD);

		// Asignando el total de importes
		totalImportes += impP;

		// Calculando el obsequio
		canobsequio = calcularObsequio(cantidad);

		// Salida de resultados
		txtS.setText("Boleta de Venta \n\n");
		imprimir("Modelo\t\t: " + modelo1);
		imprimir("Precio\t\t: S/." + precio);
		imprimir("Cantidad Adquirida\t: " + cantidad);
		imprimir("Importe de Compra\t: S/." + impC);
		imprimir("Importe de Descuento\t: S/." + impD);
		imprimir("Importe a Pagar\t: S/." + impP);
		imprimir("Tipo de obsequio\t: " + tipo);
		imprimir("Unidades obsequiadas\t: " + canobsequio);

		// Mensaje de alerta
		if (contador % 5 == 0) {
			String mensaje, titulo;
			double porcentaje;

			porcentaje = totalImportes * 100 / frmPrincipal.cuotaDiaria;
			mensaje = "Venta Nro. " + contador + "\n" + "Importe total general acumulado: S/. " + totalImportes + "\n"
					+ "Porcentaje de la cuota diaria: " + porcentaje + "%";
			titulo = "Avance de ventas";

			mostrarAlerta(mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
		}

	}

	protected void actionPerformedBtnBorrar(ActionEvent e) {
		txtCantidad.setText("");
		txtS.setText("");
		cboModelo.setSelectedIndex(0);
		txtCantidad.requestFocus();
	}

	// Método - Importe de compra
	double calcularImporteCompra(int cantidad) {
		switch (cboModelo.getSelectedIndex()) {
		case 0:
			return cantidad * frmPrincipal.precio0;
		case 1:
			return cantidad * frmPrincipal.precio1;
		case 2:
			return cantidad * frmPrincipal.precio2;
		case 3:
			return cantidad * frmPrincipal.precio3;
		default:
			return cantidad * frmPrincipal.precio4;
		}
	}

	// Método - Importe de descuento
	double calcularImporteDescuento(double impC, int cantidad) {
		if (cantidad <= 5)
			return impC / 100 * frmPrincipal.porcentaje1;
		else if (cantidad <= 10)
			return impC / 100 * frmPrincipal.porcentaje2;
		else if (cantidad <= 15)
			return impC / 100 * frmPrincipal.porcentaje3;
		else
			return impC / 100 * frmPrincipal.porcentaje4;
	}

	// Método - Importe a pagar
	double calcularImporteAPagar(double impC, double impD) {
		return impC - impD;
	}

	// Método - Obsequio
	int calcularObsequio(int cantidad) {
		if (cantidad <= 5)
			return cantidad * frmPrincipal.obsequioCantidad1;
		else if (cantidad <= 10)
			return cantidad * frmPrincipal.obsequioCantidad2;
		else
			return cantidad * frmPrincipal.obsequioCantidad3;
	}

	// Método - Mostrar resultados
	void imprimir(String texto) {
		txtS.append(texto + "\n");
	}

	// Método - Mostrar alerta
	void mostrarAlerta(String mensaje, String titulo, int icono) {
		JOptionPane.showMessageDialog(this, mensaje, titulo, icono);
	}

	// Método - Validar números
	boolean validarNumeros(String datos) {
		return datos.length() > 0 && datos.matches("[0-9]*");
	}

}
