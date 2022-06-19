package ru.skypro;

import java.util.Objects;

public class Employee {
    private final String name;
    private int department;
    private int salary;
    private final int id;
    private static int counterId;

    public Employee(String name, int department, int salary){
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.id = ++counterId;
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID сотрудника: " + id + "  Имя: " + name + "  Отдел: " + department + "  ЗП: " + salary;
            }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, department, salary);
    }
}
