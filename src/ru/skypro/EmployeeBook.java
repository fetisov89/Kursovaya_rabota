package ru.skypro;

import java.util.Arrays;
import java.util.Scanner;

class EmployeeBook {
     Scanner scn = new Scanner(System.in);

     private final Employee[] employees;

     public EmployeeBook(int size) {
          this.employees = new Employee[size];
     }

     public void createEmployee(String name, int department, int salary) {
          boolean emptyEmployee = false;
          int emptyCount = 0;
          for (int i = 0; i < employees.length; i++) {
               if (employees[i] == null) {
                    emptyEmployee = true;
                    emptyCount = i;
                    break;
               }
          }
          if (!emptyEmployee) {
               System.out.println("Нет свободного места в книге");
          } else {
               boolean sameEmployee = false;
               for (Employee employees : employees) {
                    if (employees != null) {
                         if (employees.getName().equals(name)) {
                              sameEmployee = true;
                              System.out.println("Такой сотрудник уже есть.");
                              break;
                         }
                    }
               }
               if (!sameEmployee) {
                    employees[emptyCount] = new Employee(name, department, salary);
               }
          }
     }

     public void delEmployee(int id) {
          for (int i = 0; i < employees.length; i++) {
               if (employees[i] != null) {
                    if (employees[i].getId() == id) {
                         employees[i] = null;
                    }
               }
          }
     }

     public void editEmployee() {
          int userInput = 0;
          boolean sameName = false;
          int indexFindingEmployee = 0;

          System.out.println("Укажите ФИО сотрудника");
          String findingName = scn.nextLine();
          for (int i = 0; i < employees.length; i++) {
               if (employees[i] != null) {
                    if (employees[i].getName().equals(findingName)) {
                         sameName = true;
                         indexFindingEmployee = i;
                         System.out.println(employees[i].toString());
                    }
               }
          }
          if (!sameName) {
               System.out.println("Сотрудник не найден");
          } else {
               while (userInput != 3) {
                    System.out.println("""
                            1. Изменить отдел
                            2. Изменить зарплату
                            3. Выход""");
                    userInput = scn.nextInt();
                    if (userInput == 1) {
                         System.out.println("Укажите отдел");
                         employees[indexFindingEmployee].setDepartment(scn.nextInt());
                    } else if (userInput == 2) {
                         System.out.println("Укажите зарплату");
                         employees[indexFindingEmployee].setSalary(scn.nextInt());
                    } else if (userInput == 3) {
                         System.out.println("Exit");
                    } else {
                         System.out.println("incorrect enter");
                    }
               }
          }
          scn.close();
     }

     public void sortingDepartmentEmployee() {
          for (int i = 0; i < 5; i++) {
               System.out.println("Сотрудники отдела " + (i + 1) + ":");
               for (Employee employee : employees) {
                    if (employee != null) {
                         if (employee.getDepartment() == (i + 1)) {
                              System.out.println(employee);
                         }
                    }
               }
          }
     }

     public void salarySum() {
          int salarySum = 0;
          for (Employee employee : employees) {
               if (employee != null) {
                    salarySum += employee.getSalary();
               }
          }
          System.out.println("Сумма всех зп: " + salarySum);
     }

     public void print() {
          for (Employee employee : employees) {
               System.out.println(employee);
          }
     }

     public void minSalary() {
          int minSalary = employees[0].getSalary();
          for (Employee employee : employees) {
               if (employee != null) {
                    if (employee.getSalary() < minSalary) {
                         minSalary = employee.getSalary();
                    }
               }
          }
          System.out.println("Минимальная зп: " + minSalary);
     }

     public void maxSalary() {
          int maxSalary = employees[0].getSalary();
          for (Employee employee : employees) {
               if (employee != null) {
                    if (employee.getSalary() > maxSalary) {
                         maxSalary = employee.getSalary();
                    }
               }
          }
          System.out.println("Максимальная зп: " + maxSalary);
     }

     public void averageSalary() {
          int counter = 0;
          int sum = 0;
          for (Employee employee : employees) {
               if (employee != null) {
                    sum += employee.getSalary();
                    counter++;
               }
          }
          System.out.println("Средняя зп: " + sum / counter * 1.0);
     }

     public void nameList() {
          for (Employee employee : employees) {
               if (employee != null) {
                    System.out.println(employee.getName());
               }
          }
     }

     @Override
     public String toString() {
          return Arrays.toString(employees);
     }

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          EmployeeBook that = (EmployeeBook) o;
          return Arrays.equals(employees, that.employees);
     }

     @Override
     public int hashCode() {
          return Arrays.hashCode(employees);
     }
}
