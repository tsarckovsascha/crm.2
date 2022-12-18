package DB;

import entity.Disciplins;
import entity.Student;
import entity.StudentProgress;

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
            Class.forName("com.mysql.jdbc.Driver");
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
            Class.forName("com.mysql.jdbc.Driver");
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
            Class.forName("com.mysql.jdbc.Driver");
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
            Class.forName("com.mysql.jdbc.Driver");
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
    public ArrayList<StudentProgress> getAllStudentProgress() {
        ArrayList<StudentProgress> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crm_students_4", "root", "admin");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from `student` where status  = 1");
            while (rs.next()) {
                StudentProgress s = new StudentProgress();
                s.setId(rs.getInt("id"));
                s.setNameDisciplins(rs.getString("name_disciplins"));
                s.setNameMark(rs.getString("name_mark"));
                res.add(s);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;

    }

}

