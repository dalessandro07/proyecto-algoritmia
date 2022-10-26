package proyecto;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.UIManager;

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
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgListar dialog = new DlgListar();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DlgListar() {
		setTitle("Listar");
		setBounds(100, 100, 466, 321);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 430, 226);
		getContentPane().add(scrollPane);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 17));
		scrollPane.setViewportView(txtS);

		panel = new JPanel();
		panel.setBounds(131, 248, 188, 23);
		getContentPane().add(panel);
		panel.setLayout(null);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(99, 0, 89, 23);
		panel.add(btnCerrar);

		btnListar = new JButton("Listar");
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

	protected void actionPerformedBtnListar(ActionEvent e) 
	{
		txtS.setText("Listado de Ceramicos \n\n");
		txtS.append("Modelo : "+frmPrincipal.modelo0+"\n");
		txtS.append("Precio : "+frmPrincipal.precio0+"\n");
		txtS.append("Ancho (cm) : "+frmPrincipal.ancho0+" cm"+"\n");
		txtS.append("Largo (cm) : "+frmPrincipal.largo0+" cm"+"\n");
		txtS.append("Espesor (mm) : "+frmPrincipal.espesor0+" mm"+"\n");
		txtS.append("Contenido : "+frmPrincipal.contenido0+" unidades"+"\n\n");
		
		txtS.append("Modelo : "+frmPrincipal.modelo1+"\n");
		txtS.append("Precio : "+frmPrincipal.precio1+"\n");
		txtS.append("Ancho (cm) : "+frmPrincipal.ancho1+" cm"+"\n");
		txtS.append("Largo (cm) : "+frmPrincipal.largo1+" cm"+"\n");
		txtS.append("Espesor (mm) : "+frmPrincipal.espesor1+" mm"+"\n");
		txtS.append("Contenido : "+frmPrincipal.contenido1+" unidades"+"\n\n");
		
		txtS.append("Modelo : "+frmPrincipal.modelo2+"\n");
		txtS.append("Precio : "+frmPrincipal.precio2+"\n");
		txtS.append("Ancho (cm) : "+frmPrincipal.ancho2+" cm"+"\n");
		txtS.append("Largo (cm) : "+frmPrincipal.largo2+" cm"+"\n");
		txtS.append("Espesor (mm) : "+frmPrincipal.espesor2+" mm"+"\n");
		txtS.append("Contenido : "+frmPrincipal.contenido2+" unidades"+"\n\n");
		
		txtS.append("Modelo : "+frmPrincipal.modelo3+"\n");
		txtS.append("Precio : "+frmPrincipal.precio3+"\n");
		txtS.append("Ancho (cm) : "+frmPrincipal.ancho3+" cm"+"\n");
		txtS.append("Largo (cm) : "+frmPrincipal.largo3+" cm"+"\n");
		txtS.append("Espesor (mm) : "+frmPrincipal.espesor3+" mm"+"\n");
		txtS.append("Contenido : "+frmPrincipal.contenido3+" unidades"+"\n\n");
		
		txtS.append("Modelo : "+frmPrincipal.modelo4+"\n");
		txtS.append("Precio : "+frmPrincipal.precio4+"\n");
		txtS.append("Ancho (cm) : "+frmPrincipal.ancho4+" cm"+"\n");
		txtS.append("Largo (cm) : "+frmPrincipal.largo4+" cm"+"\n");
		txtS.append("Espesor (mm) : "+frmPrincipal.espesor4+" mm"+"\n");
		txtS.append("Contenido : "+frmPrincipal.contenido4+" unidades"+"\n\n");
		
		
	}
}