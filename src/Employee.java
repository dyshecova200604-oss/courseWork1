 import java.util.Objects;

    public class Employee {
        private static int counter = 1; // Счетчик для id
        private int id;
        private String fullName;
        private int department; // Отдел от 1 до 5
        private double salary; // Зарплата

        public Employee(String fullName, int department, double salary) {
            this.id = counter++;
            this.fullName = fullName;
            this.department = department;
            this.salary = salary;
        }

        public int getId() {
            return id;
        }

        public String getFullName() {
            return fullName;
        }

        public int getDepartment() {
            return department;
        }

        public double getSalary() {
            return salary;
        }

        public void setDepartment(int department) {
            this.department = department;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Employee)) return false;
            Employee employee = (Employee) obj;
            return Double.compare(employee.salary, salary) == 0; // Сравнение по зарплате
        }

        @Override
        public int hashCode() {
            return Objects.hash(salary);
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + fullName + ", Department: " + department + ", Salary: " + salary;
        }

        public void printShortInfo() {
            System.out.println("Name: " + fullName + ", Salary: " + salary);
        }
}
