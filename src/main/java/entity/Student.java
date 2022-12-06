package entity;

import java.util.Date;
import java.util.Objects;

public class Student {
    private int id;
    private String surname;
    private String name;
    private String group;
    private byte status;
    private Date datr_enter;

    public Student() {
    }

    public Student(int id, String surname, String name, String group, byte status, Date datr_enter) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.group = group;
        this.status = status;
        this.datr_enter = datr_enter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public Date getDatr_enter() {
        return datr_enter;
    }

    public void setDatr_enter(Date datr_enter) {
        this.datr_enter = datr_enter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && status == student.status && Objects.equals(surname, student.surname) && Objects.equals(name, student.name) && Objects.equals(group, student.group) && Objects.equals(datr_enter, student.datr_enter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, group, status, datr_enter);
    }
}
