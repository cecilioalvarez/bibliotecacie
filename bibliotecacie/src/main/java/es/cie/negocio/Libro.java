package es.cie.negocio;

public class Libro {

	private String isbn;
	private String titulo;
	private String autor;
	private int paginas;
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
	public Libro() {
		super();
	}
	public Libro(String isbn) {
		super();
		this.isbn = isbn;
	}
	public Libro(String isbn, String titulo, String autor, int paginas) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.paginas = paginas;
	}
	
	
}
