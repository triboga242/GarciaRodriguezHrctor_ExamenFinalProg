package models;

import java.util.Calendar;

public class Coche {

	protected Calendar fechaEntrada;
	protected Calendar fechaSalida;
	protected String matricula;
	protected String horaEntrada;
	protected String horaSalida;
	protected Double pagado;
	
	public Coche(Calendar fechaEntrada, String matricula, String horaEntrada) {
		this.fechaEntrada = fechaEntrada;
		this.matricula = matricula;
		this.horaEntrada = horaEntrada;
	}

	

	public Calendar getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Calendar fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Calendar getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Calendar fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}



	public Double getPagado() {
		return pagado;
	}



	public void setPagado(Double pagado) {
		this.pagado = pagado;
	}
}
