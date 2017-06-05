package gui;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import container.Contenedor;
import models.Coche;

public class Principal {

	private JFrame frame;
	private JTextField txtMatricula;
	private JTextField txtHoraentrada;
	private JTextField txtHorasalida;
	private JTextField txtImporteentregado;
	private JButton btnEntradavehiculo;
	private JButton PagoYSalida;
	private JButton btnCajadeldia;
	private JButton buttonRegistrar;
	private JLabel lblTotalapagar;
	private JLabel lblCambioTxt;
	private JLabel lblPrecio;
	private JLabel lblCambio;
	private JButton btnPagarYSalir;
	private JLabel lblCajaDelDia;
	private JTextField txtCajaDelDia;
	private JLabel lblMatricula;

	// calcular fechas y horas

	private Calendar calendario1;
	private Calendar calendario2;
	private int hora1, minutos1, segundos1;
	private int hora2, minutos2, segundos2;
	private JButton btnBuscarCoche;

	private Double cajaTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
		setContents();
		setEventos();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		btnEntradavehiculo = new JButton("Entrada Vehiculo");

		PagoYSalida = new JButton("Salida y pago");

		btnCajadeldia = new JButton("Caja Del Dia");

		buttonRegistrar = new JButton("Registrar");

		lblTotalapagar = new JLabel("Total A Pagar");
		lblCambioTxt = new JLabel("Cambio");
		lblPrecio = new JLabel("Precio");
		lblCambio = new JLabel("Cambio");
		btnPagarYSalir = new JButton("Pagar y Salir");

		txtMatricula = new JTextField();
		txtHoraentrada = new JTextField();
		txtHorasalida = new JTextField();
		txtImporteentregado = new JTextField();
		lblCajaDelDia = new JLabel("Caja del Dia");
		txtCajaDelDia = new JTextField();
		lblMatricula = new JLabel("Matricula");
		btnBuscarCoche = new JButton("Buscar Coche");

		cajaTotal = (double) 0f;

		modoEntrar();

	}
/**
 * Setear contenidos
 */
	private void setContents() {

		frame.setBounds(100, 100, 733, 636);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnEntradavehiculo.setBounds(6, 6, 117, 117);
		frame.getContentPane().add(btnEntradavehiculo);

		PagoYSalida.setBounds(165, 6, 117, 117);
		frame.getContentPane().add(PagoYSalida);

		btnCajadeldia.setBounds(327, 6, 117, 117);
		frame.getContentPane().add(btnCajadeldia);

		txtMatricula.setText("Matricula");
		txtMatricula.setColumns(10);
		txtMatricula.setBounds(49, 171, 203, 41);
		frame.getContentPane().add(txtMatricula);

		buttonRegistrar.setBounds(33, 406, 164, 52);
		frame.getContentPane().add(buttonRegistrar);

		txtHoraentrada.setEditable(false);
		txtHoraentrada.setText("Hora de Entrada");
		txtHoraentrada.setBounds(49, 238, 203, 41);
		frame.getContentPane().add(txtHoraentrada);
		txtHoraentrada.setColumns(10);

		txtHorasalida.setEditable(false);
		txtHorasalida.setText("Hora de Salida");
		txtHorasalida.setBounds(49, 290, 203, 41);
		frame.getContentPane().add(txtHorasalida);
		txtHorasalida.setColumns(10);

		lblTotalapagar.setBounds(301, 171, 143, 52);
		frame.getContentPane().add(lblTotalapagar);

		lblCambioTxt.setBounds(301, 378, 143, 80);
		frame.getContentPane().add(lblCambioTxt);

		txtImporteentregado.setText("Importe Entregado");
		txtImporteentregado.setBounds(288, 290, 143, 80);
		frame.getContentPane().add(txtImporteentregado);
		txtImporteentregado.setColumns(10);

		lblPrecio.setBounds(311, 238, 117, 41);
		frame.getContentPane().add(lblPrecio);

		lblCambio.setBounds(327, 442, 117, 41);
		frame.getContentPane().add(lblCambio);

		btnPagarYSalir.setBounds(33, 493, 164, 52);
		frame.getContentPane().add(btnPagarYSalir);

		lblCajaDelDia.setEnabled(false);
		lblCajaDelDia.setBounds(517, 204, 61, 16);
		frame.getContentPane().add(lblCajaDelDia);

		txtCajaDelDia.setEnabled(false);
		txtCajaDelDia.setEditable(false);
		txtCajaDelDia.setText("Caja del dia");
		txtCajaDelDia.setBounds(499, 245, 124, 52);
		frame.getContentPane().add(txtCajaDelDia);
		txtCajaDelDia.setColumns(10);

		lblMatricula.setBounds(49, 151, 61, 16);
		frame.getContentPane().add(lblMatricula);

		btnBuscarCoche.setBounds(218, 495, 164, 52);
		frame.getContentPane().add(btnBuscarCoche);
	}

	private void setEventos() {
		btnEntradavehiculo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				modoEntrar();
			}
		});

		PagoYSalida.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				modoPagar();
			}
		});
/**
 * modo caja del dia
 */
		btnCajadeldia.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				modoCaja();

				txtCajaDelDia.setText(cajaTotal + "");

			}
		});
/**
 * Controla escritura
 */
		txtImporteentregado.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				int contadorPuntos = 0;
				int contadorNumeros = 0;

				if (((caracter < '0') || (caracter > '9')) && (caracter != '.')) {
					e.consume();
				}
				if (caracter == '.' && contadorPuntos != 0) {
					e.consume();
				}
				if (caracter == '.') {
					contadorPuntos++;
				}
				if (caracter == '.' && contadorNumeros == 0) {
					e.consume();
					contadorPuntos = 0;
				}
				if (((caracter >= '0') || (caracter <= '9'))) {
					contadorNumeros++;
				}
			}
		});
/**
 * Registrar la hora de enrtrada y crear vehiculo con su matricula
 */
		buttonRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				start();
				hora1 = calendario1.get(Calendar.HOUR_OF_DAY);
				minutos1 = calendario1.get(Calendar.MINUTE);
				segundos1 = calendario1.get(Calendar.SECOND);

				String horaEntrada = (hora1 + ":" + minutos1 + ":" + segundos1);
				String matricula = txtMatricula.getText();
				if (!matricula.isEmpty()) {
					for (Coche c : Contenedor.ml) {
						if (c.getMatricula().equals(matricula)) {
							JOptionPane.showMessageDialog(frame, "El coche ya esta dentro.",
									"Error Matricula incorrecta", JOptionPane.ERROR_MESSAGE);
							break;
						}
					}
					Coche cAux = new Coche(calendario1, matricula, horaEntrada);
					Contenedor.ml.add(cAux);
				} else {
					JOptionPane.showMessageDialog(frame, "Revise la matricula introducida",
							"Error Matricula incorrecta", JOptionPane.ERROR_MESSAGE);
				}

				modoEntrar();

			}
		});
/**
 * b uscar y cargar un vehiculo con su matricula
 */
		btnBuscarCoche.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String matricula = txtMatricula.getText();
				if (!matricula.isEmpty()) {
					for (Coche c : Contenedor.ml) {
						if (c.getMatricula().equals(matricula)) {
							stop();
							txtMatricula.setEnabled(false);
							txtHoraentrada.setText(c.getHoraEntrada());
							hora2 = calendario2.get(Calendar.HOUR_OF_DAY);
							minutos2 = calendario2.get(Calendar.MINUTE);
							segundos2 = calendario2.get(Calendar.SECOND);
							txtHorasalida.setText((hora2 + ":" + minutos2 + ":" + segundos2));
							calcularPrecio();
							btnPagarYSalir.setEnabled(true);
							btnPagarYSalir.setVisible(true);
							btnBuscarCoche.setEnabled(false);
							btnBuscarCoche.setVisible(false);
						}
					}

				} else {
					JOptionPane.showMessageDialog(frame, "Revise la matricula introducida",
							"Error Matricula incorrecta", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
/**
 * pagar y salir
 */
		btnPagarYSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				Double aPagar = Contenedor.TOTAL;
				Double pagado = (double) 0f;
				try {
					pagado = Double.parseDouble(txtImporteentregado.getText());
				} catch (NumberFormatException error) {

				}
				Double cambio = pagado - aPagar;

				if (cambio < 0) {
					JOptionPane.showMessageDialog(frame, "Revise la cantidad introducida", "Error Pago incorrecto",
							JOptionPane.ERROR_MESSAGE);
				} else if (cambio == 0) {
					JOptionPane.showMessageDialog(frame, "Dinerico justico", "No Olvide Sonreir",
							JOptionPane.INFORMATION_MESSAGE);
					lblCambioTxt.setText(cambio + "");
					cajaTotal += aPagar;
					cobrar();

				} else if (cambio > 100) {
					JOptionPane.showMessageDialog(frame, "No se dispone de tanto cambio", "Error Pago incorrecto",
							JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(frame, "El cambio a entregar es de " + cambio, "No Olvide Sonreir",
							JOptionPane.INFORMATION_MESSAGE);
					lblCambioTxt.setText(cambio + "");
					cajaTotal += aPagar;
					cobrar();
				}

			}
		});
	}
/**
 * Modo entrar
 */
	private void modoEntrar() {
		txtHoraentrada.setVisible(false);
		txtHorasalida.setVisible(false);
		lblTotalapagar.setVisible(false);
		lblCambioTxt.setVisible(false);
		lblPrecio.setVisible(false);
		lblCambio.setVisible(false);
		btnPagarYSalir.setVisible(false);
		txtImporteentregado.setVisible(false);
		btnBuscarCoche.setVisible(false);

		txtHorasalida.setEnabled(false);
		txtHoraentrada.setEnabled(false);
		lblTotalapagar.setEnabled(false);
		lblCambioTxt.setEnabled(false);
		lblPrecio.setEnabled(false);
		lblCambio.setEnabled(false);
		btnPagarYSalir.setEnabled(false);
		txtImporteentregado.setEnabled(false);
		btnBuscarCoche.setEnabled(false);

		lblCajaDelDia.setVisible(false);
		txtCajaDelDia.setVisible(false);
		lblCajaDelDia.setEnabled(false);
		txtCajaDelDia.setEnabled(false);

		buttonRegistrar.setVisible(true);
		txtMatricula.setVisible(true);

		buttonRegistrar.setEnabled(true);
		txtMatricula.setEnabled(true);

		lblMatricula.setEnabled(true);
		lblMatricula.setVisible(true);

		clear();
	}
/**
 * modo pagar
 */
	private void modoPagar() {
		txtHoraentrada.setVisible(true);
		txtHorasalida.setVisible(true);
		lblTotalapagar.setVisible(true);
		lblCambioTxt.setVisible(true);
		lblPrecio.setVisible(true);
		lblCambio.setVisible(true);
		btnPagarYSalir.setVisible(false);
		txtImporteentregado.setVisible(true);
		btnBuscarCoche.setVisible(true);

		txtHorasalida.setEnabled(true);
		txtHoraentrada.setEnabled(true);
		lblTotalapagar.setEnabled(true);
		lblCambioTxt.setEnabled(true);
		lblPrecio.setEnabled(true);
		lblCambio.setEnabled(true);
		btnPagarYSalir.setEnabled(false);
		txtImporteentregado.setEnabled(true);
		btnBuscarCoche.setEnabled(true);

		lblCajaDelDia.setVisible(false);
		txtCajaDelDia.setVisible(false);
		lblCajaDelDia.setEnabled(false);
		txtCajaDelDia.setEnabled(false);

		buttonRegistrar.setVisible(false);
		txtMatricula.setVisible(true);
		buttonRegistrar.setEnabled(false);
		txtMatricula.setEnabled(true);

		lblMatricula.setEnabled(true);
		lblMatricula.setVisible(true);

		clear();
	}
/**
 * modoCaja
 */
	private void modoCaja() {
		txtHoraentrada.setVisible(false);
		txtHorasalida.setVisible(false);
		lblTotalapagar.setVisible(false);
		lblCambioTxt.setVisible(false);
		lblPrecio.setVisible(false);
		lblCambio.setVisible(false);
		btnPagarYSalir.setVisible(false);
		txtImporteentregado.setVisible(false);
		btnBuscarCoche.setEnabled(false);
		btnBuscarCoche.setVisible(false);

		txtHorasalida.setEnabled(false);
		txtHoraentrada.setEnabled(false);
		lblTotalapagar.setEnabled(false);
		lblCambioTxt.setEnabled(false);
		lblPrecio.setEnabled(false);
		lblCambio.setEnabled(false);
		btnPagarYSalir.setEnabled(false);
		txtImporteentregado.setEnabled(false);

		lblCajaDelDia.setVisible(true);
		txtCajaDelDia.setVisible(true);
		lblCajaDelDia.setEnabled(true);
		txtCajaDelDia.setEnabled(true);

		buttonRegistrar.setVisible(false);
		txtMatricula.setVisible(false);
		buttonRegistrar.setEnabled(false);
		txtMatricula.setEnabled(false);

		lblMatricula.setEnabled(false);
		lblMatricula.setVisible(false);

	}

	/**
	 * Calendario de hora de entrada
	 */
	private void start() {
		calendario1 = new GregorianCalendar();
	}

	/**
	 * Calendario de hora de salida
	 */
	private void stop() {
		calendario2 = new GregorianCalendar();

	}
/**
 * Limpiar campos
 */
	private void clear() {
		txtCajaDelDia.setText("");
		txtHoraentrada.setText("");
		txtHorasalida.setText("");
		txtImporteentregado.setText("");
		txtMatricula.setText("");
		lblCambioTxt.setText("");
	}
/**
 * Calculos de el precio en funcion de la hora
 */
	private void calcularPrecio() {
		int horas = hora2 - hora1;
		int minutos = minutos2 - minutos1;
		int tiempo = horas * 60 + minutos;
		double total = 0;

		if (tiempo < 31) {
			total = tiempo * 0.06;
		}
		if (tiempo > 30 && tiempo < 61) {
			tiempo = tiempo - 30;
			total = tiempo * 0.01;
			total += 30 * 0.06;
		}
		if (tiempo > 60 && tiempo < 721) {
			tiempo = tiempo - 60;
			total = tiempo * 0.03;
			total += 30 * 0.01;
			total += 30 * 0.06;
		}
		if (tiempo > 720) {
			tiempo = tiempo - 720;
			total = tiempo * 0.15;
			total += 30 * 0.01;
			total += 30 * 0.06;
			total += 660 * 0.03;
		}

		if (total == 0)
			total = 0.06;
		Contenedor.TOTAL = total;
		lblPrecio.setText(String.format("%.2f", total));
	}
/**
 * Setear el vehiculo al salir
 * cambiar matricula para que pueda vuelva a entrar
 */
	private void cobrar() {
		for (Coche c : Contenedor.ml) {
			if (c.getMatricula().equals(txtMatricula.getText())) {
				c.setFechaSalida(calendario2);
				c.setHoraSalida(txtHorasalida.getText());
				c.setPagado(Contenedor.TOTAL);
				c.setMatricula(txtMatricula.getText() + "Fuera");

			}
		}
		modoEntrar();
	}
}
