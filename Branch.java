import java.util.ArrayList;

public class Branch {
    private String location;
    private int opened;
    private ArrayList<Employee> emp;
    private int index;
    public Branch() {
        this.location = "";
        this.opened = 0;
        this.emp = new ArrayList<>();
        this.index = 0;
    }
    public Branch(String location, int opened, ArrayList<Employee> emp) {
        this.location = location;
        this.opened = opened;
        this.emp = emp;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getOpened() {
        return opened;
    }

    public void setOpened(int opened) {
        this.opened = opened;
    }

    public ArrayList<Employee> getEmp() {
        return emp;
    }

    public void setEmp(ArrayList<Employee> emp) {
        this.emp = emp;
    }
}
