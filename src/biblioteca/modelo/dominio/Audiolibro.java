package biblioteca.modelo.dominio;

import biblioteca.modelo.dominio.Categoria;
import biblioteca.modelo.dominio.Libro;

import java.time.Duration;
import java.util.InputMismatchException;

public class Audiolibro extends Libro implements Comparable<Audiolibro> {

    private Duration duracion;
    private String formato;

    public Audiolibro(String isbn,
                      String titulo,
                      int anio,
                      Categoria categoria,
                      Duration duracion,
                      String formato) {

        super(isbn, titulo, anio, categoria);
        setDuracion(duracion);
        setFormato(formato);
    }

    public Duration getDuracion() {
        return duracion;
    }

    public void setDuracion(Duration duracion) throws IllegalArgumentException {
        if (duracion == null || duracion.isZero() || duracion.isNegative())
            throw new IllegalArgumentException("La duración es inválida.");
        this.duracion = duracion;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) throws IllegalArgumentException {
        if (formato == null) throw new IllegalArgumentException("Nombre no puede ser nulo");
        if (formato.trim().isEmpty()) throw new IllegalArgumentException("Nombre no puede estar vacío");
        this.formato = formato;
    }

    @Override
    public String toString() {
        return "Audiolibro{" +
                "isbn='" + getISBN() + '\'' +
                ", titulo='" + getTitulo() + '\'' +
                ", anio=" + getAnio() +
                ", categoria=" + getCategoria() +
                ", duracion=" + duracion +
                ", formato='" + formato + '\'' +
                '}';
    }

    @Override
    public int compareTo(Audiolibro objeto) {
        return 0;
    }
}