package DB;

import entity.Disciplins;
import entity.Student;
import entity.StudentProgress;

import java.util.ArrayList;

public interface IDBManager {
    ArrayList<Student> getAllStudent();
    ArrayList<Disciplins> getAllDisciplins();
    void studentCreating(String firstName, String lastName, String groupName, String registrationDate);
    void daletStudent(String ids);
    void deleteDiscipline(String ids);

    ArrayList<StudentProgress> getAllStudentProgress();
}

