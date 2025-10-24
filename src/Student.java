package lab.pkg5;
import static java.lang.System.exit;

public class Student {
    private int studentID;
    private String name;
    private int age;
    private String gender;
    private String department;
    private float gpa;

    public Student(String name, int age, int studentID,
                   String gender, String department, float gpa) {
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
        if(age<=10 || age>30) {
            System.out.println("Invalid age");
            exit(1);
        }
        this.age=age;
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

    public void setGpa(float gpa) {
       if(gpa>4 || gpa<0){
           System.out.println("Invalid gpa");
           exit(1);
       }
       this.gpa=gpa;
    }
    
    @Override
    public String toString() {
    return name + "," + age + "," + studentID + "," + gender + "," + department + "," + gpa;
   }
}
