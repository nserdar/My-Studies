package main.java.advanceTopics;

import java.util.List;

public class Student {
    String firstName;
    String lastName;
    int grade;
    int no;

    public Student(String firstName, String lastName, int no, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.no = no;
        this.grade = grade;
    }

    public void showFullName(List<Student> list, int no) {
        for (Student student : list) {
            if (student.no == no) {
                System.out.println("Student full name : " + student.firstName + " " + student.lastName);
                return;  // Öğrenci bulunduğunda işlemi sonlandır
            }
        }
        System.out.println("Öğrenci bulunamadı");
    }

    public static void allStudents(List<Student> list) {
        for (Student student : list) {
            System.out.println(student.firstName + " " + student.lastName + " " + student.no);
        }
    }
}
