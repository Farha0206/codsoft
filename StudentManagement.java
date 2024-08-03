import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    private static final String FILE_NAME = "Student.txt";
    private List<Student> students;

    // Student class to represent individual students
    static class Student {
        private String name;
        private int rollNumber;
        private String grade;

        public Student(String name, int rollNumber, String grade) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.grade = grade;
        }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public int getRollNumber() { return rollNumber; }
        public void setRollNumber(int rollNumber) { this.rollNumber = rollNumber; }

        public String getGrade() { return grade; }
        public void setGrade(String grade) { this.grade = grade; }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", rollNumber=" + rollNumber +
                    ", grade='" + grade + '\'' +
                    '}';
        }
    }

    public StudentManagement() {
        this.students = new ArrayList<>();
        loadStudentsFromFile();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    private void saveStudentsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student student : students) {
                writer.write(student.getName() + "," + student.getRollNumber() + "," + student.getGrade());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadStudentsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    students.add(new Student(parts[0], Integer.parseInt(parts[1]), parts[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement sms = new StudentManagement();

        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();

                    if (!name.isEmpty() && !grade.isEmpty()) {
                        sms.addStudent(new Student(name, rollNumber, grade));
                        System.out.println("Student added successfully!");
                    } else {
                        System.out.println("Invalid input. Name and grade cannot be empty.");
                    }
                    break;

                case 2:
                    System.out.print("Enter roll number of the student to remove: ");
                    int rollToRemove = scanner.nextInt();
                    sms.removeStudent(rollToRemove);
                    System.out.println("Student removed successfully!");
                    break;

                case 3:
                    System.out.print("Enter roll number of the student to search: ");
                    int rollToSearch = scanner.nextInt();
                    Student student = sms.searchStudent(rollToSearch);
                    if (student != null) {
                        System.out.println(student);
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 4:
                    System.out.println("All Students:");
                    for (Student s : sms.getAllStudents()) {
                        System.out.println(s);
                    }
                    break;

                case 5:
                    sms.saveStudentsToFile();
                    System.out.println("Exiting and saving data...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
