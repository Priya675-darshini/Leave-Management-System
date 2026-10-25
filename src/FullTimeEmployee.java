
public class FullTimeEmployee extends Employee {
    public FullTimeEmployee(int employeeId, String employeeName,
                            String department) {
        super(employeeId, employeeName, department, 20);
    }

    @Override
    public String getEmployeeType() {
        return "Full-Time Employee";
    }

    @Override
    public int getMaximumDaysPerRequest() {
        return 10;
    }
}
