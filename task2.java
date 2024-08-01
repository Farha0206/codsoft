import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter the number of subject");
        int numberofSubjects = scanner.nextInt();

        int[] marks = new int[numberofSubjects];
        int totalMarks = 0;

        for (int i = 0; i < numberofSubjects; i++ ){
            System.out.println("enter marks obtained in subjects" + (i + 1) + ":");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];

        }

        double averagePercentage = (double) totalMarks/ numberofSubjects;

        char grade;
        if(averagePercentage >= 90){
            grade = 'A';
        } 
        else if (averagePercentage >= 80) {
            grade = 'B';
        }
        else if (averagePercentage >= 70) {
            grade = 'C';
        }
        else if (averagePercentage >= 60) {
            grade = 'D';
            
        }
        else{
            grade = 'F';
        }
        System.out.println(("Result"));
        System.out.println("Total Marks" + totalMarks);
        System.out.println("Average Percentage" + averagePercentage);
        System.out.println("Grade" + grade);
    }
}
