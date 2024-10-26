import java.util.Objects;

public class Employee {
    private String employeesName;
    private int salary;
    private int department;
    private static int counter = 0;
    private int id;

    public Employee (String employeesName, int salary, int department) {
        id = ++counter;
        this.employeesName = employeesName;
        this.salary = salary;
        this.department = department;
    }

    public String getEmployeesName() {
        return this.employeesName;
    }

    public int getSalary() {
        return this.salary;
    }

    public int getDepartment() {
        return this.department;
    }

    public int getId() {
        return this.id;
    }

    public void setEmployeesName(String employeesName) {
        this.employeesName = employeesName;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public String toString() {
        return "Сотрудник: " +
                "id= " + id + " " +
                "ФИО сотрудника =" + " " + employeesName + ", " +
                "Зарплата =" + " " + salary + ", " +
                "Отдел =" + " " + department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && department == employee.department && counter == employee.counter && Objects.equals(employeesName, employee.employeesName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeesName, salary, department, counter);
    }
}



