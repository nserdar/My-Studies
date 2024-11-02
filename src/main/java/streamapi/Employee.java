package main.java.streamapi;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Employee {
    String name;
    String department;
    double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public String toString() { return name + " - " + salary; }

    // Main
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "IT", 7000),
                new Employee("Bob", "IT", 8000),
                new Employee("Charlie", "HR", 5000),
                new Employee("David", "HR", 6000),
                new Employee("Eve", "Sales", 5500)
        );

        Map<String, Optional<Employee>> highestPaidByDept = employees.stream()

                //	groupingBy(Employee::getDepartment): employees listesindeki her Employee nesnesini
                //	getDepartment metoduna göre gruplar. Yani her bir departman için ayrı bir grup oluşturur.
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,

                        //Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)): Her departmandaki
                        // çalışanlar için getSalary metoduna göre en yüksek maaşlı çalışanı seçer. Bu seçim
                        // Comparator.comparingDouble(Employee::getSalary) ile yapılır, bu da her bir departman
                        // grubundaki çalışanları maaşlarına göre karşılaştırır ve en yükseği bulur.
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                ));

        highestPaidByDept.forEach((dept,emp) ->
                        System.out.println(dept + ": " + emp.orElse(null))
                );
        /*
        Department: HR, Highest Paid: Employee{name='Charlie', department='HR', salary=55000.0}
Department: Engineering, Highest Paid: Employee{name='David', department='Engineering', salary=80000.0}
         */




    }


}
