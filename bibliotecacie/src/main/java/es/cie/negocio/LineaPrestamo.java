package es.cie.negocio;

import java.time.LocalDate;

public class LineaPrestamo {

	private int identificador;
	private int identificadorlinea;
	private int idejemplar;
	private int idcopia;
	
	
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public int getIdentificadorlinea() {
		return identificadorlinea;
	}
	public void setIdentificadorlinea(int identificadorlinea) {
		this.identificadorlinea = identificadorlinea;
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
	
	
	public LineaPrestamo(int identificador, int identificadorlinea, int idejemplar, int idcopia) {
		super();
		this.identificador = identificador;
		this.identificadorlinea = identificadorlinea;
		this.idejemplar = idejemplar;
		this.idcopia = idcopia;
	}
	public LineaPrestamo(int identificador, int identificadorlinea) {
		super();
		this.identificador = identificador;
		this.identificadorlinea = identificadorlinea;
	}
	public LineaPrestamo() {
		super();
	}
	
	
}
	
	
