import java.util.Scanner;

// Custom Exception ----------------------------------------------------
class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}

// Loader Thread (Multithreading) -------------------------------------
class Loader implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Loading.....");
            Thread.sleep(2000); // simulate loading delay
        } catch (InterruptedException e) {
            System.out.println("Loader interrupted.");
        }
    }
}

// Student POJO --------------------------------------------------------
class Student {
    private Integer rollNo;     // Wrapper class
    private String name;
    private String email;
    private String course;
    private Double marks;       // Wrapper class

    public Student(Integer rollNo, String name, String email, String course, Double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.email = email;
        this.course = course;
        this.marks = marks;
    }

    public String calculateGrade() {
        double m = marks;
        if (m >= 90) return "A";
        else if (m >= 75) return "B";
        else if (m >= 60) return "C";
        else if (m >= 40) return "D";
        else return "F";
    }

    public void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
    }
}

// StudentManager implementing actions ---------------------------------
interface RecordActions {
    void addStudent() throws Exception;
}

class StudentManager implements RecordActions {

    @Override
    public void addStudent() throws Exception {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Roll No (Integer): ");
            Integer roll = Integer.valueOf(sc.nextLine());  // Autoboxing

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            if (name.isEmpty() || course.isEmpty()) {
                throw new StudentNotFoundException("Name or Course cannot be empty!");
            }

            System.out.print("Enter Marks: ");
            Double marks = Double.valueOf(sc.nextLine());  // Wrapper class

            if (marks < 0 || marks > 100) {
                throw new ArithmeticException("Invalid Marks! Must be between 0–100.");
            }

            // Loading Thread
            Thread t = new Thread(new Loader());
            t.start();
            t.join(); // wait for thread to finish

            Student st = new Student(roll, name, email, course, marks);
            st.display();

        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input! Please enter correct numeric values.");
        } finally {
            System.out.println("Program execution completed.");
        }
    }
}

public class LabAssignment3 {
    public static void main(String[] args) throws Exception {
        StudentManager sm = new StudentManager();
        sm.addStudent();
    }
}
