class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
}

class EmployeeArraySystem {
    private Employee[] employees = new Employee[100];
    private int size = 0;

    // Time Complexity: O(1)
    public void addEmployee(Employee e) {
        employees[size++] = e;
    }

    // Time Complexity: O(n)
    public Employee search(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id) return employees[i];
        }
        return null;
    }

    // Time Complexity: O(n)
    public void delete(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                size--;
                break;
            }
        }
    }
}

