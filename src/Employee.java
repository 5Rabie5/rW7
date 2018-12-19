public class Employee {
    private String name;
    private String department;
    private Integer salary;
    private String account;

    public Employee(String name, String department, Integer salary, String account) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public Integer getSalary() {
        return salary;
    }

    public String getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", account='" + account + '\'' +
                '}';
    }
}
