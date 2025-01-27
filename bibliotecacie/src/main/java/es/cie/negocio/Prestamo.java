package es.cie.negocio;

import java.time.LocalDate;

public class Prestamo {

	private int identificador;
	private LocalDate fecha;
	
	
	
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	
	
	public Prestamo(int identificador, LocalDate fecha) {
		super();
		this.identificador = identificador;
		this.fecha = fecha;
		
	}
	public Prestamo(int identificador) {
		super();
		this.identificador = identificador;
	}
	public Prestamo() {
		super();
	}
	
	
}
