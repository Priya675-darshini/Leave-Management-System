
# Leave Management System

## 1. Project Objective

The Leave Management System is a Java console-based application developed to manage employee information and leave requests using Object-Oriented Programming (OOP) concepts.

The application allows users to view employee details, apply for leave, cancel previously approved leave, and check the remaining leave balance. It supports different employee types with different leave allowances and request limits.

## 2. Features

- View employee details.
- Apply for leave by entering an employee ID, number of days, and leave reason.
- Cancel previously approved leave.
- Check the remaining leave balance.
- Support different leave allowances for different employee types.
- Provide separate leave allowances and request limits for managers.
- Validate leave applications and cancellations.
- Display results through a menu-driven console interface.

## 3. Technologies Used

- **Programming Language:** Java 17 or later
- **Code Editor:** Visual Studio Code
- **Version Control:** Git
- **Repository Hosting:** GitHub

## 4. Project Structure

```text
Leave Management System/
├── src/
│   ├── Employee.java
│   ├── FullTimeEmployee.java
│   ├── PartTimeEmployee.java
│   ├── Intern.java
│   ├── Manager.java
│   └── LeaveManagementSystem.java
├── out/
├── README.md
├── .gitignore
├── class-diagram.png
└── screenshots/
```

The `src` folder contains the Java source files. The `out` folder stores compiled class files. The `screenshots` folder contains sample application outputs, if included.

## 5. Employee Types and Leave Allowances

| Employee Type | Initial Leave Allowance |
|---|---:|
| Full-Time Employee | 20 days |
| Part-Time Employee | 10 days |
| Intern | 5 days |
| Manager | 25 days |

These are sample allowances defined for this project and do not represent actual company leave policies. Each employee type also has its own maximum leave-request limit.

## 6. Class Descriptions

| Class | Responsibility |
|---|---|
| `Employee` | Abstract base class containing common employee information and leave-management methods. |
| `FullTimeEmployee` | Defines the employee type and request limit for full-time employees. |
| `PartTimeEmployee` | Defines the employee type and request limit for part-time employees. |
| `Intern` | Defines the employee type and request limit for interns. |
| `Manager` | Defines the employee type and request limit for managers. |
| `LeaveManagementSystem` | Contains the main method, menu, employee records and leave-management operations. |

## 7. Important Variables

### Employee.java

| Variable | Data Type | Purpose |
|---|---|---|
| `employeeId` | `int` | Stores the employee's unique ID. |
| `employeeName` | `String` | Stores the employee's name. |
| `department` | `String` | Stores the employee's department. |
| `leaveBalance` | `int` | Stores the current remaining leave days. |
| `maximumLeaveBalance` | `int` | Stores the maximum initial leave allowance. |
| `approvedLeaveDays` | `int` | Tracks approved leave days that have not been cancelled. |

The `LeaveManagementSystem` class uses a `Scanner` for user input and an array of `Employee` objects to manage employee records during program execution.

## 8. Object-Oriented Programming Concepts

### Encapsulation
Employee fields are declared private to protect employee information. Public methods provide controlled access to employee details and leave operations.

### Inheritance
`FullTimeEmployee`, `PartTimeEmployee`, `Intern`, and `Manager` extend the abstract `Employee` class and reuse its common functionality.

### Abstraction
The abstract `Employee` class defines common employee behavior and requires subclasses to implement employee-specific methods.

### Polymorphism
The application manages different employee types through common `Employee` references, while overridden methods provide type-specific behavior.

### Method Overriding
Subclasses override methods such as `getEmployeeType()` and `getMaximumDaysPerRequest()` to provide employee-specific information and rules.

### Method Overloading
The `applyLeave()` method has two versions: one accepts the number of leave days, while the other accepts the number of days and a reason.

### Access Modifiers
- `private`: Restricts direct access to fields and internal methods.
- `protected`: Allows access from subclasses and other permitted classes or packages, where used.
- `public`: Makes methods accessible wherever permitted by Java's access rules.

## 9. How to Compile and Run

Open the project folder in Visual Studio Code and open the integrated terminal.

If the `out` folder does not exist, create it:

```powershell
mkdir out
```

Compile the Java source files:

```powershell
javac -d out src/*.java
```

Run the application:

```powershell
java -cp out LeaveManagementSystem
```

Follow the displayed menu to view employee details, apply for leave, cancel leave, check leave balances, or exit the application.

## 10. Testing

| Test Scenario | Expected Result |
|---|---|
| View employee details | Displays employee information and leave balances. |
| Apply for valid leave with a reason | Displays a successful application message and updates the leave balance. |
| Enter different leave reasons | Accepts the reason without using it to decide approval. |
| Apply for more days than the remaining balance | Rejects the request. |
| Enter an invalid employee ID | Displays an appropriate error message. |
| Exceed the employee's maximum request limit | Rejects the request. |
| Cancel valid approved leave | Restores the cancelled days to the balance. |
| Cancel more days than previously approved | Rejects the cancellation. |
| Check leave balance | Displays the current remaining balance. |

## 11. Debugging and Refactoring

1. **Reduced code duplication:** Common employee information and leave operations are maintained in the base `Employee` class.
2. **Improved reusability:** Subclasses reuse shared functionality through inheritance.
3. **Improved validation:** Leave requests and cancellations are validated against the employee ID, available leave balance, and applicable request limit.
4. **Improved maintainability:** Employee-specific rules are defined through overridden methods.
5. **Improved separation of responsibilities:** Employee-related operations are handled by the employee classes, while the main class manages the menu and user interaction.

## 12. Class Diagram

The class diagram illustrates the abstract `Employee` class, its four subclasses, and the relationship between `LeaveManagementSystem` and employee records.


## 13. Conclusion

The Leave Management System demonstrates the practical use of Java and Object-Oriented Programming concepts. It provides basic leave-management functionality for different employee types while emphasizing code reuse, validation, and maintainability.
