
public class Intern extends Employee {
    public Intern(int employeeId, String employeeName,
                  String department) {
        super(employeeId, employeeName, department, 5);
    }

    @Override
    public String getEmployeeType() {
        return "Intern";
    }

    @Override
    public int getMaximumDaysPerRequest() {
        return 2;
    }
}
