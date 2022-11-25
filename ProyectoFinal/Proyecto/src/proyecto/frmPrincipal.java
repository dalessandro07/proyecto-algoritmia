package proyecto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class frmPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JMenu mnMantenimiento;
	private JMenuItem mntmConsultarC;
	private JMenuItem mntmModificarC;
	private JMenuItem mntmListarC;
	private JMenu mnVentas;
	private JMenuItem mntmVender;
	private JMenuItem mntmGenerarReportes;
	private JMenu mnConfiguracion;
	private JMenuItem mntmConfigDsctos;
	private JMenuItem mntmConfigObs;
	private JMenuItem mntmCantOpt;
	private JMenuItem mntmCuotaDiaria;
	private JMenu mnAyuda;
	private JMenuItem mntmAcercaTienda;

	// Datos mínimos del primer producto
	public static String modelo0 = "Cinza Plus";
	public static double precio0 = 92.56;
	public static double ancho0 = 62.0;
	public static double largo0 = 62.0;
	public static double espesor0 = 8;
	public static int contenido0 = 6;

	// Datos mínimos del segundo producto
	public static String modelo1 = "Luxury";
	public static double precio1 = 42.77;
	public static double ancho1 = 60;
	public static double largo1 = 60;
	public static double espesor1 = 8.5;
	public static int contenido1 = 4;

	// Datos mínimos del tercer producto
	public static String modelo2 = "Austria";
	public static double precio2 = 52.45;
	public static double ancho2 = 45;
	public static double largo2 = 45;
	public static double espesor2 = 6.5;
	public static int contenido2 = 12;

	// Datos mínimos del cuarto producto
	public static String modelo3 = "Yungay Mix";
	public static double precio3 = 55.89;
	public static double ancho3 = 80;
	public static double largo3 = 120;
	public static double espesor3 = 6.8;
	public static int contenido3 = 9;

	// Datos mínimos del quinto producto
	public static String modelo4 = "Thalía";
	public static double precio4 = 45;
	public static double ancho4 = 45;
	public static double largo4 = 11.8;
	public static double espesor4 = 7.2;
	public static int contenido4 = 10;

	// Porcentajes de descuento
	public static double porcentaje1 = 7.5;
	public static double porcentaje2 = 10.0;
	public static double porcentaje3 = 12.5;
	public static double porcentaje4 = 15.0;

	// Obsequio
	public static String tipoObsequio = "Lapicero";
	public static int obsequioCantidad1 = 2;
	public static int obsequioCantidad2 = 3;
	public static int obsequioCantidad3 = 4;

	// Cantidad óptima de unidades vendidas por día
	public static int cantidadOptima = 10;

	// Cuota diaria
	public static double cuotaDiaria = 30000;

	// Ventas por modelo

	// Monto total y unidades vendidas del primer producto
	public static double montoTotal0 = 0;
	public static int cantVentas0 = 0;
	public static int unidades0 = 0;

	// Monto total y unidades vendidas del segundo producto
	public static double montoTotal1 = 0;
	public static int cantVentas1 = 0;
	public static int unidades1 = 0;

	// Monto total y unidades vendidas del tercer producto
	public static double montoTotal2 = 0;
	public static int cantVentas2 = 0;
	public static int unidades2 = 0;

	// Monto total y unidades vendidas del cuarto producto
	public static double montoTotal3 = 0;
	public static int cantVentas3 = 0;
	public static int unidades3 = 0;

	// Monto total y unidades vendidas del quinto producto
	public static double montoTotal4 = 0;
	public static int cantVentas4 = 0;
	public static int unidades4 = 0;

	// Método - Imprimir texto en un JTextArea
	public static void imprimir(String texto, JTextArea txtS) {
		txtS.append(texto + "\n");
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPrincipal frame = new frmPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmPrincipal() {
		setTitle("Tienda de Cer\u00E1micos - GRUPO A");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 525);

		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 153, 255));
		setJMenuBar(menuBar);

		mnArchivo = new JMenu("Archivo");
		mnArchivo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		mnArchivo.setForeground(new Color(255, 255, 255));
		menuBar.add(mnArchivo);

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		mntmSalir.setBackground(new Color(173, 216, 230));
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);

		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		mnMantenimiento.setBackground(new Color(0, 153, 255));
		mnMantenimiento.setForeground(new Color(255, 255, 255));
		menuBar.add(mnMantenimiento);

		mntmConsultarC = new JMenuItem("Consultar cer\u00E1mico");
		mntmConsultarC.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		mntmConsultarC.setBackground(new Color(173, 216, 230));
		mntmConsultarC.addActionListener(this);
		mnMantenimiento.add(mntmConsultarC);

		mntmModificarC = new JMenuItem("Modificar cer\u00E1mico");
		mntmModificarC.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		mntmModificarC.setBackground(new Color(173, 216, 230));
		mntmModificarC.addActionListener(this);
		mnMantenimiento.add(mntmModificarC);

		mntmListarC = new JMenuItem("Listar cer\u00E1micos");
		mntmListarC.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		mntmListarC.setBackground(new Color(173, 216, 230));
		mntmListarC.addActionListener(this);
		mnMantenimiento.add(mntmListarC);

		mnVentas = new JMenu("Ventas");
		mnVentas.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		mnVentas.setForeground(new Color(255, 255, 255));

		menuBar.add(mnVentas);

		mntmVender = new JMenuItem("Vender");
		mntmVender.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		mntmVender.setBackground(new Color(173, 216, 230));
		mnVentas.add(mntmVender);
		mntmVender.addActionListener(this);

		mntmGenerarReportes = new JMenuItem("Generar Reportes");
		mntmGenerarReportes.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		mntmGenerarReportes.setBackground(new Color(173, 216, 230));
		mntmGenerarReportes.addActionListener(this);
		mnVentas.add(mntmGenerarReportes);

		mnConfiguracion = new JMenu("Configuraci\u00F3n");
		mnConfiguracion.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		mnConfiguracion.setForeground(new Color(255, 255, 255));
		menuBar.add(mnConfiguracion);

		mntmConfigDsctos = new JMenuItem("Configurar descuentos");
		mntmConfigDsctos.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		mntmConfigDsctos.setBackground(new Color(173, 216, 230));
		mntmConfigDsctos.addActionListener(this);
		mnConfiguracion.add(mntmConfigDsctos);

		mntmConfigObs = new JMenuItem("Configurar obsequios");
		mntmConfigObs.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		mntmConfigObs.setBackground(new Color(173, 216, 230));
		mntmConfigObs.addActionListener(this);
		mnConfiguracion.add(mntmConfigObs);

		mntmCantOpt = new JMenuItem("Configurar cantidad \u00F3ptima");
		mntmCantOpt.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		mntmCantOpt.setBackground(new Color(173, 216, 230));
		mntmCantOpt.addActionListener(this);
		mnConfiguracion.add(mntmCantOpt);

		mntmCuotaDiaria = new JMenuItem("Configurar cuota diaria");
		mntmCuotaDiaria.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		mntmCuotaDiaria.setBackground(new Color(173, 216, 230));
		mntmCuotaDiaria.addActionListener(this);
		mnConfiguracion.add(mntmCuotaDiaria);

		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		mnAyuda.setForeground(new Color(255, 255, 255));
		menuBar.add(mnAyuda);

		mntmAcercaTienda = new JMenuItem("Acerca de Tienda");
		mntmAcercaTienda.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		mntmAcercaTienda.setBackground(new Color(173, 216, 230));
		mntmAcercaTienda.addActionListener(this);
		mnAyuda.add(mntmAcercaTienda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == mntmGenerarReportes) {
			actionPerformedMntmGenerarReportes(e);
		}

		if (e.getSource() == mntmConfigObs) {
			actionPerformedMntmConfigObs(e);
		}

		if (e.getSource() == mntmConfigDsctos) {
			actionPerformedMntmConfigDsctos(e);
		}

		if (e.getSource() == mntmCantOpt) {
			actionPerformedMntmCantOpt(e);
		}

		if (e.getSource() == mntmCuotaDiaria) {
			actionPerformedMntmCuotaDiaria(e);
		}

		if (e.getSource() == mntmAcercaTienda) {
			actionPerformedMntmAcercaTienda(e);
		}

		if (e.getSource() == mntmListarC) {
			actionPerformedMntmListarC(e);
		}

		if (e.getSource() == mntmModificarC) {
			actionPerformedMntmModificarC(e);
		}

		if (e.getSource() == mntmConsultarC) {
			actionPerformedMntmConsultarC(e);
		}

		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}

		if (e.getSource() == mntmVender) {
			actionPerformedMntmVenta(e);
		}

	}

	protected void actionPerformedMntmSalir(ActionEvent e) {
		System.exit(0);
	}

	// Menú - Mantenimiento

	protected void actionPerformedMntmConsultarC(ActionEvent e) {
		DlgConsultarCeramico ventConsult = new DlgConsultarCeramico();
		ventConsult.setVisible(true);
		ventConsult.setLocationRelativeTo(this);
	}

	protected void actionPerformedMntmModificarC(ActionEvent e) {
		DlgModificarCeramico ventConsult = new DlgModificarCeramico();
		ventConsult.setVisible(true);
		ventConsult.setLocationRelativeTo(this);
	}

	protected void actionPerformedMntmListarC(ActionEvent e) {
		DlgListar ventListar = new DlgListar();
		ventListar.setVisible(true);
		ventListar.setLocationRelativeTo(this);
	}

	// Menú - Acerca de

	protected void actionPerformedMntmAcercaTienda(ActionEvent e) {
		DlgAcercaDeTienda ventAyuda = new DlgAcercaDeTienda();
		ventAyuda.setVisible(true);
		ventAyuda.setLocationRelativeTo(this);
	}

	// Menú - Configuración

	protected void actionPerformedMntmCantOpt(ActionEvent e) {
		DlgConfigurarCantidadOptima ventConfigCantOpt = new DlgConfigurarCantidadOptima();
		ventConfigCantOpt.setVisible(true);
		ventConfigCantOpt.setLocationRelativeTo(this);
	}

	protected void actionPerformedMntmCuotaDiaria(ActionEvent e) {
		DlgConfigurarCuotaDiaria ventCuotaDiaria = new DlgConfigurarCuotaDiaria();
		ventCuotaDiaria.setVisible(true);
		ventCuotaDiaria.setLocationRelativeTo(this);
	}

	protected void actionPerformedMntmConfigDsctos(ActionEvent e) {
		DlgConfigurarDescuentos ventConfigDesc = new DlgConfigurarDescuentos();
		ventConfigDesc.setVisible(true);
		ventConfigDesc.setLocationRelativeTo(this);
	}

	protected void actionPerformedMntmConfigObs(ActionEvent e) {
		DlgConfigurarObsequios ventConfigObs = new DlgConfigurarObsequios();
		ventConfigObs.setVisible(true);
		ventConfigObs.setLocationRelativeTo(this);
	}

	// Menú - Ventas

	protected void actionPerformedMntmVenta(ActionEvent e) {
		DlgVender ventVender = new DlgVender();
		ventVender.setVisible(true);
		ventVender.setLocationRelativeTo(this);
	}

	protected void actionPerformedMntmGenerarReportes(ActionEvent e) {
		DlgGenerarReporteVentas ventGenerarReportes = new DlgGenerarReporteVentas();
		ventGenerarReportes.setVisible(true);
		ventGenerarReportes.setLocationRelativeTo(this);
	}
}
