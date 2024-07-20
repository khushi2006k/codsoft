import java.util.Scanner;
   public class GradeCalculator {
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
    
            System.out.print("Enter the number of subjects: ");
            int numSubjects = scanner.nextInt();
    
            int totalMarks = 0;
            int[] marks = new int[numSubjects];
    
            for (int i = 0; i < numSubjects; i++) {
                System.out.printf("Enter marks for subject %d (out of 100): ", i + 1);
                marks[i] = scanner.nextInt();
                totalMarks += marks[i];
            }
    
            double averagePercentage = (double) totalMarks / numSubjects;
    
            char grade;
            if (averagePercentage >= 90) {
                grade = 'A';
            } else if (averagePercentage >= 80) {
                grade = 'B';
            } else if (averagePercentage >= 70) {
                grade = 'C';
            } else if (averagePercentage >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }
    
            System.out.println("Results:");
            System.out.println("Total Marks: " + totalMarks);
            System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
            System.out.println("Grade: " + grade);
    
            scanner.close();
        }
    }
      

