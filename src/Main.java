public class Main {

 //   public Employee[] employees;

  //  public Main() {
  //      employees = new Employee[10];
    //     initializeEmployees();
  //  }
    private static Employee[] employees = new Employee[10];

    private static void initializeEmployees () {
        employees[0] = new Employee("Иванов Иван Иванович", 1000, 1);
        employees[1] = new Employee("Степанов Степан Степанович", 2000, 2);
        employees[2] = new Employee("Сергеев Сергей Сергеевич", 3000, 3);
        employees[3] = new Employee("Федоров Федор Федорович", 4000, 4);
        employees[4] = new Employee("Максимов Максим Максимович", 5000, 5);
        employees[5] = new Employee("Петров Петр Петрович", 6000, 1);
        employees[6] = new Employee("Сидоров Петр Петрович", 7000, 2);
        employees[7] = new Employee("Симонов Александр Александрович", 8000, 3);
        employees[8] = new Employee("Александров Александр Александрович", 9000, 4);
        employees[9] = new Employee("Пуфиков Максим Максимович", 10000, 5);
    }
     //ЗАМЕНИ каждый из методов на private!!
    public static void main(String[] args) {
   //     Main main = new Main();
        //main.printEmployee();
        initializeEmployees();
        getAllEmployees();
        System.out.println("Общая сумма затрат на заработную плату: " + getSumSalary());
        System.out.println("Сотрудник с минимальной ЗП: " + getEmployeeWithMinSalary());
        System.out.println("Сотрудник с максимальной ЗП: " + getEmployeeWithMaxSalary());
        System.out.println("Среднее значение зарплат: " + getAverageValueSalaries());
        getAllNamesEmployees();

        salaryIndexing();
        System.out.println("Сотрудник с минимальной ЗП в этом отделе: " + getEmployeeInDepartmentWithMinSalary(5));
        System.out.println("Сотрудник с максимальной ЗП в этом отделе: " + getEmployeeInDepartmentWithMaxSalary(5));
        System.out.println("Общая сумма затрат на заработную плату в этом отделе: " + getSumSalaryInDepartment(5) + " руб.");
        System.out.println("Средняя зп по отделу равна: " + getSumSalaryInDepartment (5) / getNumberEmployeesInDepartment(5) + " руб.");
        salaryIndexingInDepartment(5,15);
        getAllEmployeesInDepartment(4);
        getAllEmployeesWithSalaryLessNum(5500);
        getAllEmployeesWithSalaryMoreNum(7200);

    };

    public static void getAllEmployees() {
       for (Employee employee : employees) {
                System.out.println(employee);
           }
    }

    public static int getSumSalary() {
        int sum = 0;
        for (Employee employee : employees) {
            sum+=employee.getSalary();
         }
        return sum;
       }


    public static Employee getEmployeeWithMinSalary() {
        Employee minSalaryEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() < minSalaryEmployee.getSalary()) {
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    public static Employee getEmployeeWithMaxSalary() {
        Employee maxSalaryEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalaryEmployee.getSalary()) {
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    public static double getAverageValueSalaries() {
        return (double) getSumSalary() / employees.length;
    }

    public static void getAllNamesEmployees () {
        for (Employee employee : employees) {
            System.out.println("ФИО сотрудника: " + employee.getEmployeesName());
        }
    }

    //Проиндексировать зарплату
    public static void salaryIndexing() {
        int percentIndexing = 15;
        for (Employee employee : employees) {
          int indexedSum = (employee.getSalary() * percentIndexing) / 100;
          int indexedSalary = employee.getSalary() + indexedSum;
            System.out.println("Проиндексированная заработная плата: " + indexedSalary);
        }
    }
    //Получить в качестве параметра номер отдела (1-5) и найти
    //Сотрудника с минимальной зп
      public static Employee getEmployeeInDepartmentWithMinSalary(int inputDepartment) {
        Employee minSalaryEmployeeInDepartment = employees[0];
          for (Employee employee : employees)
         {
               if (employee.getSalary() < minSalaryEmployeeInDepartment.getSalary() && employee.getDepartment() == inputDepartment) {
                 minSalaryEmployeeInDepartment = employee;
              }
         }
         return minSalaryEmployeeInDepartment;
     }

     //Сотрудника с максимальной зп
     public static Employee getEmployeeInDepartmentWithMaxSalary(int inputDepartment) {
         Employee maxSalaryEmployeeInDepartment = employees[0];
         for (Employee employee : employees) {
             if (employee.getSalary() > maxSalaryEmployeeInDepartment.getSalary() && employee.getDepartment() == inputDepartment) {
                 maxSalaryEmployeeInDepartment = employee;
             }
         }
         return maxSalaryEmployeeInDepartment;
     }

    //Сумму затрат на зп по отделу
    public static int getSumSalaryInDepartment (int inputDepartment) {
        int sum2 = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == inputDepartment) {
                sum2+=employee.getSalary();
            }
        }
            return sum2;
        }

       //Метод для получения количества сотрудников в одном отделе
       public static int getNumberEmployeesInDepartment(int inputDepartment) {
           int numberEmployeesInDepartment = 0;
           for (Employee employee : employees) {
               if (employee.getDepartment() == inputDepartment) {
                   numberEmployeesInDepartment++;;
               }
           }
           return numberEmployeesInDepartment;
       }

    //Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра
    public static void salaryIndexingInDepartment(int inputDepartment, int percentIndexing2) {
        //   Employee indexedSalary = employees[0];
        for (Employee employee : employees) {
            if (employee.getDepartment() == inputDepartment) {
                int indexedSum2 = (employee.getSalary() * percentIndexing2) / 100;
                int indexedSalary2 = employee.getSalary() + indexedSum2;
                System.out.println("Проиндексированная зарплата сотрудника в отделе номер " + inputDepartment + " равна " + indexedSalary2 + " руб.");
            }
        }
    }

    //Напечатать всех сотрудников отдела (все данные, кроме отдела)
    public static void getAllEmployeesInDepartment(int inputDepartment) {
        for (Employee employee : employees) {
                if (employee.getDepartment() == inputDepartment) {
                    System.out.println("Все сотрудники в отделе: " + "id= " + employee.getId() + " " + "ФИО сотрудника =" + " " + employee.getEmployeesName() + ", " + "Зарплата =" + " " + employee.getSalary());
           }
        }
    }

    //Получить в качестве параметра число и вывести:
    //Всех сотрудников с зп меньше числа (распечатать id, фио и зп в консоль)
    public static void getAllEmployeesWithSalaryLessNum(int number) {
        for (Employee employee : employees) {
            if (employee.getSalary() < number) {
                System.out.println("Все сотрудники с зп меньше числа: " + "id= " + employee.getId() + " " + "ФИО сотрудника =" + " " + employee.getEmployeesName() + ", " + "Зарплата =" + " " + employee.getSalary());
            }
        }
    }

    //Всех сотрудников с зп больше (или равно) числа
    public static void getAllEmployeesWithSalaryMoreNum(int number) {
        for (Employee employee : employees) {
            if (employee.getSalary() >= number) {
                System.out.println("Все сотрудники с зп больше (или равно) числа: " + "id= " + employee.getId() + " " + "ФИО сотрудника =" + " " + employee.getEmployeesName() + ", " + "Зарплата =" + " " + employee.getSalary());
            }
        }
    }


}
