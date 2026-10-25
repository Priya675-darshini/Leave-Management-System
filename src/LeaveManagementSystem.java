
import java.util.Scanner;

public class LeaveManagementSystem {

    private static final Scanner scanner = new Scanner(System.in);

    private static final Employee[] employees = {
        new FullTimeEmployee(101, "Rahul", "IT"),
        new PartTimeEmployee(102, "Priya", "HR"),
        new Intern(103, "Arun", "Engineering"),
        new Manager(104, "Sneha", "Management")
    };

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n================================");
            System.out.println("     LEAVE MANAGEMENT SYSTEM");
            System.out.println("================================");
            System.out.println("1. View Employee Details");
            System.out.println("2. Apply for Leave");
            System.out.println("3. Cancel Leave");
            System.out.println("4. Check Leave Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = readInteger();

            switch (choice) {
                case 1:
                    viewAllEmployees();
                    break;

                case 2:
                    applyForLeave();
                    break;

                case 3:
                    cancelLeave();
                    break;

                case 4:
                    checkBalance();
                    break;

                case 5:
                    System.out.println(
                        "Thank you for using the system!");
                    break;

                default:
                    System.out.println(
                        "Invalid choice. Please select 1 to 5.");
            }

        } while (choice != 5);

        scanner.close();
    }

    private static int readInteger() {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }

        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    private static Employee findEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == id) {
                return employee;
            }
        }
        return null;
    }

    private static Employee askForEmployee() {
        System.out.print("Enter employee ID: ");
        int id = readInteger();

        Employee employee = findEmployee(id);

        if (employee == null) {
            System.out.println("Employee ID not found.");
        }

        return employee;
    }

    private static void viewAllEmployees() {
        for (Employee employee : employees) {
            employee.displayDetails();
        }
    }

    private static void applyForLeave() {
        Employee employee = askForEmployee();

        if (employee == null) {
            return;
        }

        System.out.print("Enter number of leave days: ");
        int days = readInteger();

        System.out.print("Enter leave reason: ");
        String reason = scanner.nextLine();

        employee.applyLeave(days, reason);
    }

    private static void cancelLeave() {
        Employee employee = askForEmployee();

        if (employee == null) {
            return;
        }

        System.out.print("Enter number of days to cancel: ");
        int days = readInteger();

        employee.cancelLeave(days);
    }

    private static void checkBalance() {
        Employee employee = askForEmployee();

        if (employee != null) {
            System.out.println("Employee: "
                    + employee.getEmployeeName());
            employee.checkLeaveBalance();
        }
    }
}
