
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import static java.lang.System.exit;
import static java.util.Collections.list;

public class Admin {
   private ArrayList <Student> sList = new ArrayList<>();
    // private UISorting sorting; // use sorting directly

    //public Admin(UISorting sorting){
    //    this.sorting=sorting;
    //}

    public ArrayList <Student> LoadFromFile() throws FileNotFoundException, IOException{
        ArrayList <Student> sList = new ArrayList <>();
        File f = new File("Students.txt");
        if(!f.exists( )){
            return sList;
        }
        try(BufferedReader r = new BufferedReader (new FileReader(f))){
            String l ;
            String[] data ;
            while (( l = r.readLine( ))!= null){
                //data = l.split(",");
                data = l.split("\\s*,\\s*");
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                int id = Integer.parseInt(data[2]);
                String gender = data[3];
                String department = data[4];
                float gpa = Float.parseFloat(data[5]);
                Student s = new Student(name , age , id , gender , department , gpa );
                sList.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sList;
    }

    // SAVE TO FILE METHOD
    public void saveToFile(ArrayList <Student> list) throws IOException {
        try(FileWriter f = new FileWriter("Students.txt", false)){
            // Flase : To delete all last data and update it .
            for(Student s : list){
                f.write(s.toString() + "\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


// ADD STUDENT METHOD
   public void addStudent(String studentID , String name , String age ,
                          String gender , String department , String gpa) throws IOException{
       if(studentID.isBlank() || name.isBlank() ||
               age.isBlank() || gender.isBlank() || department.isBlank() || gpa.isBlank()){
           System.out.println("Error : All fields must be filled");
           exit(1);
       }
       ArrayList <Student> sList = new ArrayList<>();
       sList = LoadFromFile();
       String sId = studentID.trim();
       String sName = name.trim();
       String sAge = age.trim();
       String sGender = gender.trim();
       String sDepartment = department.trim();
       String sGpa = gpa.trim();
       
       int id ; int ageAdd ; float gpaAdd ;
       try{
       id = Integer.parseInt(sId);
       ageAdd = Integer.parseInt(sAge);
       gpaAdd = Float.parseFloat(sGpa);
       } catch(NumberFormatException e){
           System.out.println("Error :ID , Gpa and Age must be numeric values");
           return;
       }
       for(Student s : sList){
           if(s.getStudentID() == id){
               System.out.println("Sorry , Id already exists");
               exit(1);
           }
       }
       Student s = new Student(sName , ageAdd , id , sGender , sDepartment , gpaAdd);
      
       
       try(FileWriter f = new FileWriter("Students.txt" , true)){
          f.write(s.toString() + "\n");
          System.out.println("Successfully added to the file");
       }
       catch(IOException e){
           System.out.println("Error");
           e.printStackTrace();
       }
       
   } 

   // VIEW/DISPLAY STUDENTS METHOD
public void ViewStudents( ) throws IOException{
    ArrayList <Student> studentsList = new ArrayList <>( );
    studentsList = LoadFromFile();
    if(studentsList.isEmpty()){
        System.out.println("NO student found");
        return;
    }
    studentsList.sort((S1,S2) -> Long .compare(S1.getStudentID() ,S2.getStudentID()));
    for ( Student s : studentsList){
    System.out.println(s);
    }
}
  
// public void updateStudent(Long id) throws IOException{
//     ArrayList <Student> studentsList = new ArrayList <>( );
//     studentsList = LoadFromFile(); 
//     for(Student s : studentsList){
//        if (s.getStudentID() == id){
//          // lesa m4 3rfa hn3ml update l eh
//         }
//     }
//     saveToFile(studentsList);
// }


    //DELETE STUDENT METHOD
public void deleteStudent(long id) throws IOException{
   ArrayList <Student> studentslist = new ArrayList<>();
   studentslist = LoadFromFile();
      for(int i=0 ; i<studentslist.size() ; i++){
          if(studentslist.get(i).getStudentID()== id){
              studentslist.remove(i);
              break;
          }
      }
   saveToFile(studentslist);
}


    //searchStudent using name
    public Student searchStudent(String name) throws IOException {
        ArrayList<Student> students=LoadFromFile();
        Student foundStudent=null;
        for(int i=0;i<students.size();i++){
            if(students.get(i).getName().equalsIgnoreCase(name)){
                foundStudent= students.get(i);
            }
        }
        //delete this part later==============================
//        if(foundStudent!=null)
//            System.out.println("Found");
//        else
//            System.out.println("not Found");
        //===================================================
        return foundStudent;
    }

    //overloading searchStudent method
    public Student searchStudent(int ID) throws IOException {
        ArrayList<Student> students=LoadFromFile();
        Student foundStudent=null;
        for(int i=0;i<students.size();i++){
            if( (students.get(i).getStudentID()) ==ID){
                foundStudent= students.get(i);
            }

        }
        //delete this part later==============================
//        if(foundStudent!=null)
//            System.out.println("Found");
//        else
//            System.out.println("not Found");
        //===================================================

        return foundStudent;
    }
}
