public class EmployeeBook {

    private Employee[] employees = new Employee[10];

    public boolean addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) { // Найти свободное место
                employees[i] = employee;
                return true; // Успешно добавлено
            }
        }
        return false; // Нет свободных мест
    }

    public void listEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public double averageSalary() {
        double totalSalary = 0;
        int count = 0;

        for (Employee employee : employees) {
            if (employee != null) {
                totalSalary += employee.getSalary();
                count++;
            } else {
                break; // Остановиться на первом null
            }
        }

        return count > 0 ? totalSalary / count : 0; // Средняя зарплата
    }

    public void printTaxes(String type) {
        for (Employee employee : employees) {
            if (employee != null) {
                double tax = 0;
                switch (type.toUpperCase()) {
                    case "PROPORTIONAL":
                        tax = employee.getSalary() * 0.13;
                        break;
                    case "PROGRESSIVE":
                        if (employee.getSalary() <= 150) {
                            tax = employee.getSalary() * 0.13;
                        } else if (employee.getSalary() <= 350) {
                            tax = employee.getSalary() * 0.17;
                        } else {
                            tax = employee.getSalary() * 0.21;
                        }
                        break;
                    default:
                        System.out.println("Unknown tax type.");
                        return;
                }
                System.out.println("Employee ID: " + employee.getId() + ", Tax: " + tax);
            }
        }
    }

    public void indexSalaries(int department, double percentage) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                double newSalary = employee.getSalary() * (1 + percentage / 100);
                if (newSalary != employee.getSalary()) { // Проверка на изменение
                    employee.setSalary(newSalary);
                }
            }
        }
    }

    public void findEmployeeByDepartmentAndSalary(int department, double salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department && employees[i].getSalary() > salary) {
                System.out.print("Employee found: ");
                employees[i].printShortInfo();
                break; // Прерывание после нахождения первого сотрудника
            }
        }
    }

    public void findEmployeesWithSalaryLessThan(double wage, int employeeNumber) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < wage) {
                employee.printShortInfo();
                count++;
                if (count >= employeeNumber) break; // Прерывание после нахождения нужного количества
            }
        }
    }

    public boolean containsEmployee(Employee employee) {
        for (Employee emp : employees) {
            if (emp != null && emp.equals(employee)) {
                return true; // Сотрудник найден
            }
        }
        return false; // Сотрудник не найден
    }

    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee != null && employee.getId() == id) {
                return employee; // Возвращаем сотрудника по id
            }
        }
        return null; // Не найден
            }
        }

