
public abstract class Employee {
    private int employeeId;
    private String employeeName;
    private String department;
    private int leaveBalance;
    private final int maximumLeaveBalance;
    private int approvedLeaveDays;

    public Employee(int employeeId, String employeeName,
                    String department, int leaveBalance) {
        if (leaveBalance < 0) {
            throw new IllegalArgumentException(
                "Leave balance cannot be negative.");
        }

        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.leaveBalance = leaveBalance;
        this.maximumLeaveBalance = leaveBalance;
        this.approvedLeaveDays = 0;
    }

    public abstract String getEmployeeType();

    // Different employee types can override this rule.
    public abstract int getMaximumDaysPerRequest();

    // Method overloading
   public void applyLeave(int days) {
    applyLeave(days, "Personal leave");
}

    public void applyLeave(int days, String reason) {
        if (days <= 0) {
            System.out.println("Days must be greater than zero.");
            return;
        }

        if (days > getMaximumDaysPerRequest()) {
            System.out.println("Leave rejected: maximum allowed per request is "
                    + getMaximumDaysPerRequest() + " days.");
            return;
        }

        if (reason == null || reason.trim().isEmpty()
                || reason.equalsIgnoreCase("Not specified")) {
            System.out.println("Please provide a leave reason.");
            return;
        }

        if (days > leaveBalance) {
            System.out.println("Leave rejected: insufficient leave balance.");
            return;
        }

        leaveBalance -= days;
        approvedLeaveDays += days;

        System.out.println("Leave approved successfully!");
        System.out.println("Employee: " + employeeName);
        System.out.println("Reason: " + reason);
        System.out.println("Days approved: " + days);
        checkLeaveBalance();
    }

    public void cancelLeave(int days) {
        if (days <= 0) {
            System.out.println("Days must be greater than zero.");
            return;
        }

        if (days > approvedLeaveDays) {
            System.out.println("Cancellation rejected: not enough approved "
                    + "leave days to cancel.");
            return;
        }

        approvedLeaveDays -= days;
        leaveBalance += days;

        System.out.println("Leave cancelled successfully!");
        checkLeaveBalance();
    }

    public void checkLeaveBalance() {
        System.out.println("Current leave balance: "
                + leaveBalance + " day(s)");
    }

    public void displayDetails() {
        System.out.println("\n------------------------------");
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + employeeName);
        System.out.println("Department: " + department);
        System.out.println("Type: " + getEmployeeType());
        System.out.println("Leave balance: " + leaveBalance);
        System.out.println("Initial leave allowance: "
                + maximumLeaveBalance);
        System.out.println("Approved leave days: " + approvedLeaveDays);
        System.out.println("------------------------------");
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getLeaveBalance() {
        return leaveBalance;
    }
}
