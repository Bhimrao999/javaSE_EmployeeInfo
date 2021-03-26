package com.smarteinc.employeemanagement.model;


import java.util.Scanner;

public class EntryClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("\n\n-------Employee Management Syatem ------------");
            System.out.println("  1. Create Department");
            System.out.println("  2. Create Employee");
            System.out.println("  3. Non DB functions");
            System.out.println("  4. Exit the program...\n");
            System.out.println("Choose one:");
            choice = sc.nextInt();

            System.out.println("");

            switch (choice) {
                case 1:
                    System.out.println("");
                    Department db = new Department();
                    db.createDepartment();
                    break;
                case 2:
                    System.out.println("");
                    Employee employee = new Employee();
                    employee.createEmployee();
                    break;
                case 3:
                    System.out.println("");
                    NonDBFunctions nb = new NonDBFunctions();
                    nb.getemployee();
                    break;
                case 4:
                    return;

            }
        }
    }
}

