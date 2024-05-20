
//Autora: Núria Marzo

import java.util.ArrayList;
import java.util.List;

public class Autor {
    private String nombre;
    private List<Libro> libros; //llista de llibres escrits per l'autor

    public Autor(String nombre) { 
        this.nombre = nombre;
        this.libros = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void publicarLibro(Libro libro) {
        libros.add(libro); //agrega un llibre a la llista de llibres de l'autor.
    }
}
