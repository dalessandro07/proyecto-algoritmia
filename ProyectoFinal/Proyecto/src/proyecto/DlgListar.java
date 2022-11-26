package proyecto;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.Color;

public class DlgListar extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnCerrar;
	private JButton btnListar;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgListar dialog = new DlgListar();
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
	public DlgListar() {
		setTitle("Listado de Ceramicos");
		setBounds(100, 100, 466, 321);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 430, 226);
		getContentPane().add(scrollPane);

		txtS = new JTextArea();
		txtS.setEditable(false);
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 15));
		scrollPane.setViewportView(txtS);

		panel = new JPanel();
		panel.setBounds(131, 248, 188, 23);
		getContentPane().add(panel);
		panel.setLayout(null);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCerrar.setBackground(new Color(255, 153, 153));
		btnCerrar.setBounds(99, 0, 89, 23);
		panel.add(btnCerrar);

		btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnListar.setBackground(new Color(0, 153, 255));
		btnListar.addActionListener(this);
		btnListar.setBounds(0, 0, 89, 23);
		panel.add(btnListar);
		btnCerrar.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}

	protected void actionPerformedBtnListar(ActionEvent e) {
		txtS.setText("Listado de Ceramicos \n\n");

		frmPrincipal.imprimir("Modelo : " + frmPrincipal.modelo0, txtS);
		frmPrincipal.imprimir("Precio : " + frmPrincipal.precio0, txtS);
		frmPrincipal.imprimir("Ancho (cm) : " + frmPrincipal.ancho0 + " cm", txtS);
		frmPrincipal.imprimir("Largo (cm) : " + frmPrincipal.largo0 + " cm", txtS);
		frmPrincipal.imprimir("Espesor (mm) : " + frmPrincipal.espesor0 + " mm", txtS);
		frmPrincipal.imprimir("Contenido : " + frmPrincipal.contenido0 + " unidades" + "\n", txtS);

		frmPrincipal.imprimir("Modelo : " + frmPrincipal.modelo1, txtS);
		frmPrincipal.imprimir("Precio : " + frmPrincipal.precio1, txtS);
		frmPrincipal.imprimir("Ancho (cm) : " + frmPrincipal.ancho1 + " cm", txtS);
		frmPrincipal.imprimir("Largo (cm) : " + frmPrincipal.largo1 + " cm", txtS);
		frmPrincipal.imprimir("Espesor (mm) : " + frmPrincipal.espesor1 + " mm", txtS);
		frmPrincipal.imprimir("Contenido : " + frmPrincipal.contenido1 + " unidades" + "\n", txtS);

		frmPrincipal.imprimir("Modelo : " + frmPrincipal.modelo2, txtS);
		frmPrincipal.imprimir("Precio : " + frmPrincipal.precio2, txtS);
		frmPrincipal.imprimir("Ancho (cm) : " + frmPrincipal.ancho2 + " cm", txtS);
		frmPrincipal.imprimir("Largo (cm) : " + frmPrincipal.largo2 + " cm", txtS);
		frmPrincipal.imprimir("Espesor (mm) : " + frmPrincipal.espesor2 + " mm", txtS);
		frmPrincipal.imprimir("Contenido : " + frmPrincipal.contenido2 + " unidades" + "\n", txtS);

		frmPrincipal.imprimir("Modelo : " + frmPrincipal.modelo3, txtS);
		frmPrincipal.imprimir("Precio : " + frmPrincipal.precio3, txtS);
		frmPrincipal.imprimir("Ancho (cm) : " + frmPrincipal.ancho3 + " cm", txtS);
		frmPrincipal.imprimir("Largo (cm) : " + frmPrincipal.largo3 + " cm", txtS);
		frmPrincipal.imprimir("Espesor (mm) : " + frmPrincipal.espesor3 + " mm", txtS);
		frmPrincipal.imprimir("Contenido : " + frmPrincipal.contenido3 + " unidades" + "\n", txtS);

		frmPrincipal.imprimir("Modelo : " + frmPrincipal.modelo4, txtS);
		frmPrincipal.imprimir("Precio : " + frmPrincipal.precio4, txtS);
		frmPrincipal.imprimir("Ancho (cm) : " + frmPrincipal.ancho4 + " cm", txtS);
		frmPrincipal.imprimir("Largo (cm) : " + frmPrincipal.largo4 + " cm", txtS);
		frmPrincipal.imprimir("Espesor (mm) : " + frmPrincipal.espesor4 + " mm", txtS);
		frmPrincipal.imprimir("Contenido : " + frmPrincipal.contenido4 + " unidades", txtS);
	}
}
