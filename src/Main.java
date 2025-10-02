//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        // Добавляем сотрудников
        System.out.println("Adding employees:");
        for (int i = 0; i < 11; i++) { // Попробуем добавить 11 сотрудников
            Employee emp = new Employee("Employee " + (i + 1), (i % 5) + 1, 50 + Math.random() * 400);
            boolean added = employeeBook.addEmployee(emp);
            System.out.println("Added: " + added);
        }

        System.out.println("\nList of all employees:");
        employeeBook.listEmployees();

        System.out.println("\nAverage Salary: " + employeeBook.averageSalary());

        System.out.println("\nTaxes (Proportional):");
        employeeBook.printTaxes("PROPORTIONAL");

        System.out.println("\nTaxes (Progressive):");
        employeeBook.printTaxes("PROGRESSIVE");

        System.out.println("\nIndexing salaries in department 2 by 10%:");
        employeeBook.indexSalaries(2, 10);

        System.out.println("\nList of all employees after indexing:");
        employeeBook.listEmployees();

        System.out.println("\nFinding first employee in department 3 with salary greater than 300:");
        employeeBook.findEmployeeByDepartmentAndSalary(3, 300);

        System.out.println("\nFinding first 3 employees with salary less than 200:");
        employeeBook.findEmployeesWithSalaryLessThan(200, 3);

        // Проверка на наличие сотрудника
        Employee testEmp = new Employee("Employee 1", 1, 150); // Создаем тестового сотрудника
        boolean exists = employeeBook.containsEmployee(testEmp);
        System.out.println("\nDoes the test employee exist? " + exists);

        // Получение сотрудника по id
        Employee empById = employeeBook.getEmployeeById(1);
        if (empById != null) {
            System.out.println("\nEmployee with ID 1 found:");
            empById.printShortInfo();
        } else {
            System.out.println("\nEmployee with ID 1 not found.");
        }
    }
}
