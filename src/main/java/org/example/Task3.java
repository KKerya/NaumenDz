package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Task3 {
    public static void run(){
        System.out.println("Задание 3");
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Иванов Иван", 30, "ИТ", 165000.0));
        employees.add(new Employee("Самарский Александо", 45, "Маркетинг", 65000.0));
        employees.add(new Employee("Яблокова Ольга", 28, "Бухгалтерия", 40000.0));
        employees.add(new Employee("Кузнецов Иван", 35, "Бухгалтерия", 55000.0));
        employees.add(new Employee("Кузнецова Елена", 40, "ИТ", 210000.0));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название отдела: ");
        String departament = scanner.nextLine();
        double averageSalary = employees.stream()
                .filter(x -> x.getDepartament().equalsIgnoreCase(departament))
                .mapToDouble(Employee :: getSalary)
                .average()
                .orElse(0);

        System.out.println("Средняя зарплата в отделе: " + averageSalary);
    }
}

class Employee{
    private String fullName;
    private int age;
    private String departament;
    private Double salary;

    public Employee(String fullName, int age, String departament, Double salary){
        this.fullName = fullName;
        this.age = age;
        this.departament = departament;
        this.salary = salary;
    }

    public String getFullName(){
        return fullName;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getDepartament(){
        return departament;
    }

    public void setDepartament(String departament){
        this.departament = departament;
    }

    public Double getSalary(){
        return salary;
    }

    public void setSalary(Double salary){
        this.salary = salary;
    }


}
