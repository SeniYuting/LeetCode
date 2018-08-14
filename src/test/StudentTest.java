package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentTest {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        Student s1 = new Student(1);
        Student s2 = new Student(3);
        Student s3 = new Student(2);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        Collections.sort(list);

        for (Student s : list) {
            System.out.println(s.age);
        }
    }
}
