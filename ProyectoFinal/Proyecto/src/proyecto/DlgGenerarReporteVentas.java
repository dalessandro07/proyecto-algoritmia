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
				new String[] { "Ventas por modelo", "Comparaci\u00F3n de precios con el precio promedio",
						"Comparaci\u00F3n de cajas vendidas con la cantidad \u00F3ptima",
						"Estad\u00EDstica sobre el precio" }));
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
		scp.setViewportView(txtS);

		reporteVentasModelo();
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
			reporteVentasModelo();
			break;
		case 1:
			break;
		case 2:
			break;
		default:
			break;

		}
	}

	// M�todo - Calcular y mostrar reporte de ventas por modelo
	void reporteVentasModelo() {
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

	// M�todo - Imprimir reporte de ventas por modelo
	void imprimirReporte(String modelo, int cantVentas, int unidades, double montoTotal) {
		frmPrincipal.imprimir("Modelo \t\t: " + modelo, txtS);
		frmPrincipal.imprimir("Cantidad de ventas \t: " + cantVentas, txtS);
		frmPrincipal.imprimir("Cantidad de cajas vendidas \t: " + unidades, txtS);
		frmPrincipal.imprimir("Importe total vendido \t: " + montoTotal, txtS);
		frmPrincipal.imprimir("Aporte a la cuota diaria \t: " + montoTotal * 100 / frmPrincipal.cuotaDiaria + "%\n",
				txtS);
	}

}
