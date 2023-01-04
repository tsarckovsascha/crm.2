package DB;

import entity.*;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class DBManager implements IDBManager {
    @Override
    public ArrayList<Student> getAllStudent() {
        ArrayList<Student> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crm_students_4", "root", "admin");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from `student` where status  = 1");
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setSurname(rs.getString("surname"));
                s.setName(rs.getString("name"));
                s.setGroup(rs.getString("group"));
                s.setDatr_enter(rs.getDate("datr_enter"));
                res.add(s);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    public ArrayList<Disciplins> getAllDisciplins() {
        ArrayList<Disciplins> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crm_students_4", "root", "admin");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from `disciplins` where status  = 1");
            while (rs.next()) {
                Disciplins d = new Disciplins();
                d.setId(rs.getInt("id"));
                d.setName(rs.getString("name"));
                d.setStatus(rs.getByte("status"));
                res.add(d);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    public void studentCreating(String firstName, String lastName, String groupName, String registrationDate) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crm_students_4", "root", "admin");
            Statement stmt = con.createStatement();
            stmt.execute
                    ("INSERT INTO `student` (`surname`, `name`, `group`, `status`, `datr_enter`) " +
                            "VALUES ('" + lastName + "', '" + firstName + "', '" + groupName + "','1', '" + registrationDate + "');");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void daletStudent(String ids) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crm_students_4", "root", "admin");
            Statement stmt = con.createStatement();
            stmt.execute(
                    "UPDATE `student` SET `status` = '0' WHERE (`id` in(" + ids + "));");
            //stmt.execute("delete from `status` WHERE (`id` in(" + idS + "));");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteDiscipline(String ids) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crm_students_4", "root", "admin");
            Statement stmt = con.createStatement();
            stmt.execute(
                    "UPDATE `disciplins` SET `status` = '0' WHERE (`id` in(" + ids + "));");
            //stmt.execute("delete from `status` WHERE (`id` in(" + idS + "));");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public Student getAllStudentProgress(String id) {
        Student s = new Student();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crm_students_4", "root", "admin");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from `student` where status  = 1 and id =  " + id + "");
            while (rs.next()) {
                s.setId(rs.getInt("id"));
                s.setSurname(rs.getString("surname"));
                s.setName(rs.getString("name"));
                s.setGroup(rs.getString("group"));
                s.setDatr_enter(rs.getDate("datr_enter"));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return s;
    }

    public ArrayList<Term> getAllTermsByIdStudent(String id) {
        ArrayList<Term> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crm_students_4", "root", "admin");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select distinct t.* from term t\n" +
                    "join term_disciplin td on t.id = td.id_term\n" +
                    "join student_termdisciplin_mark stm \n" +
                    "on td.id = stm.id_term_disciplin\n" +
                    "and stm.id_student =" + id);
            while (rs.next()) {
                Term t = new Term();
                t.setId(rs.getInt("id"));
                t.setName(rs.getString("name"));
                t.setDuration(rs.getInt("duration"));
                res.add(t);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    public ArrayList<DisciplinMark> getDisciplinMark(String id, Term term) {
        ArrayList<DisciplinMark> res = new ArrayList();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crm_students_4", "root", "admin");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select distinct d.*, m.name as mark from term t\n" +
                    "join term_disciplin td on t.id = td.id_term\n" +
                    "join student_termdisciplin_mark stm \n" +
                    "on td.id = stm.id_term_disciplin\n" +
                    "and stm.id_student = " + id + "\n" +
                    "join disciplins d on d.id = td.id_disciplins\n" +
                    "join mark m on m.id = stm.id_mark\n" +
                    "where td.id_term = " + term.getId());
            while (rs.next()) {
                DisciplinMark s = new DisciplinMark();
                s.setId(rs.getInt("id"));
                s.setStatus(rs.getByte("status"));
                s.setMark(rs.getString("mark"));
                s.setName(rs.getString("name"));
                res.add(s);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    public ArrayList<News> getAllNews() {
        ArrayList<News> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crm_students_4", "root", "admin");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from `news` ");
            while (rs.next()) {
                News n = new News();
                n.setId(rs.getInt("id"));
                n.setHeader(rs.getString("header"));
                n.setText(rs.getString("text"));
                res.add(n);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    public void newsCreating(String header, String text) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crm_students_4", "root", "admin");
            Statement stmt = con.createStatement();
            stmt.execute
                    ("INSERT INTO `news` (`header`, `text`) " +
                            "VALUES ('" + header + "', '" + text + "');");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public ArrayList<Role> getAllRole() {
        ArrayList<Student> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crm_students_4", "root", "admin");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from `student` where status  = 1");
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setSurname(rs.getString("surname"));
                s.setName(rs.getString("name"));
                s.setGroup(rs.getString("group"));
                s.setDatr_enter(rs.getDate("datr_enter"));
                res.add(s);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    @Override
    public ArrayList<User> gwtAllUser() {
        ArrayList<User> res = new ArrayList<User>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crm_students_4", "root", "admin");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from `role` where status  = 1");
            while (rs.next()) {
                User s = new User();
                s.setLogin(rs.getString("surname"));
                s.setPassword(rs.getString("password"));
                s.setGroup(rs.getString("group"));
                s.setDatr_enter(rs.getDate("datr_enter"));
                res.add(s);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    @Override
    public boolean isLogin(String login, String password, String idRole) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crm_students_4", "root", "admin");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from user u \n" +
                    "join user_role ur on u.id = ur.id_user\n" +
                    "where login = '"+login+"' and password = '"+password+"' and ur.id_role = '"+ur.id_role+"';");
            while (rs.next()) {
                return true;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

}



