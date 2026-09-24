package com.campus.app;

import com.campus.model.Student;
import com.campus.service.StudentService;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Inputs from user
        System.out.print("Enter Student ID: ");
        int studentId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter Student Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Department: ");
        String department = sc.nextLine();

        System.out.print("Number of subjects: ");
        int n = sc.nextInt();

        int[] marks = new int[n];

        System.out.println("Enter the marks of " + n + " subjects:");

        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }

        // Create Student object
        Student student = new Student(
                studentId,
                studentName,
                age,
                department,
                marks
        );

        // Display student information
        student.displayStudentInfo(true);

        // Display student count
        Student.displayStudentCount();

        // Create service object
        StudentService studentService = new StudentService();

        // Display report card
        studentService.displayReportCard(student);

        sc.close();
    }
}