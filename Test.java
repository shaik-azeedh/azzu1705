import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter marks for Physics: ");
        int PHYSICS = scanner.nextInt();

        System.out.print("Enter marks for Mathematics: ");
        int MATH = scanner.nextInt();

        System.out.print("Enter marks for COMPUTERS: ");
        int COMPUTER = scanner.nextInt();

        int total = PHYSICS + MATH + COMPUTER;
        double average = total / 3.0;
        boolean pass = PHYSICS >= 35 && MATH >= 35 && COMPUTER >= 35;

        System.out.println("\nStudent: " + name);
        System.out.println("Total marks: " + total);
        System.out.printf("Average marks: %.2f%n", average);
        System.out.println("Result: " + (pass ? "Azeedh Great Person Passed" : "Try Bro Next Time"));

        scanner.close();
    }
}

NOTE : Program Must be saved in Test01.java

    compile : javac Test01.java
    Run     : java Test01
