/*
Name: Jacob Benson
Current Date: 3/24/2023
Sources Consulted:StackOverflow.com, Lecture Notes
By submitting this work, I attest that it is my original work and that I did
not violate the University of Mississippi academic policies set forth in the
UM book.
*/

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DP3 {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("          Welcome to Titan Communications Directory          ");
        Scanner scan = new Scanner(new File("src/TitanCommunication.txt"));
        ArrayList<Branch> branches = new ArrayList<>();
        Branch currentBranch = null;
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] tokens = line.split(",");
            if (tokens.length == 2) {
                String location = tokens[0];
                int opened = Integer.parseInt(tokens[1]);
                currentBranch = new Branch(location, opened, new ArrayList<>());
                branches.add(currentBranch);
            } else if (tokens.length == 3) {
                String name = tokens[0];
                String position = tokens[1];
                int salary = Integer.parseInt(tokens[2]);
                Employee employee = new Employee(name, position, salary);
                currentBranch.getEmp().add(employee);
            }
        }
//        for (Branch branch : branches) {
//            System.out.println("Branch Location: " + branch.getLocation() + " Year Opened: " + branch.getOpened());
//            System.out.println("___________________________________________");
//            for (Employee employee : branch.getEmp()) {
//                System.out.println("Employee Name: " + employee.getName() + " Position: " + employee.getPosition() + "Salary: " + employee.getSalary());
//
//            }
//        }
        scan.close();
        Business busi = new Business("Titan Communication", branches);

        while (true) {
            System.out.println("What would you like to do today?" + "\n" +
                    "            1. Display List of Current Employees" + "\n" +
                    "            2. Add to Directory" + "\n" +
                    "            3. Remove Employee from Directory" + "\n" +
                    "            4. Exit Directory");
            int input = keyboard.nextInt();
            switch (input) {
                case 1:
                    for (Branch branch : branches) {
                        System.out.println("Branch Location: " + branch.getLocation() + " Year Opened: " + branch.getOpened());
                        System.out.println("___________________________________________");
                        for (Employee employee : branch.getEmp()) {
                            System.out.println("Employee Name: " + employee.getName() + " Position: " + employee.getPosition() + " Salary: $" + employee.getSalary());

                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter Branch Location: ");
                    String location = keyboard.nextLine();
                    keyboard.nextLine();
                    System.out.println("Enter Year Branch Opened: ");
                    int opened = keyboard.nextInt();
                    keyboard.nextLine();
                    System.out.println("Enter new employee name; ");
                    String name = keyboard.nextLine();
                    System.out.println("Enter new employee's position: ");
                    String position = keyboard.nextLine();
                    System.out.println("Enter new employee's salary: ");
                    int salary = keyboard.nextInt();
                    keyboard.nextLine();
                    Employee employees = new Employee(name, position, salary);
                    Branch branch = new Branch(location, opened, new ArrayList<>());
                    branch.getEmp().add(employees);
                    branches.add(branch);
                    System.out.println("New Employee added");
                    break;
                case 3:
                    System.out.println("Enter Employee's name to remove: ");
                    String remove = keyboard.nextLine();
                    keyboard.nextLine();
                    boolean employeeRemove = false;
                    for (Branch b : branches) {
                        ArrayList<Employee> emp = b.getEmp();
                        for (Employee employee : emp) {
                            if (employee.getName().equals(remove)) {
                                emp.remove(employee);
                                employeeRemove = true;
                                System.out.println("Employee Removed ");
                                break;
                            }
                        }
                        if (employeeRemove) {
                            break;
                        }
                    }
                    if (!employeeRemove) {
                        System.out.println("No Employee found");
                    }
                    break;


                case 4:
                    System.out.println("Thank You, for accessing the Employee Directory." + "\n" +
                            "                          Have a TitanDay!");
                    return;
                default:
                    System.out.println("You have entered an incorrect response. ");
                    break;

            }
//            keyboard.nextLine();
        }
    }
}



//                System.out.println("Employee Name: "+employee.getName() + " Position: "+employee.getPosition()+"Salary: "+employee.getSalary());
