package entity;

import java.util.Objects;

public class News {

    private int id;

    private String header;

    private String text;

    public News() {
    }

    public News(int id, String header, String text) {
        this.id = id;
        this.header = header;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return id == news.id && Objects.equals(header, news.header) && Objects.equals(text, news.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, header, text);
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
