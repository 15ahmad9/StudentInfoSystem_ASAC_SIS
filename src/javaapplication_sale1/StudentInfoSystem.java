package javaapplication_sale1;

import java.util.ArrayList;
import java.util.Scanner;

class Student {

    private String name;
    private float age;
    private String major;
    private float gpa;
    private int level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}

class GradesAnalyzer {

    public static float findMinGPA(ArrayList<Student> students) {
        float minGPA = Float.MAX_VALUE;
        for (Student student : students) {
            if (student.getGpa() < minGPA) {
                minGPA = student.getGpa();
            }
        }
        return minGPA;
    }

    public static float findMaxGPA(ArrayList<Student> students) {
        float maxGPA = Float.MIN_VALUE;
        for (Student student : students) {
            if (student.getGpa() > maxGPA) {
                maxGPA = student.getGpa();
            }
        }
        return maxGPA;
    }

    public static float calculateAvgGPA(ArrayList<Student> students) {
        float totalGPA = 0;
        for (Student student : students) {
            totalGPA += student.getGpa();
        }
        return totalGPA / students.size();
    }
}

public class StudentInfoSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("Enter the number of students:");
        int numStudents = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numStudents; i++) {
            Student student = new Student();
            System.out.println("Enter student name:");
            student.setName(scanner.nextLine());

            System.out.println("Enter student age:");
            student.setAge(scanner.nextFloat());
            scanner.nextLine();

            System.out.println("Enter student major:");
            student.setMajor(scanner.nextLine());

            System.out.println("Enter student GPA:");
            student.setGpa(scanner.nextFloat());

            System.out.println("Enter student level:");
            student.setLevel(scanner.nextInt());
            scanner.nextLine();

            students.add(student);
        }

        System.out.println("Options:");
        System.out.println("1. Find Min GPA");
        System.out.println("2. Find Max GPA");
        System.out.println("3. Calculate Average GPA");
        System.out.println("Enter your choice: ");
        
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                System.out.println("Min GPA: " + GradesAnalyzer.findMinGPA(students));
                break;
            case 2:
                System.out.println("Max GPA: " + GradesAnalyzer.findMaxGPA(students));
                break;
            case 3:
                System.out.println("Average GPA: " + GradesAnalyzer.calculateAvgGPA(students));
                break;
            default:
                System.out.println("Invalid choice");
        }

        scanner.nextLine();

        System.out.print("Enter student name to search: ");
        String searchName = scanner.nextLine();
        boolean found = false;

        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(searchName)) {
                found = true;
                System.out.println("Student found:");
                System.out.println("Name: " + student.getName());
                System.out.println("Age: " + student.getAge());
                System.out.println("Major: " + student.getMajor());
                System.out.println("GPA: " + student.getGpa());
                System.out.println("Level: " + student.getLevel());
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }
}
