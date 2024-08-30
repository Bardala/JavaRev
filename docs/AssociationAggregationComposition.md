# Association, Aggregation, and Composition in OOP (Java)

In object-oriented programming (OOP), relationships between classes are crucial for defining how objects interact. Java provides mechanisms to model these relationships through association, aggregation, and composition. Let's explore each concept with details and examples.

## Association

Association is a general term that describes a relationship between two independent classes. It can be one-to-one, one-to-many, many-to-one, or many-to-many. Association does not imply ownership.

### Example:

```java
class Bank {
    private String bankName;
    private Set<Employee> employees;

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public String getBankName() {
        return this.bankName;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<Employee> getEmployees() {
        return this.employees;
    }
}

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getEmployeeName() {
        return this.name;
    }
}

public class AssociationExample {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Ridhi");
        Employee emp2 = new Employee("Vijay");

        Set<Employee> employees = new HashSet<>();
        employees.add(emp1);
        employees.add(emp2);

        Bank bank = new Bank("ICICI");
        bank.setEmployees(employees);

        for (Employee emp : bank.getEmployees()) {
            System.out.println(emp.getEmployeeName() + " belongs to bank " + bank.getBankName());
        }
    }
}
```

## Aggregation

Aggregation is a special form of association where one class (the whole) contains a collection of other classes (the parts). The lifecycle of the parts does not depend on the whole. This represents a "has-a" relationship.

### Example:

```java
class Student {
    String name;
    int id;
    String dept;

    public Student(String name, int id, String dept) {
        this.name = name;
        this.id = id;
        this.dept = dept;
    }
}

class Department {
    String name;
    private List<Student> students;

    public Department(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }
}

class Institute {
    String instituteName;
    private List<Department> departments;

    public Institute(String instituteName, List<Department> departments) {
        this.instituteName = instituteName;
        this.departments = departments;
    }

    public int getTotalStudentsInInstitute() {
        int noOfStudents = 0;
        for (Department dept : departments) {
            noOfStudents += dept.getStudents().size();
        }
        return noOfStudents;
    }
}

public class AggregationExample {
    public static void main(String[] args) {
        Student s1 = new Student("Mia", 1, "CSE");
        Student s2 = new Student("Priya", 2, "CSE");
        Student s3 = new Student("John", 1, "EE");
        Student s4 = new Student("Rahul", 2, "EE");

        List<Student> cse_students = new ArrayList<>();
        cse_students.add(s1);
        cse_students.add(s2);

        List<Student> ee_students = new ArrayList<>();
        ee_students.add(s3);
        ee_students.add(s4);

        Department CSE = new Department("CSE", cse_students);
        Department EE = new Department("EE", ee_students);

        List<Department> departments = new ArrayList<>();
        departments.add(CSE);
        departments.add(EE);

        Institute institute = new Institute("BITS", departments);

        System.out.println("Total students in institute: " + institute.getTotalStudentsInInstitute());
    }
}
```

## Composition

Composition is a stronger form of aggregation that implies ownership and lifecycle dependency. If the whole is destroyed, the parts are also destroyed. This represents a "part-of" relationship.

### Example:

```java
class Engine {
    private String type;

    public Engine(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class Car {
    private String model;
    private Engine engine;

    public Car(String model, String engineType) {
        this.model = model;
        this.engine = new Engine(engineType);
    }

    public String getCarDetails() {
        return "Car model: " + model + ", Engine type: " + engine.getType();
    }
}

public class CompositionExample {
    public static void main(String[] args) {
        Car car = new Car("Tesla", "Electric");
        System.out.println(car.getCarDetails());
    }
}
```

## Summary

- **Association**: General relationship between classes.
- **Aggregation**: "Has-a" relationship where parts can exist independently.
- **Composition**: "Part-of" relationship with ownership and lifecycle dependency.

These concepts help in designing robust and maintainable object-oriented systems.

¹: [Association, Composition and Aggregation in Java - GeeksforGeeks](https://www.geeksforgeeks.org/association-composition-aggregation-java/)
²: [Difference Between Aggregation and Composition in Java - GeeksforGeeks](https://www.geeksforgeeks.org/difference-between-aggregation-and-composition-in-java/)

```

Feel free to copy this content into a `.md` file. If you need any further assistance, let me know! 😊

Source: Conversation with Copilot, 8/22/2024
(1) GeeksforGeeks | A computer science portal for geeks. https://www.geeksforgeeks.org/.
(2) Python Tutorial | Learn Python Programming - GeeksforGeeks. https://www.geeksforgeeks.org/python-programming-language-tutorial/.
(3) Practice | GeeksforGeeks | A computer science portal for geeks. https://www.geeksforgeeks.org/explore.
(4) github.com. https://github.com/antgonto/datastructures/tree/18a6b6aada822c8527c26d27518ac0e53e036eb9/src%2Fuml%2FAggregation.java.
(5) github.com. https://github.com/dinesh-malviya/java_basics_programs/tree/2ccf9f5892828c1d128abc474aadfc3883430842/src%2Fcom%2Fmalviyad%2Fassociation%2FAgreegationExample.java.
(6) github.com. https://github.com/satish3922/Placement_Help/tree/357aca4598168622c3bf3d52bf40c96ad17c380a/WIPRO%2FBLUFFER%2FDAY2%2FAssociation%2Fhas_A_relationship%2FAggregation.java.
(7) github.com. https://github.com/ismaildemirler/JavaSE/tree/24c299503ea558fcaa7d93fefd4415134bc6c01b/src%2FB_Intermediate%2FA_OOP%2FJ_Aggregation%2FAggregation.java.
(8) github.com. https://github.com/alexsorindrago/Java-noob-to-advanced/tree/114253f6ecf25bc5eebe866ea320571ed8800ed8/design-pattern%2Fsrc%2Fmain%2Fjava%2Fcom%2Fbucur%2Frelationships%2Faggregation%2FDemoAggregation.java.
```
