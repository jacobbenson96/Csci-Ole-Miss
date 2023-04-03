import java.util.ArrayList;

public class Business {
    private String name;
    private final ArrayList<Branch> branch;
    private int index;

    public Business() {
        this.name = "";
        this.branch = new ArrayList<>();
        this.index = 0;
    }

    public Business(String name, ArrayList<Branch> branch) {
        this.name = name;
        this.branch = branch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void display() {
        for (Branch branch : branch) {
            System.out.println("Branch Location: " + branch.getLocation() + " Year Opened: " + branch.getOpened());
            System.out.println("___________________________________________");
            for (Employee employee : branch.getEmp()) {
                System.out.println("Employee Name: " + employee.getName() + " Position: " + employee.getPosition() + "Salary: " + employee.getSalary());


            }
        }
    }
}