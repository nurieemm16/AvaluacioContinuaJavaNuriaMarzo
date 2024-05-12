// Autora: Núria Marzo
//Importem les classes Array List i List del paquet java.util, ja que són necessaries per treballar amb les llistes de Java.
import java.util.ArrayList;
import java.util.List;

// Classe Llibre
class Libro {
    private String titulo;
    private Autor autor;
    private boolean disponible;

    public Libro(String titulo, Autor autor) { //Constructor
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
        autor.publicarLibro(this);
    }

    public String getTitulo() { //Mètode d'acces
        return titulo;
    }

    public Autor getAutor() {//Mètode de modificació
        return autor;
    }

    public boolean isDisponible() { //Per defecte estarà disponible
        return disponible;
    }

    public void marcarPrestado() { //Quan estigui prestat, el disponible passarà a false
        disponible = false;
    }

    public void marcarDevuelto() { //canvia l'estat de disponibilitat del llibre quan es presta o es retorna
        disponible = true;
    }
}

// Classe Autor
class Autor {
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

// Classe Usuari
class Usuario {
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

// Classe MiembroPremium (hereda d'usuari)
class MiembroPremium extends Usuario {
    private List<Libro> librosReservados;//Aquest atribut és una llista que emmagatzemarà els llibres reservats pel membre premium.

    public MiembroPremium(String nombre) { 
        super(nombre);//Fa servir super per cridar al constructor de la classe padre d'Usuari i passar-li el nom del membre premium
        this.librosReservados = new ArrayList<>(); //inicialitza la llista librosReservados creant una nova instància de ArrayList
    }

    public void reservarLibro(Libro libro) { //Aquest mètode permet al membre premium reservar un llibre. Pren un paràmetre libro que representa el libro que es vol reservar.
        if (!libro.isDisponible()) { //Comprovació de disponibilitat: Es verifica si el libro no està disponible invocant al mètode isDisponible() de l'objecte libro. Si el llibre no està disponible (ja està prestat), s'executa el bloc de codi dins de l'If.
            librosReservados.add(libro);//En aquest cas, s'afegeix el libro a la llista de llibres reservats (librosPrestados) del membre premium usant el mètode add() de la llista. Després, s'imprimeix un missatge que indica que el membre premium ha reservat el llibre.
            System.out.println(super.getNombre() + " ha reservado el libro: " + libro.getTitulo());
        } else {
            super.tomarPrestado(libro); //Si el llibre està disponible, es crida al mètode tomarPrestado de la classe base Usuari usant la paraula clau super. Això permet al membre premium prendre el llibre prestat com ho faria un usuari normal.
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Crear els autors
        Autor autor1 = new Autor("Santiago Posteguillo");
        Autor autor2 = new Autor("Brandon Sanderson");
        Autor autor3 = new Autor("Ken Follett");

        // Crear els llibres
        Libro libro1 = new Libro("Yo, Julia", autor1);
        Libro libro2 = new Libro("Roma soy yo", autor1);
        Libro libro3 = new Libro("El aliento de los Dioses", autor2);
        Libro libro4 = new Libro("Elantris", autor2);
        Libro libro5 = new Libro("Los Pilares de la tierra", autor3);

        // Crear els usuaris
        Usuario usuario1 = new Usuario("Núria");
        Usuario usuario2 = new Usuario("Maya");
        MiembroPremium premium1 = new MiembroPremium("Alex");
        MiembroPremium premium2 = new MiembroPremium("Vinyet");

        // Demostració de relacions
        usuario1.tomarPrestado(libro1);
        usuario1.tomarPrestado(libro4);
        usuario1.devolverLibro(libro4);
        premium1.reservarLibro(libro3);
        premium1.reservarLibro(libro2);
        premium1.reservarLibro(libro1);
        premium2.reservarLibro(libro5);
        usuario2.tomarPrestado(libro3);
    }
}