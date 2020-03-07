import java.util.Optional;

public class MainApp {
    public static void main(String[] args) {

        Student s1 = new Student("1", "AAA", "AAA");
        Student s2 = new Student("2", "BBB", "BBB");
        Student s3 = new Student("3", "CCC", "CCC");
        Student s4 = new Student("4", "DDD", "DDD");
        Student s5 = new Student("5", "EEE", "EEE");
        Student s6 = new Student("6", "FFF", "FFF");

        Dziennik d1 = new Dziennik();
        d1.dodajStudenta(s1);
        d1.dodajStudenta(s2);
        d1.dodajStudenta(s3);
        d1.dodajStudenta(s4);
        d1.dodajStudenta(s5);

        d1.usunStudenta("3");
        d1.usunStudenta("4");

        for (Student student : d1.studentList
        ) {
            System.out.println(student);
        }


        // ______ ZWRACANEI STUDENTA JESLI ISTNUEJE - OPTIONAL
        System.out.println("szukany student:");
        Optional<Student> pudelko = d1.zwrocStudenta("1");
        if (pudelko.isPresent()){
            Student s=pudelko.get();
            System.out.println(s.getImie());
        }

        System.out.println("LISTA POSORTOWANYCH STUDENTOW:");

        d1.posortujStudentowPoIndeksie(d1.studentList).forEach(System.out::println);
        d1.posortujStudentowPoIndeksie(d1.studentList).forEach(s-> System.out.println(s));





    }
}
