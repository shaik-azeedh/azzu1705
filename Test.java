import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter marks for subject 1: ");
        int mark1 = scanner.nextInt();

        System.out.print("Enter marks for subject 2: ");
        int mark2 = scanner.nextInt();

        System.out.print("Enter marks for subject 3: ");
        int mark3 = scanner.nextInt();

        int total = mark1 + mark2 + mark3;
        double average = total / 3.0;
        boolean pass = mark1 >= 35 && mark2 >= 35 && mark3 >= 35;

        System.out.println("\nStudent: " + name);
        System.out.println("Total marks: " + total);
        System.out.printf("Average marks: %.2f%n", average);
        System.out.println("Result: " + (pass ? "Azeedh Great Person Passed" : "Try Bro Next Time"));

        scanner.close();
    }
}
