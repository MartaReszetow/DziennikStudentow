package DziennikStudentow;

import java.util.*;
import java.util.stream.Collectors;

public class Dziennik {
//Klasa DziennikStudentow.Dziennik powinna:
//    - posiadać (jako pole) listę Studentów.
//    - posiadać metodę 'dodajStudenta(DziennikStudentow.Student):void' do dodawania nowego studenta do dziennika
//    - posiadać metodę 'usuńStudenta(DziennikStudentow.Student):void' do usuwania studenta
//    - posiadać metodę 'usuńStudenta(String):void' do usuwania studenta po jego numerze indexu
//    - posiadać metodę 'zwróćStudenta(String):DziennikStudentow.Student' która jako parametr przyjmuje numer indexu studenta,
//      a w wyniku zwraca konkretnego studenta.
//    - posiadać metodę 'podajŚredniąStudenta(String):double' która przyjmuje indeks studenta i zwraca średnią ocen studenta. (ZROBIONE W STUDENCIE)
//    - posiadać metodę 'podajStudentówZagrożonych():List<DziennikStudentow.Student>'
//    - posiadać metodę 'posortujStudentówPoIndeksie():List<DziennikStudentow.Student>' - która sortuje listę studentów po numerach indeksów, a następnie zwraca posortowaną listę.
//    - posiadać metodę ‘dodajOcene(String, Double):void’

    List<Student> studentList = new ArrayList<Student>();

    public void dodajStudenta(Student student) {
        studentList.add(student);
    }

    public void usunStudenta(Student student) {
        studentList.remove(student);
    }

    public void usunStudenta(String indexNumber) {

        for (Student singleStudent : studentList
        ) {
            if (singleStudent.getNrIndeksu().equalsIgnoreCase(indexNumber)) {
                studentList.remove(singleStudent);
                break;
            }
        }

    }
    // możnaby zrobić metodę z iteratorem

//    Iterator<DziennikStudentow.Student> it = studentList.iterator();
//    while (it.hasNext()){
//        DziennikStudentow.Student st = it.hasNext();
//        if(st.getNrIndeksu().equalsIgnoreCase(indexNumber)){
//            it.remove();
//        }
//    }


    public Optional<Student> zwrocStudenta(String indexNumber) {
        for (Student singleStudent : studentList
        ) {
            if (singleStudent.getNrIndeksu().equalsIgnoreCase(indexNumber)) {
                return Optional.of(singleStudent);
            }
        }
        return Optional.empty();
    }


    public Optional<Double> podajStredniaStudenta(String index) {
        Optional<Student> studentOptional = zwrocStudenta(index);
        if (studentOptional.isPresent()) {
            Student st = studentOptional.get();
            return Optional.of(st.obliczSrednia());
        }
        return Optional.empty();
    }


    public List<Student> zworocStudentowZagrozonych(Student student) {
        return studentList.stream().
                filter(student1 -> student.obliczSrednia() <= 2.5)
                .collect(Collectors.toList());
    }


    public List<Student> posortujStudentowPoIndeksie(List<Student> students) {
        Collections.sort(studentList, new Comparator<Student>() {

            //-1
            //0
            //1m -- pierwszy wiekszy
            @Override
            public int compare(Student student1, Student student2) {
                Long s1 = Long.parseLong(student1.getNrIndeksu());
                Long s2 = Long.parseLong(student2.getNrIndeksu());

                return s1.compareTo(s2); // -1 0 1
            }
        });
        return studentList;
    }

    public void dodajOcene(String indexNr, Double ocena) {
        Optional<Student> studentOptional = zwrocStudenta(indexNr);
        if (studentOptional.isPresent()) {
            Student st = studentOptional.get();
            st.getListaOcen().add(ocena);
        } else {
            throw new RuntimeException("Nie udało odnaleźć studenta!");
        }
    }


}
