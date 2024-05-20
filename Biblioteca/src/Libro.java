
//Autora: Núria Marzo

public class Libro {

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
