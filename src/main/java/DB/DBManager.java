package DB;

import entity.Disciplins;
import entity.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
            ResultSet rs = stmt.executeQuery("select * from `discipline` where status  = 0");
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
}
