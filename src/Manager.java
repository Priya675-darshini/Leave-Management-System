
public class Manager extends Employee {
    public Manager(int employeeId, String employeeName,
                   String department) {
        super(employeeId, employeeName, department, 25);
    }

    @Override
    public String getEmployeeType() {
        return "Manager";
    }

    @Override
    public int getMaximumDaysPerRequest() {
        return 15;
    }
}
