package es.cie.negocio;

public class Ejemplar {

	private int id;
	private String isbn;
	private String titulo;
	private String autor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Ejemplar(int id, String isbn, String titulo, String autor) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
	}

	public Ejemplar(String isbn, String titulo, String autor) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
	}

	public Ejemplar(int id) {
		super();
		this.id = id;
	}

	public Ejemplar() {
		super();
	}

}
