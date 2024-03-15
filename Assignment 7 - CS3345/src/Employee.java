public class Employee {
    int empNum;
    double hourlyRate;

    public Employee(int empNum, double hourlyRate) {
        this.empNum = empNum;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() {
        return "Employee [empNum=" + empNum + ", hourlyRate=" + hourlyRate + "]";
    }
}