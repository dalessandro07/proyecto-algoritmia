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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DlgConsultarCeramico extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblModelo;
	private JComboBox<String> cboModelo;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JLabel lblAncho;
	private JLabel lblLargo;
	private JLabel lblEspesor;
	private JLabel lblContenido;
	private JTextField txtAncho;
	private JTextField txtLargo;
	private JTextField txtEspesor;
	private JTextField txtContenido;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConsultarCeramico dialog = new DlgConsultarCeramico();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConsultarCeramico() {
		setTitle("Consultar Cerámico");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModelo.setBounds(10, 31, 62, 13);
		contentPanel.add(lblModelo);

		cboModelo = new JComboBox<String>();
		cboModelo.setBackground(new Color(255, 255, 204));
		cboModelo.addActionListener(this);
		cboModelo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboModelo.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Cinza Plus", "Luxury", "Austria", "Yungay Mix", "Thalía" }));
		cboModelo.setBounds(129, 27, 123, 21);
		contentPanel.add(cboModelo);

		lblPrecio = new JLabel("Precio (S/):");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecio.setBounds(10, 70, 86, 13);
		contentPanel.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setForeground(Color.BLACK);
		txtPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPrecio.setBounds(129, 66, 123, 19);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);

		lblAncho = new JLabel("Ancho (cm):");
		lblAncho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAncho.setBounds(10, 109, 94, 13);
		contentPanel.add(lblAncho);

		lblLargo = new JLabel("Largo (cm):");
		lblLargo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLargo.setBounds(10, 146, 86, 22);
		contentPanel.add(lblLargo);

		lblEspesor = new JLabel("Espesor (mm):");
		lblEspesor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEspesor.setBounds(10, 187, 117, 21);
		contentPanel.add(lblEspesor);

		lblContenido = new JLabel("Contenido:");
		lblContenido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContenido.setBounds(10, 233, 86, 13);
		contentPanel.add(lblContenido);

		txtAncho = new JTextField();
		txtAncho.setEditable(false);
		txtAncho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAncho.setBounds(129, 105, 123, 19);
		contentPanel.add(txtAncho);
		txtAncho.setColumns(10);

		txtLargo = new JTextField();
		txtLargo.setEditable(false);
		txtLargo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtLargo.setBounds(129, 147, 123, 19);
		contentPanel.add(txtLargo);
		txtLargo.setColumns(10);

		txtEspesor = new JTextField();
		txtEspesor.setEditable(false);
		txtEspesor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEspesor.setBounds(129, 187, 123, 19);
		contentPanel.add(txtEspesor);
		txtEspesor.setColumns(10);

		txtContenido = new JTextField();
		txtContenido.setEditable(false);
		txtContenido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtContenido.setBounds(129, 229, 123, 19);
		contentPanel.add(txtContenido);
		txtContenido.setColumns(10);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBackground(new Color(255, 153, 153));
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCerrar.setBounds(311, 21, 104, 31);
		contentPanel.add(btnCerrar);

		txtPrecio.setText("" + frmPrincipal.precio0);
		txtAncho.setText("" + frmPrincipal.ancho0);
		txtLargo.setText("" + frmPrincipal.largo0);
		txtEspesor.setText("" + frmPrincipal.espesor0);
		txtContenido.setText("" + frmPrincipal.contenido0);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == cboModelo) {
			actionPerformedcboModelo(e);
		}
	}

	protected void actionPerformedcboModelo(ActionEvent e) {
		obtenerModelo();

		switch (modelo) {
		case 0:
			mostrarCinza();
			break;
		case 1:
			mostrarLuxury();
			break;
		case 2:
			mostrarAustria();
			break;
		case 3:
			mostrarYungay();
			break;
		default:
			mostrarThalia();
			break;
		}

	}

	// declaracion de variables
	int modelo;

	// Entrada de datos
	void obtenerModelo() {
		modelo = cboModelo.getSelectedIndex();
	}

	// mostrar datos de acuerdo al modelo
	void mostrarCinza() {
		txtPrecio.setText("" + frmPrincipal.precio0);
		txtAncho.setText("" + frmPrincipal.ancho0);
		txtLargo.setText("" + frmPrincipal.largo0);
		txtEspesor.setText("" + frmPrincipal.espesor0);
		txtContenido.setText("" + frmPrincipal.contenido0);
	}

	void mostrarLuxury() {
		txtPrecio.setText("" + frmPrincipal.precio1);
		txtAncho.setText("" + frmPrincipal.ancho1);
		txtLargo.setText("" + frmPrincipal.largo1);
		txtEspesor.setText("" + frmPrincipal.espesor1);
		txtContenido.setText("" + frmPrincipal.contenido1);
	}

	void mostrarAustria() {
		txtPrecio.setText("" + frmPrincipal.precio2);
		txtAncho.setText("" + frmPrincipal.ancho2);
		txtLargo.setText("" + frmPrincipal.largo2);
		txtEspesor.setText("" + frmPrincipal.espesor2);
		txtContenido.setText("" + frmPrincipal.contenido2);
	}

	void mostrarYungay() {
		txtPrecio.setText("" + frmPrincipal.precio3);
		txtAncho.setText("" + frmPrincipal.ancho3);
		txtLargo.setText("" + frmPrincipal.largo3);
		txtEspesor.setText("" + frmPrincipal.espesor3);
		txtContenido.setText("" + frmPrincipal.contenido3);
	}

	void mostrarThalia() {
		txtPrecio.setText("" + frmPrincipal.precio4);
		txtAncho.setText("" + frmPrincipal.ancho4);
		txtLargo.setText("" + frmPrincipal.largo4);
		txtEspesor.setText("" + frmPrincipal.espesor4);
		txtContenido.setText("" + frmPrincipal.contenido4);
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
