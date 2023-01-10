package entity;

import java.util.Objects;

public class Term_disciplin {

    private int id;
    private String id_term;
    private String id_disciplins;

    public Term_disciplin() {
    }

    public Term_disciplin(int id, String id_term, String id_disciplins) {
        this.id = id;
        this.id_term = id_term;
        this.id_disciplins = id_disciplins;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Term_disciplin that = (Term_disciplin) o;
        return id == that.id && Objects.equals(id_term, that.id_term) && Objects.equals(id_disciplins, that.id_disciplins);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, id_term, id_disciplins);
    }

    @Override
    public String toString() {
        return "Term_disciplin{" +
                "id=" + id +
                ", id_term='" + id_term + '\'' +
                ", id_disciplins='" + id_disciplins + '\'' +
                '}';
    }
}
