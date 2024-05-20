import java.util.ArrayList;
import java.util.List;

public class MiembroPremium extends Usuario {
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
