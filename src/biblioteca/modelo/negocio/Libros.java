package biblioteca.modelo.negocio;

import biblioteca.modelo.dominio.Libro;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Clase Libros (paquete negocio).
 * Gestiona la colección de libros de la biblioteca.
 * Permite alta, baja, búsqueda y listado de libros.
 * Utiliza ArrayList para almacenamiento dinámico.
 */
public class Libros {

    // Atributo
    private List<Libro> libros;

    // Constructor
    public Libros() {
        libros = new ArrayList<>();
    }


    public void alta(Libro libro) throws IllegalArgumentException {
        if (libro == null) {
            throw new IllegalArgumentException("El libro no puede ser nulo");
        }
        if (libros.contains(libro)) {
            throw new IllegalArgumentException("El préstamo ya existe");
        }

        libros.add(new Libro(libro)); // copia profunda
    }

    public boolean baja(Libro libro) {
        return libro != null && libros.remove(libro);
    }

    public Libro buscar(Libro libro) {
        if (libro == null)
            return null;

        int index = libros.indexOf(libro);

        if (index != -1) {
            return new Libro(libros.get(index));
        }

        return null;
    }

    private void ordenar() {

        for (int i = 0; i < libros.size() - 1; i++) {
            for (int j = 0; j < libros.size() - i - 1; j++) {

                Libro actual = libros.get(j);
                Libro siguiente = libros.get(j + 1);

                if (actual.compareTo(siguiente) > 0) {

                    libros.set(j, siguiente);
                    libros.set(j + 1, actual);
                }
            }
        }
    }

    public List<Libro> todos() {

        ordenar();

        List<Libro> copia = new ArrayList<>();

        for (Libro l : libros) {
            copia.add(new Libro(l));
        }
        return copia;
    }
}