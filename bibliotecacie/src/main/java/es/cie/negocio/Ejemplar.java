package es.cie.negocio;

public class Ejemplar {

	private int id;
	private String isbn;
	private String titulo;
	private String autor;
	private int paginas;

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

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public Ejemplar(int id, String isbn, String titulo, String autor, int paginas) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.paginas = paginas;
	}

	public Ejemplar(int id, String isbn) {
		super();
		this.id = id;
		this.isbn = isbn;
	}

	public Ejemplar() {
		super();
	}

}
