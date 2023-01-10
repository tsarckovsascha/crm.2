package entity;

import java.util.Objects;

public class UserRole {

    private int id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;

    private int idRole;
    private String name;

    public UserRole() {
    }

    public UserRole(int id, String login, String password, String firstName, String lastName, int idRole, String name) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idRole = idRole;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return id == userRole.id && idRole == userRole.idRole && Objects.equals(login, userRole.login) && Objects.equals(password, userRole.password) && Objects.equals(firstName, userRole.firstName) && Objects.equals(lastName, userRole.lastName) && Objects.equals(name, userRole.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, firstName, lastName, idRole, name);
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idRole=" + idRole +
                ", name='" + name + '\'' +
                '}';
    }
}

