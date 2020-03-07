

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;


@Getter
@Setter
@NoArgsConstructor

public class Student {
    // Stwórz aplikację, a w niej klasę Dziennik i Student. Klasa Student powinna:
    //    - posiadać listę ocen studenta (List<Double>)
    //    - posiadać (pole) numer indeksu studenta (String)
    //    - posiadać (pole) imię studenta
    //    - posiadać (pole) nazwisko studenta

    private List<Double> listaOcen = new ArrayList<>();
    private String nrIndeksu;
    private String imie;
    private String nazwisko;


    public Student(String nrIndeksu, String imie, String nazwisko) {
        this.nrIndeksu = nrIndeksu;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    @Override
    public String toString() {
        return "Student{" +
                "listaOcen=" + listaOcen +
                ", nrIndeksu='" + nrIndeksu + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                '}';
    }



    public Double obliczSrednia (){
        double suma = 0.0;
        for (int i = 0; i <listaOcen.size() ; i++) {
            suma +=listaOcen.get(i);
        }

        // forma2
        //  suma = listaOcen.stream().mapToDouble(Double::doubleValue).sum();

        // forma3 (od razu daje wynik) - i zabespiecza przed brakeim ocen
        OptionalDouble srednia = listaOcen.stream().mapToDouble(Double::doubleValue).average();
        return srednia.orElse(0.0);

        // forma1
       // return suma/listaOcen.size();
    }

}
