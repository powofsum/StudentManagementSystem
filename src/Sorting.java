import java.util.ArrayList;
import java.util.Collections;

public class Sorting implements UISorting {
    @Override
    public void sortName(ArrayList<Student> studentArrayList) {
        for (int i = 0; i < studentArrayList.size() - 1; i++) {  //sorting

            for (int j = 0; j < studentArrayList.size() - i - 1; j++) {
                if (studentArrayList.get(j).getName().compareTo(
                        studentArrayList.get(j + 1).getName()) >0
                ) {
                    Collections.swap(studentArrayList, j, j + 1);
                }
            }
        }

    }

    @Override
    public void sortID(ArrayList<Student> studentArrayList) {
        for (int i = 0; i < studentArrayList.size() - 1; i++) {  //sorting

            for (int j = 0; j < studentArrayList.size() - i - 1; j++) {
                if (studentArrayList.get(j).getStudentID() >
                        studentArrayList.get(j + 1).getStudentID()) {
                    Collections.swap(studentArrayList, j, j + 1);
                }
            }
        }
    }
}
