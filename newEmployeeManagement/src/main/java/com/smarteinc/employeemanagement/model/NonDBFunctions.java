package com.smarteinc.employeemanagement.model;


import java.util.*;
import java.util.stream.Collectors;

public class NonDBFunctions {


    List<Employee1> employeeList = new ArrayList<Employee1>();

    public void getemployee() {
        employeeList.add(new Employee1(111, "Jiya Brein", 32, true, "HR", 2011, 250000.0, "mumbai"));
        employeeList.add(new Employee1(122, "Paul Niksui", 25, true, "Sales And Marketing", 2015, 135000.0, "pune"));
        employeeList.add(new Employee1(133, "Martin Theron", 29, true, "IT", 2012, 180000.0, "mumbai"));
        employeeList.add(new Employee1(144, "Murali Gowda", 28, true, "IT", 2014, 325000.0, "mumbai"));
        employeeList.add(new Employee1(155, "Nima Roy", 27, true, "HR", 2013, 227000.0, "pune"));
        employeeList.add(new Employee1(166, "Iqbal Hussain", 43, true, "Sales And Marketing", 2016, 105000.0, "mumbai"));
        employeeList.add(new Employee1(177, "Manu Sharma", 45, true, "IT", 2010, 270000.0, "pune"));
        employeeList.add(new Employee1(188, "Wang Liu", 41, true, "HR", 2015, 345000.0, "pune"));
        employeeList.add(new Employee1(199, "Amelia Zoe", 24, true, "Sales And Marketing", 2016, 115000.0, "pune"));
        employeeList.add(new Employee1(200, "Jaden Dough", 48, true, "IT", 2015, 110000.5, "mumbai"));
        employeeList.add(new Employee1(211, "Jasna Kaur", 27, true, "IT", 2014, 157000.0, "delhi"));
        employeeList.add(new Employee1(222, "Nitin Joshi", 45, true, "IT", 2016, 282000.0, "pune"));
        employeeList.add(new Employee1(233, "Jyothi Reddy", 27, true, "IT", 2013, 213000.0, "mumbai"));

        int choice;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n\n-------Employee Details ------------");
            System.out.println("  1.find employees in department");
            System.out.println("  2.find employees below a given age having CTC greater than 2 lakh.");
            System.out.println("  3.find employees having CTC greater than 2 lakh. and less than 5 lakh and current city is mumbai");
            System.out.println("  4. Exit the program...\n");
            System.out.println("Choose one:");
            choice = sc.nextInt();

            System.out.println("");
            switch (choice) {
                case 1:
                    System.out.println("");
                    System.out.println("enter the  age of employee to find how many employees present in given departments");

                    int givenEmployeeAge = sc.nextInt();
                    Map<String, Long> employeeCountByDepartment =
                            employeeList.stream().filter(e -> e.getAge() > givenEmployeeAge).collect(Collectors.groupingBy(Employee1::getDepartment, Collectors.counting()));

                    Set<Map.Entry<String, Long>> entrySet = employeeCountByDepartment.entrySet();

                    for (Map.Entry<String, Long> entry : entrySet) {
                        System.out.println(entry.getKey() + " : " + entry.getValue());
                    }
                    break;
                case 2:
                    System.out.println("enter age of employee");
                    int givenEmployeeAge1 = sc.nextInt();
                    Map<String, List<Employee1>> employeeListByDepartment =
                            employeeList.stream().filter(e -> e.getAge() < givenEmployeeAge1 && e.getCTC() > 200000).collect(Collectors.groupingBy(Employee1::getDepartment));

                    Set<Map.Entry<String, List<Employee1>>> entrySet1 = employeeListByDepartment.entrySet();

                    for (Map.Entry<String, List<Employee1>> entry : entrySet1) {
                        System.out.println("--------------------------------------");

                        System.out.println("Employees In " + entry.getKey() + " : ");

                        System.out.println("--------------------------------------");

                        List<Employee1> list = entry.getValue();

                        for (Employee1 employee1 : list) {
                            System.out.println("Name : " + employee1.getName() + "," + "Age: " + employee1.getAge() + "," + " CTC: " + employee1.getCTC());
                        }

                    }
                    break;
                case 3:
                    System.out.println("enter city name");
                    String currentCity = sc.next();

                    Map<String, List<Employee1>> employeeListByDepartment1 =
                            employeeList.parallelStream().filter(e -> e.getCity().equalsIgnoreCase(currentCity) && e.getCTC() > 200000 && e.getCTC() < 500000).collect(Collectors.groupingBy(Employee1::getDepartment));

                    Set<Map.Entry<String, List<Employee1>>> entrySet11 = employeeListByDepartment1.entrySet();

                    for (Map.Entry<String, List<Employee1>> entry : entrySet11) {
                        System.out.println("--------------------------------------");

                        System.out.println("Employees In " + entry.getKey() + " : ");

                        System.out.println("--------------------------------------");

                        List<Employee1> list = entry.getValue();

                        for (Employee1 employee1 : list) {
                            System.out.println("Name: " + employee1.getName() + "," + " City: " + employee1.getCity() + "," + " CTC: " + employee1.getCTC());
                        }

                    }
                    break;

                case 4:
                    return;

                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        }


    }
}
