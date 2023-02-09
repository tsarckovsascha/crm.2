package entity;

import java.util.Objects;

public class TermDisciplin {

    private int id;
    private String id_term;
    private String id_disciplins;

    private String termName;

    private int duration;

    private String disciplineName;

    public TermDisciplin() {
    }

    public TermDisciplin(int id, String id_term, String id_disciplins, String termName, int duration, String disciplineName) {
        this.id = id;
        this.id_term = id_term;
        this.id_disciplins = id_disciplins;
        this.termName = termName;
        this.duration = duration;
        this.disciplineName = disciplineName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_term() {
        return id_term;
    }

    public void setId_term(String id_term) {
        this.id_term = id_term;
    }

    public String getId_disciplins() {
        return id_disciplins;
    }

    public void setId_disciplins(String id_disciplins) {
        this.id_disciplins = id_disciplins;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TermDisciplin that = (TermDisciplin) o;
        return id == that.id && duration == that.duration && Objects.equals(id_term, that.id_term) && Objects.equals(id_disciplins, that.id_disciplins) && Objects.equals(termName, that.termName) && Objects.equals(disciplineName, that.disciplineName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, id_term, id_disciplins, termName, duration, disciplineName);
    }

    @Override
    public String toString() {
        return "Term_disciplin{" +
                "id=" + id +
                ", id_term='" + id_term + '\'' +
                ", id_disciplins='" + id_disciplins + '\'' +
                ", termName='" + termName + '\'' +
                ", duration=" + duration +
                ", disciplineName='" + disciplineName + '\'' +
                '}';
    }
}
