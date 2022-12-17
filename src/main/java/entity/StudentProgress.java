package entity;

import java.util.Objects;

public class StudentProgress {
    private int id;
    private String nameDisciplins;
    private String nameMark;

    public StudentProgress() {
    }

    public StudentProgress(int id, String nameDisciplins, String nameMark) {
        this.id = id;
        this.nameDisciplins = nameDisciplins;
        this.nameMark = nameMark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameDisciplins() {
        return nameDisciplins;
    }

    public void setNameDisciplins(String nameDisciplins) {
        this.nameDisciplins = nameDisciplins;
    }

    public String getNameMark() {
        return nameMark;
    }

    public void setNameMark(String nameMark) {
        this.nameMark = nameMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentProgress that = (StudentProgress) o;
        return id == that.id && Objects.equals(nameDisciplins, that.nameDisciplins) && Objects.equals(nameMark, that.nameMark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameDisciplins, nameMark);
    }
}
