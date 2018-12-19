import java.util.*;

public class BankApplaction {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        List<String> lines = fileReader.getLines("employees.csv");
        lines.remove(0);
        List<Employee> listOfEmployees = toEmployees(lines);
        bankTransfer(listOfEmployees);
        totalAmount(listOfEmployees);
        highstSalary(listOfEmployees);
        mostPayingDepartment(listOfEmployees);
    }

    private static void mostPayingDepartment(List<Employee> listOfEmployees) {
        Map<String, Integer> departmentSalaryMap = new HashMap<>();
        for (Employee employee1 : listOfEmployees) {
            String department = employee1.getDepartment();
            if (!departmentSalaryMap.keySet().contains(department)) {
                departmentSalaryMap.put(department, 0);
            }
            Integer amount = departmentSalaryMap.get(department);
            amount += employee1.getSalary();
            departmentSalaryMap.put(department, amount);

        }
        System.out.println(departmentSalaryMap);
    }

    private static void totalAmount(List<Employee> listOfEmployees) {
        Integer totalAmount = 0;
        for (Employee employee : listOfEmployees) {
            totalAmount = +employee.getSalary();
        }
        System.out.println("Total amount paid: " + totalAmount);
    }

    private static void bankTransfer(List<Employee> listOfEmployees) {
        Bank bank = new Bank();

        for (Employee employee : listOfEmployees) {
            Integer salary = employee.getSalary();
            String account = employee.getAccount();
            bank.transfer(salary, account);
        }
    }

    private static void highstSalary(List<Employee> listOfEmployees) {
        listOfEmployees.sort(Comparator.comparingInt(Employee::getSalary));
        Collections.reverse(listOfEmployees);
        System.out.println("Highest salary employee: " + listOfEmployees.get(0).getName() + "from " + listOfEmployees.get(0).getDepartment() + " with " + listOfEmployees.get(0).getSalary() + "€");
    }

    public static List<Employee> toEmployees(List<String> lines) {
        List<Employee> listOfEmployees = new ArrayList<>();
        for (String line : lines) {
            Employee employee = toEmployee(line);
            listOfEmployees.add(employee);

        }
        return listOfEmployees;
    }


    public static Employee toEmployee(String line) {
        String[] spilts = line.split(";");
        List<String> columes = Arrays.asList(spilts);
        String name = columes.get(0);
        String department = columes.get(1);
        Integer salary = Integer.valueOf(columes.get(2));
        String account = columes.get(3);
        return new Employee(name, department, salary, account);
    }
}
