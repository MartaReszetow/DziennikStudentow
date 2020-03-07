import java.util.List;

public class Student {
    // Stwórz aplikację, a w niej klasę Dziennik i Student. Klasa Student powinna:
    //    - posiadać listę ocen studenta (List<Double>)
    //    - posiadać (pole) numer indeksu studenta (String)
    //    - posiadać (pole) imię studenta
    //    - posiadać (pole) nazwisko studenta
    List<Double> listaOcen;
    String nrIndeksu;
    String imie;
    String nazwisko;


    public Student(String nrIndeksu, String imie, String nazwisko) {
        this.nrIndeksu = nrIndeksu;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }
}
