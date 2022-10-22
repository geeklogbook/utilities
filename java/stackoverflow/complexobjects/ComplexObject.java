package stackoverflow.complexobjects;

import java.util.ArrayList;
import java.util.List;

public class ComplexObject {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Navin", 40));
        students.add(new Student(2, "Pooja", 80));
        students.add(new Student(3, "Nadeem", 60));

        for (Student s : students) {
            if (s.marks >= 60)
                System.out.println(s);
        }

        /*
         * students.stream().filter(new Predicate<Student>()
         * {
         * public boolean test(Student s){
         * if(s.marks>=60)
         * return true;
         * else
         * return false;
         * }
         * }).forEach(s -> System.out.println(s));
         */

        students.stream().filter(s -> s.marks >= 60).forEach(s -> System.out.println(s));

    }

}
