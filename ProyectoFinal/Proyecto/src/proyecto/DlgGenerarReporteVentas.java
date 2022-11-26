package proyecto;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DlgGenerarReporteVentas extends JDialog implements ActionListener {
	private JLabel lblTipoReporte;
	private JComboBox<String> cboTipoReporte;
	private JButton btnCerrar;
	private JScrollPane scp;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgGenerarReporteVentas dialog = new DlgGenerarReporteVentas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgGenerarReporteVentas() {
		setTitle("Generar reportes");
		setBounds(100, 100, 666, 422);
		getContentPane().setLayout(null);

		lblTipoReporte = new JLabel("Tipo de reporte");
		lblTipoReporte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipoReporte.setBounds(22, 24, 103, 14);
		getContentPane().add(lblTipoReporte);

		cboTipoReporte = new JComboBox<String>();
		cboTipoReporte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboTipoReporte.setBackground(new Color(255, 255, 204));
		cboTipoReporte.addActionListener(this);
		cboTipoReporte.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Ventas por modelo", "Comparación de precios con el precio promedio",
						"Comparación de cajas vendidas con la cantidad óptima", "Estadística sobre el precio" }));
		cboTipoReporte.setBounds(132, 20, 381, 22);
		getContentPane().add(cboTipoReporte);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCerrar.setBackground(new Color(255, 153, 153));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(541, 20, 89, 23);
		getContentPane().add(btnCerrar);

		scp = new JScrollPane();
		scp.setBounds(20, 56, 610, 269);
		getContentPane().add(scp);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 16));
		scp.setViewportView(txtS);

		generarReporteModelo();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == cboTipoReporte) {
			actionPerformedCboTipoReporte(e);
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}

	protected void actionPerformedCboTipoReporte(ActionEvent e) {

		int tipoReporte;

		tipoReporte = cboTipoReporte.getSelectedIndex();

		// Mostrar reportes

		switch (tipoReporte) {
		case 0:
			generarReporteModelo();
			break;
		case 1:
			mostrarComparacionPromedio();
			break;
		case 2:
			mostrarComparacionCantOpt();
			break;
		default:
			mostrarEstPrecio();
			break;

		}
	}

	// Metodo - Calcular y mostrar reporte de ventas por modelo
	void generarReporteModelo() {

		// Mostrando ventas por modelo
		txtS.setText("VENTAS POR MODELO \n\n");

		// Mostrando reporte del primer modelo
		imprimirReporte(frmPrincipal.modelo0, frmPrincipal.cantVentas0, frmPrincipal.unidades0,
				frmPrincipal.montoTotal0);

		// Mostrando reporte del segundo modelo
		imprimirReporte(frmPrincipal.modelo1, frmPrincipal.cantVentas1, frmPrincipal.unidades1,
				frmPrincipal.montoTotal1);

		// Mostrando reporte del tercer modelo
		imprimirReporte(frmPrincipal.modelo2, frmPrincipal.cantVentas2, frmPrincipal.unidades2,
				frmPrincipal.montoTotal2);

		// Mostrando reporte del cuarto modelo
		imprimirReporte(frmPrincipal.modelo3, frmPrincipal.cantVentas3, frmPrincipal.unidades3,
				frmPrincipal.montoTotal3);

		// Mostrando reporte del quinto modelo
		imprimirReporte(frmPrincipal.modelo4, frmPrincipal.cantVentas4, frmPrincipal.unidades4,
				frmPrincipal.montoTotal4);
	}

	// Metodo - Imprimir reporte de ventas por modelo
	void imprimirReporte(String modelo, int cantVentas, int unidades, double montoTotal) {

		double aporteCuota = montoTotal * 100 / frmPrincipal.cuotaDiaria;

		frmPrincipal.imprimir("Modelo \t\t\t\t: " + modelo, txtS);
		frmPrincipal.imprimir("Cantidad de ventas \t\t: " + cantVentas, txtS);
		frmPrincipal.imprimir("Cantidad de cajas vendidas \t: " + unidades, txtS);
		frmPrincipal.imprimir("Importe total vendido \t\t: S/." + frmPrincipal.redondear(montoTotal), txtS);
		frmPrincipal.imprimir("Aporte a la cuota diaria \t: " + frmPrincipal.redondear(aporteCuota) + "%\n", txtS);
	}

	// Metodo - Calcular y mostrar comparación de precios con el precio promedio
	void mostrarComparacionPromedio() {

		// Calculo del precio promedio

		double precioProm = (frmPrincipal.precio0 + frmPrincipal.precio1 + frmPrincipal.precio2 + frmPrincipal.precio3
				+ frmPrincipal.precio4) / 5;

		// Salida de resultados

		txtS.setText("COMPARACIÓN DE PRECIOS CON EL PRECIO PROMEDIO \n\n");

		imprimirPrecioPromedio(frmPrincipal.modelo0, frmPrincipal.precio0, precioProm);
		imprimirPrecioPromedio(frmPrincipal.modelo1, frmPrincipal.precio1, precioProm);
		imprimirPrecioPromedio(frmPrincipal.modelo2, frmPrincipal.precio2, precioProm);
		imprimirPrecioPromedio(frmPrincipal.modelo3, frmPrincipal.precio3, precioProm);
		imprimirPrecioPromedio(frmPrincipal.modelo4, frmPrincipal.precio4, precioProm);

	}

	// Metodo - Imprimir comparación precio promedio
	void imprimirPrecioPromedio(String modelo, double precio, double precioProm) {

		String mayorOMenor = " más que el promedio";
		double diferenciaPre = (precio - precioProm);

		if (diferenciaPre < 0)
			mayorOMenor = " menos que el promedio";

		frmPrincipal.imprimir("Modelo \t\t: " + modelo, txtS);
		frmPrincipal.imprimir("Precio \t\t: S/." + precio, txtS);
		frmPrincipal.imprimir("Precio promedio : S/." + precioProm, txtS);
		frmPrincipal.imprimir("Comparación \t: S/." + frmPrincipal.redondear(diferenciaPre) + mayorOMenor + "\n", txtS);
	}

	// Metodo - Calcular y mostrar comparación de precios con el precio promedio
	void mostrarComparacionCantOpt() {

		// Lectura de datos

		int cantOpt = frmPrincipal.cantidadOptima;

		// Salida de resultados

		txtS.setText("COMPARACIÓN DE DE CAJAS VENDIDAS CON LA CANTIDAD ÓPTIMA \n\n");

		imprimirCantOpt(frmPrincipal.modelo0, frmPrincipal.cantVentas0, cantOpt);
		imprimirCantOpt(frmPrincipal.modelo1, frmPrincipal.cantVentas1, cantOpt);
		imprimirCantOpt(frmPrincipal.modelo2, frmPrincipal.cantVentas2, cantOpt);
		imprimirCantOpt(frmPrincipal.modelo3, frmPrincipal.cantVentas3, cantOpt);
		imprimirCantOpt(frmPrincipal.modelo4, frmPrincipal.cantVentas4, cantOpt);

	}

	// Metodo - Imprimir comparación precio promedio
	void imprimirCantOpt(String modelo, int cantVentas, int cantOpt) {

		String comparacion = " más que la cantidad óptima";
		int diferenciaCant = (cantVentas - cantOpt);

		if (diferenciaCant < 0)
			comparacion = " menos que la cantidad óptima";
		else if (diferenciaCant == cantOpt) {
			comparacion = " igual que la cantidad óptima";
		}

		frmPrincipal.imprimir("Modelo \t\t\t  : " + modelo, txtS);
		frmPrincipal.imprimir("Cantidad de cajas vendidas: " + cantVentas, txtS);
		frmPrincipal.imprimir("Cantidad óptima \t  : " + cantOpt, txtS);
		frmPrincipal.imprimir("Comparación \t\t  : " + Math.abs(diferenciaCant) + comparacion + "\n", txtS);
	}

	// Metodo - Calcular y mostrar estadistica sobre el precio
	void mostrarEstPrecio() {

		double precioMayor, precioProm, precioMenor;

		// Calculando precio promedio, precio mayor y precio menor
		precioProm = (frmPrincipal.precio0 + frmPrincipal.precio1 + frmPrincipal.precio2 + frmPrincipal.precio3
				+ frmPrincipal.precio4) / 5;

		precioMayor = Math.max(frmPrincipal.precio0, Math.max(frmPrincipal.precio1,
				Math.max(frmPrincipal.precio2, Math.max(frmPrincipal.precio3, frmPrincipal.precio4))));

		precioMenor = Math.min(frmPrincipal.precio0, Math.min(frmPrincipal.precio1,
				Math.min(frmPrincipal.precio2, Math.min(frmPrincipal.precio3, frmPrincipal.precio4))));

		// Salida de resultados
		txtS.setText("ESTADÍSTICA SOBRE EL PRECIO \n\n");

		frmPrincipal.imprimir("Precio promedio : S/." + frmPrincipal.redondear(precioProm), txtS);
		frmPrincipal.imprimir("Precio mayor    : S/." + frmPrincipal.redondear(precioMayor), txtS);
		frmPrincipal.imprimir("Precio menor    : S/." + frmPrincipal.redondear(precioMenor), txtS);
	}

}
