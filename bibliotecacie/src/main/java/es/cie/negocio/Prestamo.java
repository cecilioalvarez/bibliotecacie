package es.cie.negocio;

public class Prestamo {
	
	private String identificador;
	private String fecha;
	private String idEjemplar;
	private String idCopia;
	public Prestamo(String identificador) {
		super();
		this.identificador = identificador;
	}
	public Prestamo() {
		super();
	}
	public Prestamo(String identificador, String fecha, String idEjemplar, String idCopia) {
		super();
		this.identificador = identificador;
		this.fecha = fecha;
		this.idEjemplar = idEjemplar;
		this.idCopia = idCopia;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getIdEjemplar() {
		return idEjemplar;
	}
	public void setIdEjemplar(String idEjemplar) {
		this.idEjemplar = idEjemplar;
	}
	public String getIdCopia() {
		return idCopia;
	}
	public void setIdCopia(String idCopia) {
		this.idCopia = idCopia;
	}
	
}