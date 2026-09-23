package com.campus.service;

import com.campus.model.Student;

public class StudentService{
    //calculate total marks
    public int calculateTotal(Student student) {
        if (marks == null){
            return 0;
        }
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }
    //calculate average marks
    public double calculateAverage(Student student) {
        if (marks == null || marks.length == 0) {
            return 0.0;
        }
        int total = calculateTotal(student);
        return (double) total / marks.length;
    }
    //find madximum marks
    public int findMaximum(Student student) {
        if (marks == null || marks.length == 0) {
            return Integer.MIN_VALUE; // or throw an exception
        }
        int max = marks[0];
        for (int mark : marks) {
            if (mark > max) {
                max = mark;
            }
        }
        return max;
    
    }
    //find minimum marks
    public int findMinimum(Student student) {
        if (marks == null || marks.length == 0) {
            return Integer.MAX_VALUE; // or throw an exception
        }
        int min = marks[0];
        for (int mark : marks) {
            if (mark < min) {
                min = mark;
            }
        }
        return min;
    }   
    //grade based an marks
    public char grade(Student student) {
        int[] marks = student.getMarks();
        if (marks == null || marks.length == 0) {
            return 'F'; // or throw an exception

        }
        int total = calculateTotal(student);
        int average = (int) calculateAverage(student);
        if (average >= 90) {
            return 'A';
        } else if (average >= 80) {
            return 'B';
        } else if (average >= 70) {
            return 'C';
        } else if (average >= 60) {
            return 'D';
        }else if (average >= 40) {
            return 'E';
         else {
            return 'F';
        }

    }
    //pass or fail
    public String passOrFail(Student student) {
        int[] marks = student.getMarks();
        if (marks == null || marks.length == 0) {
            return "Fail"; // or throw an exception
        }
        int average = (int) calculateAverage(student);
        if (average >= 40) {
            return "Pass";
        } else {
            return "Fail";
        }
    }

    //display report card
    public void displayReportCard(Student student) {
        System.out.println("Student Name: " + student.getStudentName());
        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("Department: " + student.getDepartment());
        System.out.println("Total Marks: " + calculateTotalMarks(student));
        System.out.println("Average Marks: " + calculateAverageMarks(student));
        System.out.println("Maximum Marks: " + findMaximumMarks(student));
        System.out.println("Minimum Marks: " + findMinimumMarks(student));
        System.out.println("Grade: " + grade(student));
        System.out.println("Result: " + passOrFail(student));
    }

}
