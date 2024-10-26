public class EmployeeBook {

    private Employee[] employees = new Employee[10];

    private void initializeEmployees() {
        employees[0] = new Employee("Иванов Иван Иванович", 1000, 1);
        employees[1] = new Employee("Степанов Степан Степанович", 2000, 2);
        employees[2] = new Employee("Сергеев Сергей Сергеевич", 3000, 3);
        employees[3] = new Employee("Федоров Федор Федорович", 4000, 4);
        employees[4] = new Employee("Максимов Максим Максимович", 5000, 5);
        employees[5] = new Employee("Петров Петр Петрович", 6000, 1);
        employees[6] = new Employee("Сидоров Петр Петрович", 7000, 2);

    }

    public void print() {
        initializeEmployees();
        getAllEmployees();
        System.out.println("Общая сумма затрат на заработную плату: " + getSumSalary());
        System.out.println("Сотрудник с минимальной ЗП: " + getEmployeeWithMinSalary());
        System.out.println("Сотрудник с максимальной ЗП: " + getEmployeeWithMaxSalary());
        System.out.println("Среднее значение зарплат: " + getAverageValueSalaries());
        getAllNamesEmployees();

        salaryIndexing();
        System.out.println("Сотрудник с минимальной ЗП в этом отделе: " + getEmployeeInDepartmentWithMinSalary(1));
        System.out.println("Сотрудник с максимальной ЗП в этом отделе: " + getEmployeeInDepartmentWithMaxSalary(1));
        System.out.println("Общая сумма затрат на заработную плату в этом отделе: " + getSumSalaryInDepartment(2) + " руб.");
        System.out.println("Средняя зп по отделу равна: " + getSumSalaryInDepartment(2) / getNumberEmployeesInDepartment(2) + " руб.");
        salaryIndexingInDepartment(2, 15);
        getAllEmployeesInDepartment(4);
        getAllEmployeesWithSalaryLessNum(5500);
        getAllEmployeesWithSalaryMoreNum(6200);

        addNewEmployee("Достоевский Федор Михайлович", 50020, 1);
        deleteEmployee(7);
        getEmployeeById(1);
    }


    //Получить список всех сотрудников со всеми имеющимися по ним данными
    public void getAllEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    //Посчитать сумму затрат на ЗП в месяц
    public int getSumSalary() {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }


    //Найти сотрудника с минимальной ЗП
    public Employee getEmployeeWithMinSalary() {
        Employee minSalaryEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < minSalaryEmployee.getSalary()) {
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    //Найти сотрудника с максимальной ЗП
    public Employee getEmployeeWithMaxSalary() {
        Employee maxSalaryEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > maxSalaryEmployee.getSalary()) {
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    //Подсчитать среднее значение зарплат
    public double getAverageValueSalaries() {
        return (double) getSumSalary() / employees.length;
    }

    //Распечатать ФИО всех сотрудников
    public void getAllNamesEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println("ФИО сотрудника: " + employee.getEmployeesName());
            }
        }
    }

    //Проиндексировать зарплату всем сотрудникам
    public void salaryIndexing() {
        int percentIndexing = 15;
        for (Employee employee : employees) {
            if (employee != null) {
                int indexedSum = (employee.getSalary() * percentIndexing) / 100;
                int indexedSalary = employee.getSalary() + indexedSum;
                System.out.println("Проиндексированная заработная плата: " + indexedSalary);
            }
        }
    }

    //Получить в качестве параметра номер отдела (1-5) и найти
    //Сотрудника с минимальной зп
    public Employee getEmployeeInDepartmentWithMinSalary(int inputDepartment) {
        Employee minSalaryEmployeeInDepartment = employees[0];
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == inputDepartment && employee.getSalary() < minSalaryEmployeeInDepartment.getSalary()) {
                minSalaryEmployeeInDepartment = employee;
            }
        }
        return minSalaryEmployeeInDepartment;
    }

    //Сотрудника с максимальной зп
    public Employee getEmployeeInDepartmentWithMaxSalary(int inputDepartment) {
        Employee maxSalaryEmployeeInDepartment = employees[0];
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > maxSalaryEmployeeInDepartment.getSalary() && employee.getDepartment() == inputDepartment) {
                maxSalaryEmployeeInDepartment = employee;
            }
        }
        return maxSalaryEmployeeInDepartment;
    }

    //Сумму затрат на зп по отделу
    public int getSumSalaryInDepartment(int inputDepartment) {
        int sum2 = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == inputDepartment) {
                sum2 += employee.getSalary();
            }
        }
        return sum2;
    }

    //Метод для получения количества сотрудников в одном отделе
    public int getNumberEmployeesInDepartment(int inputDepartment) {
        int numberEmployeesInDepartment = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == inputDepartment) {
                numberEmployeesInDepartment++;
                ;
            }
        }
        return numberEmployeesInDepartment;
    }

    //Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра
    public void salaryIndexingInDepartment(int inputDepartment, int percentIndexing2) {
        //   Employee indexedSalary = employees[0];
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == inputDepartment) {
                int indexedSum2 = (employee.getSalary() * percentIndexing2) / 100;
                int indexedSalary2 = employee.getSalary() + indexedSum2;
                System.out.println("Проиндексированная зарплата сотрудника в отделе номер " + inputDepartment + " равна " + indexedSalary2 + " руб.");
            }
        }
    }

    //Напечатать всех сотрудников отдела (все данные, кроме отдела)
    public void getAllEmployeesInDepartment(int inputDepartment) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == inputDepartment) {
                System.out.println("Все сотрудники в отделе: " + "id= " + employee.getId() + " " + "ФИО сотрудника =" + " " + employee.getEmployeesName() + ", " + "Зарплата =" + " " + employee.getSalary());
            }
        }
    }

    //Получить в качестве параметра число и вывести:
    //Всех сотрудников с зп меньше числа (распечатать id, фио и зп в консоль)
    public void getAllEmployeesWithSalaryLessNum(int number) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < number) {
                System.out.println("Все сотрудники с зп меньше числа: " + "id= " + employee.getId() + " " + "ФИО сотрудника =" + " " + employee.getEmployeesName() + ", " + "Зарплата =" + " " + employee.getSalary());
            }
        }
    }

    //Всех сотрудников с зп больше (или равно) числа
    public void getAllEmployeesWithSalaryMoreNum(int number) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= number) {
                System.out.println("Все сотрудники с зп больше (или равно) числа: " + "id= " + employee.getId() + " " + "ФИО сотрудника =" + " " + employee.getEmployeesName() + ", " + "Зарплата =" + " " + employee.getSalary());
            }
        }
    }


    //Метод для добавления нового сотрудника
    //  Добавить нового сотрудника. (метод должен найти свободную ячейку в массиве и положить нового сотрудника в нее.
    //  Поиск свободных ячеек происходит с начала массива. Если свободных мест для сотрудника нет, то метод должен
    //  вернуть false, если для сотрудника нашлось место, то метод должен вернуть true)
    public boolean addNewEmployee(String employeesName, int salary, int department) {
        for (int i = 0; i < employees.length; i = i + 1) {
            if (employees[i] == null) {
                employees[i] = new Employee(employeesName, salary, department);
                return true;
            }
        }
        return false;
    }

    //Метод для удаления сотрудника из массива
    public void deleteEmployee(int id) {
        int i = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getId() == id) {
                employees[i] = null;
                System.out.println("Сотрудник с " + "id= " + employee.getId() + " " + "успешно удален");
            }
        }
    }

    //Метод получения сотрудника по id
    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee != null && employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
}
