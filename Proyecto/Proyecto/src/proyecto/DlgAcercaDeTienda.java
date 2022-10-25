package proyecto;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class DlgAcercaDeTienda extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblTienda;
	private JButton btnCerrar;
	private JLabel lblAutor;
	private JLabel lblA�o;
	private JLabel lblLimaPeru;
	private JLabel lblMauricioM;
	private JLabel lblAlessandroR;
	private JLabel lblMayraC;
	private JLabel lblJoseYep;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DlgAcercaDeTienda dialog = new DlgAcercaDeTienda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgAcercaDeTienda() {
		setTitle("Acerca de Tienda");
		setBounds(100, 100, 448, 278);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblTienda = new JLabel("Tienda 1.0");
		lblTienda.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTienda.setBounds(172, 10, 89, 17);
		contentPanel.add(lblTienda);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(172, 207, 89, 23);
		contentPanel.add(btnCerrar);

		lblAutor = new JLabel("Autores");
		lblAutor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAutor.setBounds(49, 51, 59, 15);
		contentPanel.add(lblAutor);

		lblA�o = new JLabel("2022");
		lblA�o.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblA�o.setBounds(49, 212, 44, 15);
		contentPanel.add(lblA�o);

		lblLimaPeru = new JLabel("Lima, Per\u00FA");
		lblLimaPeru.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLimaPeru.setBounds(329, 212, 75, 15);
		contentPanel.add(lblLimaPeru);

		lblMauricioM = new JLabel("Mauricio Menacho\r\n");
		lblMauricioM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMauricioM.setBounds(49, 81, 135, 23);
		contentPanel.add(lblMauricioM);

		lblAlessandroR = new JLabel("Alessandro Rios\r\n");
		lblAlessandroR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlessandroR.setBounds(49, 115, 135, 23);
		contentPanel.add(lblAlessandroR);

		lblMayraC = new JLabel("Mayra Cuadros");
		lblMayraC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMayraC.setBounds(49, 149, 135, 23);
		contentPanel.add(lblMayraC);

		lblJoseYep = new JLabel("Jos\u00E9 Yep");
		lblJoseYep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblJoseYep.setBounds(212, 115, 104, 23);
		contentPanel.add(lblJoseYep);

		lblNewLabel = new JLabel("Alfonso Torres");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(212, 87, 109, 17);
		contentPanel.add(lblNewLabel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
