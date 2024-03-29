package proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
	private JLabel lblCantidad;
	private JTextField txtCantidad;

	// Variables contador, cantidad vendida y total acumulado
	public int contadorCant = 0;
	public double totalImportes = 0;
	private JTextArea txtS;

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
		setBounds(100, 100, 452, 388);
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
		btnProcesar.setBackground(new Color(0, 153, 255));
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(325, 21, 89, 23);
		contentPanel.add(btnProcesar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBorrar.setBackground(new Color(255, 153, 153));
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(325, 46, 89, 23);
		contentPanel.add(btnBorrar);

		scp = new JScrollPane();
		scp.setBounds(10, 114, 404, 226);
		contentPanel.add(scp);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 15));
		scp.setViewportView(txtS);

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
		contadorCant++;

		// Declaracion de variables
		int cantidad = 0, canobsequio;
		double impD, impC, impP, precio;
		String modelo, tipo;

		// Validacion de campo cantidad
		if (validarNumeros(txtCantidad.getText().trim())) {
			cantidad = Integer.parseInt(txtCantidad.getText());
		} else {
			JOptionPane.showMessageDialog(this, "�Solo se puede ingresar n�meros!", "Datos inv�lidos",
					JOptionPane.WARNING_MESSAGE);
			actionPerformedBtnBorrar(e);
			return;
		}

		// Lectura de datos
		modelo = "" + cboModelo.getSelectedItem();
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
		mostrarResultados(modelo, precio, cantidad, impC, impD, impP, tipo, canobsequio);

		// Mensaje de alerta
		mostrarAlerta();

		// Sumando al total de ventas por modelo
		registrarVentasModelo(impP, cantidad);

	}

	protected void actionPerformedBtnBorrar(ActionEvent e) {
		txtCantidad.setText("");
		txtS.setText("");
		cboModelo.setSelectedIndex(0);
		txtCantidad.requestFocus();
	}

	// M�todo - Importe de compra
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

	// M�todo - Importe de descuento
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

	// Metodo - Importe a pagar
	double calcularImporteAPagar(double impC, double impD) {
		return impC - impD;
	}

	// Metodo - Obsequio
	int calcularObsequio(int cantidad) {
		if (cantidad <= 5)
			return cantidad * frmPrincipal.obsequioCantidad1;
		else if (cantidad <= 10)
			return cantidad * frmPrincipal.obsequioCantidad2;
		else
			return cantidad * frmPrincipal.obsequioCantidad3;
	}

	// Metodo - Mostrar boleta de venta
	void mostrarResultados(String modelo, double precio, int cantidad, double impC, double impD, double impP,
			String tipo, int canobsequio) {

		txtS.setText("Boleta de Venta \n\n");

		frmPrincipal.imprimir("Modelo\t\t\t: " + modelo, txtS);
		frmPrincipal.imprimir("Precio\t\t\t: S/." + precio, txtS);
		frmPrincipal.imprimir("Cantidad Adquirida\t: " + cantidad, txtS);
		frmPrincipal.imprimir("Importe de Compra\t: S/." + frmPrincipal.redondear(impC), txtS);
		frmPrincipal.imprimir("Importe de Descuento\t: S/." + frmPrincipal.redondear(impD), txtS);
		frmPrincipal.imprimir("Importe a Pagar\t\t: S/." + frmPrincipal.redondear(impP), txtS);
		frmPrincipal.imprimir("Tipo de obsequio\t: " + tipo, txtS);
		frmPrincipal.imprimir("Unidades obsequiadas\t: " + canobsequio, txtS);
	}

	// Metodo - Mostrar alerta
	void mostrarAlerta() {
		if (contadorCant % 5 == 0) {
			String mensaje, titulo;
			double porcentaje;

			porcentaje = totalImportes * 100 / frmPrincipal.cuotaDiaria;

			mensaje = "Venta Nro. " + contadorCant + "\n" + "Importe total general acumulado: S/. "
					+ frmPrincipal.redondear(totalImportes) + "\n" + "Porcentaje de la cuota diaria: "
					+ frmPrincipal.redondear(porcentaje) + "%";

			titulo = "Avance de ventas";

			JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
		}
	}

	// Metodo - Registrando ventas
	void registrarVentasModelo(double impP, int cantidad) {
		switch (cboModelo.getSelectedIndex()) {
		case 0:
			frmPrincipal.montoTotal0 += impP;
			frmPrincipal.cantVentas0++;
			frmPrincipal.unidades0 += cantidad;
			break;
		case 1:
			frmPrincipal.montoTotal1 += impP;
			frmPrincipal.cantVentas1++;
			frmPrincipal.unidades1 += cantidad;
			break;
		case 2:
			frmPrincipal.montoTotal2 += impP;
			frmPrincipal.cantVentas2++;
			frmPrincipal.unidades2 += cantidad;
			break;
		case 3:
			frmPrincipal.montoTotal3 += impP;
			frmPrincipal.cantVentas3++;
			frmPrincipal.unidades3 += cantidad;
			break;
		default:
			frmPrincipal.montoTotal4 += impP;
			frmPrincipal.cantVentas4++;
			frmPrincipal.unidades4 += cantidad;
			break;
		}
	}

	// M�todo - Validar numeros
	boolean validarNumeros(String datos) {
		return datos.length() > 0 && datos.matches("[0-9]*");
	}

}