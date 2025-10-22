import static java.lang.System.exit;

public class Student {
    private int studentID;
    private String name;
    private int age;
    private String gender;
    private String department;
    private double gpa;

    public Student(String name, int age, int studentID,
                   String gender, String department, double gpa) {
        this.name = name;
        this.department = department;
        setAge(age);
        setStudentID(studentID);
        setGender(gender);
        setGpa(gpa);
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
        if(age<=0) {
            System.out.println("Invalid age");
            exit(1);
        }
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        if(studentID<=0) {
            System.out.println("Invalid ID");
            exit(1);
        }
        this.studentID=studentID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if(gender.equalsIgnoreCase("Male")||
                gender.equalsIgnoreCase("Female")){
            this.gender=gender;
        }
        else {
            System.out.println("InValid gender");
            exit(1);
        }
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
       if(gpa<0){
           System.out.println("Invalid gpa");
           exit(1);
       }
       this.gpa=gpa;
    }
}
