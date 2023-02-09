package DB;

import constants.Connections;
import entity.*;

import java.sql.*;
import java.util.ArrayList;

public class DBManager implements IDBManager {
    @Override
    public ArrayList<Student> getAllStudent() {
        ArrayList<Student> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Connections.CONNECTIONS_URL, Connections.CONNECTIONS_USER, Connections.CONNECTIONS_PASSWORD);
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
                    Connections.CONNECTIONS_URL, Connections.CONNECTIONS_USER, Connections.CONNECTIONS_PASSWORD);
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
                    Connections.CONNECTIONS_URL, Connections.CONNECTIONS_USER, Connections.CONNECTIONS_PASSWORD);
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
                    Connections.CONNECTIONS_URL, Connections.CONNECTIONS_USER, Connections.CONNECTIONS_PASSWORD);
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
                    Connections.CONNECTIONS_URL, Connections.CONNECTIONS_USER, Connections.CONNECTIONS_PASSWORD);
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
                    Connections.CONNECTIONS_URL, Connections.CONNECTIONS_USER, Connections.CONNECTIONS_PASSWORD);
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
                    Connections.CONNECTIONS_URL, Connections.CONNECTIONS_USER, Connections.CONNECTIONS_PASSWORD);
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
                    Connections.CONNECTIONS_URL, Connections.CONNECTIONS_USER, Connections.CONNECTIONS_PASSWORD);
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
                    Connections.CONNECTIONS_URL, Connections.CONNECTIONS_USER, Connections.CONNECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from `news` where status  = 1");
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
                    Connections.CONNECTIONS_URL, Connections.CONNECTIONS_USER, Connections.CONNECTIONS_PASSWORD);
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
        ArrayList<Role> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Connections.CONNECTIONS_URL, Connections.CONNECTIONS_USER, Connections.CONNECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from role where status  = 1;");
            while (rs.next()) {
                Role s = new Role();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setStatus(rs.getString("status"));

                res.add(s);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    @Override
    public ArrayList<User> getAllUser() {
        ArrayList<User> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Connections.CONNECTIONS_URL, Connections.CONNECTIONS_USER, Connections.CONNECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from `user` where status  = 1");
            while (rs.next()) {
                User s = new User();
                s.setLogin(rs.getString("surname"));
                s.setPassword(rs.getString("password"));
                s.setFirstName(rs.getString("firstName"));
                s.setLastName(rs.getString("lastName"));
                s.setStatus(rs.getInt("status"));
                res.add(s);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    @Override
    public boolean isLogin(String login, String password, String RoleId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Connections.CONNECTIONS_URL, Connections.CONNECTIONS_USER, Connections.CONNECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from user u \n" +
                    "join user_role ur on u.id = ur.iduser\n" +
                    "where login = '" + login + "' and password = '" + password + "' and ur.idrole = " + RoleId + ";");
            while (rs.next()) {
                return true;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public UserRole getUserFull(String login, String RoleId) {
        UserRole res = new UserRole();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Connections.CONNECTIONS_URL, Connections.CONNECTIONS_USER, Connections.CONNECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select u.id id_us, firstName,lastName,r.id id_r, r.name\n" +
                    "from user u\n" +
                    "join user_role ur on u.id = ur.iduser\n" +
                    "join role r on r.id = ur.idrole\n" +
                    "where u.login = \"" + login + "\" and r.id = " + RoleId);
            while (rs.next()) {
                res.setId(rs.getInt("id_us"));
                res.setFirstName(rs.getString("firstName"));
                res.setLastName(rs.getString("lastName"));
                res.setIdRole(rs.getInt("id_r"));
                res.setName(rs.getString("name"));

            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    @Override
    public void deletNews(String idn) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Connections.CONNECTIONS_URL, Connections.CONNECTIONS_USER, Connections.CONNECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            stmt.execute(
                    "UPDATE `news` SET `status` = '0' WHERE (`id` in(" + idn + "));");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void DisciplinCreating(String name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Connections.CONNECTIONS_URL, Connections.CONNECTIONS_USER, Connections.CONNECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            stmt.execute
                    ("INSERT INTO `disciplins` (`name`) " +
                            "VALUES ('" + name + "')");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public ArrayList<TermDisciplin> getAllDisciplinsTerm(String id_term, String id_disciplins) {
        ArrayList<TermDisciplin> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Connections.CONNECTIONS_URL, Connections.CONNECTIONS_USER, Connections.CONNECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from `term_disciplin` ");
            while (rs.next()) {
                TermDisciplin d = new TermDisciplin();
                d.setId(rs.getInt("id"));
                d.setId_term(rs.getString("id_term"));
                d.setId_disciplins(rs.getString("id_disciplins"));
                res.add(d);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

//    @Override
//    public void registration(String firstName, String lastName, String login, String password, String iduser, String idrole, String id) {
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection(
//                    Connections.CONNECTIONS_URL, Connections.CONNECTIONS_USER, Connections.CONNECTIONS_PASSWORD);
//            Statement stmt = con.createStatement();
//            int i = stmt.executeUpdate
//                    ("INSERT INTO `user` (`login`, `password`, `firstName`, `lastName`,`status`,`id`) " +
//                            "VALUES ('" + login + "','" + password + "','" + firstName + "','" + lastName + "','1', id);");
//            int ii = stmt.executeUpdate
//                    ("INSERT INTO `user` (`login`, `password`, `firstName`, `lastName`,`status`,`id`) " +
//                            "VALUES ('" + login + "','" + password + "','" + firstName + "','" + lastName + "','1', id); SELECT LAST_INSERT_ID(); ");
//            stmt.execute
//                    ("INSERT INTO `user_role` (`iduser`, `idrole`) VALUES (" + ii + ", '3')");
//            con.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }

    @Override
    public ArrayList<Term> getTermbyId(String id) {
        ArrayList<Term> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Connections.CONNECTIONS_URL, Connections.CONNECTIONS_USER, Connections.CONNECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select distinct t.* from term t\n" +
                    "join term_disciplin td on t.id = td.id_term;");
            while (rs.next()) {
                Term t = new Term();
                t.setId((rs.getInt("id")));
                t.setName((rs.getString("name")));
                t.setDuration((rs.getInt("duration")));
                res.add(t);
            }
            System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }
    @Override
    public ArrayList<TermDisciplin> getDisciplineByTerm(Term term, String idTerm) {
        ArrayList<TermDisciplin> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Connections.CONNECTIONS_URL, Connections.CONNECTIONS_USER, Connections.CONNECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select distinct d.name as disciplineName from term_disciplin td\n" +
                    "join term t on td.id_term = t.id\n" +
                    "join disciplins d on td.id_disciplins = d.id\n" +
                    "where td.id_term = " + term.getId());
            while (rs.next()) {
                TermDisciplin t = new TermDisciplin();
                t.setDisciplineName((rs.getString("disciplineName")));
                res.add(t);
            }
            System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }
    @Override
    public Term getTermId(String ids) {
        Term s = new Term();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Connections.CONNECTIONS_URL, Connections.CONNECTIONS_USER, Connections.CONNECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from `term` where `id` = " + ids);
            while (rs.next()) {
                s.setId((rs.getInt("id")));
                s.setName((rs.getString("name")));

            }
            System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return s;
    }
    @Override
    public void addUser(String login, String password, String lastName, String firstName) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Connections.CONNECTIONS_URL, Connections.CONNECTIONS_USER, Connections.CONNECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO `user` (`login`, `password`, `firstName`, `lastName`, `status`) " +
                    "VALUES ('" + login + "', '" + password + "', '" + firstName + "', '" + lastName + "', '1');");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void addIds(String roleId, String userId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Connections.CONNECTIONS_URL, Connections.CONNECTIONS_USER, Connections.CONNECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO `user_role` (`iduser`, `idrole`) VALUES ('" + userId + "', 3 );");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    @Override
    public User getUserId(String login) {
        User res = new User();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Connections.CONNECTIONS_URL, Connections.CONNECTIONS_USER, Connections.CONNECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select id , login from user \n" +
                    "where login = '" + login + "';");
            while (rs.next()) {

                res.setId((rs.getInt("id")));
                res.setLogin((rs.getString("login")));

            }
            System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    @Override
    public ArrayList<User> getLogins() {
        ArrayList<User> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Connections.CONNECTIONS_URL, Connections.CONNECTIONS_USER, Connections.CONNECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select `login` from `user`");
            while (rs.next()) {
                User t = new User();
                t.setLogin((rs.getString("login")));
                res.add(t);
            }
            System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }
}

