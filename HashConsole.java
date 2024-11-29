import java.util.HashMap;
import java.util.Scanner;

public class StudentGradeManager {
    public static void main(String[] args) {
        HashMap<String, Double> studentGrades = new HashMap<>();
        Scanner gv = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Student Grade Manager ===");
            System.out.println("1. Add Student");
            System.out.println("2. Get Student Grade");
            System.out.println("3. Update Student Grade");
            System.out.println("4. Delete Student Record");
            System.out.println("5. Display All Records");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = gv.nextInt();
            gv.nextLine(); 

            switch (choice) {
                case 1: 
                    System.out.print("Enter student name: ");
                    String name = gv.nextLine();
                    System.out.print("Enter grade: ");
                    double grade = gv.nextDouble();
                    studentGrades.put(name, grade);
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    System.out.print("Enter student name: ");
                    name = gv.nextLine();
                    if (studentGrades.containsKey(name)) {
                        System.out.println(name + "'s Grade: " + studentGrades.get(name));
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3: 
                    System.out.print("Enter student name: ");
                    name = gv.nextLine();
                    if (studentGrades.containsKey(name)) {
                        System.out.print("Enter new grade: ");
                        grade = gv.nextDouble();
                        studentGrades.put(name, grade);
                        System.out.println("Grade updated successfully!");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4: 
                    System.out.print("Enter student name: ");
                    name = gv.nextLine();
                    if (studentGrades.remove(name) != null) {
                        System.out.println("Student record deleted successfully!");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    if (studentGrades.isEmpty()) {
                        System.out.println("No records found.");
                    } else {
                        System.out.println("=== Student Records ===");
                        for (HashMap.Entry<String, Double> entry : studentGrades.entrySet()) {
                            System.out.println("Name: " + entry.getKey() + ", Grade: " + entry.getValue());
                        }
                    }
                    break;

                case 6: 
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        gv.close();
    }
}
