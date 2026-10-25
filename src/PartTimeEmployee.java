
public class PartTimeEmployee extends Employee {
    public PartTimeEmployee(int employeeId, String employeeName,
                            String department) {
        super(employeeId, employeeName, department, 10);
    }

    @Override
    public String getEmployeeType() {
        return "Part-Time Employee";
    }

    @Override
    public int getMaximumDaysPerRequest() {
        return 5;
    }
}
