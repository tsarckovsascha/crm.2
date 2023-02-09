package DB;

import entity.*;

import java.util.ArrayList;

public interface IDBManager {
    ArrayList<Student> getAllStudent();

    ArrayList<Disciplins> getAllDisciplins();

    void studentCreating(String firstName, String lastName, String groupName, String registrationDate);

    void daletStudent(String ids);

    void deleteDiscipline(String ids);

    Student getAllStudentProgress(String id);

    ArrayList<DisciplinMark> getDisciplinMark(String id, Term term);

    ArrayList<Term> getAllTermsByIdStudent(String id);

    ArrayList<News> getAllNews();

    void newsCreating(String header, String text);

    ArrayList<Role> getAllRole();

    ArrayList<User> getAllUser();

    boolean isLogin(String login, String password, String idRole);

    UserRole getUserFull(String login, String RoleId);

    void deletNews(String idn);

    void DisciplinCreating(String name);

    ArrayList<TermDisciplin> getAllDisciplinsTerm(String id_term, String id_disciplins);

 //   void registration(String login, String password, String firstName, String lastName, String iduser, String idrole, String id);

    ArrayList<Term> getTermbyId(String id);

    ArrayList<TermDisciplin> getDisciplineByTerm(Term term, String idTerm);

    Term getTermId(String ids);

    void addUser(String login, String password, String lastName, String firstName);

    void addIds(String roleId, String userId);

    User getUserId(String login);

    ArrayList<User> getLogins();
}

