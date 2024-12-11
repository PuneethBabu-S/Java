import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class StreamsPractice {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>(); 
		employees.add(new Employee(1, "Alice Johnson", 30, 55000, "Developer", "Female", "IT")); 
		employees.add(new Employee(2, "Bob Smith", 45, 75000, "Manager", "Male", "HR")); 
		employees.add(new Employee(3, "Carol White", 28, 52000, "Designer", "Female", "Design")); 
		employees.add(new Employee(4, "David Brown", 35, 68000, "Analyst", "Male", "Finance")); 
		employees.add(new Employee(5, "Eva Green", 40, 80000, "Lead Developer", "Female", "IT")); 
		employees.add(new Employee(6, "Frank Black", 29, 49000, "Support Engineer", "Male", "Support")); 
		employees.add(new Employee(7, "Grace Wilson", 32, 61000, "Sales Executive", "Female", "Sales")); 
		employees.add(new Employee(8, "Henry Adams", 27, 45000, "Intern", "Male", "Marketing")); 
		employees.add(new Employee(9, "Ivy Taylor", 50, 95000, "Director", "Female", "Admin")); 
		employees.add(new Employee(10, "Jack Davis", 37, 69000, "HR Specialist", "Male", "HR")); 
		employees.add(new Employee(11, "Kathy Clark", 31, 56000, "Content Writer", "Female", "Marketing")); 
		employees.add(new Employee(12, "Leo Lewis", 42, 88000, "Consultant", "Male", "Consulting")); 
		employees.add(new Employee(13, "Mona Walker", 26, 47000, "Junior Developer", "Female", "IT")); 
		employees.add(new Employee(14, "Nate Harris", 33, 63000, "Project Manager", "Male", "IT")); 
		employees.add(new Employee(15, "Olivia Young", 38, 72000, "QA Lead", "Female", "Quality Assurance"));
		
		//Employee with highest salary
		Optional<Employee> highestSalaryEmp = employees.stream()
				.max(Comparator.comparing(Employee::getSalary));
		System.out.println("Employee with highest salary: " + highestSalaryEmp.get());
		
		//Highest salary
		OptionalDouble highestSalary = employees.stream()
				.mapToDouble(Employee::getSalary).max();
		System.out.println("Highest salary: " + highestSalary.getAsDouble());
		
		//Youngest Employee
		Optional<Employee> youngestEmp = employees.stream()
				.min(Comparator.comparing(Employee::getAge));
		System.out.println("Youngest Employee: " + youngestEmp.get());
		
		//3rd most eldest employee
		Optional<Employee> thirdEldestEmp = employees.stream()
				.sorted(Comparator.comparing(Employee::getAge).reversed())
				.skip(2).findFirst();
		System.out.println("3rd most eldest employee: " + thirdEldestEmp.get());
		
		//Expense of each department 
		Map<String, Double> expense = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));
		System.out.println("Expense in each department: " + expense);
		
		//Average age of employees in each designation
		Map<String, Double> avgAgeInDep = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getAge)));
		System.out.println("Average age in each Department: " + avgAgeInDep);
		
		//Total number of males and females
		Map<String, Long> maleFemale = employees.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println("Gender ratio: " + maleFemale);
		
		
		
	}

}

class Employee{
	private int eid;
	private String name;
	private int age;
	private double salary;
	private String designation;
	private String gender;
	private String department;
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public Employee(int eid, String name, int age, double salary, String designation, String gender,
			String department) {
		this.eid = eid;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.designation = designation;
		this.gender = gender;
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", age=" + age + ", salary=" + salary + ", designation="
				+ designation + ", gender=" + gender + ", department=" + department + "]";
	}
	
	
	
}
