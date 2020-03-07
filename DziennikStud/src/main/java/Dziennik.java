import java.util.List;

public class Dziennik {
//Klasa Dziennik powinna:
//    - posiadać (jako pole) listę Studentów.
//    - posiadać metodę 'dodajStudenta(Student):void' do dodawania nowego studenta do dziennika
//    - posiadać metodę 'usuńStudenta(Student):void' do usuwania studenta
//    - posiadać metodę 'usuńStudenta(String):void' do usuwania studenta po jego numerze indexu
//    - posiadać metodę 'zwróćStudenta(String):Student' która jako parametr przyjmuje numer indexu studenta,
//      a w wyniku zwraca konkretnego studenta.
//    - posiadać metodę 'podajŚredniąStudenta(String):double' która przyjmuje indeks studenta i zwraca średnią ocen studenta.
//    - posiadać metodę 'podajStudentówZagrożonych():List<Student>'
//    - posiadać metodę 'posortujStudentówPoIndeksie():List<Student>' - która sortuje listę studentów po numerach indeksów, a następnie zwraca posortowaną listę.
//    - posiadać metodę ‘dodajOcene(String, Double):void’

    List<Student> studentList;

    public void dodajStudenta(Student student) {
        studentList.add(student);
    }

    public void usunStudenta(Student student) {
        studentList.remove(student);
    }

    public void usunStudenta(String indexNumber) {
        studentList.remove(indexNumber);
    }

    public Student zwrocStudenta (String indexNumber){
        Student student = studentList.get(indexNumber);
    }





}
