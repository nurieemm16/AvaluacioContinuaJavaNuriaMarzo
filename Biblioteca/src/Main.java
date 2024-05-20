// Autora: Núria Marzo
//Importem les classes Array List i List del paquet java.util, ja que són necessaries per treballar amb les llistes de Java.

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
        usuario2.tomarPrestado(libro4);
    }
}