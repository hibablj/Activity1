package model;

public class Paper {
    private int id;
    private String title;
    private int authorId;

    public Paper(int id, String title, int authorId) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public int getAuthorId() { return authorId; }

    public void setTitle(String title) { this.title = title; }

    @Override
    public String toString() {
        return "Paper{id=" + id + ", title='" + title + "', authorId=" + authorId + "}";
    }
}
