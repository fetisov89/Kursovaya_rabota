package ru.skypro;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook(10);
        Scanner scn = new Scanner(System.in);
        employeeBook.createEmployee("Фетисов Илья Андреевич", 1, 50_000);
        employeeBook.createEmployee("Фетисов Андрей Высильевич", 3, 100_000);
        employeeBook.createEmployee("Сидоров Андрей Валерьевич", 2, 150_000);
        employeeBook.createEmployee("Петрова Ольга Павловна", 3, 90_000);
        employeeBook.print();
        employeeBook.delEmployee(2);
        employeeBook.createEmployee("Иванов Станистав Сергеевич", 4, 300_000);
        employeeBook.print();
        employeeBook.editEmployee();
        employeeBook.print();
        employeeBook.sortingDepartmentEmployee();
        employeeBook.salarySum();
        employeeBook.maxSalary();
        employeeBook.minSalary();
        employeeBook.averageSalary();
        employeeBook.nameList();
    }
}
