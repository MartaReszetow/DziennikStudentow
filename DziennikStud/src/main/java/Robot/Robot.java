package Robot;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Robot {

    // Stwórz klasę Robot która posiada pola:
    //- poziom baterii ( wartość od 0 do 100)
    //- nazwa robota
    //- czy włączony
    //
    //Stwórz metody:
    //- poruszRobotem(RuchRobota):void - ktora porusza robotem jeśli robot posiada dostateczną ilość energii
    // (oraz odejmuje zadaną ilość energii z robota)
    //- naładujRobota():void - która zwiększa ilość % baterii do 100%
    //- włączRobota():void - włącza robota
    //- wyłączRobota():void - wyłącza robota
    //
    //UWAGI:
    //Robot nie może się poruszać kiedy jest wyłączony!
    //Robot może być ładowany tylko gdy jest wyłączony!
    //Dodaj obsługę komend:
    //  ruch RUCH
    //  naladuj
    //  wlacz
    //  wylacz
    @Getter
    @Setter

    private int poziomBaterii = 100;
    private String nazwaRobota;
    private boolean czyWlaczony = false;


    public Robot( String nazwaRobota) {
        this.nazwaRobota = nazwaRobota;
    }

    public void poruszRObotem(RuchRobota ruchRobota) {
        if (!czyWlaczony) {
            System.err.println("Robot jest wylaczony");
            return;
        }
        if (poziomBaterii >= ruchRobota.getZuzycieEnergii()) {
            System.out.println("Wykonuję ruch robota");
            poziomBaterii -= ruchRobota.getZuzycieEnergii();
            System.out.println("Pozostało baterii:"  + poziomBaterii);
        } else {
            System.err.println("Niewystarczająca ilość energii");
        }
    }

    public void naladujRobota() {
        if (czyWlaczony) {
            // nie może się ładować
            System.err.println("Nie można ładoać robota, robot włączony");
        } else {
            poziomBaterii = 100;
            System.out.println("Robot naładowany");
        }
    }

    public void włącz() {

        if (czyWlaczony) {
            System.err.println("Robot jest juz wlaczony");
        } else {
            czyWlaczony = true;
        }
    }

    public void wyłącz() {
        if (!czyWlaczony) {
            System.err.println("Robot jest już wyłaczony");
        } else {
            czyWlaczony = false;
        }
    }

}
