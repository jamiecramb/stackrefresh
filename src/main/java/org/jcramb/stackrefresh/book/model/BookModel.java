package org.jcramb.stackrefresh.book.model;

/**
 * Model that represents a book.
 * 
 * @author Jamie Cramb
 */
public class BookModel {

    private Long id;

    private String name;

    private String description;

    private String author;

    public BookModel() {
    }

    public BookModel(String name, String description, String author) {
        this.name = name;
        this.description = description;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "BookModel [id=" + id + ", name=" + name + ", description=" + description + ", author=" + author + "]";
    }
}