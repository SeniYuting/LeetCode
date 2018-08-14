package test;

public class Student implements Comparable<Student> {

    int age;

    public Student(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Student s) {  // 降序
        return s.age - age;
    }
}
