import java.util.ArrayList;
import java.util.List;

public class Usuario {
private String nombre;
    private List<Libro> librosPrestados;  //llista de llirbes que l'usuari ha agafat prestats.

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.librosPrestados = new ArrayList<>(); //Al constructor s'inicialitzen els atributs, creant una nova llista de llibres prestats buida
    }

    public String getNombre() {
        return nombre;
    }

    public void tomarPrestado(Libro libro) {  //Aquest mètode pren un llibre com a entrada, verifica si està disponible per a préstec, l'afegeix a una llista de llibres prestats i el marca com a prestat si està disponible. Després, s'imprimeix un missatge confirmant el préstec o informant a l'usuari que el llibre no està disponible.
        if (libro.isDisponible()) { 
            librosPrestados.add(libro);
            libro.marcarPrestado();
            System.out.println(nombre + " ha tomado prestado el libro: " + libro.getTitulo());
        } else {
            System.out.println("El libro " + libro.getTitulo() + " no está disponible para préstamo.");
        }
    }

    public void devolverLibro(Libro libro) {
        librosPrestados.remove(libro);
        libro.marcarDevuelto();
        System.out.println(nombre + " ha devuelto el libro: " + libro.getTitulo());
    }
}
