package com.campus.service;

import com.campus.model.Student;

public class StudentService {

    // Calculate Total Marks
    public int calculateTotalMarks(Student student) {

        if (student.getMarks() == null) {
            return 0;
        }

        int totalMarks = 0;

        int[] marks = student.getMarks();

        for (int mark : marks) {
            totalMarks += mark;
        }

        return totalMarks;
    }

    // Calculate Average Marks
    public double calculateAverageMarks(Student student) {

        if (student.getMarks() == null ||
            student.getMarks().length == 0) {

            return 0.0;
        }

        int[] marks = student.getMarks();

        int totalMarks = calculateTotalMarks(student);

        return (double) totalMarks / marks.length;
    }

    // Find Maximum Marks
    public int findMaximumMarks(Student student) {

        if (student.getMarks() == null ||
            student.getMarks().length == 0) {

            return 0;
        }

        int[] marks = student.getMarks();

        int maxMarks = marks[0];

        for (int mark : marks) {

            if (mark > maxMarks) {
                maxMarks = mark;
            }
        }

        return maxMarks;
    }

    // Find Minimum Marks
    public int findMinimumMarks(Student student) {

        if (student.getMarks() == null ||
            student.getMarks().length == 0) {

            return 0;
        }

        int[] marks = student.getMarks();

        int minMarks = marks[0];

        for (int mark : marks) {

            if (mark < minMarks) {
                minMarks = mark;
            }
        }

        return minMarks;
    }

    // Calculate Grade
    public char grade(Student student) {

        int[] marks = student.getMarks();

        if (marks == null || marks.length == 0) {
            return 'F';
        }

        double average = calculateAverageMarks(student);

        if (average >= 90) {
            return 'A';
        }
        else if (average >= 80) {
            return 'B';
        }
        else if (average >= 70) {
            return 'C';
        }
        else if (average >= 60) {
            return 'D';
        }
        else {
            return 'F';
        }
    }

    // Pass or Fail
    public String passOrFail(Student student) {

        int[] marks = student.getMarks();

        if (marks == null || marks.length == 0) {
            return "Fail";
        }

        double average = calculateAverageMarks(student);

        if (average >= 40) {
            return "Pass";
        }
        else {
            return "Fail";
        }
    }

    // Display Report Card
    public void displayReportCard(Student student) {

        System.out.println("\n========== REPORT CARD ==========");

        System.out.println("Student Name: "
                + student.getStudentName());

        System.out.println("Student ID: "
                + student.getStudentId());

        System.out.println("Age: "
                + student.getStudentAge());

        System.out.println("Department: "
                + student.getDepartment());

        System.out.println("Total Marks: "
                + calculateTotalMarks(student));

        System.out.printf("Average Marks: %.2f%n",
                calculateAverageMarks(student));

        System.out.println("Maximum Marks: "
                + findMaximumMarks(student));

        System.out.println("Minimum Marks: "
                + findMinimumMarks(student));

        System.out.println("Grade: "
                + grade(student));

        System.out.println("Pass/Fail: "
                + passOrFail(student));

        System.out.println("=================================");
    }
}