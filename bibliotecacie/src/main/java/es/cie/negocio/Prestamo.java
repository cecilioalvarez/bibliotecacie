package es.cie.negocio;

import java.time.LocalDate;

public class Prestamo {

	private int identificador;
	private LocalDate fecha;
	private int idejemplar;
	private int idcopia;
	
	
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
	public int getIdejemplar() {
		return idejemplar;
	}
	public void setIdejemplar(int idejemplar) {
		this.idejemplar = idejemplar;
	}
	public int getIdcopia() {
		return idcopia;
	}
	public void setIdcopia(int idcopia) {
		this.idcopia = idcopia;
	}
	
	public Prestamo(int identificador, LocalDate fecha, int idejemplar, int idcopia) {
		super();
		this.identificador = identificador;
		this.fecha = fecha;
		this.idejemplar = idejemplar;
		this.idcopia = idcopia;
	}
	public Prestamo(int identificador) {
		super();
		this.identificador = identificador;
	}
	public Prestamo() {
		super();
	}
	
	
}
