package proyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;

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

		// TODO: Falta completar

		int tipoReporte;

		tipoReporte = cboTipoReporte.getSelectedIndex();

		switch (tipoReporte) {
		case 0:
			break;
		case 1:
			break;
		case 2:
			break;
		default:
			break;

		}
	}

}
